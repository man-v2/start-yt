package com.example;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yueting.Repository.ItermRepository;
import com.yueting.Repository.UserRepository;
import com.yueting.model.Iterm;
import com.yueting.model.User;


@SpringBootTest({"UserRepository"})
public class TestUser {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ItermRepository itermRepository;
	
	@Test
	public void test() {
		List<User> users = userRepository.findAll();
		for(User u : users) {
			logger.info(u.toString());
		}
		
	}
}
