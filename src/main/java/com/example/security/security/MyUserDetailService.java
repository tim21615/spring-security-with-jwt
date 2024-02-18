package com.example.security.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.security.entity.Member;
import com.example.security.repository.MemberRepository;
import com.example.security.repository.RoleRepository;

@Component
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Member member = memberRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("查無此帳號"));
		List<GrantedAuthority> authorities = roleRepository.findRoleByMemberId(member.getMemberId()).stream()
				.map(e -> new SimpleGrantedAuthority(e.getRoleName())).collect(Collectors.toList());

		System.out.println("auth:" + authorities);
		return new User(member.getEmail(), member.getPassword(), authorities);
	}

}
