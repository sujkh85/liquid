
<%@page import="com.catalogue.UserDesignCatalogueDTO"%>
<%@page import="java.util.ArrayList"%>
<%
	/***********************************************************************
 * �۾��� : �̽¿�
 * �۾����� : 2014.11.03
 * � ���Ͽ� ȣ��޴°� : main.jsp
 * � ������ ȣ���ϴ°� : �����θ�,�������̹������� �α������, �� �������� �Խ��Ǳ�.jsp 
 * ���� Ÿ�� : ��ǰ
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
<!--=======================================��ǰ īŻ�α� �ΰ� ����==========================================-->			
	<div class="main-content-catalogue-logo">
		<span class="glyphicon glyphicon-fire"></span>	Hot Design<hr>
	</div> 
<!--=======================================��ǰ īŻ�α� �ΰ� ��==========================================-->
<!--========================================��ǰ īŻ�α� ����==========================================-->
		<div class="main-content-catalogue-content">  
			<!-- ǥ���� ��ǰ�� ���� �� -->			
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
						<li class="title">Ÿ��Ʋ: <a href="designDetail.do?board_userdesign_no=${list.getNo()}" >${list.getTitle()}</a></li>
						<li class="nickname">�����̳�: ${list.getNickname()} </li>	
						<li class="favorite">��õ��: ${list.getFavorite()}</li>	
				</c:if>
				</ul>
			</c:forEach>
			<!-- ǥ���� ��ǰ�� 8������ ������ -->
			<c:if test="${UserDesignCatalogueList.size() < 8}">
				<c:forEach var="i" begin="1" end="${8-UserDesignCatalogueList.size()}">
				 	<mytag:NoImg />
				</c:forEach>
			</c:if>
			<!-- ǥ���� ��ǰ�� ���� �� -->
			<c:if test="${UserDesignCatalogueList.size() == 0}">
				<c:forEach var="i" begin="1" end="8">
					<mytag:NoImg />
				</c:forEach>
			</c:if>
		</div> 	
<!--========================================��ǰ īŻ�α� ��==========================================-->
	</div>
</body>
</html>