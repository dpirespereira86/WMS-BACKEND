package com.diogopires.demo.repository;


import com.diogopires.demo.domain.EnderecoEmpresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoEmpresaRepository extends JpaRepository<EnderecoEmpresa,Integer> {
  
}