package com.diogopires.demo.services;

import javax.mail.internet.MimeMessage;

import com.diogopires.demo.domain.PedidoCompra;
import com.diogopires.demo.domain.Usuario;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
  
  void sendOrderConfirmationEmail(PedidoCompra obj);
	
	void sendEmail(SimpleMailMessage msg);

  void sendNewPasswordEmail(Usuario usuario, String newPass);

  void sendOrderConfirmationHtmlEmail(PedidoCompra obj);

  void sendHtmlEmail(MimeMessage msg);


}
