package com.joy.demo.dto.maria.code;

import java.time.LocalDateTime;

import com.joy.demo.entity.maria.codeEntity;

import lombok.Getter;

@Getter
public class codeResDto {

	private String codeid;
	private String codename;
	private String upcodeid;
	private LocalDateTime reg_dt;
	private String reg_id;
	

	public codeResDto(codeEntity entity) {
		super();
		this.codeid = entity.getCodeid();
		this.codename = entity.getCodename();
		this.upcodeid = entity.getUpcodeid();
		this.reg_dt = entity.getReg_dt();
		this.reg_id = entity.getReg_id();
	}
	
	
	@Override
	public String toString() {
		return "codeResDto [codeid=" + codeid + ", codename=" + codename + ", upcodeid=" + upcodeid + ", reg_dt="
				+ reg_dt + ", reg_id=" + reg_id + "]";
	}

	
	
}
