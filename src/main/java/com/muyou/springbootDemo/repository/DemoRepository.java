package com.muyou.springbootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muyou.springbootDemo.domian.User;

public interface DemoRepository extends JpaRepository<User, String>{

}
