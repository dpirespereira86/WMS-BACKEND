package com.diogopires.demo.dto;

import java.io.Serializable;



public class EmpresaPostDTO implements Serializable{
  private static final long serialVersionUID = 1L;
  
  
  private String razaoSocial;
  private String cnpj;
  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String cep;
  private String uf;
  private String cidade;
  private String responsavel;
  private String emailresponsavel;
  private String setor;
  private String perfil;
  private String senha;


  


  public EmpresaPostDTO() {
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


  public String getLogradouro() {
    return logradouro;
  }


  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }


  public String getNumero() {
    return numero;
  }


  public void setNumero(String numero) {
    this.numero = numero;
  }


  public String getComplemento() {
    return complemento;
  }


  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }


  public String getBairro() {
    return bairro;
  }


  public void setBairro(String bairro) {
    this.bairro = bairro;
  }


  public String getCep() {
    return cep;
  }


  public void setCep(String cep) {
    this.cep = cep;
  }


  public String getUf() {
    return uf;
  }


  public void setUf(String uf) {
    this.uf = uf;
  }


  public String getCidade() {
    return cidade;
  }


  public void setCidade(String cidade) {
    this.cidade = cidade;
  }


  public String getResponsavel() {
    return responsavel;
  }


  public void setResponsavel(String responsavel) {
    this.responsavel = responsavel;
  }


  public String getSetor() {
    return setor;
  }


  public void setSetor(String setor) {
    this.setor = setor;
  }


  public String getPerfil() {
    return perfil;
  }


  public void setPerfil(String perfil) {
    this.perfil = perfil;
  }

  public String getEmailresponsavel() {
    return emailresponsavel;
  }


  public void setEmailresponsavel(String emailresponsavel) {
    this.emailresponsavel = emailresponsavel;
  }

  public String getSenha() {
    return senha;
  }


  public void setSenha(String senha) {
    this.senha = senha;
  }

  



}
