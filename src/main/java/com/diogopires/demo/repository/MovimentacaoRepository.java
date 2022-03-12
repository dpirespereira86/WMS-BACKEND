package com.diogopires.demo.repository;

import com.diogopires.demo.domain.Movimentacao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Integer> {
  
}