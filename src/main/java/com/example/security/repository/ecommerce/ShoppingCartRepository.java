package com.example.security.repository.ecommerce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.entity.ecommerce.ShoppingCart;
import com.example.security.entity.ecommerce.ShoppingCartPK;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartPK> {
	List<ShoppingCart> findByMemberId(Integer memberId);
}
