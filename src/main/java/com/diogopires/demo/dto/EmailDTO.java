package com.diogopires.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmailDTO implements Serializable{
  private static final long serialVersionUID = 1L;
  
  @NotBlank(message="Prenchimento Obrigatório")
  @Email(message = "Email inválido")
  private String email;

  public EmailDTO() {
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  
}
