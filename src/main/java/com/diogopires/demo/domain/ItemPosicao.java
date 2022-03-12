package com.diogopires.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemPosicao implements Serializable {
  private static final long serialVersionUID = 1L; 

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(unique=true)
  private String codInterno;
  private String descricaoProduto;
  private Double quantidade;
  private Double peso;

  @ManyToOne
  @JoinColumn(name = "posicao_id")
  private Posicao posicao;

  public ItemPosicao() {
  }

  public ItemPosicao(Integer id, String codInterno, String descricaoProduto, Double quantidade, Double peso,
      Posicao posicao) {
    this.id = id;
    this.codInterno = codInterno;
    this.descricaoProduto = descricaoProduto;
    this.quantidade = quantidade;
    this.peso = peso;
    this.posicao = posicao;
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

  public Posicao getPosicao() {
    return posicao;
  }

  public void setPosicao(Posicao posicao) {
    this.posicao = posicao;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ItemPosicao other = (ItemPosicao) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }


}
