package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.tutorial.spring.model.Product;
import com.boraji.tutorial.spring.model.User;

public interface ProductService {

	int save(Product product);
	int addUser(String user_email, String product_name);
   Product get(int id);
   List<Product> listProductLiked(int id);
   List<Product> list();
   void update(int id, Product product);
   void delete(int id);
}
