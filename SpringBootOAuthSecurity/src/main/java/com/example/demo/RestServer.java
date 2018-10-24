package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServer {

	private Set <ServedThing> things = new HashSet <ServedThing> ();
	
	public RestServer () {
		things.add(new ServedThing ("Thing1", "Value1"));
		things.add(new ServedThing ("Thing2", "Value2"));		
	}
	
	@GetMapping ("/")
	public Set <ServedThing> getContent () {
		return things;
	}
}
