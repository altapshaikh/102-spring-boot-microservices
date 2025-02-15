package com.ait.email;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Environment env;
	
	public void sendEmail(String to, String subject, String body) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		message.setFrom(env.getProperty("spring.mail.username"));
		
		mailSender.send(message);
	}
	public void sendHtmlEmail(String to, String subject, String htmlBody,String attachment) {
		//create mime message
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		//use MimeMessageHelper to simply the process
		try {
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(htmlBody,true);
			helper.setFrom(env.getProperty("spring.mail.username"));
			
			//add an attchment
			
			if(attachment!=null && !attachment.isEmpty()) {
				
				File file=new File("C:\\Users\\shaik\\Downloads\\car.jpg");
				if(file.exists()) {
					helper.addAttachment(file.getName(), file);
				}else {
					System.out.println("attachment file is not found");
				}
			}
			
			mailSender.send(mimeMessage);
			
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
