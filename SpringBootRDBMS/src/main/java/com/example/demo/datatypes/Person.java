package com.example.demo.datatypes;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	Long id;
	
	private String name;

/*	
	private Collection <Order> orders;
	private Collection <Person> children;

	public Person (String name) {
		this.name = name;
	}
	
	public String getName () {
		return name;
	}
	
	public Collection <Order> getOrders () {
		return orders;
	}

	public Collection <Person> getChildren () {
		return children;
	}
*/
}
