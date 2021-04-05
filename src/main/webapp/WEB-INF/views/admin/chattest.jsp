<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/adminhead.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 class="title" id="in">관리자 문의하기</h3>
	<input type="text" id="name" />
	<input type="text" id="message" />
	<input type="button" id="sendBtn" value="submit"/>
	<h4 id="messageArea" class="title"></h4>

<div class="title"> 입퇴장내용
	<h4 id="infoArea" class="title"></h4>
</div>
</body>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script type="text/javascript">
	$("#sendBtn").click(function() {
		sendMessage();
		$('#message').val('')
	});

	let sock = new SockJS("http://localhost:8888/echo/");
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	
	// 메시지 전송
	function sendMessage() {
		let msg = {
				target : $("#name").val(),
				messeage : $("#message").val()
		}
		sock.send(JSON.stringify(msg));
	}
	// 서버로부터 메시지를 받았을 때
	function onMessage(msg) {
		let data = msg.data;
		console.dir(data);
		if(data.includes("[안내]")){
			$("#infoArea").append(data + "<br/>");
		} else {
			$("#messageArea").append(data + "<br/>");
		}
		
	}
	// 서버와 연결을 끊었을 때
	function onClose(evt) {
		$("#messageArea").append("연결 끊김");
	
	}

</script>


</html>