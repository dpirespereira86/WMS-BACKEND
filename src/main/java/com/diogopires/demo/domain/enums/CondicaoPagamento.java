package com.diogopires.demo.domain.enums;

public enum CondicaoPagamento {

  AVISTA(1,"A Vista"),
  PRAZO(2,"A Prazo");
 

  private Integer cod;
  private String descricao;

  
  private CondicaoPagamento(Integer cod, String descricao) {
    this.cod = cod;
    this.descricao = descricao;
  }


  public Integer getCod() {
    return cod;
  }


  public void setCod(Integer cod) {
    this.cod = cod;
  }


  public String getDescricao() {
    return descricao;
  }


  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public static CondicaoPagamento toEnum (Integer cod){
     if(cod == null){
       return null;
     }

     for (CondicaoPagamento x : CondicaoPagamento.values()){
       if(cod.equals(x.getCod())){
         return x;
       }
     }
     throw new IllegalArgumentException("Id inválido:" + cod);
  }

  
  
}
