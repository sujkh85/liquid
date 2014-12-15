<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="./css/order.css" type="text/css"> 
<title>��Ϻ���</title>
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
</head>
<body>
<!-- ��ȸ�� ���ٽ� �α��� �� �����ֱ�  -->
<c:if test="${s_member_info_no  == null}">
	<div align="center">
		<font color="red">�α��� �� �̿� �����մϴ�</font>
	</div>
	<jsp:include page="/member/memberLoginForm.jsp"></jsp:include>
</c:if>

<!-- ȸ���� ���� -->
<c:if test="${orderList.size() > 0 }">
<div align="center">
	<h1><span class="glyphicon glyphicon-shopping-cart"> �ֹ�����Ʈ</h1>
	<hr>
<form id="order">
		<table border="1" >
			<tr align="center">
				<td>��ǰ �̹���</td>
				<td>�ֹ�����</td>
				<td width="15%">��ǰ��</td>
				<td width="10%">��ǰ����</td>
				<td width="5%">�ֹ�����</td>
				<td width="10%">�ֹ�����</td>
				<td>��ۻ���</td>
			</tr>
		<c:forEach items="${orderList}" var="dto">
			<tr>
				<td width="150"><a href="productDetail.do?product_no=${dto.product_no}"><img src="${dto.product_imgsrc1}" width="150"></a></td>
				<td align="center">${dto.order_date}<br><br><input type="button" value="�ֹ��󼼺���" onClick="location.href='orderDetailInfo.do?order_no=${dto.order_no}'"></td>
				<td width="150" align="center">
				<a href="productDetail.do?product_no=${dto.product_no}">${dto.product_name}</a></td>
				<td align="center">${dto.product_price}</td>
				<td align="center">${dto.order_detail_quantity}</td>
				<td align="center">${dto.product_price*dto.order_detail_quantity}</td>
				<td align="center">
						<c:choose>
							<c:when test="${dto.order_cancel == 'Y'}">
								�ֹ� ��ҵ� ��ǰ�Դϴ�
							</c:when>
							<c:when test="${dto.order_paystatus== '�Աݴ��'}">
							�ֹ��Ϸ�<br><br>
							<input type="button" onclick="location.href='order_payment.do?order_no=${dto.order_no}&order_money=${dto.product_price*dto.order_detail_quantity}'" value="�����ϱ�">
							&nbsp;<input type="button" value="�ֹ����" onclick="location.href='order_delete.do?order_no=${dto.order_no}&stock_no=${dto.stock_no}'">
							</c:when>

							<c:otherwise>
								${dto.order_paystatus}
								<br><br><input type="button" value="�ֹ����" onclick="location.href='order_delete.do?order_no=${dto.order_no}&stock_no=${dto.stock_no}'">
							</c:otherwise>
						</c:choose>
				</td>
			</tr>
		</c:forEach>
		</table>
</form>
	</div>
</c:if>
</body>
</html>