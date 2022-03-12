package com.diogopires.demo.resource;

import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.ItemPosicao;
import com.diogopires.demo.dto.ItemPosicaoDTO;
import com.diogopires.demo.services.ItemPosicaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="v1/{empresa}/itemposicao")
public class ItemPosicaoResource {
  
  @Autowired
  private ItemPosicaoService service;
  
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity <List<ItemPosicaoDTO>> listAll(@PathVariable Integer empresa){
     List<ItemPosicao> obj = service.findAll(empresa);
     List<ItemPosicaoDTO> listDto = obj.stream().map(p -> new ItemPosicaoDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
  public ResponseEntity <List<ItemPosicaoDTO>> lookup(@PathVariable Integer empresa,@PathVariable Integer id ){
     List<ItemPosicao> obj = service.find(empresa,id);
     List<ItemPosicaoDTO> listDto = obj.stream().map(p -> new ItemPosicaoDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }

}
