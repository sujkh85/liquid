<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 페이지 용도 : 상품목록 보여줄 페이지
 ***********************************************************************/
 -->       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="product_list" align="center">
<h2>상품 전체 정보</h2>
<hr>
<div id="search">
	<form action="manager_productlist.do">
	<select name="search">
		<option value="상품명">상품명</option>
		<option value="상품번호">상품번호</option>
	</select>
	<input type="text" name="product_name">
	<input type="submit" value="검색" >
	</form>
</div>
<p>
		<table border="1" align="center" width="1000">
		<tr align="center" bgcolor="gray" >
				<td>상품 번호</td>
				<td>상품명</td>
				<td>상품 분류</td>
				<td>사이즈</td>
				<td>재고 수량</td>
				<td>구입 가격</td>
				<td>판매 가격</td>			
				<td>등록 일자</td>	
				<td>관리</td>		
				
		</tr>

		<c:forEach items="${list}" var="dto">
			<tr onmouseover="this.style.backgroundColor='gray'" onMouseOut="this.style.backgroundColor='white'">
				<td align="center">${dto.product_no}</td>
				<td align="center">${dto.product_name}</td>
				<td align="center">${dto.product_type_name}</td>
				<td align="center">${dto.stock_size}</td>
				<td align="center">${dto.stock_quantity}</td>
				<td align="center">${dto.product_cost}</td>
				<td align="center">${dto.product_price}</td>
				<td align="center">${dto.product_date}</td>	
				<td align="center">
				<input type="button" value="상세보기" onclick="javascript:location.href='manager_productDetail.do?product_no=${dto.product_no}'">
				</td>			
			</tr>
		</c:forEach>
			<tr>
				<td colspan="9">${pg }</td>
			</tr>
		</table>
</div>
<p>
</body>
</html>