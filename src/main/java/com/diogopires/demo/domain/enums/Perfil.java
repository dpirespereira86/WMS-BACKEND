package com.diogopires.demo.domain.enums;

public enum Perfil {

  ADMIN(1,"ROLE_ADMIN"),
  GERENTE(2,"ROLE_GERENTE"),
  SUPERVISOR(3,"ROLE_SUPERVISOR"),
  OPERADOR(4,"ROLE_OPERADOR");
  
 

  private Integer cod;
  private String descricao;

  
  private Perfil(Integer cod, String descricao) {
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

  public static Perfil toEnum (Integer cod){
     if(cod == null){
       return null;
     }

     for (Perfil x : Perfil.values()){
       if(cod.equals(x.getCod())){
         return x;
       }
     }
     throw new IllegalArgumentException("Id inválido:" + cod);
  }

  
  
}
