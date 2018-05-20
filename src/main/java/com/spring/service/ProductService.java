package com.spring.service;

import java.util.List;

import com.spring.model.Product;
import com.spring.model.User;

public interface ProductService {

	int save(Product product);
	int addUser(String user_email, String product_name);
   Product get(int id);
   List<Product> listProductLiked(String email);
   List<Product> list();
   void update(int id, Product product);
   void delete(int id);
}
