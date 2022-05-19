package com.joy.demo.dto.maria.board;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.joy.demo.entity.maria.boardEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

//@SequenceGenerator(name = "board_seq_gen", // 시퀀스 제너레이터 이름
//sequenceName = "board_seq", // 시퀀스 이름
//initialValue = 1, // 시작값
//allocationSize = 1 // 메모리를 통해 할당할 범위 사이즈
//)

public class boardReqDto {
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
//	generator = "board_seq_gen" // 식별자 생성기를 설정해놓은 USER_SEQ_GEN으로 설정
//)
	private Long id;
	private String title;
	private String content;
	private String writer;
	private Integer hits;
	private char delyn;
	private LocalDateTime createDate = LocalDateTime.now();
	private LocalDateTime modifedDate ;
	
	
	public boardEntity toEntity() {
		return boardEntity.builder()
				.title(title)
				.content(content)
				.writer(writer)
				.build();
	}
}
