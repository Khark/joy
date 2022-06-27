package com.joy.demo.dto.maria.menu;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.joy.demo.entity.maria.menuEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class menuReqDto {


	@Id
	private Long id;
	
	private String menutitle;
	private LocalDateTime createdate = LocalDateTime.now();
	private Integer hits;
	private char delyn;
	private LocalDateTime modifieddate ;
	private String menuexplan;
	private String writer;
	
	public menuEntity toEntity() {
		return menuEntity.builder()
				.menutitle(menutitle)
				.menuexplan(menuexplan)
				.writer(writer)
				.build();
	}
}
