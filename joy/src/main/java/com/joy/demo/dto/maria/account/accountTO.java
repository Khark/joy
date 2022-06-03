package com.joy.demo.dto.maria.account;

import java.time.LocalDateTime;

import com.joy.demo.entity.maria.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class accountTO {

	private Integer id;
	private String name;
	private String account;
	private String password;
	private LocalDateTime lastAccessDt;
	private LocalDateTime regDt;
	
	public account toEntity() {
		return new account(id, name, account, password);
	}
}
