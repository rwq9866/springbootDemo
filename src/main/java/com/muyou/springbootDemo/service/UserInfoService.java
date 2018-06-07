package com.muyou.springbootDemo.service;

import com.muyou.springbootDemo.domian.UserInfo;

public interface UserInfoService {

	UserInfo findByUsername(String username);

}
