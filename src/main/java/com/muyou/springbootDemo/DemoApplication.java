package com.muyou.springbootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 开启定时
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("The service to start...");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("The service has started...");
	}
}
