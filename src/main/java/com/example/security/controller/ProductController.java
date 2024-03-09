package com.example.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.dto.ecommerce.ProductDTO;
import com.example.security.service.ecommerce.ProductService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public List<ProductDTO> getAllAvailableProduct() {

		return productService.getAllAvailableProduct();
	}

	@GetMapping(value ="/products" ,params = "query")
	public List<ProductDTO> getAllAvailableProduct(@RequestParam("query")String query) {

		return productService.getAllAvailableProduct(query);
	}
}
