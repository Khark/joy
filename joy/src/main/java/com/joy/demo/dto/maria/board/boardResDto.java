package com.joy.demo.dto.maria.board;

import java.time.LocalDateTime;

import com.joy.demo.entity.maria.boardEntity;
import com.joy.demo.repository.maria.board.Board;

import lombok.Getter;

@Getter
//vo같은 개념인듯..
public class boardResDto {


	private Long id;
	private String title;
	private String content;
	private String writer;
	private Integer hits;
	private char delyn;
	private LocalDateTime createDate = LocalDateTime.now();
	private LocalDateTime modifedDate ;
	
	public boardResDto(boardEntity entity) {
		// 객체를  스트림 맵 하기위해 엔티티의 생성자를 받아오으는ㄷㅅ 
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.hits = entity.getHits();
		this.delyn = entity.getDelyn();
		this.createDate = entity.getCreatedate();
		this.modifedDate = entity.getModifieddate();
	}

	@Override
	public String toString() {
		return "boardResDto [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer + ", hits="
				+ hits + ", delyn=" + delyn + ", createDate=" + createDate + ", modifedDate=" + modifedDate + "]";
	}

	
}
