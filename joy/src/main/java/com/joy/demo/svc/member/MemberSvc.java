package com.joy.demo.svc.member;

import com.joy.demo.entity.maria.memberEntity;
import com.joy.demo.entity.maria.tokenEntity;

public interface MemberSvc {
	public memberEntity selectMember(Long memberno);
	public tokenEntity OAuthgetKakaoAccessToken(String token);
	public String createUser(tokenEntity tokenTo);
	
	
}
