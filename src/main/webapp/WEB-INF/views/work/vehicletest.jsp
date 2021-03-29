<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
<c:choose>
	<c:when test="${vehicle eq null }">
	</c:when>
	<c:otherwise>
	<div style="border-color: pink; width: 500px; height: 500px; background-image: url('${vehicle.vehicleIMG}')"></div>
	</c:otherwise>
</c:choose>
<!-- <div>
<form action="/work/vehicletestimpl" id="form1" method="get" enctype="multipart/form-data">
	<input type="hidden" name="url" class="intest" value="/work/readvehicle">
	<button type="submit" >큐알생성</button>
</form>
</div> -->

</body>
<script type="text/javascript">
	document.querySelector('.test').addEventListener('click',()=>{
		let link = document.location.href;
		console.dir(link);
	});
	
</script>
</html>