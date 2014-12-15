<!--
/***********************************************************************
 * 작업자 :  이승우 
 * 작업일자 : 2014.11.15~
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 : memberCheck.jsp : 닉네임 중복검사시
 * 파일 타입 : 틀
 * 기능 : 비밀번호를 제외한 회원정보수정 가능. 
  ***********************************************************************/
  --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script> 
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<title>주문상세정보</title>
</head>
<body>
<h3>주문상세정보</h3>
<hr>
<div id="order_detail" align="center">
<table class="table">
<c:forEach items="${list}" var="dto">
	<tr>
		<td><h5><strong>주문번호</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.order_no}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>주문일자</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.order_date}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>주문자</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.member_info_name}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>주문현황</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.order_paystatus}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>결제수단</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.order_payment}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>운송장번호</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.order_waybillno}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>배송지</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.order_post1}-${dto.order_post2}<p><p>${dto.order_address1 }  ${dto.order_address2 }</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>배송메세지</strong></h5></td>						
		<td colspan="2"><h5><strong>${dto.order_message}</strong></h5></td>
	</tr>
	<tr>
	<td><h5><strong>결제금액</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.order_final_money}</strong></h5></td>
		
	</tr>
	</c:forEach>
	<tr>
		<td></td>
		<td colspan="2">
		<input class="btn btn-success" type="button" value="돌아가기" onclick="location.href='manager_todayorder.do?order_date=0'">
		</td>  
	</tr>
</table>
</div>
</body>
</html>