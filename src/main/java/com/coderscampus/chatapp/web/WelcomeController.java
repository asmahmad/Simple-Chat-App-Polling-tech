package com.coderscampus.chatapp.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.chatapp.domain.Channel;
import com.coderscampus.chatapp.domain.User;
import com.coderscampus.chatapp.service.ChannelService;
import com.coderscampus.chatapp.service.UserService;

@Controller
public class WelcomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ChannelService channelService;
	
	@GetMapping("")
	public String redirect() {
		return "redirect:/welcome";
	}
	
	@GetMapping("/welcome")
	public String getWelcomePage(ModelMap model) {
		// Channel-1
		Channel channel = new Channel();
		channel.setChannelName("Music & Movies");
		channel.setId(1L);
		
		// Channel-2
		Channel channel2 = new Channel();
		channel2.setChannelName("Fashion & Style");
		channel2.setId(2L);
		
		// Save channels
		Channel savedChannel1 = channelService.saveChannel(channel);
		Channel savedChannel2 = channelService.saveChannel(channel2);
		List<Channel> channels = new ArrayList<>();
		channels.add(savedChannel1);
		channels.add(savedChannel2);
		
		// Put channels to the model
		model.put("channels", channels);
		return "welcome";
	}
	
	@PostMapping("/welcome")
	@ResponseBody
	public User postUsername(@RequestBody User userFromJs) {
		UUID id = userFromJs.getId();
		User user = new User();
		user.setUsername(userFromJs.getUsername());
		user.setId(id);
		userService.saveUser(user);
		
		return user;
	}
}
