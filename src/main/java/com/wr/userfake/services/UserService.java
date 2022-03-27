package com.wr.userfake.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import javax.persistence.MapsId;

import org.springframework.stereotype.Service;

import com.wr.userfake.repositories.UserRepository;

import antlr.collections.List;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public CompletableFuture<Optional<User>> findById(Long id){
		System.out.println("ServiceThread :" + Thread.currentThread().getName());
		return this.userRepository.findOneById(id);
	}
	public CompletableFuture<List<User> findAll() {
		System.out.println("ServiceThread :" + Thread.currentThread().getName());
		return userRepository.findAllBy();
		
	}
	
	public CompletableFuture<User> save(final User user) {
		System.out.println("ServiceThread :" + Thread.currentThread().getName());

		return CompletableFuture.completedFuture(userRepository.save(user));
}
