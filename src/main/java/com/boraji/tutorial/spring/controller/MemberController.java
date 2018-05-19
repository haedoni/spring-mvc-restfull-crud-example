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

import com.boraji.tutorial.spring.model.Member;
import com.boraji.tutorial.spring.model.GoogleMember;
import com.boraji.tutorial.spring.service.MemberService;

@CrossOrigin(origins="*")
@RestController
public class MemberController {

   @Autowired
   private MemberService memberService;

   /*---Add new book---*/
   @PostMapping("/signup")
   public ResponseEntity<?> save(@RequestBody GoogleMember googleMember) {
	   System.out.println(googleMember.getEmail());
	   System.out.println(googleMember.getName());
	   System.out.println(googleMember.getProvider());
	   System.out.println(googleMember.getProvider_id());
	   System.out.println(googleMember.getProvider_pic());
	   
	   
	   //long id = memberService.save(member);
      return ResponseEntity.ok().body(googleMember);
   }
   
   /*---Add new book---*/
   @PostMapping("/member")
   public ResponseEntity<?> save(@RequestBody Member member) {
      long id = memberService.save(member);
      return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
   }


}