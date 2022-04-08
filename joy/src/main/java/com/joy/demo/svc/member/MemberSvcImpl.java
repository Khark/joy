package com.joy.demo.svc.member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.joy.demo.advice.RestException;
import com.joy.demo.entity.maria.memberEntity;
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
	public String OAuthgetKakaoAccessToken(String token) {
		// TODO Auto-generated method stub
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

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

	            while ((line = br.readLine()) != null) {
	                result += line;
	            }
	            System.out.println("response body : " + result);

	            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
	            JsonParser parser = new JsonParser();
	            JsonElement element = parser.parse(result);

	            access_Token = element.getAsJsonObject().get("access_token").getAsString();
	            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

	            System.out.println("access_token : " + access_Token);
	            System.out.println("refresh_token : " + refresh_Token);

	            br.close();
	            bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return access_Token;
	}
}
