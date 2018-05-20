package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.ProductDao;
import com.boraji.tutorial.spring.model.Product;
import com.boraji.tutorial.spring.model.User;

@Service
@Transactional(readOnly = true)
public class ProductServiceImp implements ProductService {

   @Autowired
   private ProductDao productDao;

   @Transactional
   @Override
   public int save(Product product) {
      return productDao.save(product);
   }
   
   @Override
   public int addUser(String user_email, String product_name) {
      return productDao.addUser(user_email, product_name);
   }

   @Override
   public Product get(int id) {
      return productDao.get(id);
   }

   @Override
   public List<Product> listProductLiked(int id){
	   return productDao.listProductLiked(id);
   }
   
   @Override
   public List<Product> list() {
      return productDao.list();
   }

   @Transactional
   @Override
   public void update(int id, Product product) {
	   productDao.update(id, product);
   }

   @Transactional
   @Override
   public void delete(int id) {
	   productDao.delete(id);
   }

}
