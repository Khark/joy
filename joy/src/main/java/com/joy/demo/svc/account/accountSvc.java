package com.joy.demo.svc.account;

import java.util.HashMap;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.joy.demo.dto.maria.account.accountReqDto;

public interface accountSvc extends UserDetailsService {

	Integer save(accountReqDto accountto);
	HashMap<String, Object> findAll(Integer page, Integer size);
}
