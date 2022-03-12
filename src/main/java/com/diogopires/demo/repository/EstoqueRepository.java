package com.diogopires.demo.repository;



import java.util.List;

import com.diogopires.demo.domain.Empresa;
import com.diogopires.demo.domain.Estoque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EstoqueRepository extends JpaRepository<Estoque,Integer> {
  
  @Transactional(readOnly = true)
  List<Estoque> findByEmpresa(Empresa  empresa); 
  
}
