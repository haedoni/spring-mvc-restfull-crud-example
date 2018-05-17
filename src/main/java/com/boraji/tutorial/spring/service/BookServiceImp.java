package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.BookDao;
import com.boraji.tutorial.spring.model.Book;

@Service
@Transactional(readOnly = true)
public class BookServiceImp implements BookService {

   @Autowired
   private BookDao bookDao;

   @Transactional
   @Override
   public int save(Book book) {
      return bookDao.save(book);
   }

   @Override
   public Book get(int id) {
      return bookDao.get(id);
   }

   @Override
   public List<Book> list() {
      return bookDao.list();
   }

   @Transactional
   @Override
   public void update(int id, Book book) {
      bookDao.update(id, book);
   }

   @Transactional
   @Override
   public void delete(int id) {
      bookDao.delete(id);
   }

}
