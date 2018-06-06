package com.muyou.springbootDemo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muyou.springbootDemo.domian.User;
import com.muyou.springbootDemo.service.DemoService;

@RestController
@RequestMapping("de")
public class DemoController2 {

	@Resource
	private DemoService demoService;
	
	@RequestMapping("demo")
	public String demo() {
		return "SpringBootDemo!!!";
	}
	
	@RequestMapping("add")
	public String add(User user) {
		User user2 = demoService.add(user);
		return (!"".equals(user2) && user2 != null) ?"添加成功":"添加失败";
	}
	
	@RequestMapping("del")
	public String del(String id) {
		demoService.del(id);
		return "删除成功!";
	}
	
	@RequestMapping("modi")
	public String nodi(User user) {
		User user2 = demoService.modi(user);
		return (!"".equals(user2) && user2 != null) ?"修改成功":"修改失败";
	}
}
