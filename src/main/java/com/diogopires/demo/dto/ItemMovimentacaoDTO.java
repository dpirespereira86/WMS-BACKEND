package com.diogopires.demo.dto;

import java.io.Serializable;

import com.diogopires.demo.domain.ItemMovimentacao;

public class ItemMovimentacaoDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private Integer cod;
  private Integer codigoInterno;
  private String descricaoProduto;
  private Double quantidade;
  private Double peso;


  public ItemMovimentacaoDTO() {
  }

  public ItemMovimentacaoDTO(ItemMovimentacao obj) {
     cod = obj.getCod();
     codigoInterno = Integer.parseInt(obj.getCodigoInterno());
     descricaoProduto = obj.getDescricaoProduto();
     quantidade = obj.getQuantidade();
     peso = obj.getPeso();
  }


  public Integer getCod() {
    return cod;
  }


  public void setCod(Integer cod) {
    this.cod = cod;
  }


  public Integer getCodigoInterno() {
    return codigoInterno;
  }


  public void setCodigoInterno(Integer codigoInterno) {
    this.codigoInterno = codigoInterno;
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

  

  



}
