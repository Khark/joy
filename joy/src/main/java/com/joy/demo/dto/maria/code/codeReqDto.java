package com.joy.demo.dto.maria.code;

import java.time.LocalDateTime;

import com.joy.demo.entity.maria.codeEntity;
import com.joy.demo.entity.maria.codeEntity.codeEntityBuilder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class codeReqDto {

	
	private String codeid;
	private String codename;
	private String upcodeid;
	private LocalDateTime reg_dt = LocalDateTime.now();
	private String reg_id;
	
	
	public codeEntityBuilder toEntity() {
		return codeEntity.builder()
				.codeid(codeid)
				.codename(codename)
				.upcodeid(upcodeid)
				.reg_id(reg_id)
				;
	}
	
	
	
	
}
