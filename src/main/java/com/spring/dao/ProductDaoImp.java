package com.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transaction;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Product;
import com.spring.model.User;

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
	  
	  Transaction trans = null;
	  Session session = sessionFactory.getCurrentSession();
	  try {
	  Query userQuery = session.createQuery("from USER u where u.email=:email");
	  userQuery.setParameter("email", user_email);

	  User users = (User)userQuery.getSingleResult();

	  Query productQuery = session.createQuery("from PRODUCT u where u.name=:name");
	  productQuery.setParameter("name", product_name);
	  Product products = (Product)productQuery.getSingleResult();

	  users.getProducts().add(products);
	  
	  session.save(users);
	  session.getTransaction().commit();
	  
//	  Query userQuery1 = session.createQuery("from USER");
//	  User user1s = (User)userQuery1.getSingleResult();
//	  List<Product> aa = user1s.getProducts();
//	  Product sss = aa.get(0);
//	  System.out.println("aaaaa= " + sss.getName());

	  } catch(Exception e) {
		  e.printStackTrace();
	  }
	  
	  return 1; 
   }

   @Override
   public Product get(int id) {
      Product result = sessionFactory.getCurrentSession().get(Product.class, id);
      return result;
   }

   @Override
   public List<Product> listProductLiked(String email){
	   System.out.println(email);
	   Session session = sessionFactory.getCurrentSession();
	   Query userQuery = session.createQuery("from PRODUCT p "
	   		+ "Join USER u "
	   		+ "where u.email = :email");
	   userQuery.setParameter("email", email);
	   List<Product> products = userQuery.getResultList();
	   
//	   User users = (User)userQuery.getSingleResult();   
//	   List<Product> products = users.getProducts();
	   System.out.println("wow = " + products.get(0).getName());
	   Hibernate.initialize(products);
	   return products;
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
