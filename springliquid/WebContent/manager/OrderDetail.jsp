<!--
/***********************************************************************
 * �۾��� :  �̽¿� 
 * �۾����� : 2014.11.15~
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� : memberCheck.jsp : �г��� �ߺ��˻��
 * ���� Ÿ�� : Ʋ
 * ��� : ��й�ȣ�� ������ ȸ���������� ����. 
  ***********************************************************************/
  --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script> 
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<title>�ֹ�������</title>
</head>
<body>
<h3>�ֹ�������</h3>
<hr>
<div id="order_detail" align="center">
<table class="table">
<c:forEach items="${list}" var="dto">
	<tr>
		<td><h5><strong>�ֹ���ȣ</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.order_no}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>�ֹ�����</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.order_date}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>�ֹ���</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.member_info_name}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>�ֹ���Ȳ</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.order_paystatus}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>��������</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.order_payment}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>������ȣ</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.order_waybillno}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>�����</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.order_post1}-${dto.order_post2}<p><p>${dto.order_address1 }  ${dto.order_address2 }</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>��۸޼���</strong></h5></td>						
		<td colspan="2"><h5><strong>${dto.order_message}</strong></h5></td>
	</tr>
	<tr>
	<td><h5><strong>�����ݾ�</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.order_final_money}</strong></h5></td>
		
	</tr>
	</c:forEach>
	<tr>
		<td></td>
		<td colspan="2">
		<input class="btn btn-success" type="button" value="���ư���" onclick="location.href='manager_todayorder.do?order_date=0'">
		</td>  
	</tr>
</table>
</div>
</body>
</html>