package com.joy.demo.entity.maria;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="USER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class userEntity {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	
	private Long userid;
	
	private String username;
	private String userpw;
	private LocalDateTime createdate = LocalDateTime.now();
	private String delyn;
	private Integer role;
	
	@Builder
	public userEntity(String username, String userpw, String delyn, Integer role) {
		
	}

	
}
