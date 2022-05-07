package com.joy.demo.repository.maria.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.joy.demo.dto.maria.board.boardReqDto;
import com.joy.demo.entity.maria.boardEntity;
import com.joy.demo.entity.maria.memberEntity;

public interface BoardRepository extends JpaRepository<boardEntity, Long>{

	
	
	String MODIFY_BOARD = "UPDATE BOARDTABLE SET "+
				"TITLE = :#{#boardEntity.title},"+
				"CONTENT = :#{#boardEntity.content},"+
				"MODIFIEDDATE = NOW()"+
				"WHERE ID = :#{#boardEntity.id} ";
	
	@Transactional
	@Modifying
	@Query(value = MODIFY_BOARD, nativeQuery = true)
	public int modifyBoard(@Param("boardEntity") boardEntity boardentity);
	
	


	public static void aa(EntityManager em, String param1) {
		String LIST_BOARD =  "SELECT title, writer, hits FROM boardtable"
				+" WHERE delyn ='N'";
		TypedQuery<boardEntity> query= em.createQuery(LIST_BOARD, boardEntity.class);

		List<boardEntity> list =   query.getResultList();
		for(boardEntity board : list) {
			System.out.println("##"+board.getTitle()+"##"+board.getContent());
		}
		
	}
}
