package com.diogopires.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Movimentacao;


public class MovimentacaoDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private Integer id;
  private Date instante;
  private String operacao;
  private String posicao;
  private List<ItemMovimentacaoDTO> itens = new ArrayList<>();
  

  public MovimentacaoDTO() {
  }

  public MovimentacaoDTO(Movimentacao obj) {

    id = obj.getId();
    instante = obj.getInstante();
    operacao = obj.getOperacao().getDescricao();
    posicao = obj.getPosicao().getNome();
    List<ItemMovimentacaoDTO> it = obj.getItens().stream().map(p -> new ItemMovimentacaoDTO(p)).collect(Collectors.toList());
    itens = it;
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

  public String getOperacao() {
    return operacao;
  }

  public void setOperacao(String operacao) {
    this.operacao = operacao;
  }

  public List<ItemMovimentacaoDTO> getItens() {
    return itens;
  }

  public void setItens(List<ItemMovimentacaoDTO> itens) {
    this.itens = itens;
  }

  public String getPosicao() {
    return posicao;
  }

  public void setPosicao(String posicao) {
    this.posicao = posicao;
  }
  
  
  

}
