<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table border="1" >
			<tr align="center">
				<td>��ǰ �̹���</td>
				<td>�ֹ�����</td>
				<td width="15%">��ǰ��</td>
				<td width="10%">��ǰ����</td>
				<td width="5%">�ֹ�����</td>
				<td width="10%">�ֹ�����</td>
				<td>�ֹ���Ȳ</td>
				<td>���� ���</td>
				<td>����ּ�</td>
				<td>��۸޽���</td>
				<td>������ȣ</td>
			</tr>
		<c:forEach items="${orderDetailInfo}" var="dto">
			<tr>
				<td><a href="productDetail.do?product_no=${dto.product_no}"><img src="${dto.product_imgsrc1}" width="100"></a></td>
				<td align="center">${dto.order_date}</td>
				<td width="150" align="center">
				<a href="productDetail.do?product_no=${dto.product_no}">${dto.product_name}<br>(������ : ${dto.stock_size})</a></td>
				<td align="center">${dto.product_price}</td>
				<td align="center">${dto.order_detail_quantity}</td>
				<td align="center">${dto.product_price*dto.order_detail_quantity}</td>
				<td align="center">
							<c:choose>
							<c:when test="${dto.order_paystatus== '��۴��'}">
								�����Ϸ�
							</c:when>
							<c:otherwise>
								${dto.order_paystatus}
							</c:otherwise>
						</c:choose>
				</td>
				<td align="center">${dto.order_payment}</td>
				<td align="center">${dto.order_address1}${dto.order_address2}</td>
				<td align="center">${dto.order_message}</td>
				<td align="center">${dto.order_waybillno}</td>
			</tr>
		</c:forEach>
</table>
<br>
<div align="center">
<input type="button" value="��ϵ��ư���" onClick="location.href='order_list.do?'">
</div>
</body>
</html>