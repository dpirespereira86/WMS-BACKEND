package com.diogopires.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
import javax.persistence.OneToMany;



@Entity
public class Produto implements Serializable {
  private static final long serialVersionUID = 1L;
  

  //  ATRIBUTOS ----------------------------------------------------------
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @JoinColumn(unique = true)
  private String codigoBarra;
  private String sku;
  private String descricao;
  private Double comprimento;
  private Double largura;
  private Double altura;
  private Double peso;
  private Double ultimoPrecoCompra;
  private String unidade;
  private Double estoqueMinimo;
  private Double estoqueMaximo;
  private Double quantidade;
  private Integer prazoEntrega;
  private Date dataCriacao;
  private Date dataAtualizacao;
  private String imageUrl;
  
  
  @OneToMany(mappedBy = "id.produto")
  private List<ItemMovimentacao> itens = new ArrayList<>();

  // private List<ItemCompra> itensCompras = new ArrayList<>();

  @ManyToMany(mappedBy = "produtos")
  private List<Posicao> posicoes = new ArrayList<>();
  

  @ManyToOne
  @JoinColumn(name = "empresa_id")
  private Empresa empresa;

  @ManyToOne
  @JoinColumn(name = "fornecedor_id")
  private Fornecedor fornecedor;

  //  CONSTRUTOR ----------------------------------------------------------

  public Produto(){

  }


  public Produto(Integer id, String codigoBarra,String sku, String descricao, Double comprimento, Double largura, Double altura,
      Double peso, Double ultimoPrecoCompra, String unidade, Double estoqueMinimo, Double estoqueMaximo,
      Double quantidade, Integer prazoEntrega,Empresa empresa,Fornecedor fornecedor) {
    this.id = id;
    this.codigoBarra = codigoBarra;
    this.sku = sku;
    this.descricao = descricao;
    this.comprimento = comprimento;
    this.largura = largura;
    this.altura = altura;
    this.peso = peso;
    this.ultimoPrecoCompra = ultimoPrecoCompra;
    this.unidade = unidade;
    this.estoqueMinimo = estoqueMinimo;
    this.estoqueMaximo = estoqueMaximo;
    this.quantidade = quantidade;
    this.prazoEntrega = prazoEntrega;
    this.empresa= empresa;
    this.fornecedor = fornecedor;
  }

  //  GETS e SETS ----------------------------------------------------------

  // public List<Movimentacao> getMovimentacoes(){
  //   List<Movimentacao> lista = new ArrayList<>();
  //   for(ItemMovimentacao x : itens){
  //     lista.add(x.getMovimentacao());
  //   }
  //   return lista;
  // }

  // public List<PedidoCompra> getPedidoCompra(){
  //   List<PedidoCompra> lista = new ArrayList<>();
  //   for(ItemCompra x : itens){
  //     lista.add(x.get());
  //   }
  //   return lista;
  // }

  

  public Integer getId() {
    return id;
  }

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCodigoBarra() {
    return codigoBarra;
  }

  public void setCodigoBarra(String codigoBarra) {
    this.codigoBarra = codigoBarra;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getComprimento() {
    return comprimento;
  }

  public void setComprimento(Double comprimento) {
    this.comprimento = comprimento;
  }

  public Double getLargura() {
    return largura;
  }

  public void setLargura(Double largura) {
    this.largura = largura;
  }

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public Double getUltimoPrecoCompra() {
    return ultimoPrecoCompra;
  }

  public void setUltimoPrecoCompra(Double ultimoPrecoCompra) {
    this.ultimoPrecoCompra = ultimoPrecoCompra;
  }

  public String getUnidade() {
    return unidade;
  }

  public void setUnidade(String unidade) {
    this.unidade = unidade;
  }

  public Double getEstoqueMinimo() {
    return estoqueMinimo;
  }

  public void setEstoqueMinimo(Double estoqueMinimo) {
    this.estoqueMinimo = estoqueMinimo;
  }

  public Double getEstoqueMaximo() {
    return estoqueMaximo;
  }

  public void setEstoqueMaximo(Double estoqueMaximo) {
    this.estoqueMaximo = estoqueMaximo;
  }

  public Double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Double quantidade) {
    this.quantidade = quantidade;
  }

  public Integer getPrazoEntrega() {
    return prazoEntrega;
  }

  public void setPrazoEntrega(Integer prazoEntrega) {
    this.prazoEntrega = prazoEntrega;
  }

  
  public List<ItemMovimentacao> getItens() {
    return itens;
  }

  public void setItens(List<ItemMovimentacao> itens) {
    this.itens = itens;
  }

  public List<Posicao> getPosicoes() {
    return posicoes;
  }

  public void setPosicoes(List<Posicao> posicoes) {
    this.posicoes = posicoes;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public Date getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao() {
    Calendar calendar =  Calendar.getInstance();
    this.dataCriacao = calendar.getTime();
  }

  public Date getDataAtualizacao() {
    return dataAtualizacao;
  }

  public void setDataAtualizacao(Date dataAtualizacao) {
    this.dataAtualizacao = dataAtualizacao;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  

  //  HASH e EQUALS ----------------------------------------------------------

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
    Produto other = (Produto) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  

  
}
