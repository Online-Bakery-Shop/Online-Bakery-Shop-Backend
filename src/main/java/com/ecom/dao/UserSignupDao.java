package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecom.entity.User;

public interface UserSignupDao extends JpaRepository<User,Integer> {
	
	User findByEmailAndPassword(String email,String password);
	
	User findByEmail(String email);
}
