package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.UserSignupDao;
import com.ecom.entity.User;


@Service
public class UserSignupImpl implements UserSignup {

	@Autowired
	private UserSignupDao signUpdao;
	
	
	@Override
	public User addUSer(User user) {
		
		signUpdao.save(user);
		
		return user;
		
	}


	@Override
	public List<User> getUser() {
		
		return signUpdao.findAll();
	}


	@Override
	public User login(String Email, String Password) {
		
		return signUpdao.findByEmailAndPassword(Email,Password);
	}


	

	
	
	
}
