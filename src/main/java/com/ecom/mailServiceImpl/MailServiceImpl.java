package com.ecom.mailServiceImpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ecom.mailService.MailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class MailServiceImpl implements MailService{
	
	
	
	private JavaMailSender mailSender;
	
	public MailServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	
	private Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	

	@Override
	public void sendEmail(String to, String subject, String message) {
		
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom("arch007chowdhury@gmail.com");
		mailSender.send(simpleMailMessage);
		
		logger.info("The Email has sent");
		
	}

	@Override
	public void sendEmail(String[] to, String subject, String message) {
		
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom("arch007chowdhury@gmail.com");
		mailSender.send(simpleMailMessage);
	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlContent) {
	
		
		MimeMessage simpleMailMessage = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage,true,"UTF-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom("arch007chowdhury@gmail.com");
			helper.setText(htmlContent,true);
			mailSender.send(simpleMailMessage);
			logger.info("The Email has sent...");
		} 
		catch (MessagingException e) {
		
			//e.printStackTrace();
			throw new RuntimeException(e);
			
		}
	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, File file) {
		
		  MimeMessage mimeMessage =  mailSender.createMimeMessage();
		  try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			
			helper.setFrom("arch007chowdhury@gmail.com");
			helper.setTo(to);
			helper.setText(message,true);
			helper.setSubject(subject);
			FileSystemResource fileSystemResource = new FileSystemResource(file);
			helper.addAttachment(fileSystemResource.getFilename(),file);
			
			mailSender.send(mimeMessage);
			logger.info("The Email has sent...");
			
		} 
		  
		 catch (MessagingException e) {
			
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		  

		
	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, InputStream is) {
		
		MimeMessage mimeMessage =  mailSender.createMimeMessage();
		  try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			
			helper.setFrom("arch007chowdhury@gmail.com");
			helper.setTo(to);
			helper.setText(message);
			helper.setSubject(subject);
			
			File file = new File("test.png");
			Files.copy(is,file.toPath(),StandardCopyOption.REPLACE_EXISTING);
			FileSystemResource fileSystemResource = new FileSystemResource(file);
			
			helper.addAttachment(fileSystemResource.getFilename(),file);
			mailSender.send(mimeMessage);
			logger.info("The Email has sent...");
			
		} 
		  
		 catch (MessagingException e) {
			
			//e.printStackTrace();
			throw new RuntimeException(e);
		} 
		  
		  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
	}

}
