package com.muyou.springbootDemo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muyou.springbootDemo.util.CodeImageUtil;


@RestController
@RequestMapping("login")
public class LoginController {
	
	@RequestMapping("/getCode")
	public void getCode(HttpServletRequest req,HttpServletResponse res) throws IOException {
		System.out.println("cehi1");
		// 创建验证码及图片
		Object[] ob = CodeImageUtil.createImage();
		// 将验证码存入session
		HttpSession session = req.getSession();
		session.setAttribute("code", ob[0]);
		// 将图片输出
		res.setContentType("image/png");
		OutputStream os = res.getOutputStream();
		ImageIO.write((BufferedImage)ob[1], "jpg", os);
		os.close();
		System.out.println("ceshi");
	}
}
