package com.joy.demo.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joy.demo.dto.maria.account.accountTO;
import com.joy.demo.svc.account.accountSvc;

@Controller
@RequestMapping(path = "/")
public class MainContoller {

	@Autowired
	private accountSvc accountsvc;

	@GetMapping("/home")
	public String homeView() {
		return "main/home";
	}

	@GetMapping("/login")
	public String loginView() {
		return "main/login";
	}

	@GetMapping("/signup")
	public String signupView() {
		return "main/signup";
	}

	@PostMapping("/signup")
	public String signup(accountTO accountto) {
		accountsvc.save(accountto);
		return "redirect:/login";
	}

	@PreAuthorize("hasRole('ROLE_MEMBER')")
	@GetMapping("/member/info")
	public String userInfoView() {
		return "main/user_info";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String adminView() {
		return "main/admin";
	}

	@GetMapping("/denied")
	public String deniedView() {
		return "main/denied";
	}

}
