package com.joy.demo.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joy.demo.svc.member.MemberSvc;

@Controller
@RequestMapping("/member/*")

public class MemberController {
	
	@Autowired
	MemberSvc membersvc;
	@Value("${user.kakaokey}")
	private String kakaokey;
	
	@GetMapping("memberdummyview")
	public String memberdummyview() {
		Long memberid = (long) 4;
		membersvc.selectMember(memberid);
		return "member/memberdummyview";
	}

	@GetMapping("memberjoin")
	public String kakaoLogin(Model model) {
		model.addAttribute("kakaokey", kakaokey);
		System.out.println("##kakaokey?"+kakaokey);
		return "member/memberjoin";
	}
}
