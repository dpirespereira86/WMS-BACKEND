package com.diogopires.demo.services;

import java.util.Random;

import com.diogopires.demo.domain.Usuario;
import com.diogopires.demo.repository.UsuarioRepository;
import com.diogopires.demo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private BCryptPasswordEncoder be;

  @Autowired
  private EmailService emailService;

  private Random randon;

  public void sendNewPassword(String email){
    
    Usuario usuario = usuarioRepository.findByEmail(email);
    if(usuario == null){
      throw new ObjectNotFoundException("Email não encontrado");
    }

    String newPass = newPassword();
    usuario.setSenha(be.encode(newPass));

    usuarioRepository.save(usuario);
    emailService.sendNewPasswordEmail(usuario,newPass);
  }

  private String newPassword() {
    char[] vet = new char[10];
    for(int i=0; i<10; i++){
      vet[i] = randomChar();
    }
    return new String(vet);
  }

  private char randomChar() {
    int opt = randon.nextInt(3);
    if(opt ==0) {// gera um digito
      return (char) (randon.nextInt(10) + 48);
    }
    else if (opt == 1) { // gera letra maúscula
      return (char) (randon.nextInt(26) + 65);
    }
    else {
      // gera letra minuscula
      return (char) (randon.nextInt(26) + 97);
    }
    
  }
  
}
