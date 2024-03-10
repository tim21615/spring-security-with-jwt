package com.example.security.service.ecommerce.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.dto.ecommerce.ShoppingCartInsertResponse;
import com.example.security.dto.ecommerce.ShoppingCartResponse;
import com.example.security.entity.ecommerce.Product;
import com.example.security.entity.ecommerce.ShoppingCart;
import com.example.security.entity.ecommerce.ShoppingCartPK;
import com.example.security.repository.ecommerce.ProductRepository;
import com.example.security.repository.ecommerce.ShoppingCartRepository;
import com.example.security.service.ecommerce.ShoppingCartService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ObjectMapper mapper;

	@Override
	public ShoppingCart findById(ShoppingCartPK shoppingCartPK) {

		ShoppingCart cart = shoppingCartRepository.findById(shoppingCartPK).orElse(null);
		return cart;
	}

	@Override
	public List<ShoppingCartResponse> findByMemberId(Integer memberId) {

		List<ShoppingCartResponse> list = shoppingCartRepository.findByMemberId(memberId).stream().map(cart -> {
			Product product = productRepository.findById(cart.getProductId()).orElse(null);
			ShoppingCartResponse cartResponse = mapper.convertValue(product, ShoppingCartResponse.class);
			cartResponse.setMemberId(memberId);
			cartResponse.setQuantity(cart.getQuantity());
			if (cartResponse.getQuantity() > cartResponse.getStock()) {
				cartResponse.setQuantity(cartResponse.getStock());
			}

			return cartResponse;
		}).filter(cartResponse -> cartResponse.getAvailable() == true && cartResponse.getStock() > 0)
				.collect(Collectors.toList());

		return list;
	}

	@Override
	public ShoppingCartInsertResponse insert(ShoppingCart cart) {

		ShoppingCart entity = shoppingCartRepository.save(cart);
		return new ShoppingCartInsertResponse("success", entity);
	}
}
