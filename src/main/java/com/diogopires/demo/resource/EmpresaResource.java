package com.diogopires.demo.resource;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.diogopires.demo.domain.Empresa;
// import com.diogopires.demo.domain.EnderecoEmpresa;
// import com.diogopires.demo.domain.Usuario;
import com.diogopires.demo.dto.EmpresaPostDTO;
// import com.diogopires.demo.repository.EnderecoEmpresaRepository;
// import com.diogopires.demo.repository.UsuarioRepository;
import com.diogopires.demo.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "v1/empresas")
public class EmpresaResource {
  
  @Autowired
  private EmpresaService service;

  // @Autowired
  // private EnderecoEmpresaRepository endRepo;
  
  // @Autowired
  // private UsuarioRepository useRepo;

  @RequestMapping(value ="/{id}",method = RequestMethod.GET)
  public ResponseEntity<?> listar(@PathVariable Integer id){
     Optional<Empresa> obj = service.buscar(id);
     return ResponseEntity.ok().body(obj);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@Valid @RequestBody EmpresaPostDTO objDto){
    Empresa obj = service.fromDTO(objDto);
    obj= service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
    .path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }
}
