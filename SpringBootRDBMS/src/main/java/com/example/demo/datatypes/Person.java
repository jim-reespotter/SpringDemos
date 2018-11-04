package com.example.demo.datatypes;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	Long id;
	
	private String name;

	@OneToMany(mappedBy="customer")
	private Set <Thing> things = new HashSet <Thing> ();;
/*
	private Collection <Person> children;

	public Person (String name) {
		this.name = name;
	}
*/	
	public String getName () {
		return name;
	}
	
	public Collection <Thing> getThings () {
		return things;
	}
/*
	public Collection <Person> getChildren () {
		return children;
	}
*/
}
