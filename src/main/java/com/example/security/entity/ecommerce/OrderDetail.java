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
@Table(name = "order_detail")
@IdClass(value = OrderDetailPK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "order_id")
	private Integer orderId;
	
	@Id
	@Column(name= "product_id")
	private Integer productId;
	
	@Column(name= "quantity")
	private Integer quantity;
	
	@Column(name= "detail_amount")
	private Integer detailAmount;
	
}
