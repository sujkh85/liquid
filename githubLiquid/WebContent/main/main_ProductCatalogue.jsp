<%
 /***********************************************************************
  * 작업자 : 이승우 
  * 작업일자 : 2014.11.06(update)
  * 어떤 파일에 호출받는가 : main.jsp
  * 어떤 파일을 호출하는가 : 상품이미지,상품명,상품가격을 랭킹순으로, 각 상품의 상세페이지.jsp 
  * 파일 타입 : 부품
  * 14.11.21 ~ 14.11.22_이승우 : table에서 div/css로 수정 
  ***********************************************************************/
 %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>hot item</title>
</head>
<body> 
<div class="main-content-product ">
<!--=======================================상품 카탈로그 로고 시작==========================================-->			
	<div class="main-content-catalogue-logo" >
			<span class="glyphicon glyphicon-fire"></span>Hot Item<hr>
	</div>
<!--=======================================상품 카탈로그 로고 끝==========================================-->
<!--========================================상품 카탈로그 시작==========================================-->
		<div class="main-content-catalogue-content ">  
			<!-- 표시할 상품이 있을 때 -->			
			<c:forEach items="${productCatalogueList}" var="list" varStatus="i">
				<ul class="main-content-catalogue-content-box btn btn-default">
			
				<c:if test="${productCatalogueList != null}">
						<c:choose>
						<c:when test="${list.getImg() != null }">
						<li class="img"><a href="productDetail.do?product_no=${list.getNo()}"><img src="${list.getImg()}" height="100%" width="100%"></a></li>
						</c:when>
						<c:when test="${list.getImg() == null }"> 
						<li class="img"><img src="./img/img_No.jpg" height="100%" width="100%" style="margin-bottom: 15px;"></li>
						</c:when>
						</c:choose>
						<li class="name"><a href="productDetail.do?product_no=${list.getNo()}" >${list.getName()}</a></li>
						<li class="price"><a href="productDetail.do?product_no=${list.getNo()}"><font color="red">${list.getPrice()} 원</font></a></li>
				
				</c:if>
				</ul>
			</c:forEach>
			<!-- 표시할 상품이 8개보다 작을때 -->
			<c:if test="${productCatalogueList.size() < 8}">
				<c:forEach var="i" begin="1" end="${8-productCatalogueList.size()}">
					<mytag:NoImg />
				</c:forEach>
			</c:if>
			<!-- 표시할 상품이 없을 때 -->
			<c:if test="${productCatalogueList.size() == 0}">
				<c:forEach var="i" begin="1" end="8">
					<mytag:NoImg />
				</c:forEach>
			</c:if>
		</div> 	
<!--========================================상품 카탈로그 끝==========================================-->
	</div>
</body>
</html>