package com.boraji.tutorial.spring.model;

import javax.persistence.*;

@Entity(name = "users")
public class GoogleMember {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
  // private Integer user;
   private String email;
   private String name;
   private String provider;
   private String provider_id;
   private String provider_pic;
   private String token;

//   public int getUser() {
//      return user;
//   }
//
//   public void setUser(int user) {
//      this.user = user;
//   }
//   
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
