package com.managecustomers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.managecustomers.security.emaiSenderService.EmailSenderService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SecurityApplicationGo4eat {


	@Autowired
	private EmailSenderService senderService;


	public static void main(String[] args) {
		SpringApplication.run(SecurityApplicationGo4eat.class, args);
	}

	//	Data that you will be sending at the moment that application is running
	// Unhidden this service if you want to send email that server is on
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		senderService.sendEmail("marek_augustyn1@o2.pl", "Server is ON", "This message was sent because somebody activated backend application that is used to sending a messages");
	}

}
