<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table border="1" >
			<tr align="center">
				<td>제품 이미지</td>
				<td>주문일자</td>
				<td width="15%">상품명</td>
				<td width="10%">상품가격</td>
				<td width="5%">주문수량</td>
				<td width="10%">주문가격</td>
				<td>주문현황</td>
				<td>결제 방법</td>
				<td>배송주소</td>
				<td>배송메시지</td>
				<td>배송장번호</td>
			</tr>
		<c:forEach items="${orderDetailInfo}" var="dto">
			<tr>
				<td><a href="productDetail.do?product_no=${dto.product_no}"><img src="${dto.product_imgsrc1}" width="100"></a></td>
				<td align="center">${dto.order_date}</td>
				<td width="150" align="center">
				<a href="productDetail.do?product_no=${dto.product_no}">${dto.product_name}<br>(사이즈 : ${dto.stock_size})</a></td>
				<td align="center">${dto.product_price}</td>
				<td align="center">${dto.order_detail_quantity}</td>
				<td align="center">${dto.product_price*dto.order_detail_quantity}</td>
				<td align="center">
							<c:choose>
							<c:when test="${dto.order_paystatus== '배송대기'}">
								결제완료
							</c:when>
							<c:otherwise>
								${dto.order_paystatus}
							</c:otherwise>
						</c:choose>
				</td>
				<td align="center">${dto.order_payment}</td>
				<td align="center">${dto.order_address1}${dto.order_address2}</td>
				<td align="center">${dto.order_message}</td>
				<td align="center">${dto.order_waybillno}</td>
			</tr>
		</c:forEach>
</table>
<br>
<div align="center">
<input type="button" value="목록돌아가기" onClick="location.href='order_list.do?'">
</div>
</body>
</html>