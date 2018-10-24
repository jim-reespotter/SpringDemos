package com.example.demo;

public class ServedThing {

	private String name;
	private String value;

	public ServedThing (String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName () {
		return name;
	}
	
	public String getValue () {
		return value;
	}
}
