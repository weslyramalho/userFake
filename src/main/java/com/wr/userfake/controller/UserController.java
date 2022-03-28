package com.wr.userfake.controller;

import java.util.concurrent.CompletableFuture;

import javax.security.auth.x500.X500Principal;


import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wr.userfake.model.User;
import com.wr.userfake.services.UserService;

import antlr.collections.List;

@RequestMapping("/user")
@RestController
@Async
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public CompletableFuture<List<User> findAll(){
		System.out.println("Controller Thread :" + Thread.currentThread().getName());
		return this.userService.findAll();
	}
	
	@GetMapping("/{id}")
	public CompletableFuture<User> findById(@PathVariable("id") final Long id){
		System.out.println("Controller Thread :" + Thread.currentThread().getName());

		return this.userService.findById(id)
				.thenApply(x -> x.orElseThrow(UserNotFound::new));
	}
	@PostMapping
	public CompletableFuture<User> save(@RequestBody final User user) {
		System.out.println("Controller Thread :" + Thread.currentThread().getName());
		return this.userService.save(user);
		
	}

}
