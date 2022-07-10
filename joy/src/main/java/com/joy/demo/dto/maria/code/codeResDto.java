package com.joy.demo.dto.maria.code;

import java.time.LocalDateTime;

import com.joy.demo.entity.maria.codeEntity;

import lombok.Getter;

@Getter
public class codeResDto {

	
	private Integer codeid;	
	private String codecd;
	private String codename;
	private String upcodeid;
	private LocalDateTime reg_dt;
	private String reg_id;
	private String delyn;
	private String useyn;
	private Integer codedepth;
	

	public codeResDto(codeEntity entity) {
		
		this.codeid = entity.getCodeid();
		this.codecd = entity.getCodecd();
		this.codename = entity.getCodename();
		this.upcodeid = entity.getUpcodeid();
		this.reg_dt = entity.getReg_dt();
		this.reg_id = entity.getReg_id();
		this.delyn = entity.getDelyn();
		this.useyn = entity.getUseyn();
		this.codedepth = entity.getCodedepth();
	}
	
	
	@Override
	public String toString() {
		return "codeResDto [codeid ="+ codeid+"codecd=" + codecd + ", codename=" + codename + ", upcodeid=" + upcodeid + ", reg_dt="
				+ reg_dt + ", reg_id=" + reg_id +  ", delyn=" + delyn + ", useyn=" + useyn +  ", codedepth=" + codedepth +"]";
	}

	
	
}
