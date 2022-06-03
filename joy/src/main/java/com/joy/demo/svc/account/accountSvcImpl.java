package com.joy.demo.svc.account;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joy.demo.dto.maria.account.accountTO;
import com.joy.demo.entity.maria.account;
import com.joy.demo.repository.maria.account.accountRepository;


@Service
public class accountSvcImpl implements accountSvc {

	@Autowired
	private accountRepository accRepository;
	
	@Override
	public UserDetails loadUserByUsername(String Account) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<account> accountEntityWrapper = accRepository.findByAccount(Account);
		
		account accountEntity = accountEntityWrapper.orElse(null);
		
		List<GrantedAuthority> authorites = new ArrayList<>();
		
		authorites.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

		
		return new User( accountEntity.getAccount() , accountEntity.getPassword() ,authorites );
	}

	@Transactional
	@Override
	public Integer save(accountTO accountto) {
		account account = accountto.toEntity();
		account.setLastAccessDt(LocalDateTime.now());
		account.setRegDt(LocalDateTime.now());

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		
		return accRepository.save(account).getId();
	}

}
