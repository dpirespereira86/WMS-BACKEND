package com.diogopires.demo.services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.ItemPosicao;
import com.diogopires.demo.domain.Posicao;
import com.diogopires.demo.repository.ItemPosicaoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ItemPosicaoService {
  
  @Autowired
  private ItemPosicaoRepository repo;
  
  @Autowired
  private PosicaoService servicePosicao;

  public List<ItemPosicao> findAll(Integer empresa){
    List<Posicao> pos = servicePosicao.findAll(empresa);
    List<ItemPosicao> ip = new ArrayList<>();
    for(Posicao po : pos){
      ip.addAll(repo.findAll().stream()
      .filter(p -> p.getPosicao().equals(po))
      .collect(Collectors.toList()));
    }
    return ip;
  }

  public List<ItemPosicao> find(Integer empresa , Integer id){
    List<Posicao> pos = servicePosicao.findAll(empresa);
    List<ItemPosicao> ip = new ArrayList<>();
    for(Posicao po : pos){
      ip.addAll(repo.findAll().stream()
      .filter(p -> p.getPosicao().equals(po) &&
       p.getId().equals(id))
      .collect(Collectors.toList()));
    }
    return ip;
  }
  
}
