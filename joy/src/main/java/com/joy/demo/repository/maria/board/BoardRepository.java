package com.joy.demo.repository.maria.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.joy.demo.entity.maria.boardEntity;

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
	
}
