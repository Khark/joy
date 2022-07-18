package com.joy.demo.svc.code;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joy.demo.dto.maria.code.codeReqDto;
import com.joy.demo.dto.maria.code.codeResDto;
import com.joy.demo.entity.maria.codeEntity;
import com.joy.demo.repository.maria.code.CodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class codeSvcImpl implements codeSvc {

	@Autowired
	CodeRepository codeRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public String save(codeReqDto codereqdto) {
		// TODO Auto-generated method stub
		codereqdto.setReg_dt(LocalDateTime.now());
		
		Integer result =  codeRepository.save(codereqdto.toEntity()).getCodeid() ; 
		String result2= "";
		System.out.println("##"+result);
		if(result > 0 ) {
			result2 = "ProcessSuccess";
		}else {
			result2 = "ProcessFail";
		}
		
		return result2;
	}

	@Override
	public List<codeResDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public codeResDto findById(Integer codeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCode(codeReqDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer codeid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, Object> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<codeResDto> selectCodeByDetpth(codeReqDto codereqdto) {
		// TODO Auto-generated method stub
		
		List<codeEntity> list = CodeRepository.selectCodeList(em , codereqdto);
		for(int i = 0 ; i < list.size() ; i ++) {
			System.out.println("###?"+list.get(i).getCodename());
		}
		
		return null;
		
	}

}
