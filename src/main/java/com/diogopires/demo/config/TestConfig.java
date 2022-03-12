package com.diogopires.demo.config;


import java.text.ParseException;

import com.diogopires.demo.services.DBService;
import com.diogopires.demo.services.EmailService;
import com.diogopires.demo.services.MockEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
  
  @Autowired
  private DBService dbService;
  
  @Bean 
  public boolean instantiateDatabase() throws ParseException{
    dbService.instanteTestDatabase();
    return true;
  }

  @Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
