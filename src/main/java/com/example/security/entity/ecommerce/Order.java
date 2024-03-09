package com.example.security.entity.ecommerce;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "order_id")
	private Integer orderId;
	
	@Column(name= "member_id")
	private Integer memberId;
	
	@Column(name= "total_amount")
	private Integer totalAmount;
	
	@Column(name= "order_time")
	private Timestamp orderTime;

	@Column(name= "name")
	private String name;
	
	@Column(name= "mobile")
	private String mobile;
	
	@Column(name= "address")
	private String address;
	
	
	

}
