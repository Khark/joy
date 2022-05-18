package com.joy.demo.controller.basicboad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joy.demo.dto.maria.board.boardReqDto;
import com.joy.demo.entity.maria.boardEntity;
import com.joy.demo.svc.basicboard.BasicBoardSvc;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BasicBoardSvc boardsvc;
	
	@GetMapping("boardlist")
	public String boardsList(Model model, @RequestParam(required = false, defaultValue = "0") 
	Integer page, @RequestParam(required = false, defaultValue = "5") Integer size ) throws Exception {
		try {
			
			model.addAttribute("resultMap" , boardsvc.findAll(page, size));
	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "board/boardlist";
	}
	
	@GetMapping("boardinfo")
	public String boardsinfo(@ModelAttribute("boardEntity") @Validated boardEntity boardEntity, Model model) {
		
		return "board/boardinfo";

	}
	
	@GetMapping("boardwrite")
	public String boardswrite(@ModelAttribute("boardReqDto") @Validated boardReqDto boardReqDto, Model model) {

		// modelAttribute 의 내용이 타임리프의 폼과 일치 해야하나봐?
	//	boardEntity.setHits(0);
	//	boardEntity.setDelyn('N');
	//	model.addAttribute("boardEntity", boardEntity);
		System.out.println("####???");
		return "board/boardwrite";

	}
	
	@PostMapping("boardwrite")
	public String boardswritePost(boardReqDto BoardTO, Model model) {
		
		boardsvc.save(BoardTO);
		return "board/boardinfo";
		
	}
	
}

