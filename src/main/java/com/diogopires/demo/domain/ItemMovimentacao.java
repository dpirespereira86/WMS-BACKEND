package com.diogopires.demo.domain;

import java.io.Serializable;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class ItemMovimentacao implements Serializable {
  private static final long serialVersionUID = 1L;

  /*ATRIBUTOS--------------------------------*/
  
  @EmbeddedId
  private ItemMovimentacaoPK id = new ItemMovimentacaoPK();
  
  
  @JoinColumn(unique = true)
  private String codigoInterno;
  
  // @Column(columnDefinition = "integer auto_increment")
  private Integer cod;

  private String descricaoProduto;
  private Double quantidade;
  private Double peso;

  @ManyToOne
  @JoinColumn(name = "posicao_id")
  private Posicao posicao;
  
  /*CONSTRUTORES--------------------------------*/

  public ItemMovimentacao() {
  }


  public ItemMovimentacao(Movimentacao movimentacao,Produto produto, String cod, Double quantidade, Double peso) {
    id.setMovimentacao(movimentacao);
    id.setProduto(produto);
    this.codigoInterno = produto.getCodigoBarra() + "-" + cod;
    this.descricaoProduto = produto.getDescricao();
    this.quantidade = quantidade;
    this.peso = peso;
    
    
  }

  /*GET E SETERS--------------------------------*/

  public ItemMovimentacaoPK getId() {
    return id;
  }


  public void setId(ItemMovimentacaoPK id) {
    this.id = id;
  }


  public String getCodigoInterno() {
    return codigoInterno;
  }


  public void setCodigoInterno(String codigoInterno) {
    this.codigoInterno = codigoInterno;
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

  public Movimentacao getMovimentacao(){
    return id.getMovimentacao();
  }

  public void setMovimentacao(Movimentacao movimentacao){
     id.setMovimentacao(movimentacao);
  }
  
  public Produto getProduto(){
    return id.getProduto();
  }

  public void setProduto(Produto produto){
    id.setProduto(produto);
  }

  public Integer getCod() {
    return cod;
  }


  public void setCod(Integer cod) {
    this.cod = cod;
  }

  public String getDescricaoProduto() {
    return descricaoProduto;
  }


  public void setDescricaoProduto(String descricaoProduto) {
    this.descricaoProduto = descricaoProduto;
  }

  public Posicao getPosicao() {
    return posicao;
  }


  public void setPosicao(Posicao posicao) {
    this.posicao = posicao;
  }

   /*HASH COD EQUALS--------------------------------*/


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
    ItemMovimentacao other = (ItemMovimentacao) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
}
