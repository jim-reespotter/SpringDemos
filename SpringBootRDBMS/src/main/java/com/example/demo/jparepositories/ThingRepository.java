package com.example.demo.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.datatypes.Thing;

public interface ThingRepository extends JpaRepository <Thing, String> {

}
