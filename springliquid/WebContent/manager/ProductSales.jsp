<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 페이지 용도 : 상품별 매출량 보여줄 페이지
 ***********************************************************************/
 -->        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="productsales" align="center">
<h2>상품별 매출량</h2>
<hr>
		<table border="1" align="center" width="1000">
		<tr align="center" bgcolor="gray">
				<td>상품명</td>
				<td>사이즈</td>
				<td>상품가격</td>
				<td>판매수량</td>
				<td>총 판매금액</td>
				<td>관리</td>
				
		</tr>

		<c:forEach items="${list}" var="dto">
			<tr onmouseover="this.style.backgroundColor='gray'" onMouseOut="this.style.backgroundColor='white'">
				<td align="center">${dto.product_name}</td>
				<td align="center">${dto.stock_size}</td>
				<td align="center">${dto.price}</td>
				<td align="center">${dto.quantity}</td>
				<td align="center">${dto.finalmoney}</td>
				<td align="center">
		        <input type="button" value="상세보기" onclick="location.href='manager_productDetail.do?product_no=${dto.product_no}'">
		        </td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="6">${pg }</td>
			</tr>
		</table>
</div>
</body>
</html>