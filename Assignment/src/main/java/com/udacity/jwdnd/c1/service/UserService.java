package com.udacity.jwdnd.c1.service;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.c1.mappers.UserMapper;
import com.udacity.jwdnd.c1.model.Users;

@Service
public class UserService {

	private UserMapper userMapper;
	private HashService hashService;

	public boolean isUsernameAvailable(String username) {
		return userMapper.getUser(username) == null;
	}

	public int createUser(Users user) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		String encodedSalt = Base64.getEncoder().encodeToString(salt);
		String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
		return userMapper.insertUser(new Users(null, user.getUsername(), encodedSalt, hashedPassword,
				user.getFirstname(), user.getLastname()));
	}

	public Users getUser(String username) {
		return userMapper.getUser(username);
	}
}
