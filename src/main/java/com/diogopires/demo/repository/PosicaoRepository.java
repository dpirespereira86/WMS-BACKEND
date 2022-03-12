package com.diogopires.demo.repository;



import com.diogopires.demo.domain.Posicao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicaoRepository extends JpaRepository<Posicao,Integer> {
  
}
