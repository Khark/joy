package com.joy.demo.repository.maria.board;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joy.demo.entity.maria.boardEntity;

public interface BoardRepository extends JpaRepository<boardEntity, Long>{

}
