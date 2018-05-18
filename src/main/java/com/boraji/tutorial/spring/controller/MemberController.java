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
import com.boraji.tutorial.spring.service.MemberService;

@CrossOrigin(origins="*")
@RestController
public class MemberController {

   @Autowired
   private MemberService memberService;

   /*---Add new book---*/
   @PostMapping("/member")
   public ResponseEntity<?> save(@RequestBody Member member) {
      long id = memberService.save(member);
      return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
   }

   /*---Get a book by id---*/
   @GetMapping("/member/{id}/{password}")
   public ResponseEntity<Member> get(@PathVariable("id") String userid, @PathVariable("password") String password) {
	   Member member = memberService.get(userid);
	   if (member.getPassword().toString() == password) {
		   return ResponseEntity.ok().body(member);   
	   }
	   return (ResponseEntity<Member>) ResponseEntity.notFound();
   }

   /*---get all books---*/
   @GetMapping("/member")
   public ResponseEntity<List<Member>> list() {
      List<Member> products = memberService.list();
      return ResponseEntity.ok().body(products);
   }

   /*---Update a book by id---*/
   @PutMapping("/member/{id}")
   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Member member) {
	   memberService.update(id, member);
      return ResponseEntity.ok().body("Book has been updated successfully.");
   }

   /*---Delete a book by id---*/
   @DeleteMapping("/member/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") int id) {
	   memberService.delete(id);
      return ResponseEntity.ok().body("Book has been deleted successfully.");
   }
}