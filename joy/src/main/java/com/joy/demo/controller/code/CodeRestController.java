package com.joy.demo.controller.code;

import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("code/rest/*")
public class CodeRestController {

	
	//public String codeForm(@RequestBody codeReqDto codeto , ModelMap model, Authentication authenticatio)  {
	@PostMapping("codeForm")
	public String codeForm( ModelMap model)  {
		String result = "ProcessSuccess";
		System.out.println("####codeReestofrm");
		return result;
	} 

	

	@GetMapping("codeForm")
	//public String codeForm(@RequestBody codeReqDto codeto , ModelMap model, Authentication authenticatio)  {
	public String codeFormget( ModelMap model)  {
		String result = "ProcessSuccess";
		System.out.println("####codeReestofrm");
		return result;
	} 
}
