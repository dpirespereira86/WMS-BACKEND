package com.diogopires.demo.dto;

import com.diogopires.demo.domain.Usuario;
import java.io.Serializable;

public class GetUsuarioDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer id;
  private String nome;
  private String email;
  private String setor;
  private Integer empresa;
  
  public GetUsuarioDTO() {
  }

  public GetUsuarioDTO(Usuario obj) {

    this.id = obj.getId();
    this.nome = obj.getNome();
    this.email = obj.getEmail();
    this.setor = obj.getSetor();
    this.empresa = obj.getEmpresa().getId();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSetor() {
    return setor;
  }

  public void setSetor(String setor) {
    this.setor = setor;
  }

  public Integer getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Integer empresa) {
    this.empresa = empresa;
  }
  
  
}
