package com.diogopires.demo.dto;

import javax.validation.constraints.NotEmpty;

import com.diogopires.demo.domain.Rua;



public class RuaDTO {

  private Integer id;
  
  
  @NotEmpty(message="Preenchimento Obrigatório!!")
  private String nome;

  public RuaDTO() {
  }

  public RuaDTO(Rua obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
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
  
}
