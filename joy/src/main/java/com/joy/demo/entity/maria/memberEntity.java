package com.joy.demo.entity.maria;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "membertable")
@Getter
@Setter

@SequenceGenerator(name = "MEMBER_SEQ_GEN", // 시퀀스 제너레이터 이름
		sequenceName = "MEMBER_SEQ", // 시퀀스 이름
		initialValue = 1, // 시작값
		allocationSize = 1 // 메모리를 통해 할당할 범위 사이즈
)

public class memberEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
			generator = "MEMBER_SEQ_GEN" // 식별자 생성기를 설정해놓은 USER_SEQ_GEN으로 설정
	)
	private Long memberno;

	@Id
	private String memberid;

	private String email;

	private String createdate;

	private String lastlogindate;
}