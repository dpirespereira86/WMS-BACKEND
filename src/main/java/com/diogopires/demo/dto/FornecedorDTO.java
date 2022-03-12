package com.diogopires.demo.dto;

import java.io.Serializable;

import com.diogopires.demo.domain.Fornecedor;

public class FornecedorDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer id;
  private String razaoSocial;
  private String cnpj;
  private String email;

  public FornecedorDTO() {
  }

  public FornecedorDTO(Fornecedor obj) {
    this.id = obj.getId();
    this.razaoSocial = obj.getRazaoSocial();
    this.cnpj = obj.getCnpj();
    this.email = obj.getEmail();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  

  
  
  
}
