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

import com.boraji.tutorial.spring.model.Member;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

@Repository
public class MemberDaoImpl implements MemberDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public int save(Member member) {
      sessionFactory.getCurrentSession().save(member);
      return member.getId();
   }

   @Override
   public Member get(String userId) {
	   Member mem = null;
	   Session session = sessionFactory.getCurrentSession();
	   Query query = session.createQuery("from Member m where m.userId=:userId");
	   query.setParameter("userId", userId);
	   List<Member> members = query.list();
	   
	   for(Member tmpMem : members) {
		   mem = tmpMem;
	   }
	   return mem;
   }
   
}
