package com.hostmdy.ecommerce_api.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.ecommerce_api.domain.User;

public interface UserService {
	Optional<User> getUserById(Long userId);
	
	List<User> getAllUsers();
	
	User saveUser(User user);
	
	void deleteUserById(Long userId);
}
