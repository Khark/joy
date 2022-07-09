package com.joy.demo.entity.maria;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name="codemanage")
@NoArgsConstructor
public class codeEntity {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String codeid;
	
	@Column(length = 100 , nullable = false)
	private String codename;
	
	@Column(length = 100, nullable = false)
	private String upcodeid;
	
	@Column(name = "reg_dt")
	private LocalDateTime reg_dt;

	@Column(length = 100, nullable = false)
	private String reg_id;
	
	
	@Builder
	public codeEntity(String codeid , String codename, String upcodeid, String reg_id) {

		this.codeid = codeid;
		this.codename = codename;
		this.upcodeid = upcodeid;
		this.reg_id = reg_id;
	}


//
//	public static codeEntity builder() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	
}

