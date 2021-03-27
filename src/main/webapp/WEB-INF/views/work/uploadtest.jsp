<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
<form action="/work/mgmtfeeuploadimpl" id="form1" method="post" enctype="multipart/form-data">
	<input type="file" name="file">
	<button type="submit" value="제출" onclick="send()"></button>
</form>
<button type="button" class="btn_down-file btn btn-primary"  
	onclick="downloadFile()">양식 다운로드</button>

</body>
<script type="text/javascript">
	function send() {
		let form = new FormData(document.getElementById('form1'));
		
		$.ajax({
			url:"${ContextPath}/work/mgmtfeeuploadimpl",
			dataType:"json",
			data:form,
			processData:false,
			contentType:false,
			type:"POST",
			sucess:function(data){
				console.dir(data);
			},
			error:function(xhr, status, error){
				console.log(status);
			}
		})
	}
	
	function downloadFile(){
	      location.href = '${context}' + "/work/mgmtfeeformdownload";
	   }
</script>
</html>