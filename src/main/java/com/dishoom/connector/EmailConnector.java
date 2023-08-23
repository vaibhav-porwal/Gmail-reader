package com.dishoom.connector;

import com.google.api.services.gmail.model.Message;

import java.io.IOException;
import java.util.List;

public interface EmailConnector {
    List<Message> getMails() throws IOException;
    Message getMessage(String messageId) throws IOException;
}
