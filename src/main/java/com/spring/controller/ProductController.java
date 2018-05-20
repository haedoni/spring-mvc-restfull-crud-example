package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Product;
import com.spring.model.User;
import com.spring.service.ProductService;

@CrossOrigin(origins="*")
@RestController
public class ProductController {

   @Autowired
   private ProductService productService;

   /*---Add new product---*/
   @PostMapping("/product")
   public ResponseEntity<?> save(@RequestBody Product product) {
      long id = productService.save(product);
      return ResponseEntity.ok().body("New Product has been saved with ID:" + id);
   }
   
   /*---Add like---*/
   @PostMapping("/product/addLike")
   public ResponseEntity<?> save(@RequestParam Map body) {
      int rs = productService.addUser(body.get("user").toString(), body.get("product").toString());
      return ResponseEntity.ok().body(rs);
   }

   /*---Get a product by id---*/
   @GetMapping("/product/{id}")
   public ResponseEntity<Product> get(@PathVariable("id") int id) {
      Product product = productService.get(id);
      Product productObj = new Product(product);
      return ResponseEntity.ok().body(productObj);
   }

   /*---get all products liked by user---*/
   @PostMapping("/likedProduct")
   public ResponseEntity<List<Product>> listProductLiked(@RequestParam Map body) {
	   System.out.println("liked by = " + body.get("user"));
      List<Product> products = productService.listProductLiked(body.get("user").toString());
//      System.out.println("link link= " + products.get(0).getImageLink());
      
      return ResponseEntity.ok().body(products);
      
   }
   
   /*---get all products---*/
   @GetMapping("/product")
   public ResponseEntity<List<Product>> list() {
      List<Product> products = productService.list();
      return ResponseEntity.ok().body(products);
      
   }

   /*---Delete a product by id---*/
   @DeleteMapping("/product/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") int id) {
	   productService.delete(id);
      return ResponseEntity.ok().body("Product has been deleted successfully.");
   }
}