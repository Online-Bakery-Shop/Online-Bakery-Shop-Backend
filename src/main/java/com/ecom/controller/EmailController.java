package com.ecom.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.entity.CustomResponse;
import com.ecom.entity.EmailRequest;
import com.ecom.mailService.MailService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/email")
public class EmailController {
	
	@Autowired
	private MailService mailService;
	
	
	@PostMapping("/send")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
	{
		mailService.sendEmailWithHtml(request.getTo(),request.getSubject(),request.getMessage());
		return ResponseEntity.ok(
				
				CustomResponse.builder().message("The email has sent succesfully!!").httpStatus(HttpStatus.OK).success(true).build()
				
				);
		
	}
	
	
	@PostMapping("/send-with-file")
	public ResponseEntity<CustomResponse> sendWithFile(@RequestPart EmailRequest request, @RequestPart MultipartFile file) throws IOException{
		mailService.sendEmailWithFile(request.getTo(),request.getSubject(),request.getMessage(),file.getInputStream());
			return ResponseEntity.ok(
				
				CustomResponse.builder().message("The email with attachment using InputStream has sent succesfully!!").httpStatus(HttpStatus.OK).success(true).build()
				
				);
	}

}
