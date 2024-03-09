package com.example.security.dto.ecommerce;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer productId;
	
	private String productName;
	
	private String productType;
	
	private Integer productPrice;
	
	private Integer stock;
	
	private boolean available;
	
	private byte[] productPicture;
}
