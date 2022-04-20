package com.joy.demo.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@TypeAlias("drink")
@Document(collection = "drink")
public class drinkEntity {

	@Id
	private String _id;
	
	private String type;
	private String nowstate;
	private String nowdate;
	
}
