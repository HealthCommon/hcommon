package com.hc.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hc.data.models.User;
import com.hc.data.repositories.IUserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	@Autowired
	private IUserRepository userRepository;

	public UserController() {
		System.out.println("UserController()");
	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") UUID id) {
		userRepository.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public User update(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	/*@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return (List<User>)userRepository.findAll();
	}*/

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") UUID id) {
		return userRepository.findOne(id);
	}
	
	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	public User findByMobileAndPassword(@RequestParam("username") String mobile, @RequestParam("password") String password) {
		return userRepository.findByMobileAndPassword(mobile, password);
	}
	
	@RequestMapping(value = "/auth/otp", method = RequestMethod.POST)
	public User findByMobileAndOtp(@RequestParam("username") String mobile, @RequestParam("otp") String otp) {
		return userRepository.findByMobileAndOtp(mobile, otp);
	}
}
