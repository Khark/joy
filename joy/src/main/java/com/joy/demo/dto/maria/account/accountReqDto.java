package com.joy.demo.dto.maria.account;

import java.time.LocalDateTime;

import com.joy.demo.entity.maria.accountEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class accountReqDto {

	private Integer id;
	private String name;
	private String account;
	private String password;
	private LocalDateTime lastAccessDt;
	private LocalDateTime regDt;
	private Integer role;
	private Integer groupid;
	
	public accountEntity toEntity() {
		return accountEntity.builder()
				.name(name)
				.account(account)
				.password(password)
				.role(role)
				.groupid(groupid)
				.build();
	}
}
