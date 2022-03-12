package com.diogopires.demo.dto;

import java.io.Serializable;

import com.diogopires.demo.domain.ItemPosicao;

public class ItemPosicaoDTO implements Serializable {
  private static final long serialVersionUID = 1L; 
  
  private Integer id;
  private String codInterno;
  private String descricaoProduto;
  private Double quantidade;
  private Double peso;
  private Integer posicao;


  public ItemPosicaoDTO() {
  }


  public ItemPosicaoDTO(ItemPosicao obj) {
    this.id = obj.getId();
    this.codInterno = obj.getCodInterno();
    this.descricaoProduto = obj.getDescricaoProduto();
    this.quantidade = obj.getQuantidade();
    this.peso = obj.getPeso();
    this.posicao = obj.getPosicao().getId();
  }


  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public String getCodInterno() {
    return codInterno;
  }


  public void setCodInterno(String codInterno) {
    this.codInterno = codInterno;
  }


  public String getDescricaoProduto() {
    return descricaoProduto;
  }


  public void setDescricaoProduto(String descricaoProduto) {
    this.descricaoProduto = descricaoProduto;
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


  public Integer getPosicao() {
    return posicao;
  }


  public void setPosicao(Integer posicao) {
    this.posicao = posicao;
  }

  

  
}
