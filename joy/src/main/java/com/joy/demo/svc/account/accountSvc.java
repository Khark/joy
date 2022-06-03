package com.joy.demo.svc.account;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.joy.demo.dto.maria.account.accountTO;

public interface accountSvc extends UserDetailsService {

	Integer save(accountTO accountto);
}
