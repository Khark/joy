package com.joy.demo.controller.basicboad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joy.demo.dto.maria.board.boardReqDto;
import com.joy.demo.entity.maria.boardEntity;
import com.joy.demo.svc.basicboard.BasicBoardSvc;

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
	public String boardsinfo(@ModelAttribute("boardEntity") @Validated boardEntity boardEntity, ModelMap model) {
		
		return "board/boardinfo";

	}
	
	@GetMapping("boardwrite")
	public String boardswrite(@ModelAttribute("boardReqDto") @Validated boardReqDto boardReqDto, ModelMap model) {

		// modelAttribute 의 내용이 타임리프의 폼과 일치 해야하나봐?
	//	boardEntity.setHits(0);
	//	boardEntity.setDelyn('N');
	//	model.addAttribute("boardEntity", boardEntity);
		return "board/boardwrite";
	}
	
	@PostMapping("boardwrite")
	public String boardswritePost(boardReqDto BoardTO, ModelMap model) {
		try {
			boardsvc.save(BoardTO);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		return "board/boardinfo";
	}

	@GetMapping("view")
	public String getBoardViewPage(ModelMap model, boardReqDto req) {
		
		try {
			if(req.getId() != null) {
				model.addAttribute("info" , boardsvc.findById(req.getId()) );
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "board/boardview";
	}
	
	
}

