package com.kh.toy.parking.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kh.toy.parking.model.vo.CarApplication;

@Component
public class CarApplicationValidator implements Validator{

	//어떤 조건의 컨트롤러 메서드 파라미터를 검증할 것인지 작성
	@Override
	public boolean supports(Class<?> clazz) {
		// Class<?> clazz : 컨트롤러 파라미터의 class 객체
		return CarApplication.class.equals(clazz);
	}

	//검증할 코드 작성
	@Override
	public void validate(Object target, Errors errors) {
		// Object target : 컨트롤러 메서드의 파라미터
		// Errors errors : 검증에 실패할 경우, 내용을 저장할 Error 객체. 컨트롤러 메서드의 파라미터로 전달된다.

		Pattern pattern = Pattern.compile("^\\d{2,3}[가-힣]\\d{4}"); //차버노1
		CarApplication carApplicationInfo = (CarApplication) target;
		
		System.out.println("밸리데이터 도나요??");
		// 2. 비밀번호가 8자리이상 숫자,영문,특문이 각1개씩 들어있는지
		// 정규표현식에 맞다면(특문에안들어있다면) 값이 flase가 뜰꺼니까 true로 변경해주기..??
		System.out.println("2자"+pattern.matcher(carApplicationInfo.getAplctCarNumber()).find());
		// 둘중하나라도 걸리면 잡는다.
		if(!pattern.matcher(carApplicationInfo.getAplctCarNumber()).find()) {
			errors.rejectValue("aplctCarNumber", "error.aplctCarNumber", "차량번호를 다시 확인하세요.");
		} 
		
		
		//숫자,영문자,특수문자 조합의 8글자 이상인 문자열입니다.
	}

}
