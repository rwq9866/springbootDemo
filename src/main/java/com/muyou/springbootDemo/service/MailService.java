package com.muyou.springbootDemo.service;

public interface MailService {
	
	void sendSimpleMail(String to, String subject, String content);
}
