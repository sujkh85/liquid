<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>   
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 2014.11.08
 * 변경일자 : 2014.11.18 (주석추가)
 * 어떤 파일에 호출받는가 : Index.jsp
 * 어떤 파일을 호출하는가 : WishList_Product.jsp 
 * 클래스 용도 : request객체에서 list정보 가져와서 화면에 뿌려줌,총구매액도 같이..
 * 파일 타입 : WishList틀
 ***********************************************************************/
  --> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>wishList</title>
<link rel="stylesheet" href="./css/talbe.css" type="text/css">
</head>
<body>
<c:choose>
<c:when test="${s_member_info_no == null}">
	<div align="center">
		<font color="red">로그인 후 이용 가능합니다</font>
	</div>
	<jsp:include page="/member/memberLoginForm.jsp"></jsp:include>
</c:when>
<c:when test="${list.size()>0 }">
	<table border="1" align="center" class="ex1">
	<thead>
	<tbody>
			<tr align="center" bgcolor="pink">
				<td>제품 이미지</td>
				<td>제품명</td>
				<td>상품 가격</td>
				<td>상품 삭제</td>
			</tr>
		<c:forEach items="${list }" var="wishList">
		<tr>
			<td><img src="${wishList.product_imgsrc1}" width="200"></td>
			<td><a href= "productDetail.do?product_no=${wishList.product_no}" >${wishList.product_name}</a></td>
            <td align="center"><font color="red">${wishList.product_price}</font></td>
            <td>
            	<input type="hidden" name="wishlist_no" value="${wishList.wishlist_no}">
            	<input type="button" onclick="location.href='wishlist_delete.do?wishlist_no=${wishList.wishlist_no }'" value="삭제하기">
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</thead>
	</table>
</c:when>
      <c:otherwise>
      	위시리스트에 담긴 상품이 없습니다.
      </c:otherwise>
</c:choose>
</body>
</html> 