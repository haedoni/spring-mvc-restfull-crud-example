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

import com.boraji.tutorial.spring.model.Product;
import com.boraji.tutorial.spring.model.User;

@Repository
public class ProductDaoImp implements ProductDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public int save(Product product) {
      sessionFactory.getCurrentSession().save(product);
      return product.getId();
   }
   
   @Override
   public int addUser(String user_email, String product_name) {
	  User selectedUsr = null;
	  Product selectedPrdt = null;
	  
	  try {
	  Session session = sessionFactory.getCurrentSession();
	  Query userQuery = session.createQuery("from users u where u.email=:email");
	  userQuery.setParameter("email", user_email);
	  List<User> users = userQuery.list();
	   
	  for(User tmpUser : users) {
		  selectedUsr = tmpUser;
	  }
	  
	  Query productQuery = session.createQuery("from products u where u.name=:name");
	  productQuery.setParameter("name", product_name);
	  List<Product> products = productQuery.list();
	   
	  for(Product tmpproduct : products) {
		  selectedPrdt = tmpproduct;
	  }
	  
	  selectedUsr.addProduct(selectedPrdt);
	  selectedPrdt.addUser(selectedUsr);
	  } catch(Exception e) {
		  throw e;
	  }
	  
	  return 1; 
   }

   @Override
   public Product get(int id) {
      return sessionFactory.getCurrentSession().get(Product.class, id);
   }

   @Override
   public List<Product> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Product> cq = cb.createQuery(Product.class);
      Root<Product> root = cq.from(Product.class);
      cq.select(root);
      Query<Product> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(int id, Product product) {
      Session session = sessionFactory.getCurrentSession();
      Product product2 = session.byId(Product.class).load(id);
      product2.setName(product.getName());
      product2.setPrice(product.getPrice());
      product2.setImageLink(product.getImageLink());
      session.flush();
   }

   @Override
   public void delete(int id) {
      Session session = sessionFactory.getCurrentSession();
      Product product = session.byId(Product.class).load(id);
      session.delete(product);
   }

   
}
