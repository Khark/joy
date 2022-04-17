package com.joy.demo.entity.maria;

import com.google.gson.JsonElement;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class tokenEntity {

	
	private String token;
	private Integer access_code;
	private JsonElement element;
	private String result;
	private long memberid;
}
