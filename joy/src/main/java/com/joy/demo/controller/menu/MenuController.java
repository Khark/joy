package com.joy.demo.controller.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.val;
import lombok.var;

@Controller
public class MenuController {

	@PostMapping("/new")
	public String newUser() {
		
		// var val 키워드이용시 변수타입을 명시하지않고 표현식에서 타입을 추론할 수 있다.
		// val 에는 final 키워드가 자동 적용 
		
		var input = 3;
		val input2 = "FF";
		
		
		
		return "";
	}
}
