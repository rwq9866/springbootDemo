package com.muyou.springbootDemo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.muyou.springbootDemo.domian.UserInfo;
import com.muyou.springbootDemo.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoRepository userInfoRepository;
	
	@Override
	public UserInfo findByUsername(String username) {
		return userInfoRepository.findByUsername(username);
	}

}
