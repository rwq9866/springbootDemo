package com.muyou.springbootDemo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		user.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
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
