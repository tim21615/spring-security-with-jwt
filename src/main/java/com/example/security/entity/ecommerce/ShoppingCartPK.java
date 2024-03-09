package com.example.security.entity.ecommerce;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name= "member_id")
	private Integer memberId;
	
	@Column(name= "product_id")
	private Integer productId;
}
