package com.ecom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecom.mailService.MailService;

@SpringBootTest
public class MailSenderTest {
	
	@Autowired
	private MailService mailService;
	
	
	@Test
	void emailSendTest()
	{
		System.out.println("sending email");
		
		mailService.sendEmail("chowdhuryarchan76@gmail.com","Email from Spring Boot", "This mail has send using Spring Boot");
	}
	
	
	@Test
	void sendHtmlInEmail()
	{
		String html = "" + "<h1 style='color:red; border:1px solid white;' >This is testing of sending html content through springboot mail</h1>" + "";
		mailService.sendEmailWithHtml("chowdhuryarchan76@gmail.com","Email from Spring Boot",html );
		
		System.out.println("sending mail for html content testing");
		
	}
	
	
	@Test
	void senEmailWithFile()
	{
		 String filePath = "C:/Users/ARCHAN/Documents/workspace-spring-tool-suite-4-4.21.0.RELEASE/Cake-Shop/src/main/resources/static/image/SIGNATURE_JECA2024.jpg";
		mailService.sendEmailWithFile("chowdhuryarchan76@gmail.com","This is a mail with attachment","Testing mail with attchment",new File(filePath));
	}
	
	@Test
	void senEmailWithFileWithStream()
	{
		 File file = new File ("C:/Users/ARCHAN/Documents/workspace-spring-tool-suite-4-4.21.0.RELEASE/Cake-Shop/src/main/resources/static/image/SIGNATURE_JECA2024.jpg");
		 try {
		 FileInputStream is = new FileInputStream(file);
		 
		 mailService.sendEmailWithFile(
				"chowdhuryarchan76@gmail.com",
				"This is a mail with attachment using InputStream",
				"Testing mail with attchment",is);
		 System.out.println("This mail has sent using InputStream");
	}
		 catch(FileNotFoundException e) {
			 throw new RuntimeException(e);
		 }
	}
}