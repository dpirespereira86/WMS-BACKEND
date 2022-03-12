package com.diogopires.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Estoque;
import com.diogopires.demo.domain.Posicao;

public class EstoqueDTO implements Serializable{
  private static final long serialVersionUID = 1L;
  
  private Integer id;
  private String nome;
  private Double quantidade;
  private Double peso;
  private Double capacidade;
  private Integer empresa;
  private List<PosicaoDTO> posicao = new ArrayList<>();


  public EstoqueDTO() {
  }


  public EstoqueDTO(Estoque obj) {
    this.id = obj.getId() ;
    this.nome = obj.getNome();
    this.quantidade = obj.getQuantidade();
    this.peso = obj.getPeso();
    this.capacidade = obj.getCapacidade();
    this.empresa = obj.getEmpresa().getId();
    this.posicao = converter(obj.getPosicoes());
  }

  public List<PosicaoDTO> converter(List<Posicao> obj){
    List<PosicaoDTO> list = obj.stream().map(p -> new PosicaoDTO(p)).collect(Collectors.toList());
    return list;
  }


  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public String getNome() {
    return nome;
  }


  public void setNome(String nome) {
    this.nome = nome;
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


  public Double getCapacidade() {
    return capacidade;
  }


  public void setCapacidade(Double capacidade) {
    this.capacidade = capacidade;
  }


  public Integer getEmpresa() {
    return empresa;
  }


  public void setEmpresa(Integer empresa) {
    this.empresa = empresa;
  }


  public List<PosicaoDTO> getPosicao() {
    return posicao;
  }


  public void setPosicao(List<PosicaoDTO> posicao) {
    this.posicao = posicao;
  }

  

  


}
