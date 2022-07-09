package com.joy.demo.entity.maria;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name="codemanage")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class codeEntity {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer codeid;
	
	@Column(length = 50, nullable = false)
	private String codecd;
	
	@Column(length = 100 , nullable = false)
	private String codename;
	
	@Column(length = 100, nullable = false)
	private String upcodeid;
	
	@Column(name = "reg_dt")
	private LocalDateTime reg_dt;

	@Column(length = 100, nullable = false)
	private String reg_id;
	
	@Column(length = 4)
	private String delyn;
	
	@Column(length = 4)
	private String useyn;
	
	@Builder
	public codeEntity(String codecd, String codename, String upcodeid,String  reg_id, String delyn, String useyn) {
		this.codecd = codecd;
		this.codename = codename;
		this.upcodeid = upcodeid;
		this.reg_id = reg_id;
		this.delyn = delyn;
		this.useyn = useyn;
	}
	
}

