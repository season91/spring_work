package common.exception;

import common.code.ErrorCode;

public class CustomException extends RuntimeException {
	// exception 들의 부모가 되어줄 클래스이다.
	private static final long serialVersionUID = 4827430474153125429L;
	
	public ErrorCode error;
	
	// 실제로 예외가 발생한 것이 아니라 우리가 지정한 예외상황에 대한 예외처리를 위한 생성자
	public CustomException(ErrorCode error) {
		// TODO Auto-generated constructor stub
		this.error = error;
		this.setStackTrace(new StackTraceElement[0]);
	}
	
	public CustomException(ErrorCode error, Exception e) {
		// log작성
		e.printStackTrace();
		// 전달받은 enum을 error에 저장.
		this.error = error;
	}
	
}
