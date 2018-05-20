package com.spring.dao;

import java.util.List;

import com.spring.model.User;

public interface UserDao {
	int save(User member);

	User get(String userId);
	
}
