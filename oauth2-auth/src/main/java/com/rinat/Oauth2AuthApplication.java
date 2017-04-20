package com.rinat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
@EnableResourceServer
public class Oauth2AuthApplication {

	private static final Logger log = LoggerFactory.getLogger(Oauth2AuthApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		log.info("Authorisation server /user called: " + user.toString());
		return user;
	}

	@Configuration
	@EnableAuthorizationServer
	public static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.authenticationManager(authenticationManager);
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.inMemory()
					.withClient("service-account")
					.secret("secret")
					.authorizedGrantTypes("client_credentials")
					.scopes("resource-server-read", "resource-server-write")
					.authorities("ROLE_RS_READ");
		}

//		@Override
//		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//			security.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_ANONYMOUS')")
//				  .checkTokenAccess("isAnonymous() || hasAuthority('ROLE_ANONYMOUS') || hasAuthority('ROLE_RS_READ')");
//		}
	}

}
