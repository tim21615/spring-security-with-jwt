package com.example.security.service;

import com.example.security.dto.LoginDto;

public interface AuthService {
	String login(LoginDto loginDto);
}
