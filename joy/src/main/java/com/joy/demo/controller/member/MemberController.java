package com.joy.demo.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
//		model.addAttribute("kakaokey", kakaokey);
//		model.addAttribute("REDIRECT_URI", "http://localhost:8081/member/kakao_login");
//		model.addAttribute("code", "code");
//		System.out.println("##kakaokey?"+kakaokey);
		model.addAttribute("kakaokey", kakaokey);
		String redirecturi = "http://localhost:8081/member/kakao_login";

		model.addAttribute("REDIRECT_URI", "http://localhost:8081/member/kakao_login");
		model.addAttribute("code", "code");
		System.out.println("##kakaokey?"+kakaokey);
		System.out.println("###111");
		String uri = "https://kauth.kakao.com/oauth/authorize?client_id="+kakaokey+"&redirect_uri="+redirecturi+"&response_type=code";
		model.addAttribute("kakaouri", uri);
		System.out.println("##"+uri);
		return "member/memberjoin";
	}
	
	@GetMapping("join")
	public String kakaoJoin(Model model) {
		System.out.println("###122");

		model.addAttribute("kakaokey", kakaokey);
		
		model.addAttribute("REDIRECT_URI", "http://localhost:8081/member/kakao_login");
		model.addAttribute("code", "code");
		System.out.println("##kakaokey?"+kakaokey);
//		<!-- <a th:href="@{https://kauth.kakao.com/oauth/authorize(client_id = ${kakaokey), redirect_uri=${REDIRECT_URI} , response_type=${code }">회원가입 </a>
//		 -->
		String redirecturi = "http://localhost:8081/member/kakao_login";
		
		String uri = "https://kauth.kakao.com/oauth/authorize?client_id="+kakaokey+"&redirect_uri="+redirecturi+"&response_type=code";
		return "redirect:"+uri;
	}
	@GetMapping("kakao_login")
	public String getKakaoAccessToken(@RequestParam String token) {
		
		
		membersvc.OAuthgetKakaoAccessToken(token);
		return "";
	}
}
