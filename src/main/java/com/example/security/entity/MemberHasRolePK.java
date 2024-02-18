package com.example.security.entity;

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
public class MemberHasRolePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name= "member_id")
	private Integer memberId;
	
	@Column(name= "role_id")
	private Integer roleId;
}
