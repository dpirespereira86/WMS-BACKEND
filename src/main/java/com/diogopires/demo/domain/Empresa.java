package com.diogopires.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empresa implements Serializable {
  private static final long serialVersionUID = 1L;
  
  //  ATRIBUTOS ----------------------------------------------------------
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String razaoSocial;
  private String cnpj;



  @OneToMany(mappedBy = "empresa")
  private List<Usuario> usuarios = new ArrayList<>();
  
  @OneToMany(mappedBy = "empresa")
  private List<EnderecoEmpresa> enderecos = new ArrayList<>();
  
  @OneToMany(mappedBy = "empresa")
  private List<Produto> produtos = new ArrayList<>();
  
  @OneToMany(mappedBy = "empresa")
  private List<Estoque> estoques = new ArrayList<>();

  @OneToMany(mappedBy = "empresa")
  private List<Movimentacao> movimentacoes = new ArrayList<>();

  @OneToMany(mappedBy = "empresa")
  private List<Rua> ruas = new ArrayList<>();

  @OneToMany(mappedBy = "empresa")
  private List<Predio> predios = new ArrayList<>();

  @OneToMany(mappedBy = "empresa")
  private List<Nivel> niveis = new ArrayList<>();

  @OneToMany(mappedBy = "empresa")
  private List<PedidoCompra> pedidoCompra = new ArrayList<>();

  @OneToMany(mappedBy = "empresa")
  private List<Fornecedor> fornecedor = new ArrayList<>();


//  CONSTRUTORES ----------------------------------------------------------
 

  public Empresa(){

  }

  public Empresa(Integer id, String razaoSocial, String cnpj) {
    this.id = id;
    this.razaoSocial = razaoSocial;
    this.cnpj = cnpj;
  }

  //  GETS E SETS ----------------------------------------------------------

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  public List<EnderecoEmpresa> getEnderecos() {
    return enderecos;
  }

  public void setEnderecos(List<EnderecoEmpresa> enderecos) {
    this.enderecos = enderecos;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }


  public List<Estoque> getEstoques() {
    return estoques;
  }

  public void setEstoques(List<Estoque> estoques) {
    this.estoques = estoques;
  }

  public List<Movimentacao> getMovimentacoes() {
    return movimentacoes;
  }

  public void setMovimentacoes(List<Movimentacao> movimentacoes) {
    this.movimentacoes = movimentacoes;
  }

  public List<Rua> getRuas() {
    return ruas;
  }

  public void setRuas(List<Rua> ruas) {
    this.ruas = ruas;
  }

  public List<Predio> getPredios() {
    return predios;
  }

  public void setPredios(List<Predio> predios) {
    this.predios = predios;
  }

  public List<Nivel> getNiveis() {
    return niveis;
  }

  public void setNiveis(List<Nivel> niveis) {
    this.niveis = niveis;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public List<PedidoCompra> getPedidoCompra() {
    return pedidoCompra;
  }

  public void setPedidoCompra(List<PedidoCompra> pedidoCompra) {
    this.pedidoCompra = pedidoCompra;
  }
  
  //  HASH EQUALS ----------------------------------------------------------
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
    Empresa other = (Empresa) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
  
  
}
