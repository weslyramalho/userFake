package com.wr.userfake.repositories;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;

import antlr.collections.List;

@Async
public interface UserRepository extends JpaRepository<User, Long>{
	
	CompletableFuture<Optional<User>> findOneById(final Long id);
	
	CompletableFuture<List<User> findAllBy();

}
