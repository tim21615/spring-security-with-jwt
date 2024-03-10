package com.example.security.dto.ecommerce;

import java.io.Serializable;

import com.example.security.entity.ecommerce.ShoppingCart;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartInsertResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("Cart")
	private ShoppingCart cart;

}
