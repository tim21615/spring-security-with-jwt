package com.example.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.security.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query(value="select member_has_role.role_id, role.role_name from member_has_role inner join role on member_has_role.role_id = role.role_id where member_id = ?1", nativeQuery = true)
	List<Role> findRoleByMemberId(Integer memberId);
}
