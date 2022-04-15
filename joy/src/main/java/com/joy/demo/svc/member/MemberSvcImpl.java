package com.joy.demo.svc.member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.joy.demo.advice.RestException;
import com.joy.demo.entity.maria.memberEntity;
import com.joy.demo.entity.maria.tokenEntity;
import com.joy.demo.repository.maria.member.MemberRepository;

@Service
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

	@Override
	public tokenEntity OAuthgetKakaoAccessToken(String token) {
		// TODO Auto-generated method stub
		tokenEntity tokenvo = new tokenEntity();
		String access_Token = "";
		String refresh_Token = "";

		String reqURL = "https://kauth.kakao.com/oauth/token";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization", "Bearer " + token); // 전송할 header 작성, access_token전송
			System.out.println("##token" + token);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=f5167860655e408aa9ea9c9db4eb09d5"); // TODO REST_API_KEY 입력
			sb.append("&redirect_uri=http://localhost:8081/member/kakao_login"); // TODO 인가코드 받은 redirect_uri 입력
			sb.append("&code=" + token);
			bw.write(sb.toString());
			bw.flush();
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			tokenvo.setAccess_code(responseCode);
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
			// System.out.println("##id : "+id);
			System.out.println("access_token : " + access_Token);
			tokenvo.setToken(access_Token);
			br.close();
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tokenvo.setAccess_code(400);

		}

		// return access_Token;
		return tokenvo;
	}

	@Override
	public tokenEntity accessUser(tokenEntity to) {
		// TODO Auto-generated method stub
		tokenEntity vo = new tokenEntity();
		String result ="";
		String reqURL = "https://kapi.kakao.com/v2/user/me";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			String token = to.getToken();
			System.out.println("access_token : " + token);

			conn.setRequestProperty("Authorization", "Bearer " + token);

			int resCode = conn.getResponseCode();
			System.out.println("###responseCode" + resCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			// Gson 라이브러리로 JSON파싱
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			vo.setToken(token);
			vo.setElement(element);
			
			//Long longid = new Long(id);

			//memberEntity memberto = new memberEntity();
			//memberto.setMemberid(longid);
			
			
			
//			System.out.println("##loginid?"+longid);
//			Optional<memberEntity> opto = memberRepository.findById(longid);
//			System.out.println("##1111?"+longid);
//			
//			if(opto.isPresent()) {
//				vo = opto.get();
//				if(vo.getNickname() == null || vo.getNickname().equals("") ) {
//					result ="new";
//				}else {
//					result ="present";
//				}
//			}else {
//				memberto.setMemberlevel("1");
//				memberto.setMembertype("kakao");
//				memberRepository.save(memberto );
//				result ="new";
//			}
//			
//			vo.setMemberid(opto.get().getMemberid()); 
//			vo.setResult(result);
			br.close();
		} catch (Exception e) {
			result = "ProcessFail";
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public String memberLogout(HttpSession session) throws IOException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	@Transactional
	public memberEntity CR_User(tokenEntity to) {
		// TODO Auto-generated method stub
		String result = "";
		memberEntity vo = new memberEntity();
		memberEntity memberto = new memberEntity();
		try {
		

//			int id = element.getAsJsonObject().get("id").getAsInt();
//			boolean hasEmail = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_email").getAsBoolean();
//			String email = "";
//			if (hasEmail) {
//				if(result.contains("\"email\"") ) {
//					email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
//				}
//			
//			}
			
			
			
			
		}catch (Exception e) {
			result = "ProcessFail";
			e.printStackTrace();
		}
		vo.setResult(result);
		return vo;
	}
}
