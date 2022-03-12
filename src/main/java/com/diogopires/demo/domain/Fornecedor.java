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
public class Fornecedor implements Serializable {
  private static final long serialVersionUID = 1L;
  
  //  ATRIBUTOS ----------------------------------------------------------
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String razaoSocial;
  private String cnpj;
  private String email;
  
  @ManyToOne
  @JoinColumn(name = "empresa_id")
  private Empresa empresa;
  
  @OneToMany(mappedBy = "fornecedor")
  private List<EnderecoEmpresa> enderecos = new ArrayList<>();
  
  @OneToMany(mappedBy = "fornecedor")
  private List<Produto> produtos = new ArrayList<>();

  @OneToMany(mappedBy = "fornecedor")
  private List<PedidoCompra> pedidoCompra = new ArrayList<>();


//  CONSTRUTORES ----------------------------------------------------------
 

  public Fornecedor(){

  }

  public Fornecedor(Integer id, String razaoSocial, String cnpj,Empresa empresa,String email) {
    this.id = id;
    this.razaoSocial = razaoSocial;
    this.cnpj = cnpj;
    this.empresa = empresa;
    this.email = email;
  }

  //  GETS E SETS ----------------------------------------------------------


  
  public Integer getId() {
    return id;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
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

  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
    Fornecedor other = (Fornecedor) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
  
  
  
  
  
}
