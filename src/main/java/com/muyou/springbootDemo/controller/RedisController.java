package com.muyou.springbootDemo.controller;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redi")
public class RedisController {
	@Resource
	private StringRedisTemplate redisTemplate;
	
	/*
	 * Redis
	 * 
	 * redisTemplate.opsForValue();//操作字符串
	 * redisTemplate.opsForHash();//操作hash
	 * redisTemplate.opsForList();//操作list
	 * redisTemplate.opsForSet();//操作set
	 * redisTemplate.opsForZSet();//操作有序set
	 */
	
	@RequestMapping("ss")
	public String ss(String ke,String valu) {
		if(!redisTemplate.hasKey(ke)) {
			redisTemplate.opsForValue().set(ke, valu);
			return "使用Redis缓存数据成功";
		}else {
			redisTemplate.delete(ke);
			return "此key值存在,已将其删除,请重新提交";
		}
	}
	
}
