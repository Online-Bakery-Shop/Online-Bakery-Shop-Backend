package com.ecom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecom.entity.User;
import com.ecom.service.UserSignup;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	
	
	
	@Autowired
	private UserSignup usersignup;
	
	@PostMapping(path="/Customers")
	public User addUser(@RequestBody User user) {
		return this.usersignup.addUSer(user);
	}
	
	
	@GetMapping (path="/Customers")
	
	public List<User> getUsers()
	
	{
	
	return this.usersignup.getUser();
	
	}
	
	@GetMapping("/Customers/{emailId}/{password}")
	public User loginCheck(@PathVariable String emailId ,@PathVariable String password)
	{
		return this.usersignup.login(emailId, password);
	}
	
	
}
