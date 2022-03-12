package com.diogopires.demo.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Embeddable
public class ItemMovimentacaoPK implements Serializable {
  private static final long serialVersionUID = 1L;
  
  
  @ManyToOne
  @JoinColumn(name = "movimentacao_id")
  private Movimentacao movimentacao;
  
  
 
  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;


  public Movimentacao getMovimentacao() {
    return movimentacao;
  }
  public void setMovimentacao(Movimentacao movimentacao) {
    this.movimentacao = movimentacao;
  }
  public Produto getProduto() {
    return produto;
  }
  public void setProduto(Produto produto) {
    this.produto = produto;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((movimentacao == null) ? 0 : movimentacao.hashCode());
    result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
    ItemMovimentacaoPK other = (ItemMovimentacaoPK) obj;
    if (movimentacao == null) {
      if (other.movimentacao != null)
        return false;
    } else if (!movimentacao.equals(other.movimentacao))
      return false;
    if (produto == null) {
      if (other.produto != null)
        return false;
    } else if (!produto.equals(other.produto))
      return false;
    return true;
  }
  
  
  
}
