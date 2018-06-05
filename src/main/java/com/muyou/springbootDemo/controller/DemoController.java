package com.muyou.springbootDemo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.muyou.springbootDemo.domian.User;
import com.muyou.springbootDemo.service.DemoService;

@Controller
@RequestMapping("ht")
public class DemoController {

	@Resource
	private DemoService demoservice;
	
	@RequestMapping("demo")
	public String demo(Model model) {
		List<User> list = demoservice.findAll();
		model.addAttribute("users", list);
		return "demo";
	}
}
