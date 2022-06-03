package com.joy.demo.repository.maria.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joy.demo.entity.maria.account;

public interface accountRepository extends JpaRepository<account, Integer > {

	Optional<account> findByAccount(String account);
	
	
}
