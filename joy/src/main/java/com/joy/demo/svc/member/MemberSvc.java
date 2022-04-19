package com.joy.demo.svc.member;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.joy.demo.entity.maria.memberEntity;
import com.joy.demo.entity.maria.tokenEntity;

public interface MemberSvc {
	public memberEntity selectMember(Long memberno);
	public tokenEntity OAuthgetKakaoAccessToken(String token);
	public tokenEntity accessUser(tokenEntity tokenTo);
	
	public String memberLogout(HttpSession session) throws IOException;
	public memberEntity crateUser(memberEntity to);
	public memberEntity readUser(tokenEntity to);
}
