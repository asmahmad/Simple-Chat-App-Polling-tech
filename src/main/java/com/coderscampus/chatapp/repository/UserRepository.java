package com.coderscampus.chatapp.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.domain.User;
//methods for adding, getting, and removing users, as well as a method for getting all users in the repository.

@Repository
public class UserRepository {

	private List<User> users = new ArrayList<>();

	public User findUserById(UUID userId) {
		User user = null;
		for (User u : users) {
			if (u.getId().equals(userId)) {
				user = u;
			}
		}
		return user;
	}

	public void save(User user) {
		System.out.println("added user" + user);
		users.add(user);
		System.out.println("User added");

	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}

