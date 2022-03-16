package com.diogopires.demo.resource;


import com.diogopires.demo.domain.Usuario;
import com.diogopires.demo.dto.GetUsuarioDTO;
import com.diogopires.demo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/v1/usuarios")
public class UsuariosResource {
  
  @Autowired
  private UsuarioService service;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<GetUsuarioDTO> findUser(@RequestBody Usuario obj){
     Usuario objUserUsuario = service.userDateGet(obj);
     GetUsuarioDTO user = new GetUsuarioDTO(objUserUsuario);
     return ResponseEntity.ok().body(user);
  }

}
