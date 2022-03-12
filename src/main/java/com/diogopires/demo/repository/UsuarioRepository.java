package com.diogopires.demo.repository;

import javax.transaction.Transactional;

import com.diogopires.demo.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
  
  @Transactional
  Usuario findByEmail(String email);
  
}