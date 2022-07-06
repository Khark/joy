package com.joy.demo.repository.maria.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joy.demo.entity.maria.accountEntity;

public interface accountRepository extends JpaRepository<accountEntity, Integer > {

	Optional<accountEntity> findByAccount(String account);
	
	
}
