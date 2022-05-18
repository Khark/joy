package com.joy.demo.dto.maria.board;

import java.time.LocalDateTime;

import com.joy.demo.entity.maria.boardEntity;
import com.joy.demo.repository.maria.board.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class boardReqDto {
	
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
