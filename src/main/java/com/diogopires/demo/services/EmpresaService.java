package com.diogopires.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.diogopires.demo.domain.Empresa;
import com.diogopires.demo.domain.EnderecoEmpresa;
import com.diogopires.demo.domain.Usuario;
import com.diogopires.demo.domain.enums.Perfil;
import com.diogopires.demo.dto.EmpresaPostDTO;
import com.diogopires.demo.repository.EmpresaRepository;
import com.diogopires.demo.repository.EnderecoEmpresaRepository;
import com.diogopires.demo.repository.UsuarioRepository;
import com.diogopires.demo.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class EmpresaService {

  @Autowired
  private BCryptPasswordEncoder be;
  
  @Autowired
  private EmpresaRepository repo;
  
  @Autowired
  private EnderecoEmpresaRepository endRepo;
  
  @Autowired
  private UsuarioRepository useRepo;

  public Optional<Empresa> buscar(Integer id){
     Optional<Empresa> obj = repo.findById(id);
     if(obj.isEmpty()){
      throw new ObjectNotFoundException("Empresa " + id + " não existe!!");
    }
     return obj;
  }
  
  @Transactional
  public Empresa insert(Empresa obj){
    obj.setId(null);
    obj = repo.save(obj);
    endRepo.save(obj.getEnderecos().get(0));
    useRepo.save(obj.getUsuarios().get(0));
    return obj;
  }

  public Empresa fromDTO(EmpresaPostDTO objDto){
    Empresa emp = new Empresa(null, objDto.getRazaoSocial(), objDto.getCnpj());
    EnderecoEmpresa end = new EnderecoEmpresa(null, objDto.getLogradouro(),objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), emp);
    Usuario user = new Usuario(null,objDto.getEmailresponsavel() , objDto.getSetor(), objDto.getResponsavel(), emp, be.encode(objDto.getSenha()));
    user.addPerfil(Perfil.toEnum(Integer.parseInt(objDto.getPerfil())));
    emp.getEnderecos().add(end);
    emp.getUsuarios().add(user);
    return emp;
  }
  
}
