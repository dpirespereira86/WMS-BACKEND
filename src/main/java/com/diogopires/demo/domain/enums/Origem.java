package com.diogopires.demo.domain.enums;

public enum Origem {

  MANUAL(1,"Manual"),
  AUTOMATICO(2,"Sistema");
 

  private Integer cod;
  private String descricao;

  
  private Origem(Integer cod, String descricao) {
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

  public static Origem toEnum (Integer cod){
     if(cod == null){
       return null;
     }

     for (Origem x : Origem.values()){
       if(cod.equals(x.getCod())){
         return x;
       }
     }
     throw new IllegalArgumentException("Id inválido:" + cod);
  }

  
  
}
