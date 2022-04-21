package com.diogopires.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Posicao;
import com.diogopires.demo.dto.PosicaoDTO;
import com.diogopires.demo.dto.PosicaoProdutoDTO;
import com.diogopires.demo.dto.PostPosicaoDTO;
import com.diogopires.demo.services.PosicaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value ="v1/{empresa}/posicoes")
public class PosicaoResource {
  
  @Autowired
  private PosicaoService service;
  
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<PosicaoDTO>> listar(@PathVariable Integer empresa){
     List<Posicao> obj = service.findAll(empresa);
     List<PosicaoDTO> listDto = obj.stream().map(p -> new PosicaoDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(value = "/{estoque}",method = RequestMethod.GET)
  public ResponseEntity<List<PosicaoProdutoDTO>> StocklistPosition(@PathVariable Integer empresa,@PathVariable Integer estoque){
     List<Posicao> obj = service.StockFindAllPosition(empresa, estoque);
     List<PosicaoProdutoDTO> listDto = obj.stream().map(p -> new PosicaoProdutoDTO(p)).collect(Collectors.toList());
     return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@PathVariable Integer empresa, @RequestBody PostPosicaoDTO obj){
    obj = new PostPosicaoDTO(service.insert(obj,empresa));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
    .path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }


}
