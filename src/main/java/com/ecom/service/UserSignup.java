package com.ecom.service;

import java.util.List;

import com.ecom.entity.User;

public interface UserSignup {
	
	public User addUSer(User user);
	
	public  List <User> getUser();
	
	public User login(String Email,String Password);
}
