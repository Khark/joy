package com.joy.demo.entity.maria;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class accountEntity {

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
	
	@Column(length =11 , nullable = false)
	private Integer role;
	
	@Column(name="groupid" )
	private Integer groupid;
	
	@Builder
	public accountEntity(String name , String account, String password, Integer role, Integer groupid) {

		this.name = name;
		this.account = account;
		this.password = password;
		this.role = role;
		this.groupid = groupid;
	}
}
