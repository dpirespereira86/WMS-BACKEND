package com.diogopires.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.PedidoCompra;

public class PedidoCompraDTO  implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private Date instante;
  private Date dataAprovacao;
  private Date dataEntrega;
  private Date previsaoEntrega;
  private Integer prazoEntrega;
  private Double valorTotal;
  private String origem;
  private String condicaoPagamento;
  private Integer prazoPagamento;
  private String status;
  private String respAprovacao;
  private String fornecedor;
  private List<ItemPedidoCompraDTO> itens = new ArrayList<>();


  public PedidoCompraDTO() {
  }


  public PedidoCompraDTO(PedidoCompra obj) {
    System.out.println("------------- PASSEI AQUI DTO-----------------" + obj.getEmpresa().getRazaoSocial());
    this.instante = obj.getInstante();
    this.dataAprovacao = obj.getDataAprovacao();
    this.dataEntrega = obj.getDataEntrega();
    this.previsaoEntrega = obj.getPrevisaoEntrega();
    this.prazoEntrega = obj.getPrazoEntrega();
    this.valorTotal = obj.getValorTotal();
    this.origem = (obj.getOrigem() == null) ? null : obj.getOrigem().name();
    this.condicaoPagamento = (obj.getCondicaoPagamento() != null ) ? obj.getCondicaoPagamento().getDescricao() : null;
    this.prazoPagamento = obj.getPrazoPagamento();
    this.status = obj.getStatus().getDescricao();
    this.respAprovacao = (obj.getRespAprovacao() != null) ? obj.getRespAprovacao().getEmail() : null;
    this.fornecedor = (obj.getFornecedor() != null) ? obj.getFornecedor().getRazaoSocial(): null;
    List<ItemPedidoCompraDTO> it = obj.getItens().stream().map(p -> new ItemPedidoCompraDTO(p)).collect(Collectors.toList());
    this.itens = it;
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


  public String getOrigem() {
    return origem;
  }


  public void setOrigem(String origem) {
    this.origem = origem;
  }


  public String getCondicaoPagamento() {
    return condicaoPagamento;
  }


  public void setCondicaoPagamento(String condicaoPagamento) {
    this.condicaoPagamento = condicaoPagamento;
  }


  public Integer getPrazoPagamento() {
    return prazoPagamento;
  }


  public void setPrazoPagamento(Integer prazoPagamento) {
    this.prazoPagamento = prazoPagamento;
  }


  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    this.status = status;
  }


  public String getRespAprovacao() {
    return respAprovacao;
  }


  public void setRespAprovacao(String respAprovacao) {
    this.respAprovacao = respAprovacao;
  }


  public String getFornecedor() {
    return fornecedor;
  }


  public void setFornecedor(String fornecedor) {
    this.fornecedor = fornecedor;
  }


  public List<ItemPedidoCompraDTO> getItens() {
    return itens;
  }


  public void setItens(List<ItemPedidoCompraDTO> itens) {
    this.itens = itens;
  }

  
  
  


  
}
