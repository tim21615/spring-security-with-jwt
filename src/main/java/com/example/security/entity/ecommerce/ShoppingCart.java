package com.example.security.entity.ecommerce;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shopping_cart")
@IdClass(value = ShoppingCartPK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "member_id")
	private Integer memberId;
	
	@Id
	@Column(name= "product_id")
	private Integer productId;
	
	@Column(name= "quantity")
	private Integer quantity;
	
	
	
}
