package com.wr.userfake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class UserfakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserfakeApplication.class, args);
	}
	
	

}
