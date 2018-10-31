package com.example.demo;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/id**")
					.permitAll()	
			    .anyRequest()
			        .authenticated()
			.and()
				.logout().logoutUrl("/logout").permitAll();
		
		// if not authenticated, show login page (regardless of url)
		// login page has relevant links to authenticate against given providers
		// once logged in, show content
	}
	*/
}