package com.dishoom;

//import com.dishoom.db.repository.QuestionerRepositoryImpl;
import com.dishoom.gmail.EmailService;
import com.dishoom.gmail.GmailServiceImpl;
import com.google.inject.AbstractModule;
    import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class KoohooModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(EmailService.class).to(GmailServiceImpl.class);
  }

}
