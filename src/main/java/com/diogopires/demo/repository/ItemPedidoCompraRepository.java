package com.diogopires.demo.repository;

import com.diogopires.demo.domain.ItemPedidoCompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoCompraRepository extends JpaRepository<ItemPedidoCompra,Integer> {
  
}
