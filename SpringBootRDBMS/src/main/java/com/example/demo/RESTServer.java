package com.example.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.datatypes.Person;
import com.example.demo.services.PersonService;

@RestController
@EntityScan (basePackages={"com.example.demo.datatypes"})
public class RESTServer {

	@Autowired
	private PersonService pSvc;
	
	@GetMapping ("/person")
	public Collection <Person> getPeople () {
		return pSvc.getAll ();
	}
}
