package com.diogopires.demo.domain.enums;

public enum StatusCompra {

  COTAR(1,"Aguardando Cotação"),
  ORCAR(2,"Aguardando Orçamento"),
  APROVAR(3,"Aguardando Aprovação"),
  REPROVAR(4,"Reprovada"),
  ENTREGAR(5,"Aguardando Entrega"),
  FINALIZADO(6,"Entrega Realizada"),
  REJEITADA(7,"Entrega Rejeitada");

  private Integer cod;
  private String descricao;

  
  private StatusCompra(Integer cod, String descricao) {
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

  public static StatusCompra toEnum (Integer cod){
     if(cod == null){
       return null;
     }

     for (StatusCompra x : StatusCompra.values()){
       if(cod.equals(x.getCod())){
         return x;
       }
     }
     throw new IllegalArgumentException("Id inválido:" + cod);
  }

  
  
}
