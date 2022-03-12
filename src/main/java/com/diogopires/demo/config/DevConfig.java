package com.diogopires.demo.config;


import java.text.ParseException;

import com.diogopires.demo.services.DBService;
import com.diogopires.demo.services.EmailService;
import com.diogopires.demo.services.SmtpEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
  
  @Autowired
  private DBService dbService;

  @Value("${spring.jpa.hibernate.ddl-auto}")
  private String strategy;
  
  @Bean 
  public boolean instantiateDatabase() throws ParseException{

    if(!"create".equals(strategy)){
      return false;
    }
    dbService.instanteTestDatabase();
    return true;
  }

  @Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
