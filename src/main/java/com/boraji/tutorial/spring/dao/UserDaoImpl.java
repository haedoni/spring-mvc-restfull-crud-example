package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring.model.User;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

@Repository
public class UserDaoImpl implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public int save(User user) {
      sessionFactory.getCurrentSession().save(user);
      return user.getId();
   }

   @Override
   public User get(String userId) {
	   User usr = null;
	   Session session = sessionFactory.getCurrentSession();
	   Query query = session.createQuery("from Member m where m.userId=:userId");
	   query.setParameter("userId", userId);
	   List<User> users = query.list();
	   
	   for(User tmpMem : users) {
		   usr = tmpMem;
	   }
	   return usr;
   }
   
}
