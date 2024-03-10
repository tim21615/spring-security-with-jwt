package com.example.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.dto.ecommerce.MemberIdReq;
import com.example.security.dto.ecommerce.ShoppingCartInsertResponse;
import com.example.security.dto.ecommerce.ShoppingCartResponse;
import com.example.security.entity.ecommerce.ShoppingCart;
import com.example.security.entity.ecommerce.ShoppingCartPK;
import com.example.security.service.ecommerce.ShoppingCartService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
public class ShoppingCartController {

	@Autowired
	ShoppingCartService shoppingCartService;

	@PostMapping("/shoppingCart")
	public ShoppingCart findByPK(@RequestBody ShoppingCartPK req) {

		return shoppingCartService.findById(req);
	}
	
	@PostMapping("/shoppingCart/member")
	public List<ShoppingCartResponse> findByMemberId(@RequestBody MemberIdReq req) {
		
		return shoppingCartService.findByMemberId(req.getMemberId());
	}
	
	@PostMapping("/shoppingCart/insert")
	public ShoppingCartInsertResponse insert(@RequestBody ShoppingCart req) {
		
		return shoppingCartService.insert(req);
	}

	
}
