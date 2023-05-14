package com.coderscampus.chatapp.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.chatapp.domain.Channel;
import com.coderscampus.chatapp.domain.User;
import com.coderscampus.chatapp.repository.ChannelRepository;

@Service
public class ChannelService {
	@Autowired
	private ChannelRepository channelRepository;

	public void saveChannelOnPost(Channel channel) {
		channelRepository.saveUser(channel);
	}

	public Channel findChannelById(Long id) {
		return channelRepository.findById(id);
	}

	public Channel saveChannel(Channel channel) {
		return channelRepository.save(channel);
	}

	public List<Channel> getChannels() {
		return channelRepository.findAll();
	}

	// Get messages of the channel
	public Set<User> getUsers() {
		return channelRepository.getUsers();
	}
}

