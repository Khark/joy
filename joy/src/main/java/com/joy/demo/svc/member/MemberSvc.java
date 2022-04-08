package com.joy.demo.svc.member;

import com.joy.demo.entity.maria.memberEntity;

public interface MemberSvc {
	public memberEntity selectMember(Long memberno);
	public String OAuthgetKakaoAccessToken(String token);
	
}
