package com.joy.demo.dto.maria.account;

import java.time.LocalDateTime;

import com.joy.demo.entity.maria.account;

import lombok.Getter;

@Getter
public class accountResDto {

	private Integer id;
	private String name;
	private String account;
	private String password;
	private LocalDateTime lastAccessDt;
	private LocalDateTime regDt;
	private Integer role;
	

	public accountResDto(account entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
		this.account = entity.getAccount();
		this.password = entity.getPassword();
		this.lastAccessDt = entity.getLastAccessDt();
		this.regDt = entity.getRegDt();
		this.role = entity.getRole();
	}


	@Override
	public String toString() {
		return "accountResDto [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password
				+ ", lastAccessDt=" + lastAccessDt + ", regDt=" + regDt + ", role=" + role + "]";
	}
	
	
}