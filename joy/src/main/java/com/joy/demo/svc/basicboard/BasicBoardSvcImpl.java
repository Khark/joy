package com.joy.demo.svc.basicboard;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joy.demo.dto.maria.board.boardReqDto;
import com.joy.demo.dto.maria.board.boardResDto;
import com.joy.demo.entity.maria.boardEntity;
import com.joy.demo.repository.maria.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BasicBoardSvcImpl implements BasicBoardSvc {

	@Autowired
	BoardRepository boardRepository;
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Long save(boardReqDto dto) {
		// TODO Auto-generated method stub
		Long boardcnt = null;
		
		for(int i = 0 ; i < 2000; i ++) {
			boardcnt =+ boardRepository.save(dto.toEntity()).getId();
		}
		return boardcnt;
	}

	@Override
	@Transactional(readOnly = true)
	public List<boardResDto> findAll() {
		// TODO Auto-generated method stub
		return boardRepository.findAll().stream().map(boardResDto::new).collect(Collectors.toList());
	}

	@Override
	public boardResDto findById(Long id) {
		// TODO Auto-generated method stub
		return new boardResDto(boardRepository.findById(id).get());
	}

	@Override
	public int updateBoard(boardReqDto dto) {
		// TODO Auto-generated method stub
		return boardRepository.updateBoard(dto);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		boardRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public HashMap<String, Object> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object> ();
		
		Page<boardEntity> list = boardRepository.findAll(PageRequest.of(page, size, Sort.Direction.DESC,"id" ));
		
		resultMap.put("list", list.stream().map(boardResDto::new).collect(Collectors.toList()) );
		resultMap.put("paging", list.getPageable());
		
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
		resultMap.put("nowcnt", page);
		
		System.out.println("##pageable?"+list.getPageable());
		System.out.println("##totalcnt?"+list.getTotalPages());
		
		return resultMap;
	}
	
	
	
//	@Override
//	)public void save() {
//		// TODO Auto-generated method stub
////		boardEntity params = boardEntity.builder()
////				.title("1번 게시글 제목")
////                .content("1번 게시글 내용")
////                .writer("gwgwgwgwgws")
////                .hits(0)
////                .deleteYn('N')
////                .build();
//		//boardEntity params  = new boardEntity();
//	//	boardRepository.save(params);
//		
//		//boardEntity entity = boardRepository.findById((long) 1 ).get();
//	}
//
//	@Override
//	public List<boardReqDto>  findAll() {
//		// TODO Auto-generated method stub
//		Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
//        List<boardReqDto> list = boardRepository.findAll(sort);
//       // return list.stream().map(boardReqDto::new).collect(Collectors.toList());
//        return null;
//	}
//
//	@Override
//	public void delete() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Transactional
//	@Override
//	public Long save(boardReqDto dto) {
//		// TODO Auto-generated method stub
//		long result = 0;
//		try {
//			result = boardRepository.save(dto).getId();
//		}catch (Exception e) {
//			// TODO: handle exception
//			result=-1;
//			e.getStackTrace();
//		}
//		return result;
//	}
//
//	@Override
//	@Transactional (readOnly =  true)
//	public HashMap<String , Object> findList(Integer page, Integer size) {
//		// TODO Auto-generated method stub
//		HashMap<String, Object> resultMap = new HashMap<String, Object>();
//		BoardRepository.aa(em, "1");
//		Page <boardReqDto>  list = boardRepository.findAll(PageRequest.of(page, size));
//		// 위 리스트는 boardEntity 의 리턴값을 가지고 있고 이를 가공하기 위해서는 boardEntity 를 객체로 받아와 return 해주는 것이 필요하기에?
////	
////		resultMap.put("list", list.stream().map(boardResDto::new).collect(Collectors.toList()));
////		resultMap.put("paging", list.getPageable());
////		resultMap.put("totalCnt", list.getTotalElements());
////		resultMap.put("totalPage", list.getTotalPages());
//
//		
//		return resultMap;
//	
//	}
//
//	@Override
//	public Long modify(boardReqDto dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	
//	public boardResDto findById(Long id) {
//		// TODO Auto-generated method stub
//		//return new boardResDto(boardRepository.findById(id).get());
//		return null;
//	}
//	
//
//	@Override
//	public void deleteById(Long id) {
//		// TODO Auto-generated method stub
//		boardRepository.deleteById(id);
//	}

}
