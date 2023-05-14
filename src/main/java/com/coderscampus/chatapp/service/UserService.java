package com.coderscampus.chatapp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.chatapp.domain.User;
import com.coderscampus.chatapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findById(UUID id) {
		return userRepository.findUserById(id);
	}

	public void saveUser(User user) {
		userRepository.save(user);

	}

	public List<User> getUsers() {
		return userRepository.getUsers();
	}

}
