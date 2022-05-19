package com.joy.demo.entity.maria;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// @Table(name="boardtable")
@Entity(name="boardtable") // entity <-> jpa <-> db.tables 테이블 명과 Class 명이 다른 경우에 entity 어노테이션을 사용한다 

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@SequenceGenerator(name = "board_seq_gen", // 시퀀스 제너레이터 이름
//sequenceName = "board_seq", // 시퀀스 이름
//initialValue = 1, // 시작값
//allocationSize = 1 // 메모리를 통해 할당할 범위 사이즈
//)
public class boardEntity {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
//	generator = "board_seq_gen" // 식별자 생성기를 설정해놓은 USER_SEQ_GEN으로 설정
//)
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	
	private String title;
	private String content;
	private String writer;
	private Integer hits;
	private char delyn;
	private LocalDateTime createdate = LocalDateTime.now();
	private LocalDateTime modifieddate ;
	
    @Builder
    public boardEntity(String title, String content, String writer, Integer hits) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = 0;
        this.delyn = 'N';
    }
}
