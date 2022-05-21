package com.itwill.utill;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTP {

	
	/** 메일 HOST **/
	private static final String HOST = "smtp.naver.com";
	/** 메일 PORT **/
	private static final String PORT = "587";
	/** 메일 ID **/
	private static final String MAIL_ID = "minji0255@naver.com";
	/** 메일 PW **/
	private static final String MAIL_PW = "ap351294mj!";
	
	public static void sendNotiMail(String subejct, String body, String host) {
		try {
			InternetAddress[] receiverList = new InternetAddress[2];
			// 수신인
			receiverList[0] = new InternetAddress(host);
			
			// SMTP 발송 Properties 설정
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", SMTP.PORT);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.ssl.trust", SMTP.HOST);
			props.put("mail.smtp.auth", "true");
			
			// SMTP Session 생성
			Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(SMTP.MAIL_ID, SMTP.MAIL_PW);
				}
			});
			
			// Mail 조립
			Message mimeMessage = new MimeMessage(mailSession);
			mimeMessage.setFrom(new InternetAddress(SMTP.MAIL_ID));
			mimeMessage.setRecipients(Message.RecipientType.TO, receiverList);
            		// 메일 제목
			mimeMessage.setSubject(subejct);
            		// 메일 본문 (.setText를 사용하면 단순 텍스트 전달 가능)
			mimeMessage.setContent(body, "text/html; charset=UTF-8");
			
			// Mail 발송
			Transport.send(mimeMessage);
			
		} catch(Exception e) {
		}
	}
}
