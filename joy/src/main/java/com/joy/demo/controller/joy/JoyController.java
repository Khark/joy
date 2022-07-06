
package com.joy.demo.controller.joy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joy.demo.entity.mongo.joyEntity;
import com.joy.demo.svc.joy.JoySvc;

@Controller
@RequestMapping("/joy/*")
public class JoyController {
	
	@Autowired
	JoySvc joysvc;
	
	@GetMapping("main")
	 public String main(Model model){
		
		return "joy/main";
		//return "/index";
   }


	@GetMapping("writeForm")
	public String writeForm(@ModelAttribute("JoyTO") @Validated joyEntity joyto, Model model) {

		return "joy/writeForm";
	}
	
	@PostMapping("writeForm")
	public String writeFormPOST(@ModelAttribute("JoyTO") @Validated joyEntity joyto, Model model) {
		String result="";

		if(joysvc.insertEvent(joyto).equals("")) {
			
		}else {
			
		}
		
		
		return "redirect:./listForm";
	}
	
	@GetMapping("view")
	public String viewForm( Model model , joyEntity joyvo, HttpServletRequest request  ) {

		joyvo.set_id(request.getParameter("_id"));
		model.addAttribute("joy", joysvc.selectJoy(joyvo));
		return "joy/viewForm";
	}
	
	@GetMapping("listForm")
	public String listForm(@ModelAttribute("JoyTO") @Validated joyEntity joyto, Model model) {
		System.out.println("#listForm GET>?");

		//List<joyEntity> joyvo = new ArrayList<joyEntity>();
		//joyvo = joysvc.selectJoyList(joyto);
		//model.addAttribute("list", joyvo);
		HashMap<String , Object> resultMap = joysvc.selectdJoyDocList(joyto);
		model.addAttribute("resultMap", resultMap);

		return "joy/listForm";
	}

	
	@PostMapping("listForm")
	public String listFormPost(@ModelAttribute("JoyTO") @Validated joyEntity joyto, Model model) {
		System.out.println("#listForm POST?");
		List<joyEntity> joyvo = new ArrayList<joyEntity>();
		joyvo = joysvc.selectJoyList(joyto);
		model.addAttribute("list", joyvo);
		return "joy/listForm";
	}
	
}
