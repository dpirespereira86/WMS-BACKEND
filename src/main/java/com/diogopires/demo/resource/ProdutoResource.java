package com.diogopires.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Produto;
import com.diogopires.demo.dto.ProdutoDTO;
import com.diogopires.demo.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "v1/{empresa}/produtos")
public class ProdutoResource {

  @Autowired
  private ProdutoService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity <List<ProdutoDTO>> listAll(@PathVariable Integer empresa){
     List<Produto> obj = service.findAll(empresa);
     List<ProdutoDTO> listDto = obj.stream().map(p -> new ProdutoDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  public ResponseEntity <List<ProdutoDTO>> listOne(@PathVariable Integer empresa,@PathVariable Integer id ){
     List<Produto> obj = service.findOne(empresa,id);
     List<ProdutoDTO> listDto = obj.stream().map(p -> new ProdutoDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@PathVariable Integer empresa,@RequestBody Produto obj){
     obj = service.insert(empresa,obj);
     URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
     .path("/{id}").buildAndExpand(obj.getId()).toUri();
     return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value="/{id}",method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@RequestBody Produto obj,@PathVariable Integer empresa,@PathVariable Integer id){
      obj.setId(id);
      obj = service.update(obj,empresa);
      return ResponseEntity.noContent().build();
      
  }

  @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable Integer empresa,@PathVariable Integer id){
      service.delete(empresa,id);
      return ResponseEntity.noContent().build();
      
  }

  
}
