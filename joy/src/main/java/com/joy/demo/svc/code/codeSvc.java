package com.joy.demo.svc.code;

import java.util.HashMap;
import java.util.List;

import com.joy.demo.dto.maria.board.boardReqDto;
import com.joy.demo.dto.maria.board.boardResDto;
import com.joy.demo.dto.maria.code.codeReqDto;
import com.joy.demo.dto.maria.code.codeResDto;

public interface codeSvc {

	
	String save (codeReqDto codereqdto);
	public List<codeResDto> findAll();
	public codeResDto findById(Integer codeid);
	public int updateCode(codeReqDto dto);
	public void deleteById(Integer codeid);
	HashMap<String , Object> findAll(Integer page, Integer size);
	
	
	public List<codeResDto> selectCodeByDetpth(codeReqDto codereqdto);
	
}
