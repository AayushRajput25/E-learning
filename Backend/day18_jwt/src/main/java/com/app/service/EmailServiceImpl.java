package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.EmailDto;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired 
	private JavaMailSender javaMailSender;
	 
    @Value("${spring.mail.username}") 
    private String sender;
	
	
	@Override
	public ApiResponse sendSimpleMail(EmailDto details) {
		
		try {
			SimpleMailMessage mail = new SimpleMailMessage();
			
			// necessary details for email
			mail.setFrom(sender);
			mail.setTo(details.getRecipient());
			mail.setText(details.getMsgBody());
			mail.setSubject(details.getSubject());
			
			// sending mail
			javaMailSender.send(mail);
			return new ApiResponse("mail sent successfull");
					
			
		} catch (Exception e) {
			return new ApiResponse("Error while Sending Mail");
		}
		
	}

}
