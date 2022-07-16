package com.joy.demo.controller.code;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joy.demo.dto.maria.code.codeReqDto;
import com.joy.demo.svc.code.codeSvc;

@RestController
@RequestMapping("code/rest/*")
public class CodeRestController {

	@Autowired
	public codeSvc codesvc;
	
	@PostMapping("codeForm")
	//public String codeForm( @RequestBody codeReqDto codeto ,HttpServletRequest request)  {
	public String codeForm(codeReqDto codeto ,HttpServletRequest request) throws Exception  {
		//formdata 를 넘겨주는 것은 requeestBody를 사용 하지 않는다.
		
		String result = "ProcessSuccess";
		
		codesvc.save(codeto);
		return result;
	} 
	

}
