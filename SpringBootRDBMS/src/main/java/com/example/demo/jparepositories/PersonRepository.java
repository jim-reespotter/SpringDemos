package com.example.demo.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.datatypes.Person;

public interface PersonRepository extends JpaRepository <Person, String> {

}
