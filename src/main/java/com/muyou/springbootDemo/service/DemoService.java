package com.muyou.springbootDemo.service;

import java.util.List;

import com.muyou.springbootDemo.domian.User;

public interface DemoService {
	List<User> findAll();

	User add(User user);

	void del(String id);

	User modi(User user);
}
