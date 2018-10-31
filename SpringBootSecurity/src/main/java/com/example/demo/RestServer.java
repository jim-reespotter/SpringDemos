package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServer {

	private Map <String, ServedThing> things = new HashMap <String, ServedThing> ();
	
	public RestServer () {
		things.put("Thing1", new ServedThing ("Thing1", "Value1"));
		things.put("Thing2", new ServedThing ("Thing2", "Value2"));		
	}
	
	@GetMapping ("/things")
	public Collection <ServedThing> getContent () {
		return things.values();
	}
	
	@GetMapping ("thing/{id}")
	public ServedThing getThing (@PathVariable("id") String id) {
		return things.get(id);
	}
	
	@GetMapping ("id")
	public ServedThing getId () {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		return new ServedThing ("logged in username (from Spring):", currentPrincipalName);
	}
}
