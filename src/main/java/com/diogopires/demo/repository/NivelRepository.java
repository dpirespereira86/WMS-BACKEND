package com.diogopires.demo.repository;



import com.diogopires.demo.domain.Nivel;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelRepository extends JpaRepository<Nivel,Integer> {
  
}
