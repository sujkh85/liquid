<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 페이지 용도 : 인기 상품 목록 보여줄 페이지
 ***********************************************************************/
 -->    
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="bestitem" align="center">
<h2>베스트 아이템</h2>
<hr>
		<table border="1" align="center" width="1000">
		<tr align="center" bgcolor="gray">
				<td>No</td>
				<td>상품번호</td>
				<td>상품명</td>
				<td>가격</td>
				<td>판매량</td>
				<td>관리</td>
		</tr>

		<c:forEach items="${list}" var="dto">
			<tr onmouseover="this.style.backgroundColor='gray'" onMouseOut="this.style.backgroundColor='white'">
				<td align="center">${dto.rownum}</td>
				<td align="center">${dto.no}</td>
				<td align="center">${dto.name}</td>
				<td align="center">${dto.price}</td>
				<td align="center">${dto.sales}</td>
				<td align="center">
				<input type="button" value="상세보기" onclick="javascript:location.href='manager_productDetail.do?product_no=${dto.no}'">
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