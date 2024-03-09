package com.example.security.repository.ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.entity.ecommerce.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
	
}
