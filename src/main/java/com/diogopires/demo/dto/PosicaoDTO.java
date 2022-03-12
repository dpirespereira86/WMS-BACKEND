package com.diogopires.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.ItemPosicao;
import com.diogopires.demo.domain.Posicao;

public class PosicaoDTO implements Serializable {
  private static final long serialVersionUID = 1L; 
  
  private Integer id;
  private String nome;
  private Double quantidade;
  private Double peso;
  private Double capacidade;
  private String rua;
  private String predio;
  private String nivel;

  private List<ItemPosicaoDTO> itens = new ArrayList<>();

  public PosicaoDTO() {
  }

  public PosicaoDTO(Posicao obj) {
    this.id = obj.getId();
    this.nome = obj.getNome();
    this.quantidade = obj.getQuantidade();
    this.peso = obj.getPeso();
    this.capacidade = obj.getCapacidade();
    this.rua = obj.getNivel().getNome();
    this.predio = obj.getPredio().getNome();
    this.nivel = obj.getNivel().getNome();
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

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getPredio() {
    return predio;
  }

  public void setPredio(String predio) {
    this.predio = predio;
  }

  public String getNivel() {
    return nivel;
  }

  public void setNivel(String nivel) {
    this.nivel = nivel;
  }

  public List<ItemPosicaoDTO> getItens() {
    return itens;
  }

  public void setItens(List<ItemPosicaoDTO> itens) {
    this.itens = itens;
  }

  
}
