package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.MemberDao;
import com.boraji.tutorial.spring.model.Member;

@Service
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

   @Autowired
   private MemberDao memberDao;

   @Transactional
   @Override
   public int save(Member member) {
      return memberDao.save(member);
   }

   @Override
   public Member get(String userId) {
      return memberDao.get(userId);
   }



}
