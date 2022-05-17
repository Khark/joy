package com.joy.demo.svc.basicboard;

import java.util.HashMap;
import java.util.List;

import com.joy.demo.dto.maria.board.boardReqDto;
import com.joy.demo.dto.maria.board.boardResDto;

public interface BasicBoardSvc {

	void save();
	List<boardReqDto> findAll();
	void delete();
	
	Long save(boardReqDto dto);
	HashMap<String , Object> findList(Integer page, Integer size);
	Long modify(boardReqDto dto);
	boardResDto findById(Long id);
	void deleteById(Long id);
}
