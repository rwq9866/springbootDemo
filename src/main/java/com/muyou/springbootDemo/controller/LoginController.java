//package com.muyou.springbootDemo.controller;
//
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import utilModule.JsonResult;
//
//
//@RestController
//public class LoginController {
//	
////	@RequestMapping("/toLogin")
////	public String login(){
////		return "login";
////	}
//	
//	/**
//	 * 用户登录，校验用户信息
//	 */
//	@SuppressWarnings("rawtypes")
//	@RequestMapping("/confirmUser")
//	public JsonResult confirmUser(String username,String userpwd){
//		System.out.println("ceshiyixia");
//		Subject currentUser = SecurityUtils.getSubject();
//		if(!currentUser.isAuthenticated()){
//			// 把用户名和密码封装为 UsernamePasswordToken 对象
//            UsernamePasswordToken token = new UsernamePasswordToken(username, userpwd);
//           try{
//        	 //登录认证 - 调用userRealm
//               currentUser.login(token);
//           }catch (IncorrectCredentialsException ice) {
//               throw new IncorrectCredentialsException("密码错误！");
//           } 
//           catch(AuthenticationException ae){
//        	   throw new AuthenticationException(ae.getMessage());
//           }
//		}
//		return new JsonResult();
//	}
//}
