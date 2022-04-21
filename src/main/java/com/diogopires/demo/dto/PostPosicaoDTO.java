package com.diogopires.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.diogopires.demo.domain.ItemPosicao;
import com.diogopires.demo.domain.Posicao;

public class PostPosicaoDTO implements Serializable {
  private static final long serialVersionUID = 1L; 
  
  private Integer id;
  private String nome;
  private Double quantidade;
  private Double peso;
  private Integer estoque;
  private Double capacidade;
  private Integer rua;
  private Integer predio;
  private Integer nivel;
  private Integer ordem;

 

  private List<ItemPosicaoDTO> itens = new ArrayList<>();

  public PostPosicaoDTO() {
  }

  public PostPosicaoDTO(Posicao obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
    this.quantidade = obj.getQuantidade();
    this.peso = obj.getPeso();
    this.estoque=obj.getEstoque().getId();
    this.capacidade = obj.getCapacidade();
    this.rua = obj.getNivel().getId();
    this.predio = obj.getPredio().getId();
    this.nivel = obj.getNivel().getId();
    this.ordem = obj.getOrdem();
    this.itens = converter(obj.getItens());
  }

  public List<ItemPosicaoDTO> converter(List<ItemPosicao> obj){
    List<ItemPosicaoDTO> list = obj.stream().map(p -> new ItemPosicaoDTO(p)).collect(Collectors.toList());
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

  public Integer getRua() {
    return rua;
  }

  public void setRua(Integer rua) {
    this.rua = rua;
  }

  public Integer getPredio() {
    return predio;
  }

  public void setPredio(Integer predio) {
    this.predio = predio;
  }

  public Integer getNivel() {
    return nivel;
  }

  public void setNivel(Integer nivel) {
    this.nivel = nivel;
  }

  public List<ItemPosicaoDTO> getItens() {
    return itens;
  }

  public void setItens(List<ItemPosicaoDTO> itens) {
    this.itens = itens;
  }

  public Integer getEstoque() {
    return estoque;
  }

  public void setEstoque(Integer estoque) {
    this.estoque = estoque;
  }

  public Integer getOrdem() {
    return ordem;
  }

  public void setOrdem(Integer ordem) {
    this.ordem = ordem;
  }

  
}
