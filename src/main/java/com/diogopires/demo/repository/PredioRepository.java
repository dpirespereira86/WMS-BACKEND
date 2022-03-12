package com.diogopires.demo.repository;



import com.diogopires.demo.domain.Predio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredioRepository extends JpaRepository<Predio,Integer> {
  
}
