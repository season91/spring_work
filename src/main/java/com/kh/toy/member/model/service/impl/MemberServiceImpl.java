package com.kh.toy.member.model.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.toy.member.model.repository.MemberRepository;
import com.kh.toy.member.model.service.MemberService;
import com.kh.toy.member.model.vo.Member;

import common.code.Configcode;
import common.mail.MailSender;

@Service
public class MemberServiceImpl implements MemberService{

	// 우리가 만든 애들은 싱글톤이고 스레드세이프하지않다.
	// 그래서 생성자주입으로 넣어주겠다.
	private final MemberRepository memberRepository;
	
	@Autowired
	private MailSender mail; // 우리가 구현한 MailSender 의존성 주입 받기.
	
	@Autowired
	private RestTemplate http;
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Override
	public Member selectMemberById(String userId) {
		return memberRepository.selectMemberById(userId);
	}

	@Override
	public void authenicateEmail(Member persistInfo, String authPath) {
		// 1. 일반맵이 아닌 MultiValueMap를 이용해 바디 구현한다.
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("mail-template", "temp_join"); // view
		body.add("userId", persistInfo.getUserId()); // id
		body.add("authPath", authPath); // url 랜덤경로
		
		// 2. RequestEntity에 handler로 요청보낼 post에 body를 넣어 셋팅 해놓는다.
		RequestEntity<MultiValueMap<String, String>> request = 
				RequestEntity
				.post(Configcode.DOMAIN+"/mail")
				.header("content-type",MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.body(body);
		
		// 3. RestTemplate 을 통해 셋팅한 request 요청보내고 response entity로 받는다. 
		// handler가 반환하는건 view 경로이다. 왜냐면 걔도 컨트롤러니깐.
		ResponseEntity<String> response = http.exchange(request, String.class);
		String message = response.getBody();
		
		// 4. 메일은 비동기로 보내자.
		mail.send(persistInfo.getEmail(), "회원가입을 축하드립니다!", message);
	}
	
	
	

}
