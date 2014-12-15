
<%@page import="com.catalogue.UserDesignCatalogueDTO"%>
<%@page import="java.util.ArrayList"%>
<%
	/***********************************************************************
 * 작업자 : 이승우
 * 작업일자 : 2014.11.03
 * 어떤 파일에 호출받는가 : main.jsp
 * 어떤 파일을 호출하는가 : 디자인명,디자인이미지등을 인기순으로, 각 디자인의 게시판글.jsp 
 * 파일 타입 : 부품
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
<title>hot design</title>
</head>
<body>
<div class="main-content-design">
<!--=======================================상품 카탈로그 로고 시작==========================================-->			
	<div class="main-content-catalogue-logo">
		<span class="glyphicon glyphicon-fire"></span>	Hot Design<hr>
	</div> 
<!--=======================================상품 카탈로그 로고 끝==========================================-->
<!--========================================상품 카탈로그 시작==========================================-->
		<div class="main-content-catalogue-content">  
			<!-- 표시할 상품이 있을 때 -->			
			<c:forEach items="${UserDesignCatalogueList}" var="list" varStatus="i">
				<ul class="main-content-catalogue-content-box btn btn-default">
				<c:if test="${UserDesignCatalogueList != null}">
						<c:choose>
						<c:when test="${list.getImg() != null }">
						<li class="img"><a href="designDetail.do?board_userdesign_no=${list.getNo()}"><img src="${list.getImg()}" height="220" width="180"></a></li>
						</c:when>
						<c:when test="${list.getImg() == null }"> 
						<li class="img"><img src="./img/img_No.jpg" height="220" width="180" ></li>
						</c:when>
						</c:choose>
						<li class="title">타이틀: <a href="designDetail.do?board_userdesign_no=${list.getNo()}" >${list.getTitle()}</a></li>
						<li class="nickname">디자이너: ${list.getNickname()} </li>	
						<li class="favorite">추천수: ${list.getFavorite()}</li>	
				</c:if>
				</ul>
			</c:forEach>
			<!-- 표시할 상품이 8개보다 작을때 -->
			<c:if test="${UserDesignCatalogueList.size() < 8}">
				<c:forEach var="i" begin="1" end="${8-UserDesignCatalogueList.size()}">
				 	<mytag:NoImg />
				</c:forEach>
			</c:if>
			<!-- 표시할 상품이 없을 때 -->
			<c:if test="${UserDesignCatalogueList.size() == 0}">
				<c:forEach var="i" begin="1" end="8">
					<mytag:NoImg />
				</c:forEach>
			</c:if>
		</div> 	
<!--========================================상품 카탈로그 끝==========================================-->
	</div>
</body>
</html>