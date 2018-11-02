package com.example.demo;

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
		return "content";
	}
}
