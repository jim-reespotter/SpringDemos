package com.example.demo.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.services.PersonService;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan (basePackages={"com.example.demo"})
public class PersonServiceTest {

	@Autowired
	private PersonService pSvc;
	
	@Test
	public void test() {
		pSvc.getAll();
	}

}
