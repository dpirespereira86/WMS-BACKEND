package com.diogopires.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Rua;
import com.diogopires.demo.dto.RuaDTO;
import com.diogopires.demo.services.RuaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@RequestMapping(value = "/v1/{empresa}/ruas")
public class RuaResource {

  @Autowired
  private RuaService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> findAll(@PathVariable Integer empresa){
     List<Rua> obj = service.findAll(empresa);
     List<RuaDTO> listDto = obj.stream().map(p -> new RuaDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(value="/{id}",method = RequestMethod.GET)
  public ResponseEntity<?> findOne(@PathVariable Integer empresa,@PathVariable Integer id){
     List<Rua> obj = service.findOneTo(empresa, id);
     List<RuaDTO> listDto = obj.stream().map(p -> new RuaDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(value="/page",method = RequestMethod.GET)
  public ResponseEntity<Page<RuaDTO>> findPage(
     @PathVariable Integer empresa,
     @RequestParam(value="page",defaultValue = "0") Integer page,
     @RequestParam(value="linesPerPage",defaultValue = "24") Integer linesPerPage,
     @RequestParam(value="orderBy",defaultValue = "nome") String orderBy,
     @RequestParam(value="direction",defaultValue = "ASC") String direction
     ){
     Page<Rua> obj = service.findPage(empresa,page, linesPerPage, orderBy, direction);
     Page<RuaDTO> listDto = obj.map(p -> new RuaDTO(p));
     return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@PathVariable Integer empresa,@RequestBody Rua obj){
     obj = service.insert(empresa,obj);
     URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
     .path("/{id}").buildAndExpand(obj.getId()).toUri();
     return ResponseEntity.created(uri).build();
  }
  
  @RequestMapping(value="/{id}",method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@RequestBody Rua obj,@PathVariable Integer empresa,@PathVariable Integer id){
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
