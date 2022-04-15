package com.diogopires.demo.repository;


import javax.transaction.Transactional;

import com.diogopires.demo.domain.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Integer> {

  @Transactional
  Fornecedor findByRazaoSocial(String razaoSocial);
  
}
