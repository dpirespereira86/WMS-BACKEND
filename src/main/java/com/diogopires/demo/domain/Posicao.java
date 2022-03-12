package com.diogopires.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Posicao implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(unique = true)
  private String nome;
  private Double quantidade;
  private Double peso;
  private Double capacidade;
  
  @ManyToOne
  @JoinColumn(name = "estoque_id")
  private Estoque estoque;
  
  
  @OneToOne
  @JoinColumn(name = "rua_id")
  private Rua rua;

  @OneToOne
  @JoinColumn(name = "predio_id")
  private Predio predio;

  @OneToOne
  @JoinColumn(name = "nivel_id")
  private Nivel nivel;

  @ManyToMany
  @JoinTable(name="PRODUTO_POSICAO", joinColumns = @JoinColumn(name="produto_id"), inverseJoinColumns = @JoinColumn(name = "posicao_id") )
  private List<Produto> produtos = new ArrayList<>();

  @OneToMany(mappedBy = "posicao")
  private List<ItemPosicao> itens = new ArrayList<>();


  public Posicao(){

  }


  public Posicao(Integer id,Estoque estoque, Rua rua, Predio predio,
      Nivel nivel) {
    this.id = id;
    this.nome = estoque.getNome() + "-" + rua.getNome() + predio.getNome() + nivel.getNome() ;
    this.estoque = estoque;
    this.quantidade = 0.00;
    this.peso = 0.00;
    this.capacidade = 0.00;
    this.rua = rua;
    this.predio = predio;
    this.nivel = nivel;
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


  public Estoque getEstoque() {
    return estoque;
  }


  public void setEstoque(Estoque estoque) {
    this.estoque = estoque;
  }


  public Rua getRua() {
    return rua;
  }


  public void setRua(Rua rua) {
    this.rua = rua;
  }


  public Predio getPredio() {
    return predio;
  }


  public void setPredio(Predio predio) {
    this.predio = predio;
  }


  public Nivel getNivel() {
    return nivel;
  }


  public void setNivel(Nivel nivel) {
    this.nivel = nivel;
  }


  public List<Produto> getProdutos() {
    return produtos;
  }


  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  public List<ItemPosicao> getItens() {
    return itens;
  }


  public void setItens(List<ItemPosicao> itens) {
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
    Posicao other = (Posicao) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
}
