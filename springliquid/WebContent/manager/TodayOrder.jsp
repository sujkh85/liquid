<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 페이지 용도 : 오늘날자 주문목록 보여줄 페이지
 ***********************************************************************/
 -->       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div id="today_order" align="center">
<c:choose>
	<c:when test="${param.order_date==0 }">
	<h2>오늘자 주문 정보</h2>
	</c:when>
	<c:when test="${param.order_date==7 }">
	<h2>1주간 주문정보</h2>
	</c:when>
	<c:when test="${param.order_date==30 }">
	<h2>1개월간 주문 정보</h2>
	</c:when>
	<c:when test="${param.order_date==90 }">
	<h2>3개월간 주문 정보</h2>
	</c:when>
	<c:when test="${param.order_date==180 }">
	<h2>6개월간 주문 정보</h2>
	</c:when>

</c:choose>
<hr>
		<input type="radio" name="order_date" value="0" onclick="location.href='manager_todayorder.do?order_date=0'">오늘 
		<input type="radio" name="order_date" value="7" onclick="location.href='manager_todayorder.do?order_date=7'">1주일
		<input type="radio" name="order_date" value="30" onclick="location.href='manager_todayorder.do?order_date=30'">1개월
		<input type="radio" name="order_date" value="90" onclick="location.href='manager_todayorder.do?order_date=90'">3개월
		<input type="radio" name="order_date" value="180" onclick="location.href='manager_todayorder.do?order_date=180'">6개월<p>
		<table border="1" align="center"  width = "1000" >
		<tr align="center" bgcolor="gray">
				<td>주문번호</td>
				<td>회원이름</td>
				<td>주문일자</td>
				<td>결제상태</td>
				<td>결제수단</td>
				<td>전화번호</td>			
				<td>주문금액</td>		
				<td>관리</td>	
				
		</tr>
		<c:if test="${empty list}">
				<tr>
					<td colspan="8" align="center">오늘의 주문 내역이 없습니다.</td>
				</tr>
			</c:if>
		<c:forEach items="${list}" var="dto">
			
			<tr onmouseover="this.style.backgroundColor='gray'" onMouseOut="this.style.backgroundColor='white'">
				<td align="center">${dto.order_no}</td>
				<td align="center">${dto.member_info_name}</td>
				<td align="center">${dto.order_date}</td>
				<td align="center">${dto.order_paystatus}</td>
				<td align="center">${dto.order_payment}</td>
				<td align="center">${dto.member_info_phone}</td>
				<td align="center">${dto.order_final_money}</td>
				<td align="center">
        <input type="button" value="상세보기" onclick="location.href='manager_orderdetail.do?order_no=${dto.order_no}'">
        </td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="8">${pg }</td>
			</tr>
		</table>
</div>

</body>
</html>