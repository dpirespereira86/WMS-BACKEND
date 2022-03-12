package com.diogopires.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.diogopires.demo.domain.enums.TipoMovimentacao;

@Entity
public class Movimentacao implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Date instante;
  private Integer operacao;
  
  
  @ManyToOne
  @JoinColumn(name = "empresa_id")
  private Empresa empresa;
  
 
  @OneToMany(mappedBy = "id.movimentacao")
  private List<ItemMovimentacao> itens = new ArrayList<>();
  
  @ManyToOne
  @JoinColumn(name = "posicao_id")
  private Posicao posicao;

  public Movimentacao() {
  }

  public Movimentacao(Integer id, Date instante, TipoMovimentacao operacao, Empresa empresa, Posicao posicao) {
    this.id = id;
    this.instante = instante;
    this.operacao = operacao.getCod();
    this.empresa = empresa;
    this.posicao = posicao;
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

  public TipoMovimentacao getOperacao() {
    return TipoMovimentacao.toEnum(operacao);
  }

  public void setOperacao(TipoMovimentacao operacao) {
    this.operacao = operacao.getCod();
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  public List<ItemMovimentacao> getItens() {
    return itens;
  }

  public void setItens(List<ItemMovimentacao> itens) {
    this.itens = itens;
  }

  public Posicao getPosicao() {
    return posicao;
  }

  public void setPosicao(Posicao posicao) {
    this.posicao = posicao;
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
    Movimentacao other = (Movimentacao) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
  
  
  
  
  
  

}
