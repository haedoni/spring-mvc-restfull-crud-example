package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.tutorial.spring.model.User;

public interface UserDao {
	int save(User member);

	User get(String userId);
	
}
