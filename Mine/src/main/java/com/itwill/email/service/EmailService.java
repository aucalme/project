package com.itwill.email.service;

import com.itwill.command.EmailVO;

public interface EmailService {

	void sendMail(EmailVO vo);
}
