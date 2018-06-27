package com.yueting.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yueting.Repository.UserRepository;
import com.yueting.model.User;
import com.yueting.util.MsgCode;
import com.yueting.util.Result;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	Logger logger =  LoggerFactory.getLogger(getClass());
	
/*	GET/users   get list
	GET/users/1  get user by id
	POST/user/   save user
	PUT/user/    update user
	delete/user/1  delete by id 1
	*/
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public Result<List<User>> listUser() {
		Result<List<User>> result = new Result<List<User>>();
		result.setCode(MsgCode.SUCCESS.getCode());
		result.setMsg(MsgCode.SUCCESS.getDescription());
		List<User> users = userRepository.findAll();
		result.setData(users);
		return result;
	}
	
	@PostMapping("/")
	public Result<User> saveUser(@RequestBody User user) {
		Result<User> result = new Result<User>();
		result.setCode(MsgCode.SUCCESS.getCode());
		result.setMsg(MsgCode.SUCCESS.getDescription());
		result.setData(userRepository.save(user));
		return result;
	}
	
	@GetMapping("/{id}")
	public Result<User> getUser(@PathVariable(value = "id") Integer id) {
		Result<User> result = new Result<User>();
		result.setCode(MsgCode.SUCCESS.getCode());
		result.setMsg(MsgCode.SUCCESS.getDescription());
		result.setData(userRepository.findById(id));
		return result;
	}
	
}
