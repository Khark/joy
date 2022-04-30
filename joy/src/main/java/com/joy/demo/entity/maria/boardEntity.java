package com.joy.demo.entity.maria;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@SequenceGenerator(name = "BOARD_SEQ_GEN", // 시퀀스 제너레이터 이름
sequenceName = "BOARD_SEQ", // 시퀀스 이름
initialValue = 1, // 시작값
allocationSize = 1 // 메모리를 통해 할당할 범위 사이즈
)
@Table(name="boardtable")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="boardtable")
public class boardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
	generator = "BOARD_SEQ_GEN" // 식별자 생성기를 설정해놓은 USER_SEQ_GEN으로 설정
)
	private Long id;

	
	private String title;
	private String content;
	private String writer;
	private int hits;
	private char delyn;
	
	private LocalDateTime createDate = LocalDateTime.now();
	private LocalDateTime modifedDate ;
	
    @Builder
    public boardEntity(String title, String content, String writer, int hits, char deleteYn) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.delyn = deleteYn;
    }
}
