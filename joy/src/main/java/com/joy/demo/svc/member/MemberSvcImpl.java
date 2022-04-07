package com.joy.demo.svc.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.joy.demo.advice.RestException;
import com.joy.demo.entity.maria.memberEntity;
import com.joy.demo.repository.maria.member.MemberRepository;

public class MemberSvcImpl implements MemberSvc {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public memberEntity selectMember(Long memberno) {
		// TODO Auto-generated method stub

		//

		// asdfasdfa
		//
		return memberRepository.findById(memberno)
				.orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Not found member"));
	}
}
