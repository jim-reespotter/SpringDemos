package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CompositeFilter;

/**
 * All secuirity happens in here...
 * 
 * @author jim
 *
 */
@EnableOAuth2Client
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/**")
				.authorizeRequests()
					.antMatchers("/", "/login**").permitAll()
					.anyRequest().authenticated()
				.and()
					.logout().logoutSuccessUrl("/").permitAll()
				// get our filter in before the BasicAuthenticationFilter...
				.and().addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
	}

	private AuthenticationSuccessHandler asHandler = new SimpleUrlAuthenticationSuccessHandler () {
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	        this.setDefaultTargetUrl("/content");
	        super.onAuthenticationSuccess(request, response, authentication);
	    }
	};
	
	private Filter ssoFilter() {

		CompositeFilter filter = new CompositeFilter();
		List<Filter> filters = new ArrayList<Filter>();

		OAuth2ClientAuthenticationProcessingFilter facebookFilter = new OAuth2ClientAuthenticationProcessingFilter(
				"/login/facebook");
		OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(), oauth2ClientContext);
		facebookFilter.setRestTemplate(facebookTemplate);
		UserInfoTokenServices tokenServices = new UserInfoTokenServices(facebookResource().getUserInfoUri(),
				facebook().getClientId());
		tokenServices.setRestTemplate(facebookTemplate);
		facebookFilter.setTokenServices(tokenServices);
		facebookFilter.setAuthenticationSuccessHandler(asHandler);
		filters.add(facebookFilter);

		OAuth2ClientAuthenticationProcessingFilter googleFilter = new OAuth2ClientAuthenticationProcessingFilter(
				"/login/google");
		OAuth2RestTemplate googleTemplate = new OAuth2RestTemplate(google(), oauth2ClientContext);
		googleFilter.setRestTemplate(googleTemplate);
		tokenServices = new UserInfoTokenServices(googleResource().getUserInfoUri(), google().getClientId());
		tokenServices.setRestTemplate(googleTemplate);
		googleFilter.setTokenServices(tokenServices);
		googleFilter.setAuthenticationSuccessHandler(asHandler);
		filters.add(googleFilter);

		filter.setFilters(filters);
		return filter;
	}

	/**
	 * Methods to read stuff from application.yml...
	 */
	@Bean
	@ConfigurationProperties("facebook.client")
	public AuthorizationCodeResourceDetails facebook() {
		return new AuthorizationCodeResourceDetails();
	}

	@Bean
	@ConfigurationProperties("facebook.resource")
	public ResourceServerProperties facebookResource() {
		return new ResourceServerProperties();
	}

	@Bean
	@ConfigurationProperties("google.client")
	public AuthorizationCodeResourceDetails google() {
		return new AuthorizationCodeResourceDetails();
	}

	@Bean
	@ConfigurationProperties("google.resource")
	public ResourceServerProperties googleResource() {
		return new ResourceServerProperties();
	}

	/**
	 * End of config methods
	 */

	/**
	 * This method handles redirects to IdP. By setting order low (-100) it 'gets in
	 * there first' so this redirect should ha[[en before anything else if
	 * necessaryu
	 * 
	 * @param filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(
			OAuth2ClientContextFilter filter) {
		FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<OAuth2ClientContextFilter>();
		registration.setFilter(filter);
		registration.setOrder(-100);
		return registration;
	}
}