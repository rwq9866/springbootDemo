package com.muyou.springbootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muyou.springbootDemo.domian.Person;

public interface DemoRepository extends JpaRepository<Person, String>{

}
