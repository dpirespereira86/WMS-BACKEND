package com.diogopires.demo.repository;

import com.diogopires.demo.domain.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
  
}
