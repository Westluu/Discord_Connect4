package com.example.demo;

import com.example.demo.listener.PlayListen;
import com.example.demo.listener.status;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DiscordConnect4Application {

	@Autowired
	private Environment envi;
	public static void main(String[] args) {
		SpringApplication.run(DiscordConnect4Application.class, args);
	}

	@Autowired
	private PlayListen playListen;

	@Autowired
	private status Status;

	@Bean
	@ConfigurationProperties(value = "discord-api")
	public DiscordApi discordApi() {
		String token = envi.getProperty("TOKEN");
		DiscordApi api = new DiscordApiBuilder().setToken(token)
				.setAllNonPrivilegedIntents()
				.login()
				.join();

		api.addMessageCreateListener(playListen);
		api.addMessageCreateListener(Status);
		return api;
	}
}
