<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ProductList</title>
<link rel="stylesheet" href="./css/product.css" type="text/css"> 
</head>
<body>
<!-- 유저모드에서의 상품리스트 -->
<div class="product">
<c:choose>
	<c:when test="${list.size() > 0}">
 		<c:forEach items="${list}" var="dto">
			<div class="product-list">
				<ul class="btn btn-default">
					<li><a href="productDetail.do?product_no=${dto.product_no}"><img src="${dto.product_imgsrc1}" width="240"></a></li>
					<li><a href="productDetail.do?product_no=${dto.product_no}">${dto.product_name}</a> </li>
					<li>${dto.product_price}원 </li>
				</ul>
			</div>
		</c:forEach>
 	</c:when>
 	<c:otherwise>
		<div class="product-list-no" >
		 		상품정보가 없습니다
		</div>
	</c:otherwise>
</c:choose>
</div>

<!-- 관리자 모드에서의 상품 게시판 리스트 -->
<div>

</div>
</body>
</html>