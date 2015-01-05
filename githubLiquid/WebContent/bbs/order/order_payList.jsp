<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ����Ʈ</title>
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<script type="text/javascript">
 function payGo(){
      $('#order').attr("method","post");
      $('#order').attr("action","order_payment.do");
      $('#order').submit();
   }
</script>
</head>
<body>
<div align="center">
	<h1>�ֹ� ����Ʈ</h1>
	<hr>
		<form id="order">
		<table border="1" >
			<tr align="center">
				<td>��ǰ �̹���</td>
				<td>�ֹ�����</td>
				<td>��ǰ��</td>
				<td>��ǰ����</td>
				<td>�ֹ�����</td>
				<td>�ֹ���Ȳ</td>
				<td>���� ���</td>
				<td>����ּ�</td>
				<td>��۸޽���</td>
				<td>������ȣ</td>
				<td>��������</td>
			</tr>
		<c:forEach items="${orderPayList}" var="dto">
			<tr>
				<td><a href="productDetail.do?product_no=${dto.product_no}"><img src="${dto.product_imgsrc1}" width="100"></a></td>
				<td align="center">${dto.order_date}</td>
				<td width="150" align="center">
				<a href="productDetail.do?product_no=${dto.product_no}">
				${dto.product_name}</a></td>
				<td align="center">${dto.product_price}</td>
				<td align="center">${dto.order_detail_quantity}</td>
					<td>
				<c:choose>
				<c:when test="${dto.order_paystatus=='�Աݴ��'}">
				�ֹ��Ϸ�
				</c:when>
				<c:otherwise>
							${dto.order_paystatus}
				</c:otherwise>
				</c:choose>
				</td>
				<td align="center">${dto.order_payment}</td>
				<td align="center">${dto.order_address}</td>
				<td align="center">${dto.order_message}</td>
				<td align="center">${dto.order_waybillno}</td>
				<td align="center"> 
					<input type="hidden" name="order_no" value="${dto.order_no}" >
					<input type="hidden" name="order_money" value="${dto.product_price*dto.order_detail_quantity}" >
					<input type="button" value="�����ϱ�" onclick="payGo()"></td>
			</tr>
		</c:forEach>
		</table>
		</form>
	</div>
</body>
</html>