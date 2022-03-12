package com.diogopires.demo.repository;

import com.diogopires.demo.domain.ItemMovimentacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMovimentacaoRepository extends JpaRepository<ItemMovimentacao,Integer> {
  
}