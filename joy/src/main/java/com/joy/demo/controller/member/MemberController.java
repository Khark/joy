package com.joy.demo.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joy.demo.advice.SessionConstants;
import com.joy.demo.entity.maria.memberEntity;
import com.joy.demo.entity.maria.tokenEntity;
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
	public String getKakaoAccessToken(@RequestParam String code, Model model, HttpServletRequest request){
		tokenEntity tokento = membersvc.OAuthgetKakaoAccessToken(code);
		String result = "";
		memberEntity to = new memberEntity();
		
		
		if(tokento != null && tokento.getAccess_code() == 200) {
			tokento = new tokenEntity();
			tokento = membersvc.accessUser(tokento);
		}else {
			//result ="fail";
			return "joy/main";
		}
		
		
		if(tokento != null && tokento.getAccess_code() != null) {
			
			to = membersvc.CR_User(tokento);
			
			
		}else {
			return "joy/main";
		}
		
		if(to.getResult().equals("new") || to.getResult().equals("new2") ) {
			HttpSession session = request.getSession();                         // 세R션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
		   // session.setAttribute(SessionConstants.LOGIN_MEMBER, to);   
			
			session.setAttribute("access_token", tokento.getToken() );
		    model.addAttribute("to", to);
			return "member/writeForm";

		}else if(to.getResult().equals("present")) {
			return "joy/list_Form";

		}else {
			return "member/kakaoJoin";

		}
		
	}
	
	@PostMapping("logout")
	public String logout(HttpSession session ){
		
		
		
		return "joy/main";
	}
	
	
}
