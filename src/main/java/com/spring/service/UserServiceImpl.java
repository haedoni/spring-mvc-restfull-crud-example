package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserDao;
import com.spring.model.User;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public int save(User user) {
      return userDao.save(user);
   }

   @Override
   public User get(String userId) {
      return userDao.get(userId);
   }



}
