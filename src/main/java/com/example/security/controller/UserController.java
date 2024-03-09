package com.example.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.entity.Member;
import com.example.security.service.ecommerce.MemberService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/user")
	public Member getUser(Authentication auth) {
		
		return memberService.getMember(auth.getName());
	}
}
