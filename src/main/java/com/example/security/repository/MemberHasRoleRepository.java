package com.example.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.entity.MemberHasRole;
import com.example.security.entity.MemberHasRolePK;

public interface MemberHasRoleRepository extends JpaRepository<MemberHasRole, MemberHasRolePK> {

}
