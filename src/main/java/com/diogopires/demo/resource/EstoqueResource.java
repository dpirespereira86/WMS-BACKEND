package com.diogopires.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Estoque;
import com.diogopires.demo.dto.EstoqueDTO;
import com.diogopires.demo.services.EstoqueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "v1/{empresa}/estoques")
public class EstoqueResource {
  
  @Autowired
  private EstoqueService service;
  
  @PreAuthorize("hasAnyRole('ADMIN')")
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity <List<EstoqueDTO>> listAll(@PathVariable Integer empresa){
     List<Estoque> obj = service.findAll(empresa);
     List<EstoqueDTO> listDto = obj.stream().map(p -> new EstoqueDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(value ="/{id}",method = RequestMethod.GET)
  public ResponseEntity <List<EstoqueDTO>> find(@PathVariable Integer empresa,@PathVariable Integer id){
     List<Estoque> obj = service.findOne(empresa,id);
     List<EstoqueDTO> listDto = obj.stream().map(p -> new EstoqueDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@PathVariable Integer empresa, @RequestBody Estoque obj){
    obj = service.insert(obj,empresa);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
    .path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

}
