package com.coderscampus.chatapp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

	private UUID id = UUID.randomUUID();
	private String username;
	private List<String> messages = new ArrayList<>();
	private Long channelId;

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", messages=" + messages + ", channelId=" + channelId
				+ "]";
	}

}

