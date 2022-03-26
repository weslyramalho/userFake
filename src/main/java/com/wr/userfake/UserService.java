package com.wr.userfake;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.MapsId;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private static Map<Integer, String> USERS = new HashMap<>();

	public UserService() {
		USERS.put(1, "User 1");
		USERS.put(2, "User 2");
		USERS.put(3, "User 3");

	}
	
	public String findUserById(final Integer id) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return USERS.get(id);
	}
}
