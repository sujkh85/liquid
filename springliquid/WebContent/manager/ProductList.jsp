<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * ������ �뵵 : ��ǰ��� ������ ������
 ***********************************************************************/
 -->       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="product_list" align="center">
<h2>��ǰ ��ü ����</h2>
<hr>
<div id="search">
	<form action="manager_productlist.do">
	<select name="search">
		<option value="��ǰ��">��ǰ��</option>
		<option value="��ǰ��ȣ">��ǰ��ȣ</option>
	</select>
	<input type="text" name="product_name">
	<input type="submit" value="�˻�" >
	</form>
</div>
<p>
		<table border="1" align="center" width="1000">
		<tr align="center" bgcolor="gray" >
				<td>��ǰ ��ȣ</td>
				<td>��ǰ��</td>
				<td>��ǰ �з�</td>
				<td>������</td>
				<td>��� ����</td>
				<td>���� ����</td>
				<td>�Ǹ� ����</td>			
				<td>��� ����</td>	
				<td>����</td>		
				
		</tr>

		<c:forEach items="${list}" var="dto">
			<tr onmouseover="this.style.backgroundColor='gray'" onMouseOut="this.style.backgroundColor='white'">
				<td align="center">${dto.product_no}</td>
				<td align="center">${dto.product_name}</td>
				<td align="center">${dto.product_type_name}</td>
				<td align="center">${dto.stock_size}</td>
				<td align="center">${dto.stock_quantity}</td>
				<td align="center">${dto.product_cost}</td>
				<td align="center">${dto.product_price}</td>
				<td align="center">${dto.product_date}</td>	
				<td align="center">
				<input type="button" value="�󼼺���" onclick="javascript:location.href='manager_productDetail.do?product_no=${dto.product_no}'">
				</td>			
			</tr>
		</c:forEach>
			<tr>
				<td colspan="9">${pg }</td>
			</tr>
		</table>
</div>
<p>
</body>
</html>