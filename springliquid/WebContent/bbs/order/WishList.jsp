<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>   
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 2014.11.08
 * �������� : 2014.11.18 (�ּ��߰�)
 * � ���Ͽ� ȣ��޴°� : Index.jsp
 * � ������ ȣ���ϴ°� : WishList_Product.jsp 
 * Ŭ���� �뵵 : request��ü���� list���� �����ͼ� ȭ�鿡 �ѷ���,�ѱ��ž׵� ����..
 * ���� Ÿ�� : WishListƲ
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
		<font color="red">�α��� �� �̿� �����մϴ�</font>
	</div>
	<jsp:include page="/member/memberLoginForm.jsp"></jsp:include>
</c:when>
<c:when test="${list.size()>0 }">
	<table border="1" align="center" class="ex1">
	<thead>
	<tbody>
			<tr align="center" bgcolor="pink">
				<td>��ǰ �̹���</td>
				<td>��ǰ��</td>
				<td>��ǰ ����</td>
				<td>��ǰ ����</td>
			</tr>
		<c:forEach items="${list }" var="wishList">
		<tr>
			<td><img src="${wishList.product_imgsrc1}" width="200"></td>
			<td><a href= "productDetail.do?product_no=${wishList.product_no}" >${wishList.product_name}</a></td>
            <td align="center"><font color="red">${wishList.product_price}</font></td>
            <td>
            	<input type="hidden" name="wishlist_no" value="${wishList.wishlist_no}">
            	<input type="button" onclick="location.href='wishlist_delete.do?wishlist_no=${wishList.wishlist_no }'" value="�����ϱ�">
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</thead>
	</table>
</c:when>
      <c:otherwise>
      	���ø���Ʈ�� ��� ��ǰ�� �����ϴ�.
      </c:otherwise>
</c:choose>
</body>
</html> 