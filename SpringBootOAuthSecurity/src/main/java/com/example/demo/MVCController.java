package com.example.demo;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MVCController {

	@RequestMapping(value={"/", "/login"}, method=RequestMethod.GET)
	public String getLoginPage (ModelMap model) {
		
		// add each idP
		return "login";
	}
	
	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String getContent (ModelMap model) {
		
		// pass over authentication details
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof OAuth2Authentication) {
			OAuth2Authentication auth = (OAuth2Authentication) authentication;
			Map <String, Object> details = (Map <String, Object>) auth.getUserAuthentication().getDetails();
			model.put("name", details.get("name"));
			model.put("details", details);
		}	
			
		return "content";
	}
}
