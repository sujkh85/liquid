<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 페이지 용도 : 매출 관리 보여줄 페이지
 ***********************************************************************/
 -->       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div id="bestitem" align="center">
<c:choose>
	<c:when test="${param.date=='day'}"><h2>일 매출량</h2></c:when>
	<c:when test="${param.date=='month'}"><h2>월 매출량</h2></c:when>
</c:choose>
<hr>
		<table border="1" align="center" width="1000">
		<tr align="center" bgcolor="gray">
				<td>주문일자</td>
				<td>총 주문 수량</td>
				<td>총 상품 판매 수량</td>
				<td>총 매출액</td>
		</tr>

		<c:forEach items="${list}" var="dto">
			<tr onmouseover="this.style.backgroundColor='gray'" onMouseOut="this.style.backgroundColor='white'">
				<td align="center">${dto.orderdate}</td>
				<td align="center">${dto.ordercount}</td>
				<td align="center">${dto.quantity}</td>
				<td align="center">${dto.finalmoney}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">${pg }</td>
		</tr>
		</table>
</div>

</body>
</html>