package common.echo;

import java.io.IOException;
import java.util.Vector;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.kh.toy.bdmin.model.vo.Bdmin;
import com.kh.toy.generation.model.vo.Admin;
import com.kh.toy.generation.model.vo.Generation;


@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler{

	// 세션리스트
	private Vector<WebSocketSession> sessionList = new Vector<WebSocketSession>();
	// 닉네임리스트
	private Vector<Object> nameList = new Vector<Object>();
	
	
	// [클라이언트 접속시 작동]
	// 클라이언트 연결되었을때 실행
	// 접속자 session 정보 가져온다.
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String id = "";
		if(session.getAttributes().get("admin") == null) {
			Generation generation = (Generation) session.getAttributes().get("generation");
			id = generation.getId();
			//접속시에 접속자 정보 보여준다.
			//대신 접속자가 관리자라면 안내하지않는다. 어차피 받는 칸은 관리자에만 있음.
			connectList(session);
		} else if (session.getAttributes().get("generation") == null){
			Admin admin  =  (Admin) session.getAttributes().get("admin");
			id = admin.getId();
		}
		sessionList.add(session);
		nameList.add(id);
		
		System.out.println("총인원"+sessionList);
		System.out.println("총네임"+nameList);

	}
	
	public void connectList(WebSocketSession session) throws IOException {
		int res = nameList.indexOf("admin1");
		System.out.println("포함도보나?"+res);
		for (int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).equals("admin1")) {
				//관리자라면 입장자 정보 받는다.
				sessionList.get(i).sendMessage(new TextMessage("[안내] 101동101호 세대가 입장하셨습니다."));
			}
		}
	}
	
	// [클라이언트 메시지 보낼 시 작동]
	// 클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("전송"+session.getId()+message.getPayload());
		//모든 유저에게 메시지 출력
		//하지만 우리는 1:1채팅이기에 이부분 수정해야한다.
//		for (WebSocketSession webSocketSession : sessionList) {
//			webSocketSession.sendMessage(new TextMessage(message.getPayload()));
//		}
		JSONObject object = new JSONObject(message.getPayload());
		// 1. 닉네임 정보 넣어주기. 받는이와 보낸이에게 보내기
		// 전송을 눌렀을때, 세션정보가 리스트의 i 번째와 같은 위치에 name을 넣어준다.
		String target = object.getString("target");
		System.out.println("받는이 : "+target);
		int fromIdx = sessionList.indexOf(session);
		for (int i = 0; i < sessionList.size(); i++) {
			// 닉네임이 같다면 해당 i번째 세션에 보내준다
			if(nameList.get(i).equals(target)  || sessionList.get(i).equals(session)) {
				sessionList.get(i).sendMessage(new TextMessage(nameList.get(fromIdx)+object.getString("messeage")));
			}
		}

	}
	
	// [클라이언트 접속 끊었을 시 작동]
	// 클라이언트가 연결 끊었을 때 실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("퇴장"+session.getId());
		int idx = sessionList.indexOf(session);
		sessionList.remove(session);
		nameList.remove(idx);
		
		//접속시에 접속자 정보 보여준다.
		for (int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).equals("choayoung91")) {
				//관리자라면 입장자 정보 받는다.
				sessionList.get(i).sendMessage(new TextMessage("[안내] 101동101호 세대가 퇴장하셨습니다."));
			}
		}
	}
	
	
	
}
