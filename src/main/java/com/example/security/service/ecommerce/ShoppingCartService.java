package com.example.security.service.ecommerce;

import java.util.List;

import com.example.security.dto.ecommerce.ShoppingCartInsertResponse;
import com.example.security.dto.ecommerce.ShoppingCartResponse;
import com.example.security.entity.ecommerce.ShoppingCart;
import com.example.security.entity.ecommerce.ShoppingCartPK;

public interface ShoppingCartService {
	
	ShoppingCart findById(ShoppingCartPK shoppingCartPK);
	
	List<ShoppingCartResponse> findByMemberId(Integer memberId);
	
	ShoppingCartInsertResponse insert(ShoppingCart cart);
}
