package com.diogopires.demo.domain;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.diogopires.demo.domain.enums.CondicaoPagamento;
import com.diogopires.demo.domain.enums.Origem;
import com.diogopires.demo.domain.enums.StatusCompra;

@Entity
public class PedidoCompra implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private Date instante;
  private Date dataAprovacao;
  private Date dataEntrega;
  private Date previsaoEntrega;
  private Integer prazoEntrega;
  private Double valorTotal;
  private Integer origem;
  private Integer condicaoPagamento;
  private Integer prazoPagamento;
  private Integer status;
  
  @ManyToOne
  @JoinColumn(name = "respAprovacao_id")
  private Usuario respAprovacao;
  
  @ManyToOne
  @JoinColumn(name = "empresa_id")
  private Empresa empresa;
  
  @ManyToOne
  @JoinColumn(name = "fornecedor_id")
  private Fornecedor fornecedor;

  @OneToMany(mappedBy = "id.pedidoCompra")
  private List<ItemPedidoCompra> itens = new ArrayList<>();

  
  public PedidoCompra(){

  }

  
  public PedidoCompra(Integer id, Date instante, Origem origem, Empresa empresa,StatusCompra   status, Fornecedor fornecedor) {
    this.id = id;
    this.instante = instante;
    this.origem = origem.getCod();
    this.empresa = empresa;
    this.status = status.getCod();
    this.fornecedor = fornecedor;
  }


 

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public Date getInstante() {
    return instante;
  }


  public void setInstante(Date instante) {
    this.instante = instante;
  }


  public Date getDataAprovacao() {
    return dataAprovacao;
  }


  public void setDataAprovacao(Date dataAprovacao) {
    this.dataAprovacao = dataAprovacao;
  }


  public Date getDataEntrega() {
    return dataEntrega;
  }


  public void setDataEntrega(Date dataEntrega) {
    this.dataEntrega = dataEntrega;
  }


  public Date getPrevisaoEntrega() {
    return previsaoEntrega;
  }


  public void setPrevisaoEntrega(Date previsaoEntrega) {
    this.previsaoEntrega = previsaoEntrega;
  }


  public Integer getPrazoEntrega() {
    return prazoEntrega;
  }


  public void setPrazoEntrega(Integer prazoEntrega) {
    this.prazoEntrega = prazoEntrega;
  }


  public Double getValorTotal() {
    return valorTotal;
  }


  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }


  public Origem getOrigem() {
    return Origem.toEnum(origem);
  }


  public void setOrigem(Origem origem) {
    this.origem = origem.getCod();
  }


  public CondicaoPagamento getCondicaoPagamento() {
    return CondicaoPagamento.toEnum(condicaoPagamento);
  }


  public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
    this.condicaoPagamento = condicaoPagamento.getCod();
  }


  public Integer getPrazoPagamento() {
    return prazoPagamento;
  }


  public void setPrazoPagamento(Integer prazoPagamento) {
    this.prazoPagamento = prazoPagamento;
  }


  public StatusCompra getStatus() {
    return StatusCompra.toEnum(status);
  }


  public void setStatus(StatusCompra status) {
    this.status = status.getCod();
  }


  public Usuario getRespAprovacao() {
    return respAprovacao;
  }


  public void setRespAprovacao(Usuario respAprovacao) {
    this.respAprovacao = respAprovacao;
  }


  public Empresa getEmpresa() {
    return empresa;
  }


  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }


  public Fornecedor getFornecedor() {
    return fornecedor;
  }


  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }


  public List<ItemPedidoCompra> getItens() {
    return itens;
  }


  public void setItens(List<ItemPedidoCompra> itens) {
    this.itens = itens;
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
    PedidoCompra other = (PedidoCompra) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
    builder.append("Numero do Pedido");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(getInstante());
		builder.append(", Fornecedor: ");
		builder.append(getFornecedor());
		builder.append("\nDetalhes:\n");
    for(ItemPedidoCompra ipc : getItens()){
       builder.append(ipc.toString());
    }

		return builder.toString();
	}

}
