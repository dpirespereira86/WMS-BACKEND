package com.diogopires.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.diogopires.demo.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String email;
  private String setor;

  @JsonIgnore
  private String password;
 


  @ManyToOne
  @JoinColumn(name = "empresa_id")
  private Empresa empresa;

  @OneToMany(mappedBy = "respAprovacao")
  private List<PedidoCompra> pedidoCompra = new ArrayList<>();

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name="PERFIS")
  private Set<Integer> perfis = new HashSet<>();


  public List<PedidoCompra> getPedidoCompra() {
    return pedidoCompra;
  }

  public void setPedidoCompra(List<PedidoCompra> pedidoCompra) {
    this.pedidoCompra = pedidoCompra;
  }

  public Usuario(){
     addPerfil(Perfil.OPERADOR);     
  }

  public Usuario(Integer id, String email, String setor,String nome, Empresa empresa, String senha) {
    this.id = id;
    this.email = email;
    this.password = senha;
    this.nome = nome;
    this.empresa = empresa;
    this.setor = setor;
    addPerfil(Perfil.OPERADOR);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSetor() {
    return setor;
  }

  public void setSetor(String setor) {
    this.setor = setor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Set<Perfil> getPerfis() {
    return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
  }

  public void addPerfil(Perfil perfil) {
    perfis.add(perfil.getCod());
  }

  public String getSenha() {
    return password;
  }

  public void setSenha(String senha) {
    this.password = senha;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
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
    Usuario other = (Usuario) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
   
  
}
