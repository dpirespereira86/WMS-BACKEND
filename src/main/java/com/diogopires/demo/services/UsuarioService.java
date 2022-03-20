package com.diogopires.demo.services;

import com.diogopires.demo.domain.Usuario;
import com.diogopires.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
  
  @Autowired
  private UsuarioRepository repo;

  public Usuario userDateGet(Usuario objUsuario){
      Usuario user = repo.findByEmail(objUsuario.getEmail());
      return user;
  }

  public Usuario findUser(String email){
    Usuario user = repo.findByEmail(email);
    return user;
}
  
}
