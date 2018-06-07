package com.muyou.springbootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muyou.springbootDemo.domian.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
	UserInfo findByUsername(String username);
}
