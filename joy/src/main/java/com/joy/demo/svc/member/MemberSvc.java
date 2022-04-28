package com.joy.demo.svc.member;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpSession;

import com.joy.demo.entity.maria.memberEntity;
import com.joy.demo.entity.maria.tokenEntity;

public interface MemberSvc {
	public memberEntity selectMember(Long memberno);
	public tokenEntity OAuthgetKakaoAccessToken(String token);
	public tokenEntity accessUser(tokenEntity tokenTo);
	
	public memberEntity createUser(memberEntity to);
	public memberEntity readUser(tokenEntity to);
	public String memberlogout(HttpSession session) throws IOException;
}
