package com.joy.demo.entity.maria;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity(name="alcholtable")
@Table(name="alcholtable")
@Setter
@Getter


@SequenceGenerator(name = "ALCHOL_SEQ_GEN", // 시퀀스 제너레이터 이름
sequenceName = "ALCHOL_SEQ", // 시퀀스 이름
initialValue = 1, // 시작값
allocationSize = 1 // 메모리를 통해 할당할 범위 사이즈
)


public class alcholEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	private int alcholid;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
			generator = "ALCHOL_SEQ_GEN" // 식별자 생성기를 설정해놓은 USER_SEQ_GEN으로 설정
	)
	
	private int type;
	private String label;
	private Date incomingdate;
	private Date createdate;
	private long memberid;
	private Date lastdate;
	
}






