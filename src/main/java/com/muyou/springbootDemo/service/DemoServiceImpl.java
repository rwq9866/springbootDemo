package com.muyou.springbootDemo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.muyou.springbootDemo.domian.User;
import com.muyou.springbootDemo.repository.DemoRepository;

@Service
public class DemoServiceImpl implements DemoService {

	@Resource
	private DemoRepository demoRepository;
	
	@Override
	public List<User> findAll() {
		return demoRepository.findAll();
	}

	@Override
	public User add(User user) {
		return demoRepository.saveAndFlush(user);
	}

	@Override
	public void del(String id) {
		demoRepository.delete(id);
	}

	@Override
	public User modi(User user) {
		return demoRepository.save(user);
	}

	@Override
	public void save(List<User> list) {
		demoRepository.save(list);
	}
	
}
