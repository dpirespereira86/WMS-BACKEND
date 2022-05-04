package com.diogopires.demo.dto;

import java.io.Serializable;

import com.diogopires.demo.domain.ItemPedidoCompra;

public class ItemPedidoCompraDTO implements Serializable {
  private static final long serialVersionUID = 1L;
    
  private String descricaoProduto;
  private Double quantidade;
  private Double peso;
  private Double valorReferencia;
  private Double valorUnitario;

  


  public ItemPedidoCompraDTO() {
  }

  
  public ItemPedidoCompraDTO(ItemPedidoCompra obj) {
    this.descricaoProduto = obj.getDescricaoProduto();
    this.quantidade = obj.getQuantidade();
   
    this.valorReferencia = obj.getValorReferencia();
    this.valorUnitario = obj.getValorUnitario();
    
    
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


  public Double getValorReferencia() {
    return valorReferencia;
  }


  public void setValorReferencia(Double valorReferencia) {
    this.valorReferencia = valorReferencia;
  }


  public Double getValorUnitario() {
    return valorUnitario;
  }


  public void setValorUnitario(Double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }


 


  

  

  
}
