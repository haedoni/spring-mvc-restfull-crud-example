package com.spring.service;

import java.util.List;

import com.spring.model.User;

public interface UserService {

	int save(User user);
	User get(String userId);

}
