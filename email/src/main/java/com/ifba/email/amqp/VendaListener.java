package com.ifba.email.amqp;

import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ifba.email.dto.EmailDto;
import com.ifba.email.dto.PaisEmailDto;
import com.ifba.email.models.Email;
import com.ifba.email.service.EmailService;

@Component
public class VendaListener {

	
	@Autowired
	private EmailService emailService;
	
	@RabbitListener(queues = "email.notificacao")
	public void recebeMensagem(@Payload PaisEmailDto paisEmailDto) {
	
		System.out.println("Recebi a mensagem " + paisEmailDto.toString());
		
		for (String enderecoEmail : paisEmailDto.emails()){
			Email email = new Email();
			email.setMailFrom("ianbernardolim@gmail.com");
			email.setMailTo(enderecoEmail);
			email.setMailSubject("Medalha Nova!");
			email.setMailText("Medalha nova cadastrada para o país " + paisEmailDto.nomePais() + "!!!!");
			EmailDto emailDto = new EmailDto(email);
			emailService.sendEmail(emailDto) ;
		}
		
		
		return;
	}

}