package com.diogopires.demo.dto;

import com.diogopires.demo.domain.Predio;

public class PredioDTO {
  
    private Integer id;
    private String nome;
  
    public PredioDTO() {
    }
  
    public PredioDTO(Predio obj) {
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
