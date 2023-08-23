package com.dishoom.gmail;

import com.dishoom.connector.GmailConnector;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePart;
import com.google.api.services.gmail.model.MessagePartHeader;
import com.google.common.base.Strings;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GmailServiceImpl implements EmailService {

  private final GmailConnector gmailConnector;

  @Inject
  public GmailServiceImpl(GmailConnector gmailConnector) {
    this.gmailConnector = gmailConnector;
  }

  @Override
  public String extractLatestOtp() {
  try{
    List<Message> emails = gmailConnector.getMails();
    Message latestRelevantEmail = getEmailWithOtp(emails);
    if (latestRelevantEmail != null) {
      return getOtp(latestRelevantEmail);
    }
    return "Sorry Otp not found";
  } catch (Exception e) {
    e.printStackTrace();
    return null;
    }
  }

  private Message getEmailWithOtp(List<Message> emails) throws IOException {
    for (int i = emails.size() - 1; i >= 0; i--) {
      String messageId = emails.get(i).getId();
      // make it messageId
      Message message = gmailConnector.getMessage(messageId);
      List<MessagePartHeader> headers = message.getPayload().getHeaders();
      for (MessagePartHeader header : headers) {
        if (header.getName().equals("Subject")) {
          if (header.getValue() != null && header.getValue().contains("OTP")) {
            return message;
          }
        }
      }
    }
    return null;
  }


  private String getOtp(Message latestRelevantEmail) throws IOException{
      String emailBody = getEmailBody(latestRelevantEmail);
      if(!Strings.isNullOrEmpty(emailBody)){
        String otpRegex = "\\b\\d{6}\\b";
        Pattern pattern = Pattern.compile(otpRegex);
        Matcher matcher = pattern.matcher(emailBody);

        if (matcher.find()) {
          return matcher.group();
        }
      }
      return null;
    }


  public String getEmailBody (Message latestRelevantEmail) throws IOException {
    List<MessagePart> messageParts = latestRelevantEmail.getPayload().getParts();
    if (!messageParts.isEmpty()) {
      for (MessagePart part : messageParts) {
        if (part.getMimeType().startsWith("text/plain")) {
          byte[] bytes = Base64.getUrlDecoder().decode(part.getBody().getData());
          return  new String(bytes);
        }
      }
    }
    return null;
  }

}
