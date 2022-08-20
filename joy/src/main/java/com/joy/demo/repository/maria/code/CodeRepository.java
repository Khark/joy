package com.joy.demo.repository.maria.code;

import java.util.ArrayList;
import java.util.List;

//import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.joy.demo.dto.maria.code.codeReqDto;
import com.joy.demo.dto.maria.code.codeResDto;
import com.joy.demo.entity.maria.codeEntity;

public interface CodeRepository extends JpaRepository<codeEntity, Integer>, JpaSpecificationExecutor<codeEntity> {
	

	
	//public static List<codeEntity> selectCodeList(EntityManager em, codeReqDto to) {
	public static void selectCodeList(EntityManager em, codeReqDto to) {

	//TypedQuery<codeEntity> query= em.createQuery(LIST_CODE , codeEntity.class); 
	//	String query =;
		StringBuffer querystiring = new StringBuffer( "SELECT m FROM CODEMANAGE m WHERE m.codedepth = ?1") ;
		if(to.getUpcodeid() != null ) {
			querystiring.append("AND UPCODEID = ?2");
		}
//	
//		Query q1 = em.createQuery(querystiring.toString(), codeResDto.class).setParameter(1, to.getCodedepth());
//		List<codeResDto > q1result= q1.getResultList();
//		for(int j = 0 ; j <q1result.size() ; j ++) {
//			System.out.println("##wtf?"+q1result.get(j).getCodename());
//		}
//		
//		TypedQuery<codeEntity> queryresult = 
//				em.createQuery(querystiring.toString(), codeEntity.class )
//				.setParameter(1, to.getCodedepth());
//				
//		queryresult.getResultList();
				
//				;
//		List<codeEntity> list = queryresult.getResultList();
//		
//		codeReqDto vo = new codeReqDto();
//		List<codeReqDto> resultlist = new ArrayList<codeReqDto>();
//		if(list != null && list.size() > 0 ) {
//			for(int i = 0 ; i < list.size(); i ++) {
//				vo = new codeReqDto();
//				vo.setCodename( list.get(i).getCodename());
//				vo.setUpcodeid( list.get(i).getUpcodeid());
//				vo.setCodecd( list.get(i).getCodecd());
//				vo.setCodedepth(list.get(i).getCodedepth());
//				resultlist.add(vo);
//			}
//		}
		
		//return queryresult.getResultList();
	}

}
