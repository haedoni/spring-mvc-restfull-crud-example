package com.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value= {"user"})
@Entity(name = "PRODUCT")
public class Product {
//public class Product implements Serializable{

   @Id
   @GeneratedValue
   @Column(name="PRODUCT_ID")
   private Integer id;
   @Column(name = "NAME", unique = true)
   private String name;
   @Column(name = "PRICE")
   private Integer price;
   @Column(name="IMAGELINK", length = 1000)
   private String imageLink;
   
//   @ManyToMany(fetch=FetchType.LAZY, mappedBy = "products")
//   private List<User> users = new ArrayList<>();
   
   public Product() { }
   
   public Product(Product prodt) {
	   id = prodt.getId();
	   name = prodt.getName();
	   price = prodt.getPrice();
	   imageLink = prodt.getImageLink();
//	   users = prodt.getUsers();
   }
   
   public Integer getId() {
      return id;
   }
   
//   public List<User> getUsers(){
//	   return users;
//   }
//   
//   public void addUser(User user) {
//	   this.users.add(user);
//   }
   
   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getPrice() {
      return price;
   }

   public void setPrice(Integer price) {
      this.price = price;
   }

   public String getImageLink() {
      return imageLink;
   }

   public void setImageLink(String imageLink) {
      this.imageLink = imageLink;
   }

}
