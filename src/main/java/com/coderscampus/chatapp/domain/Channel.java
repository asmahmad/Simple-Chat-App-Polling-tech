package com.coderscampus.chatapp.domain;

import java.util.HashSet;
import java.util.Set;

//This class has two fields, id and name, which represent the unique ID and name of a channel. 
public class Channel {

	private Long id;
	private String channelName;
	private Set<User> users = new HashSet<>();
	
	
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> channels) {
		this.users = channels;
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", channelName=" + channelName + ", users=" + users + "]";
	}

}
