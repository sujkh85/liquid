<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="./css/order.css" type="text/css"> 
<title>��Ϻ���</title>
</head>
<body>
<div align="center">
	<h1>�ֹ� ����Ʈ</h1>
	<hr>
		<table border="1" >
		<tr align="center">
				<td>��ǰ �̹���</td>
				<td>�ֹ�����</td>
				<td>��ǰ��</td>
				<td>��ǰ����</td>
				<td>�ֹ�����</td>
				<td>�ֹ���Ȳ</td>
				<td>���� ���</td>
				<td>�����Ȳ</td>
				<td>����ּ�</td>
				<td>��۸޽���</td>
				<td>������ȣ</td>
				
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="productDetail.do?product_no=${dto.product_no}"><img src="${dto.product_imgsrc1}" width="100"></a></td>
				<td align="center">${dto.order_date}</td>
				<td width="150" align="center">
				<a href="productDetail.do?product_no=${dto.product_no}">
				${dto.product_name}</a></td>
				<td align="center">${dto.product_price}</td>
				<td align="center">${dto.order_detail_quantity}</td>
				<td align="center">${dto.order_paystatus}</td>
				<td align="center">${dto.order_payment}</td>
				<td align="center">${dto.order_paystatus}</td>
				<td align="center">${dto.order_address}</td>
				<td align="center">${dto.order_message}</td>
				<td align="center">${dto.order_waybillno}</td>
			</tr>
		</c:forEach>
		</table>
</div>
</body>
</html>