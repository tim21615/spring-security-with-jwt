package com.example.security.service.ecommerce.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.entity.Member;
import com.example.security.repository.MemberRepository;
import com.example.security.service.ecommerce.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	@Cacheable(value = "member")
	public Member getMember(String email) {
		System.err.println("從 mysql 拿 user");
		return memberRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("查無此帳號"));
	}

}
