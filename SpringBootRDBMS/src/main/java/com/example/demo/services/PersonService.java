package com.example.demo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.datatypes.Person;
import com.example.demo.jparepositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository pRepo;

	public Collection<Person> getAll() {
		return pRepo.findAll();
	}
}
