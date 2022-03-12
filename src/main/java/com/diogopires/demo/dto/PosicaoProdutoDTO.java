package com.diogopires.demo.dto;

import java.io.Serializable;

import com.diogopires.demo.domain.Posicao;

public class PosicaoProdutoDTO implements Serializable {
  private static final long serialVersionUID = 1L; 

  private Integer id;
  private String nome;
  private Double quantidade;
  private Double peso;
  private Double capacidade;
  private String rua;
  private String predio;
  private String nivel;

  public PosicaoProdutoDTO() {
  }

  public PosicaoProdutoDTO(Posicao obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
    this.quantidade = obj.getQuantidade();
    this.peso = obj.getPeso();
    this.capacidade = obj.getCapacidade();
    this.rua = obj.getNivel().getNome();
    this.predio = obj.getPredio().getNome();
    this.nivel = obj.getNivel().getNome();
    
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

  public Double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Double quantidade) {
    this.quantidade = quantidade;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public Double getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(Double capacidade) {
    this.capacidade = capacidade;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getPredio() {
    return predio;
  }

  public void setPredio(String predio) {
    this.predio = predio;
  }

  public String getNivel() {
    return nivel;
  }

  public void setNivel(String nivel) {
    this.nivel = nivel;
  }

}
