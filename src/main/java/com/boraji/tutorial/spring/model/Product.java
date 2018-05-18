package com.boraji.tutorial.spring.model;

import javax.persistence.*;

@Entity(name = "Product")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String name;
   private Integer price;
   @Column(length = 1000)
   private String imageLink;
   private Integer like;
   

   public Integer getId() {
      return id;
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
   
   public Integer getLike() {
      return like;
   }

   public void setLike(Integer like) {
      this.like = like;
   }

}
