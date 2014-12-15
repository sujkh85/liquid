<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
body {
    background-color: #d0e4fe;
}
</style>
</head>

<body>
	<div align="center" style=" position: absolute; left:50px; width:1310px; height:800px; border:thin; border-color:black;   ">
	0
	<div style=" background-color:green; position: absolute; left: 10px; top: 10px; width:700px; height:500px; border:thin; border-color:black;   ">
	1<div style=" background-image: url('./img/1.png'); position: absolute; left:10px; top:10px; width:200px; height: 200px;  "></div>
	</div>
	<div style=" background-color:blue; position: absolute; left: 10px; top: 520px; width:700px; height:270px; border:thin; border-color:black;   ">
	2
	</div>
	<div style=" background-color:lime; position: absolute; left: 720px; top: 10px; width:580px; height:200px; border:thin; border-color:black;   ">
		<jsp:include page="orderview.jsp"/>	
	</div>
	<div style=" background-color:maroon; position: absolute; left: 720px; top: 220px; width:580px; height:280px; border:thin; border-color:black;   ">
	<table>
		<tr>
			<th>글번호</th><th>글 제 목</th><th>작성날짜</th><th>조 회 수</th> 
		</tr>
	</table>
	</div>
	<div style=" background-color:aqua; position: absolute; left: 720px; top: 510px; width:580px; height:280px; border:thin; border-color:black;   ">
	5
	</div>
	</div>
</body>
</html>