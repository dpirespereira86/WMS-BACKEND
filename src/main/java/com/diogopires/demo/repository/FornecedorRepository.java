package com.diogopires.demo.repository;


import com.diogopires.demo.domain.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Integer> {
  
}
