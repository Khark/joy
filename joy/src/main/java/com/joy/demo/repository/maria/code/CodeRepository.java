package com.joy.demo.repository.maria.code;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.joy.demo.dto.maria.code.codeResDto;
import com.joy.demo.entity.maria.codeEntity;

public interface CodeRepository extends JpaRepository<codeEntity, Integer>, JpaSpecificationExecutor<codeEntity> {
 
	
	
	
}
