package com.muyou.springbootDemo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muyou.springbootDemo.service.MailService;

@RestController
public class MailController {
	
	@Resource
	private MailService mailService;
	
//	@Scheduled(fixedRate = 6000)
	@RequestMapping("sendMail")
	public String testSimpleMail() throws Exception {
        mailService.sendSimpleMail("841557177@qq.com","test simple mail"," hello this is simple mail");
        return "发送成功!";
	}
}
