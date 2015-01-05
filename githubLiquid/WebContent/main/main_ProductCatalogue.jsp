<%
 /***********************************************************************
  * �۾��� : �̽¿� 
  * �۾����� : 2014.11.06(update)
  * � ���Ͽ� ȣ��޴°� : main.jsp
  * � ������ ȣ���ϴ°� : ��ǰ�̹���,��ǰ��,��ǰ������ ��ŷ������, �� ��ǰ�� ��������.jsp 
  * ���� Ÿ�� : ��ǰ
  * 14.11.21 ~ 14.11.22_�̽¿� : table���� div/css�� ���� 
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
<!--=======================================��ǰ īŻ�α� �ΰ� ����==========================================-->			
	<div class="main-content-catalogue-logo" >
			<span class="glyphicon glyphicon-fire"></span>Hot Item<hr>
	</div>
<!--=======================================��ǰ īŻ�α� �ΰ� ��==========================================-->
<!--========================================��ǰ īŻ�α� ����==========================================-->
		<div class="main-content-catalogue-content ">  
			<!-- ǥ���� ��ǰ�� ���� �� -->			
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
						<li class="price"><a href="productDetail.do?product_no=${list.getNo()}"><font color="red">${list.getPrice()} ��</font></a></li>
				
				</c:if>
				</ul>
			</c:forEach>
			<!-- ǥ���� ��ǰ�� 8������ ������ -->
			<c:if test="${productCatalogueList.size() < 8}">
				<c:forEach var="i" begin="1" end="${8-productCatalogueList.size()}">
					<mytag:NoImg />
				</c:forEach>
			</c:if>
			<!-- ǥ���� ��ǰ�� ���� �� -->
			<c:if test="${productCatalogueList.size() == 0}">
				<c:forEach var="i" begin="1" end="8">
					<mytag:NoImg />
				</c:forEach>
			</c:if>
		</div> 	
<!--========================================��ǰ īŻ�α� ��==========================================-->
	</div>
</body>
</html>