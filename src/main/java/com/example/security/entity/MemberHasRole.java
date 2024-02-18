package com.example.security.entity;

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
@Table(name = "member_has_role")
@IdClass(value = MemberHasRolePK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberHasRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "member_id")
	private Integer memberId;
	
	@Id
	@Column(name= "role_id")
	private Integer roleId;
	
}
