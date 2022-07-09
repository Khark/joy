package com.joy.demo.svc.code;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.joy.demo.dto.maria.code.codeReqDto;
import com.joy.demo.dto.maria.code.codeResDto;
import com.joy.demo.repository.maria.code.CodeRepository;

public class codeSvcImpl implements codeSvc {

	@Autowired
	CodeRepository codeRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public String save(codeReqDto codereqdto) {
		// TODO Auto-generated method stub
		
		
		codeRepository.save(codereqdto.toEntity()) ; 
		return null;
	}

	@Override
	public List<codeResDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public codeResDto findById(String codeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCode(codeReqDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String codeid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, Object> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

}
