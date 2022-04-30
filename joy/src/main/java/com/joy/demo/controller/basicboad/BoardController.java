package com.joy.demo.controller.basicboad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joy.demo.entity.maria.boardEntity;
import com.joy.demo.svc.basicboard.BasicBoardSvc;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BasicBoardSvc boardsvc;
	
	@GetMapping("boardslist")
	public String boardsList(@ModelAttribute("BoardTO") @Validated boardEntity BoardTO, Model model) {
		
		return "board/boardslist";
	}
	
	@GetMapping("boardsinfo")
	public String boardsinfo(@ModelAttribute("BoardTO") @Validated boardEntity BoardTO, Model model) {
		
		return "board/boardsinfo";

	}
	
	@GetMapping("boardswirte")
	public String boardswrite(@ModelAttribute("BoardTO") @Validated boardEntity BoardTO, Model model) {
		
		return "board/boardswirte";

	}
	
	@PostMapping("boardswirte")
	public String boardswritePost(@ModelAttribute("BoardTO") @Validated boardEntity BoardTO, Model model) {
		
		
		return "board/boardsinfo";
		
	}
	
}

