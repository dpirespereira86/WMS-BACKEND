package com.diogopires.demo.services;

import java.util.List;


import com.diogopires.demo.domain.ItemMovimentacao;
// import com.diogopires.demo.domain.Posicao;
import com.diogopires.demo.repository.ItemMovimentacaoRepository;

import org.springframework.stereotype.Service;

@Service
public class ItemMovimentacaoService {

  private ItemMovimentacaoRepository repo;
  
  public Integer lastCod(){
     List<ItemMovimentacao> x = repo.findAll();
     Integer compara = 0;
     for(ItemMovimentacao y : x ){
       String[] codigo = y.getCodigoInterno().split("-");
       Integer cod = Integer.parseInt(codigo[1]);
       if(cod > compara){
         compara = cod;
       }
     }
     System.out.println("-----------------" + compara);
     return compara;
  }

  // public void removeItem(Posicao posicao){
  //     for(ItemMovimentacao im : posicao.getItens()){
  //       im.getProduto();
  //     }
  // }
}
