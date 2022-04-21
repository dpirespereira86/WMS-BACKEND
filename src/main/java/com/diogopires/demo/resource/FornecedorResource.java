package com.diogopires.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Fornecedor;
import com.diogopires.demo.dto.FornecedorDTO;
import com.diogopires.demo.services.FornecedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "v1/{empresa}/fornecedores")
public class FornecedorResource {

  @Autowired
  private FornecedorService service;
 
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<FornecedorDTO>> listar(@PathVariable Integer empresa){
    List<Fornecedor> obj = service.findAll(empresa);
    List<FornecedorDTO> lisObj = obj.stream().map(f -> new FornecedorDTO(f)).collect(Collectors.toList());
    return ResponseEntity.ok().body(lisObj);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@PathVariable Integer empresa,@RequestBody Fornecedor obj){
     obj = service.insert(empresa,obj);
     URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
     .path("/{id}").buildAndExpand(obj.getId()).toUri();
     return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value="/{id}",method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@RequestBody Fornecedor obj,@PathVariable Integer empresa,@PathVariable Integer id){
      obj.setId(id);
      service.update(obj,empresa);
      return ResponseEntity.noContent().build();
      
  }

  @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable Integer empresa,@PathVariable Integer id){
      service.delete(empresa,id);
      return ResponseEntity.noContent().build();
      
  }

  
}
