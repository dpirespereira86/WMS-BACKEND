package com.diogopires.demo.repository;



import com.diogopires.demo.domain.Rua;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuaRepository extends JpaRepository<Rua,Integer> {
  
}
