package com.joy.demo.entity.maria;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
public class account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 255, nullable = false)
	private String name;

	@Column(length = 255, nullable = false, unique = true)
	private String account;

	@Column(length = 255, nullable = false)
	private String password;

	@Column(name = "last_access_dt")
	private LocalDateTime lastAccessDt;

	@Column(name = "reg_dt")
	private LocalDateTime regDt;
	
	public account() {
		
	}

	public account(Integer id , String name , String account, String password) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
	}
}
