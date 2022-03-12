package com.diogopires.demo.repository;

import com.diogopires.demo.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
  
}