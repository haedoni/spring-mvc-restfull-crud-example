package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.tutorial.spring.model.Member;

public interface MemberDao {
	int save(Member member);

	Member get(String userId);
	
}
