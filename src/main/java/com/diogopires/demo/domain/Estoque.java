package com.diogopires.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Estoque implements Serializable{
  private static final long serialVersionUID = 1L;
  
  /*ATRIBUTOS-------------------------------------*/
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private Double quantidade;
  private Double peso;
  private Double capacidade;
  
  @OneToMany(mappedBy = "estoque")
  private List<Posicao> posicoes = new ArrayList<>();


  @ManyToOne
  @JoinColumn(name = "empresa_id") 
  private Empresa empresa;
  
  /*CONSTRUTORES-------------------------------------*/
  public Estoque(){

  }

  public Estoque(Integer id, String nome,Empresa empresa) {
    this.id = id;
    this.nome = nome;
    this.quantidade = 0.00;
    this.peso = 0.00;
    this.capacidade =0.00;
    this.empresa = empresa;
  }
  
  /*GET E SETS-------------------------------------*/

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

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  
  public List<Posicao> getPosicoes() {
    return posicoes;
  }

  public void setPosicoes(List<Posicao> posicoes) {
    this.posicoes = posicoes;
  }

  /*EQUALS E HASH-------------------------------------*/

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
    Estoque other = (Estoque) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
    
  }
}
