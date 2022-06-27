package com.joy.demo.entity.maria;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="menutable")

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class menuEntity {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	private String menutitle;
	private LocalDateTime createdate = LocalDateTime.now();
	private Integer hits;
	private char delyn;
	private LocalDateTime modifieddate ;
	private String menuexplan;
	private String writer;

	
	
	//builder 자동완성은 source > Generate Constructor useing fields 를 사용 
	
	@Builder
	public menuEntity(String menutitle, Integer hits, String menuexplan, String writer) {
	//	super();자동완성되는 super 는 블럭 해주기 
		this.menutitle = menutitle;
		this.hits = hits;
		this.menuexplan = menuexplan;
		this.writer = writer;
		this.delyn = 'N';
	}
	
	
}
