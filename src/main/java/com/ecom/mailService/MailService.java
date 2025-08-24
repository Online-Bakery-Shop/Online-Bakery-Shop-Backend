package com.ecom.mailService;

import java.io.File;
import java.io.InputStream;

public interface MailService {
	
	// Send Mail to single person
	void sendEmail(String to, String subject, String message);
	
	
	// Send Mail to Multiple person
	void sendEmail (String[]to, String subject, String message);
	
	
	// Send Mail with HTML Content
	
	void sendEmailWithHtml(String to, String subject, String htmlcontent);
	
	// Send mail with Attachment
	void sendEmailWithFile(String to, String subject, String message, File file);
	
	
	void sendEmailWithFile(String to, String subject, String message, InputStream is);
}
