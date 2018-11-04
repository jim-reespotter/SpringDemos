package com.example.demo.datatypes;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Thing {
	
	@Id
	private long id;

	@ManyToOne
	private Person customer;
	
	private String details;
	
	public String getDetails () {
		return details;
	}

}
