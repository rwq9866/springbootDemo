package com.muyou.springbootDemo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.muyou.springbootDemo.domian.Person;
import com.muyou.springbootDemo.repository.DemoRepository;

@Service
public class DemoServiceImpl implements DemoService {

	@Resource
	private DemoRepository demoRepository;
	
	@Override
	public List<Person> findAll() {
		return demoRepository.findAll();
	}

	@Override
	public Person add(Person person) {
		person.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return demoRepository.saveAndFlush(person);
	}

	@Override
	public void del(String id) {
		demoRepository.delete(id);
	}

	@Override
	public Person modi(Person person) {
		return demoRepository.save(person);
	}

	@Override
	public void save(List<Person> list) {
		demoRepository.save(list);
	}
	
}
