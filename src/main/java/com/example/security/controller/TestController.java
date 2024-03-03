package com.example.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "http://localhost:4200")
@RestController
public class TestController {

	@GetMapping("/test")
	public String test(Authentication auth) {
		System.out.println(auth.getCredentials());
		return "Hello, " + auth.getName();
	}
}
