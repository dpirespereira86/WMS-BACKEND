package com.diogopires.demo.repository;

import com.diogopires.demo.domain.PedidoCompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoCompraRepository extends JpaRepository<PedidoCompra,Integer> {
  
}
