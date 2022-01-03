package com.matrix.demo;

import java.util.List;

import com.matrix.demo.entity.User;
import com.matrix.demo.mapper.UserMapper2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	User person;

	@Autowired
	UserMapper2 usermapper;

	@Autowired
	ApplicationContext  ioc;

	@Test
	public void testHelloService() {
		boolean b = ioc.containsBean("personService");
		if(b) {
			System.out.println("personService  exists");
		} else {
			System.out.println("personService not exists");
		}
	}

	@Test
	void contextLoads() {
		System.out.println(person);
	}

	@Test
	void testUserMapper2() {
		List<User> users = usermapper.selectAll();
		System.out.println(users);
	}

}
