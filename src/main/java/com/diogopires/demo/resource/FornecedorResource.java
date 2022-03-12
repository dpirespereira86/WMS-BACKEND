package com.diogopires.demo.resource;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.diogopires.demo.domain.Fornecedor;
import com.diogopires.demo.dto.FornecedorDTO;
import com.diogopires.demo.services.FornecedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

  
}
