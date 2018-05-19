package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.tutorial.spring.model.Member;

public interface MemberService {

	int save(Member member);
	Member get(String userId);

}
