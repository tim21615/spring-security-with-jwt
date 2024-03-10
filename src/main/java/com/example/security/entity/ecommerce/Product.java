package com.example.security.entity.ecommerce;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "product_id")
	private Integer productId;
	
	@Column(name= "product_name")
	private String productName;
	
	@Column(name= "product_type_id")
	private Integer productTypeId;
	
	@Column(name= "product_price")
	private Integer productPrice;
	
	@Column(name= "stock")
	private Integer stock;
	
	@Column(name= "available")
	private Boolean available;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name= "product_picture")
	private byte[] productPicture;
}
