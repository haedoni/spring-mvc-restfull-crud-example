package com.boraji.tutorial.spring.dao;

import java.util.List;
import com.boraji.tutorial.spring.model.Product;

public interface ProductDao {

	int save(Product product);
	
	int addLike(String name);
	
   Product get(int id);

   List<Product> list();

   void update(int id, Product product);

   void delete(int id);

}