package org.formation.service;

import java.util.logging.Logger;

import org.formation.controller.NotificationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	  
    @Autowired
    public JavaMailSender emailSender;
    
    protected Logger logger = Logger.getLogger(NotificationController.class.getName());
 
    public void sendSimpleMessage(
      String to, String subject, String text) {
    	
    	logger.info("MailService entering");
    	SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
        
        logger.info("MailService sent a mail : "+ message);
    }
}

