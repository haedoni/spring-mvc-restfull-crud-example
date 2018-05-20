package com.boraji.tutorial.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value= {"product"})
@Entity(name = "USER")
public class User {
//public class User implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "USER_ID")
   private Integer id;
   @Column(name = "EMAIL")
   private String email;
   @Column(name = "NAME")
   private String name;
   @Column(name = "PROVIDER")
   private String provider;
   @Column(name = "PROVIDER_ID")
   private String provider_id;
   @Column(name = "PROVIDER_PIC")
   private String provider_pic;
   @Column(name = "TOKEN")
   private String token;
   
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "USER_PRODUCT",
           joinColumns = {@JoinColumn(name = "USER_ID")},
           inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID")})
   private List<Product> products = new ArrayList<>();

   public User() {  }
   
   public User(User usr) {
      email = usr.getEmail();
      name = usr.getName();
      products = usr.getProducts();
   }
   
   public int getId() {
      return id;
   }
   
   public void addProduct(Product product) {
	   this.products.add(product);
   }
   
   
   public List<Product> getProducts(){
	   return products;
   }
   
   public void setUser(int id) {
      this.id = id;
   }
   
   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getProvider() {
      return provider;
   }

   public void setProvider(String provider) {
      this.provider = provider;
   }
   
   public String getProvider_id() {
      return provider_id;
   }

   public void setProvider_id(String provider_id) {
      this.provider_id = provider_id;
   }
   
   public String getProvider_pic() {
      return provider_pic;
   }

   public void setProvider_pic(String provider_pic) {
      this.provider_pic = provider_pic;
   }
   
   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }


}
