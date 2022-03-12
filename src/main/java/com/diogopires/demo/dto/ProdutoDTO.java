package com.diogopires.demo.dto;

import java.io.Serializable;

import com.diogopires.demo.domain.Produto;

public class ProdutoDTO implements Serializable {
  private static final long serialVersionUID = 1L;

 
  private Integer id;
  private String codigoBarra;
  private String descricao;
  private Double comprimento;
  private Double largura;
  private Double altura;
  private Double peso;
  private Double ultimoPrecoCompra;
  private String unidade;
  private Double estoqueMinimo;
  private Double estoqueMaximo;
  private Double quantidade;
  private Integer prazoEntrega;

  public ProdutoDTO() {
  }

  public ProdutoDTO(Produto obj) {
    this.id = obj.getId();
    this.codigoBarra = obj.getCodigoBarra();
    this.descricao = obj.getDescricao();
    this.comprimento = obj.getComprimento();
    this.largura = obj.getLargura();
    this.altura = obj.getAltura();
    this.peso = obj.getPeso();
    this.ultimoPrecoCompra = obj.getUltimoPrecoCompra();
    this.unidade = obj.getUnidade();
    this.estoqueMinimo = obj.getEstoqueMinimo();
    this.estoqueMaximo = obj.getEstoqueMaximo();
    this.quantidade = obj.getQuantidade();
    this.prazoEntrega = obj.getPrazoEntrega();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCodigoBarra() {
    return codigoBarra;
  }

  public void setCodigoBarra(String codigoBarra) {
    this.codigoBarra = codigoBarra;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getComprimento() {
    return comprimento;
  }

  public void setComprimento(Double comprimento) {
    this.comprimento = comprimento;
  }

  public Double getLargura() {
    return largura;
  }

  public void setLargura(Double largura) {
    this.largura = largura;
  }

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public Double getUltimoPrecoCompra() {
    return ultimoPrecoCompra;
  }

  public void setUltimoPrecoCompra(Double ultimoPrecoCompra) {
    this.ultimoPrecoCompra = ultimoPrecoCompra;
  }

  public String getUnidade() {
    return unidade;
  }

  public void setUnidade(String unidade) {
    this.unidade = unidade;
  }

  public Double getEstoqueMinimo() {
    return estoqueMinimo;
  }

  public void setEstoqueMinimo(Double estoqueMinimo) {
    this.estoqueMinimo = estoqueMinimo;
  }

  public Double getEstoqueMaximo() {
    return estoqueMaximo;
  }

  public void setEstoqueMaximo(Double estoqueMaximo) {
    this.estoqueMaximo = estoqueMaximo;
  }

  public Double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Double quantidade) {
    this.quantidade = quantidade;
  }

  public Integer getPrazoEntrega() {
    return prazoEntrega;
  }

  public void setPrazoEntrega(Integer prazoEntrega) {
    this.prazoEntrega = prazoEntrega;
  }
   
  
  
  
}
