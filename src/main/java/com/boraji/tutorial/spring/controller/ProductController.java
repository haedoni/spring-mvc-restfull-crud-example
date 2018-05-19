package com.boraji.tutorial.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.spring.model.Product;
import com.boraji.tutorial.spring.service.ProductService;

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
   public ResponseEntity<?> save(@RequestBody String name) {
      long id = productService.addLike(name);
      return ResponseEntity.ok().body("add Like" + id);
   }

   /*---Get a book by id---*/
   @GetMapping("/product/{id}")
   public ResponseEntity<Product> get(@PathVariable("id") int id) {
      Product product = productService.get(id);
      return ResponseEntity.ok().body(product);
   }

   /*---get all books---*/
   @GetMapping("/product")
   public ResponseEntity<List<Product>> list() {
      List<Product> products = productService.list();
      return ResponseEntity.ok().body(products);
      
   }

   /*---Update a book by id---*/
   @PutMapping("/product/{id}")
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Product product) {
	   productService.update(id, product);
      return ResponseEntity.ok().body("Book has been updated successfully.");
   }

   /*---Delete a book by id---*/
   @DeleteMapping("/product/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") int id) {
	   productService.delete(id);
      return ResponseEntity.ok().body("Book has been deleted successfully.");
   }
}