package com.wr.userfake;

import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class UserfakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserfakeApplication.class, args);
	}
	
	@Bean
	public Executor taskExecutor() {
		return ForkJoinPool.commonPool();
		
	}

}
