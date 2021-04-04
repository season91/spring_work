package common.util.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	public static ExecutorService threadPool;
	private ServerSocket server;
	private Vector<Socket> socketList;
	private Vector<String> nameList;
	
	//서버 기능 : 서버시작, 클라이언트수락, 입력(읽기), 출력(귓속말, 전체쓰기), 서버종료, 예외처리
	
	//1. 서버 시작 서버소켓포트번호 지정 : GUI 시작버튼 눌렀을때
	//클라이언트 소켓리스트와, 유저 닉네임리스트 초기화
	public void connect() {
		try {
			server = new ServerSocket(9876);
			socketList = new Vector<Socket>();
			nameList = new Vector<String>();
			
		} catch (IOException e1) {
			// TODO Auto-gen26ated catch block
			e1.printStackTrace();
		}
		
	}
	
	//2. 클라이언트 접속수락. 클라이언트 접속, 읽기 동시작업 해야하므로 쓰레드 이용 : 클라이언트 붙었을때
	// -> 입력(읽기) 메서드 연결
	// 매번 새 소켓생성시 쓰레드도 새로 생성된다. 사용자10명이면 쓰레드도 10개
	public void startServer() {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				boolean flg = true;
				while(flg) {
					try {
						Socket client = server.accept();
						if(client.isClosed() ) {
							removeSocket(client);
						} else {
							BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
							nameList.add(br.readLine());
							socketList.add(client);
							textArea.append("입장인원 : " + socketList.size()+"\n");
							textArea.append("현재 입장자 리스트 : " + nameList+"\n");
							textArea.setCaretPosition(textArea.getDocument().getLength());
							read(client);
						}
				} catch (SocketException e1) {
					textArea.append("[서버 종료]\n");
					flg=false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}

		};
		threadPool = Executors.newCachedThreadPool();
		threadPool.submit(thread);
	}
	
	
	//3. 입력기능 : 읽기. 매개변수 소켓을 전달받아 읽기
	// 소켓을 통해 메시지를 읽는다. 메시지내용이 null이라면 해당 클라이언트 접속 종료로 판단.
	// null이 아니라면 해당메시지 전체대화인지 귓속말인지 판단해 목적에 맞는 쓰기 메서드 호출
	public void read(Socket socket) {
		Runnable thread = new Runnable()  {
			
			@Override
			public void run() {
				
			BufferedReader br = null;
				try {
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					while(true) {
						String msg = br.readLine();
						
						if(msg != null) {
							// 귓속말 양식 /w 닉네임 : 안녕하세요?
							 if (msg.contains("/w")) {
								 //귓속말 대상의 닉네임 인덱스를 찾고 메시지를 넘겨줘야함.대상자를 찾아주기
								 int toIdx = nameList.indexOf(msg.substring(3, msg.indexOf(':')-1));
								 whisper(msg.substring(msg.indexOf(":")+1, msg.length()),nameList.get(toIdx),socket);
								 textArea.append("<귓속말>"+nameList.get(toIdx)+msg.substring(msg.indexOf(":")+1)+"\n");
								 textArea.setCaretPosition(textArea.getDocument().getLength());
							 } else {
								 int idx = socketList.indexOf(socket);
								 String sendMsg = nameList.get(idx) + " : "+ msg;
								 allClientWrite(sendMsg); 
								 textArea.append(sendMsg+"\n");
								 textArea.setCaretPosition(textArea.getDocument().getLength());
							 }
							
						} else {
							removeSocket(socket);
							break;
						}
					}
				} catch (IOException e) {
					removeSocket(socket);
				}
				
			}
		}; threadPool = Executors.newCachedThreadPool();
		threadPool.submit(thread);
		
	}
	
	//4-1. 출력기능 : 귓속말
	//메시지, 귓속말보낼 대상 닉네임, 보낸자의 소켓 정보를 받아 출력
	public void whisper(String msg, String name, Socket socket) {
		PrintWriter writer = null;
		//보낸사람 socket에 바로 메시지 출력해주기
		int idx = socketList.indexOf(socket);
		try {
			writer = new PrintWriter(socket.getOutputStream());
			writer.println("<내가 보낸 귓속말>" + msg);
			writer.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//귓속말 받는 사람에게 출력하는 for문
		for (int i = 0; i < nameList.size(); i++) {
			try {
				if(nameList.get(i).equals(name)) {
	 				writer = new PrintWriter(socketList.get(i).getOutputStream());
					writer.println("<"+nameList.get(idx)+"님이 보낸 귓속말>" +msg);
					writer.flush();
					
				}
				
			} catch (IOException e) {
				writer.close();
				removeSocket(socket);
			}
		}

	}
			
	//4.2. 출력기능 : 전체
	public void allClientWrite(String msg) { 
		//예외처리때문에 소켓선언.
		Socket socket = null;
		PrintWriter writer = null;
		for (int i = 0; i < socketList.size(); i++) {
			try {
 				writer = new PrintWriter(socketList.get(i).getOutputStream());
				writer.println(msg);
				writer.flush();
				
			} catch (IOException e) {
				writer.close();
				removeSocket(socket);
			} 
		}
		
	}

	//5. 예외처리 : 클라이언트 접속 종료시 삭제
	// 클라이언트 소켓리스트와 유저 닉네임리스트에서 삭제.
	public void removeSocket(Socket socket) {
		textArea.append("client socket이 닫혔습니다.\n");
		for (int i = 0; i < socketList.size(); i++) {
			//매개변수소켓이랑 소켓리스트랑 비교해서 지운다.
			if(socketList.get(i) == socket) {
				try {
					socketList.get(i).close();
					socketList.remove(i);
					textArea.append(nameList.get(i)+"님 퇴장했습니다.\n");
					
					nameList.remove(i);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} 
		}
		textArea.append("접속인원 : " + socketList.size()+"\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	//6. 서버종료 : GUI 프로그램 종료 눌렀을 때
	// 모든 클라이언트 소켓 닫아주고, 쓰레드 닫고, 서버닫아준다.
	public void stopServer() {
		//소켓 다 닫아주고
		try {
			for (int i = 0; i < socketList.size(); i++) {
				socketList.get(i).close();
				socketList.remove(i);
				nameList.remove(i);
			}
			threadPool.isShutdown();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
