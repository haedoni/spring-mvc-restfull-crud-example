package com.boraji.tutorial.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "Products")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="PRODUCT_ID")
   private Integer id;
   @Id
   private String name;
   private Integer price;
   @Column(length = 1000)
   private String imageLink;
   
   private Set<User> users = new HashSet<User>();
   
   public Integer getId() {
      return id;
   }

   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(
           name = "USERS_PRODUCTS",
           joinColumns = @JoinColumn(name = "PRODUCT_ID"),
           inverseJoinColumns = @JoinColumn(name = "USER_ID")
   )
   public Set<User> getUsers(){
	   return users;
   }
   
   public void addUser(User user) {
	   this.users.add(user);
   }
   
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
