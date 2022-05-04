package com.diogopires.demo.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedidoCompra implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private ItemPedidoCompraPK id = new ItemPedidoCompraPK();
  
  private String descricaoProduto;
  private Double quantidade;
  private Double valorReferencia;
  private Double valorUnitario;
  private Double valorItem;

  
  /*CONSTRUTORES--------------------------------*/

  public ItemPedidoCompra() {
  }

  
  public ItemPedidoCompra(Produto produto,PedidoCompra pedidoCompra, Double quantidade,
   Double valorUnitario,Double valorItem) {
  id.setPedidoCompra(pedidoCompra);
  id.setProduto(produto);
  this.descricaoProduto = produto.getDescricao();
  this.quantidade = quantidade;
  this.valorReferencia = produto.getUltimoPrecoCompra();
  this.valorUnitario = valorUnitario;
  this.valorItem = valorItem;
}

/*GET E SETERS--------------------------------*/
  

public void setPedidoCompra(PedidoCompra pedidoCompra){
  id.setPedidoCompra(pedidoCompra);
}

public PedidoCompra getPedidoCompra(){
  return id.getPedidoCompra();
 }

public Produto getProduto(){
 return id.getProduto();
}

public void setProduto(Produto produto){
 id.setProduto(produto);
}

  public ItemPedidoCompraPK getId() {
    return id;
  }


  public void setId(ItemPedidoCompraPK id) {
    this.id = id;
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


  public Double getValorItem() {
    return valorItem;
  }


  public void setValorItem(Double valorTotal) {
    this.valorItem = valorTotal;
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
    ItemPedidoCompra other = (ItemPedidoCompra) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }


  @Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		StringBuilder builder = new StringBuilder();
		builder.append(getProduto().getDescricao());
		builder.append(", Qte: ");
		builder.append(getQuantidade());
		builder.append(", Preço unitário: ");
		builder.append(nf.format(getValorUnitario()));
		builder.append(", Subtotal: ");
		builder.append(nf.format(getValorItem()));
		builder.append("\n");
		return builder.toString();
	}

  
}
