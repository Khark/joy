package com.joy.demo.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joy.demo.entity.maria.memberEntity;
import com.joy.demo.entity.maria.tokenEntity;
import com.joy.demo.svc.account.accountSvc;
import com.joy.demo.svc.member.MemberSvc;

@Controller
@RequestMapping("/member/*")

public class MemberController {
	
	@Autowired
	MemberSvc membersvc;
	@Value("${user.kakaokey}")
	private String kakaokey;
	@Autowired 
	accountSvc accountsvc;
	
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

		model.addAttribute("kakaokey", kakaokey);
		
		model.addAttribute("REDIRECT_URI", "http://localhost:8081/member/kakao_login");
		model.addAttribute("code", "code");
//		<!-- <a th:href="@{https://kauth.kakao.com/oauth/authorize(client_id = ${kakaokey), redirect_uri=${REDIRECT_URI} , response_type=${code }">회원가입 </a>
//		 -->
		String redirecturi = "http://localhost:8081/member/kakao_login";
		
		String uri = "https://kauth.kakao.com/oauth/authorize?client_id="+kakaokey+"&redirect_uri="+redirecturi+"&response_type=code";
		return "redirect:"+uri;
	}
	@GetMapping("kakao_login")
	public String getKakaoAccessToken(@RequestParam String code, @ModelAttribute("MemberTO") @Validated memberEntity memberto ,Model model, HttpServletRequest request){
		tokenEntity tokento = membersvc.OAuthgetKakaoAccessToken(code);
		tokenEntity tokento2 = new tokenEntity();
		String result = "";
		

		if(tokento != null && tokento.getAccess_code() == 200) {
			tokento2 = membersvc.accessUser(tokento);
		}else {
			return "joy/main";
		}
		HttpSession session = request.getSession();    

		if(tokento != null && tokento.getAccess_code() != null && tokento2 != null) {
			
			if(tokento2.getResult().equals("new")) {
				//session.setAttribute("access_token", tokento.getToken() );
				session.setAttribute("memberid", tokento2.getMemberid());
				return "member/writeForm";
			}else {
				memberEntity to = membersvc.readUser(tokento2);
				session.setAttribute("access_token", tokento2.getToken() );
				session.setAttribute("memberid", to.getMemberid());
				session.setAttribute("memberlevel", to.getMemberlevel());
				return "joy/main";
			}
			
		}
		
		else {
			return "joy/main";
		}
	}
	
	@PostMapping("membersSave")
	public String membersSave(@ModelAttribute("MemberTO") @Validated memberEntity memberto ,Model model, HttpServletRequest request) {
		
		String retUrl= "";
		memberEntity vo = membersvc.createUser(memberto);
		if(vo.getResult().equals("present")) {
			//이미 가입한 회원인 경우임 
			retUrl="joy/kakao_login";
		}else if(vo.getResult().equals("ProcessSucess")) {
			retUrl ="member/memberjoin";
		}
		
		return retUrl;
	}
	
	@PostMapping("logout")
	public String logout(HttpSession session ){
		session.invalidate();
		// securityConfig 에서 호출 되며 session해
		
		return "joy/main";
	}
	
	@GetMapping("list")
	public String memberlist(Model model, @RequestParam(required = false, defaultValue = "0") 
	Integer page, @RequestParam(required = false, defaultValue = "5") Integer size ) throws Exception {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userdetail = (UserDetails) authentication.getPrincipal();
			System.out.println("##authorities?"+userdetail.getAuthorities());
			
			model.addAttribute("resultMap" , accountsvc.findAll(page, size));
	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "member/memberlist";
	}
	
}
