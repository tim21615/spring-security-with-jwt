package com.example.security.dto.ecommerce;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer memberId;
	
	private Integer productId;
	
	private String productName;
	
	private Integer productPrice;
	
	private Integer stock;
	
	private Integer quantity;
	
	private Boolean available;
	
	private byte[] productPicture;
	
	

}
