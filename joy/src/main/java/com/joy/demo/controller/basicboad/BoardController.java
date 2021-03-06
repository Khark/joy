package com.joy.demo.controller.basicboad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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
	Integer page, @RequestParam(required = false, defaultValue = "10") Integer size ) throws Exception {
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
	public String boardswritePost(boardReqDto BoardTO, ModelMap model, Authentication authentication) {
		try {
		 User user = (User) authentication.getPrincipal();
		 	if(user != null) {
		 	BoardTO.setWriter(user.getUsername());
		 // username 가져오고
			// sessionid 가져오고 
			// authorite 는 롤 가져
			boardsvc.save(BoardTO);
		 	}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		return "redirect:/board/boardlist";
	}

	@GetMapping("view")
	public String getBoardViewPage(ModelMap model, boardReqDto dto) {
		
		try {
			if(dto.getId() != null) {
				model.addAttribute("info" , boardsvc.findById(dto.getId()) );
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "board/boardview";
	}
	
	@GetMapping("modify")
	public String getBoardModifyPage(ModelMap model, boardReqDto dto) {
		
		try {
			if(dto.getId() != null) {
				model.addAttribute("info" , boardsvc.findById(dto.getId()) );
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "board/boardmodify";
	}
	
	@PostMapping("modify")
	public String getBoardModifyPagePOST(ModelMap model, boardReqDto dto) throws Exception{
		
		try {
			int result = boardsvc.updateBoard(dto);
			if(result <1) {
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "redirect:/board/boardlist";
	}
}

