package com.boraji.tutorial.spring.model;

import javax.persistence.*;

@Entity(name = "Member")
public class Member {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String userid;
   private String name;
   private String password;
   private String email;
   

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }
   
   public String getUserId() {
      return userid;
   }

   public void setUserId(String userid) {
      this.userid = userid;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
