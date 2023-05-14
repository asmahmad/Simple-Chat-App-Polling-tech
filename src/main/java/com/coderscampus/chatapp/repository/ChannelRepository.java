package com.coderscampus.chatapp.repository;
import com.coderscampus.chatapp.domain.Channel;
import com.coderscampus.chatapp.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;

// This class has methods for adding, getting, and removing channels, as well as a method for getting all channels in the repository. 
@Repository
public class ChannelRepository {

	private List<Channel> channels = new ArrayList<>();
	private Set<User> usersList = null;

	public Channel findById(Long id) {
		Channel channel = null;
		for (int i = 0; i < channels.size(); i++) {
			if (channels.get(i).getId().equals(id)) {
				channel = channels.get(i);
			}
		}
		return channel;

	}

	public Channel save(Channel channel) {
		channels.add(channel);
		return channel;
	}

	public List<Channel> findAll() {
		return channels;
	}

	public void saveUser(Channel channel) {
		channels.add(channel);
	}

	public Set<User> getUsers() {

		channels.forEach(channel -> {
			usersList = channel.getUsers();
		});
		return this.usersList;
	}

}