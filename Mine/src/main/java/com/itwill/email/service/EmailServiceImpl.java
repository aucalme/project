package com.itwill.email.service;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.itwill.command.EmailVO;

@Service
public class EmailServiceImpl implements EmailService{

	@Inject
	JavaMailSender mailSender;
	
	@Override
	public void sendMail(EmailVO vo) {
		try {
			MimeMessage msg=mailSender.createMimeMessage(); // 이메일 객체
			
			// 수산자 
			msg.addRecipient(RecipientType.TO, new InternetAddress(vo.getReceiveMail()));
			
			// 발신자 이메일주소, 이름
			msg.addFrom(new InternetAddress[] {
					
					new InternetAddress(vo.getSenderMail(), vo.getSenderName())
			});
			
			msg.setSubject(vo.getSubject(), "utf-8"); // 제목
			msg.setText(vo.getMessage(), "utf-8");    // 내용
			mailSender.send(msg);				      // 이메일 발신
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

