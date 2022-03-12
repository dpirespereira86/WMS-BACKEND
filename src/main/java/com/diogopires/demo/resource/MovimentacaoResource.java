package com.diogopires.demo.resource;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Movimentacao;
import com.diogopires.demo.dto.MovimentacaoDTO;
import com.diogopires.demo.services.MovimentacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "v1/{empresa}/movimentacoes")
public class MovimentacaoResource {
  
  @Autowired
  private MovimentacaoService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<MovimentacaoDTO>> listar(@PathVariable Integer empresa){
     List<Movimentacao> obj = service.findAll(empresa);
     List<MovimentacaoDTO> listDto = obj.stream().map(p -> new MovimentacaoDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@PathVariable Integer empresa, @RequestBody Movimentacao obj){
    obj = service.entradaInsert(obj,empresa);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
    .path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }
}
