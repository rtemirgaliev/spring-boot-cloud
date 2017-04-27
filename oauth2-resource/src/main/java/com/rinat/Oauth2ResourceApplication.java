package com.rinat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Oauth2ResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2ResourceApplication.class, args);
	}

	private String message = "Hello";

	@PreAuthorize("hasRole('ROLE_RS_READ')")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Map<String, String> home() {
		return Collections.singletonMap("hello", message);
	}

	@PreAuthorize("hasRole('ROLE_RS_WRITE')")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void updateMessage(@RequestBody String message) {
		this.message = message;
	}

	@PreAuthorize("#oauth2.hasScope('resource-server-read')")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Map<String, String> user(Principal user) {
		return Collections.singletonMap("message", "user is: " + user.toString());
	}

	@Autowired
	private ResourceServerProperties sso;

	@Bean
	public ResourceServerTokenServices tokenServices() {
		return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
	}

}
