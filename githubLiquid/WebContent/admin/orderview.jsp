<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주문 상태 뷰어</title>
</head>
<body>
	<div onclick="location.href='ordercheck.jsp'" align="center" style=" background-color:aqua; cursor:pointer; position: absolute; left: 10px; top: 10px; width: 50px; height: 50px;"><font size="2" color="#765757">
	주문확인<br>\${주문확인중 카운터 }</font></div>
	<div onclick="location.href='ordercheck.jsp'" align="center" style=" background-color:aqua; cursor:pointer; position: absolute; left: 70px; top: 10px; width: 50px; height: 50px;"><font size="2" color="#765757">
	입금확인<br>\${주문접수중 카운터 }</font></div>
	<div onclick="location.href='ordercheck.jsp'" align="center" style=" background-color:aqua; cursor:pointer; position: absolute; left: 130px; top: 10px; width: 50px; height: 50px;"><font size="2" color="#765757">
	발송중<br>\${발송중 카운터 }</font></div>
	<div onclick="location.href='ordercheck.jsp'" align="center" style=" background-color:aqua; cursor:pointer; position: absolute; left: 190px; top: 10px; width: 50px; height: 50px;"><font size="2" color="#765757">
	거래완료<br>\${거래완료 카운터 }</font></div>
	
</body>
</html>