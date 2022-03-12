package com.diogopires.demo.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.diogopires.demo.domain.PedidoCompra;
import com.diogopires.demo.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


public abstract class AbstractEmailService implements EmailService {

  @Value("${default.sender}")
	private String sender;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	
	@Override
	public void sendOrderConfirmationEmail(PedidoCompra obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(PedidoCompra obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getFornecedor().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

  @Override
  public void sendNewPasswordEmail(Usuario usuario, String newPass){
    SimpleMailMessage sm = prepareNewPasswordEmail(usuario, newPass);
		sendEmail(sm);
  }

  protected SimpleMailMessage prepareNewPasswordEmail(Usuario usuario, String newPass) {
    SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(usuario.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de Nova Senha! Código: ");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova Senha: " + newPass);
		return sm;
  }

	protected String htmlFromTemplatePedido(PedidoCompra obj){
     Context context = new Context();
		 context.setVariable("pedido", obj);
		 return templateEngine.process("email/confimacaoPedido", context);

	}
  
	@Override
	public void sendOrderConfirmationHtmlEmail(PedidoCompra obj){
		try{
      MimeMessage mm = prepareMimeMessageFromPedido(obj);
			sendHtmlEmail(mm);
		}
		catch (MessagingException e){
      sendOrderConfirmationEmail(obj);
		}
		
	}

	protected MimeMessage prepareMimeMessageFromPedido(PedidoCompra obj) throws MessagingException  {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage,true);
		mmh.setTo(obj.getFornecedor().getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Pedido confirmado! Código: " + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePedido(obj),true);
		return mimeMessage;
	}

  
}
