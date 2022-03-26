package com.wr.userfake;

import java.util.concurrent.CompletableFuture;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

	private final AsyncService asyncService;
	
	public AppRunner(AsyncService asyncService) {
		this.asyncService = asyncService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		System.out.println("Thread principal " + Thread.currentThread().getName());
		CompletableFuture<String> page1 = asyncService.findUserById(1);
		CompletableFuture<String> page2 = asyncService.findUserById(2);
		CompletableFuture<String> page3 = asyncService.findUserById(3);

		CompletableFuture.allOf(page1, page2, page3).join();
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		System.out.println("--> " + page1.get());
		System.out.println("--> " + page2.get());
		System.out.println("--> " + page3.get());

	}

}
