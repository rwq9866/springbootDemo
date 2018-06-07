package com.muyou.springbootDemo.service;

import java.util.List;

import com.muyou.springbootDemo.domian.Person;

public interface DemoService {
	List<Person> findAll();

	Person add(Person person);

	void del(String id);

	Person modi(Person person);

	void save(List<Person> list);
}
