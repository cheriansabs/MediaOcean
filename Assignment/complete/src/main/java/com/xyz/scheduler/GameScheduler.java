package com.xyz.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.xyz")
public class GameScheduler {

	public static void main(String[] args) {
		SpringApplication.run(GameScheduler.class, args);	
	}

	
}
