package com.joy.demo.entity.mongo;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@Getter
@Setter
@Document(collection = "lagav")
public class lagavEntity {
	@Id
	private String _id;
	private String createdon;
	
	//@NotEmpty
	private String createyear;
	
	private String serialno;
	private String location;
	private String location_num;
	
	//@NotEmpty
	private String label;
	//@NotEmpty
	private String order;
}
