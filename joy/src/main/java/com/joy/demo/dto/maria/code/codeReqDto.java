package com.joy.demo.dto.maria.code;

import java.time.LocalDateTime;

import com.joy.demo.entity.maria.codeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class codeReqDto {

	
	private Integer codeid;	
	private String codecd;
	private String codename;
	private String upcodeid;
	private String reg_id;
	private String delyn;
	private String useyn;
	private LocalDateTime reg_dt = LocalDateTime.now();
	private Integer codedepth;
	
	public codeEntity toEntity() {
		
		return codeEntity.builder()
				.codecd(codecd)
				.codename(codename)
				.upcodeid(upcodeid)
				.reg_id(reg_id)
				.delyn(delyn)
				.useyn(useyn)
				.codedepth(codedepth)
				.build();
		
		//끝에 build() 를 넣어줘야 하는 것 잊지말것..!
	}
	
	
	
}
