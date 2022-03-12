package com.diogopires.demo.repository;


import com.diogopires.demo.domain.ItemPosicao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPosicaoRepository extends JpaRepository<ItemPosicao,Integer> {
  
}
