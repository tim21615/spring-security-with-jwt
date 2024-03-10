package com.example.security.dto.ecommerce;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberIdReq implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer memberId;

}
