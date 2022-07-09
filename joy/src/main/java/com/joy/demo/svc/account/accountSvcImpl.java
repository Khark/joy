
package com.joy.demo.svc.account;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joy.demo.dto.maria.account.accountReqDto;
import com.joy.demo.dto.maria.account.accountResDto;
import com.joy.demo.entity.maria.accountEntity;
import com.joy.demo.repository.maria.account.accountRepository;


@Service
public class accountSvcImpl implements accountSvc {

	@Autowired
	private accountRepository accRepository;
	
	@Override
	public UserDetails loadUserByUsername(String Account) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<accountEntity> accountEntityWrapper = accRepository.findByAccount(Account);
		
		accountEntity accountEntity = accountEntityWrapper.orElse(null);
		
		List<GrantedAuthority> authorites = new ArrayList<>();
			
		switch (accountEntity.getRole()) {
		case 1:
			authorites.add(new SimpleGrantedAuthority("ROLE_MEMBER")); // 1인 그룹은 회원 
			break;
		case 9 : 	
			authorites.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // 9인 그룹은 관리자
			break;
		default:
			break;
		}
		
		return new User( accountEntity.getAccount() , accountEntity.getPassword() ,authorites );
	}

	@Transactional
	@Override
	public Integer save(accountReqDto accountto) {
		accountEntity account = accountto.toEntity();
		account.setLastAccessDt(LocalDateTime.now());
		account.setRegDt(LocalDateTime.now());

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		account.setRole(1); // 회원으로 가입을 하는 경우 
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		account.setGroupid(99); // 99 는 사업체 기
		return accRepository.save(account).getId();
	}

	@Override
	@Secured("ROLE_USER")
	public HashMap<String, Object> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Page<accountEntity> list = accRepository.findAll(PageRequest.of(page, size));
		
		resultMap.put("list", list.stream().map(accountResDto::new).collect(Collectors.toList()));
		resultMap.put("paging", list.getPageable());
		resultMap.put("totalCnt", list.getTotalElements());
		resultMap.put("totalPage", list.getTotalPages());
		
		return resultMap;
	}

}
