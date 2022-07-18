package com.joy.demo.repository.maria.code;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.joy.demo.dto.maria.code.codeReqDto;
import com.joy.demo.entity.maria.codeEntity;

public interface CodeRepository extends JpaRepository<codeEntity, Integer>, JpaSpecificationExecutor<codeEntity> {
	

	
	public static List<codeEntity> selectCodeList(EntityManager em, codeReqDto to) {
		//TypedQuery<codeEntity> query= em.createQuery(LIST_CODE , codeEntity.class); 
	//	String query =;
		StringBuffer query = new StringBuffer( "SELECT m FROM CODEMANAGE m WHERE m.codedepth = ?1") ;
		if(to.getUpcodeid() != null ) {
			query.append("AND UPCODEID = ?2");
		}
		
		
		TypedQuery<codeEntity> queryresult = 
				em.createQuery(query.toString(), codeEntity.class )
				.setParameter(1, to.getCodedepth())
				
				
				;
		List<codeEntity> list = queryresult.getResultList();
		
		return list;
	}

}
