package com.wr.userfake;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	
	private final UserService userService;
	
	public AsyncService(UserService userService) {
		this.userService = userService;
	}
	
	@Async
	public CompletableFuture<String> findUserById(final Integer id){
		System.out.println("Executing method in thread " + Thread.currentThread().getName());
		return CompletableFuture.completedFuture(userService.findUserById(id));
	}

}
