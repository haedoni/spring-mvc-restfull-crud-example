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
   public Member get(String userid) {
      return sessionFactory.getCurrentSession().get(Member.class, userid);
   }

   @Override
   public List<Member> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Member> cq = cb.createQuery(Member.class);
      Root<Member> root = cq.from(Member.class);
      cq.select(root);
      Query<Member> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(int id, Member member) {
      Session session = sessionFactory.getCurrentSession();
      Member product2 = session.byId(Member.class).load(id);
      product2.setName(member.getName());
      product2.setPassword(member.getPassword());
      product2.setEmail(member.getEmail());
      session.flush();
   }

   @Override
   public void delete(int id) {
      Session session = sessionFactory.getCurrentSession();
      Member product = session.byId(Member.class).load(id);
      session.delete(product);
   }

   
}
