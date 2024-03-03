package com.example.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.dto.JWTAuthResponse;
import com.example.security.dto.LoginDto;
import com.example.security.entity.Member;
import com.example.security.entity.MemberHasRole;
import com.example.security.repository.MemberHasRoleRepository;
import com.example.security.repository.MemberRepository;
import com.example.security.service.AuthService;

@CrossOrigin("*")
@RequestMapping("/api/auth")
@RestController
public class AuthController {

    @Autowired 
	MemberRepository memberRepository;
	
	@Autowired
	MemberHasRoleRepository memberHasRoleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private AuthService authService;
	
	
    // Login REST API
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

	@PostMapping("/register")
	@Transactional
	public Member register(@RequestBody Member member) {
		
		// encode password
		String encodedPassword = passwordEncoder.encode(member.getPassword());
		member.setPassword(encodedPassword);
		
		Member member2 = memberRepository.save(member);
		
		// register => 給 USER 身分
		memberHasRoleRepository.save(new MemberHasRole(member2.getMemberId(), 2));
		return member;
	}
}