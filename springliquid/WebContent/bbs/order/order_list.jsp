<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="./css/order.css" type="text/css"> 
<title>목록보기</title>
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
</head>
<body>
<!-- 비회원 접근시 로그인 폼 보여주기  -->
<c:if test="${s_member_info_no  == null}">
	<div align="center">
		<font color="red">로그인 후 이용 가능합니다</font>
	</div>
	<jsp:include page="/member/memberLoginForm.jsp"></jsp:include>
</c:if>

<!-- 회원만 가능 -->
<c:if test="${orderList.size() > 0 }">
<div align="center">
	<h1><span class="glyphicon glyphicon-shopping-cart"> 주문리스트</h1>
	<hr>
<form id="order">
		<table border="1" >
			<tr align="center">
				<td>제품 이미지</td>
				<td>주문일자</td>
				<td width="15%">상품명</td>
				<td width="10%">상품가격</td>
				<td width="5%">주문수량</td>
				<td width="10%">주문가격</td>
				<td>배송상태</td>
			</tr>
		<c:forEach items="${orderList}" var="dto">
			<tr>
				<td width="150"><a href="productDetail.do?product_no=${dto.product_no}"><img src="${dto.product_imgsrc1}" width="150"></a></td>
				<td align="center">${dto.order_date}<br><br><input type="button" value="주문상세보기" onClick="location.href='orderDetailInfo.do?order_no=${dto.order_no}'"></td>
				<td width="150" align="center">
				<a href="productDetail.do?product_no=${dto.product_no}">${dto.product_name}</a></td>
				<td align="center">${dto.product_price}</td>
				<td align="center">${dto.order_detail_quantity}</td>
				<td align="center">${dto.product_price*dto.order_detail_quantity}</td>
				<td align="center">
						<c:choose>
							<c:when test="${dto.order_cancel == 'Y'}">
								주문 취소된 상품입니다
							</c:when>
							<c:when test="${dto.order_paystatus== '입금대기'}">
							주문완료<br><br>
							<input type="button" onclick="location.href='order_payment.do?order_no=${dto.order_no}&order_money=${dto.product_price*dto.order_detail_quantity}'" value="결제하기">
							&nbsp;<input type="button" value="주문취소" onclick="location.href='order_delete.do?order_no=${dto.order_no}&stock_no=${dto.stock_no}'">
							</c:when>

							<c:otherwise>
								${dto.order_paystatus}
								<br><br><input type="button" value="주문취소" onclick="location.href='order_delete.do?order_no=${dto.order_no}&stock_no=${dto.stock_no}'">
							</c:otherwise>
						</c:choose>
				</td>
			</tr>
		</c:forEach>
		</table>
</form>
	</div>
</c:if>
</body>
</html>