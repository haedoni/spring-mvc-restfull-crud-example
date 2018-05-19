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
   private Integer likeCnt;
   

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
   
   public Integer getLikeCnt() {
      return likeCnt;
   }

   public void setLikeCnt(Integer likeCnt) {
      this.likeCnt = likeCnt;
   }

}
