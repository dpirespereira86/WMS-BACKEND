package com.diogopires.demo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.diogopires.demo.domain.Fornecedor;
import com.diogopires.demo.domain.ItemPedidoCompra;
import com.diogopires.demo.domain.PedidoCompra;


public class PostPedidoCompraDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  
  
  private Date previsaoEntrega;
  private Integer prazoEntrega;
  private Double valorTotal;
  private Integer origem;
  private Integer condicaoPagamento;
  private Integer prazoPagamento;
  private Integer status;
  private Fornecedor fornecedor;
  
  private List<ItemPedidoCompraDTO> itens;

  public PostPedidoCompraDTO() {
  }

  public PostPedidoCompraDTO(PedidoCompra obj) {
    this.previsaoEntrega = obj.getPrevisaoEntrega();
    this.prazoEntrega = obj.getPrazoEntrega();
    this.valorTotal = obj.getValorTotal();
    this.origem = obj.getOrigem().getCod();
    this.condicaoPagamento = obj.getCondicaoPagamento().getCod();
    this.prazoPagamento = prazoPagamento;
    this.status = status;
    this.fornecedor = fornecedor;
    this.itens = itens;
  }



  

}
