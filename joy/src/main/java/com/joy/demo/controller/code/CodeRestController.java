package com.joy.demo.controller.code;

import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joy.demo.dto.maria.code.codeReqDto;

@RestController
@RequestMapping("code/rest/*")
public class CodeRestController {

	@PostMapping("codeForm")
	public String codeForm( codeReqDto codeto , ModelMap model, Authentication authenticatio)  {
		String result = "";
	System.out.println("####codeReestofrm");
		return result;
	} 
	
}
