package com.joy.demo.controller.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joy.demo.dto.maria.code.codeReqDto;
import com.joy.demo.svc.code.codeSvc;

@Controller
@RequestMapping("/code/*")
public class CodeController {

	
	@Autowired
	codeSvc codesvc;
	
	@GetMapping("codelist")
	public String codeList(Model model) {
		codeReqDto codereqdto = new codeReqDto();
		codereqdto.setCodedepth(1);
		model.addAttribute("group1" , codesvc.selectCodeByDetpth(codereqdto));
		
		return "code/codelist";
	}

	
	@GetMapping("codeForm")
	public String codeForm(@ModelAttribute("codeReqDto") codeReqDto codeReqDto, ModelMap model  ) {
		
		System.out.println("#####jo");
		model.addAttribute("codeReqDto", codeReqDto);
		return "code/codeformpop";
	}
	
	
	
	
	@GetMapping("codeView")
	public String codeView() {
		
		return "code/codeView";
	}
}
