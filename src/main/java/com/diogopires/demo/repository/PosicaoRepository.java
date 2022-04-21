package com.diogopires.demo.repository;



import java.util.List;

import javax.transaction.Transactional;

import com.diogopires.demo.domain.Estoque;
import com.diogopires.demo.domain.Posicao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicaoRepository extends JpaRepository<Posicao,Integer> {

  @Transactional
  List<Posicao> findByEstoque(Estoque estoque);

  @Transactional
  Posicao findByNome(String nome);
  
}
