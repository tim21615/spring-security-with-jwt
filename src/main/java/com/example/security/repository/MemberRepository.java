package com.example.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	Optional<Member> findByEmail(String email);
}
