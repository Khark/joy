package com.joy.demo.svc.basicboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joy.demo.entity.maria.boardEntity;
import com.joy.demo.repository.maria.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BasicBoardSvcImpl implements BasicBoardSvc {

	  private final BoardRepository boardRepository;
	
	@Override
	@Test
	public void save() {
		// TODO Auto-generated method stub
		boardEntity params = boardEntity.builder()
				.title("1번 게시글 제목")
                .content("1번 게시글 내용")
                .writer("gwgwgwgwgws")
                .hits(0)
                .deleteYn('N')
                .build();
		if(params == null) {
			System.out.println("######");
		}else {
			System.out.println("####@@@@#");

		}
		boardRepository.save(params);
		
		//boardEntity entity = boardRepository.findById((long) 1 ).get();
	}

	@Override
	public void findAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
