package com.joy.demo.repository.maria.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.joy.demo.dto.maria.board.boardReqDto;
import com.joy.demo.entity.maria.boardEntity;

public interface BoardRepository extends JpaRepository<boardEntity, Long>{

	
	
	String MODIFY_BOARD = "UPDATE boardtable SET "+
				"TITLE = :#{#boardReqDto.title}, "+
				"CONTENT = :#{#boardReqDto.content} "+
				
				"WHERE ID = :#{#boardReqDto.id} ";
	
	@Transactional
	@Modifying
	@Query(value = MODIFY_BOARD, nativeQuery = true)
	public int updateBoard(@Param("boardReqDto") boardReqDto boardReqDto);
	
	
	static final String UPDATE_BOARD_READ_CNT_INC = "UPDATE BOARDTABLE SET "+
							"HITS = HITS +1"+
							"WHERE ID = :id";
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE_BOARD_READ_CNT_INC", nativeQuery = true)
	public int updateBoardReadCntInc(@Param("id") Long id);
	
	static final String DELETE_BOARD = "DELETE FROM TBLBOARDTABLE WHERE ID = (:deleteList)";
	
	@Transactional
	@Modifying
	@Query(value="DELETE_BOARD" , nativeQuery =  true)
	public int deleteBoard(@Param("deleteList") Long[] deleteList );
	


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
