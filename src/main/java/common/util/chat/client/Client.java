package common.util.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private Socket socket;
	
	//클라이언트 기능 : 서버접속(클라이언트 시작), 서버접속종료(클라이언트 종료), 채팅시작, 입력(읽기), 출력(쓰기)

	//1. 서버 접속(클라이언트 시작) : GUI 시작하기버튼 눌렀을때
	//서버 IP번호와 port번호, 입장할 닉네임 작성후 접속, 채팅은 읽는걸 먼저 하는것이 우선이므로 read 메서드 호출
	public void connect(String host, int port, String name) {

		try {
			socket = new Socket(host, port);
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println(name);
			writer.flush();
			read();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 2. 채팅 시작, 읽기와 쓰기는 동시에 진행되어야 하므로 쓰레드 이용 : GUI버튼 보내기
	// GUI를 통해 입력한 내용을 서버로 출력
	public void chatStart(String message) {

		// 채팅은 계속하니깐 무한반복문.그래서 닫아줄필요는 없을듯.
		 // 버퍼비우는용도.
		// 닉네임 입력
		Thread thread = new Thread() {
			public void run() {
				PrintWriter writer = null;
				try {
					writer = new PrintWriter(socket.getOutputStream());
					writer.println(message);
					writer.flush();
				} catch (IOException e) {
					try {
						writer.close();
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
			}
		}; thread.start();
	}
	
	// 3. 입력 : 서버에서 온 메시지 읽어 GUI에 보여주기. : textArea에 입력내용 보내줌
	public void read() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String message = br.readLine();
						
						if(message!=null) {
							textArea.append(message + "\n");
							textArea.setCaretPosition(textArea.getDocument().getLength());
						} else {
							break;
						}
					} catch (IOException e) {
						try {
							socket.close();
							break;
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}

			}
		}); thread.start(); 
	}

}
