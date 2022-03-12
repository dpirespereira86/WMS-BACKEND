package com.diogopires.demo.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.diogopires.demo.dto.EmailDTO;
import com.diogopires.demo.security.JWTUtil;
import com.diogopires.demo.security.UserSS;
import com.diogopires.demo.services.AuthService;
import com.diogopires.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/auth")
public class AuthResource {

  @Autowired
  private AuthService service;
  
  @Autowired
  private JWTUtil jwtUtil;

  @RequestMapping(value="/refresh_token", method=RequestMethod.POST)
  public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
  UserSS user = UserService.authenticated();
  String token = jwtUtil.generateToken(user.getUsername());
  response.addHeader("Authorization", "Bearer " + token);
  return ResponseEntity.noContent().build();
  }

  @RequestMapping(value="/forgot", method=RequestMethod.POST)
  public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
  service.sendNewPassword(objDto.getEmail());
  return ResponseEntity.noContent().build();
  }
  
}
