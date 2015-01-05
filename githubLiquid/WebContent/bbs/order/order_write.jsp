<%@page import="java.util.ArrayList"%>
<%@page import="com.order.OrderDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="./css/order.css" type="text/css">
<title>�ֹ��ϱ�</title>
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script> 
<script type="text/JavaScript"> 
function openDaumPostcode() {  
	new daum.Postcode({
		oncomplete: function(data){
			document.getElementById('order_post1').value = data.postcode1; 
			document.getElementById('order_post2').value = data.postcode2; 
			document.getElementById('order_address1').value = data.address; 
			document.getElementById('order_address2').focus();
		}
	}).open();  
}	
	$(document).ready(function(){
		hide();
		
		function hide(){
		$("#new_order").hide();
		$("#member_order").hide();
		}
		$("#chk").click(new_order);
		$("#chk1").click(member_order);
	});
		function new_order(){
			$("#new_order").show();
			$("#member_order").hide();
		}
		
		function member_order(){
			$("#member_order").show();
			$("#new_order").hide();
		}
</script>
</head>
<body>
<c:choose>
<c:when test="${s_member_info_no == null}">
	<div align="center">
		<font color="red">�α��� �� �̿� �����մϴ�</font>
	</div>
	<jsp:include page="/member/memberLoginForm.jsp"></jsp:include>
</c:when>
<c:otherwise>
<div align="center">
<hr><h4>�ֹ��ϱ�</h4>

<div>
	<table border="1" align="center">
		<tr>
			<td>��ǰ�̹���</td>
			<td>��ǰ��</td>
			<td>��ǰ����</td>
			<td>�ֹ�����</td>
			<td>�� ����</td>
		</tr>
		<tr>
			<td><img src="${order_detail.product_imgsrc1}" width="150"></td>
			<td>${order_detail.product_name}</td>
			<td>${order_detail.product_price}</td>
			<td>${order_detail.order_detail_quantity}</td>
			<td>${order_detail.product_price*order_detail.order_detail_quantity}</td> 
		</tr>
	</table>
</div>
<div align="center">
<hr><h4>�ֹ��� ����</h4>
	<table border="1" align="center">
		<tr>
		<td>�̸� :</td>
		<td><input type="text" value="${orderMember.member_info_name}" size="10"></td>
		</tr>
		<tr>
		<td>����ó :</td>
		<td><input type="text" value="${orderMember.member_info_phone}" size="20"></td>
		</tr>
		<tr>
		<td>�ּ�</td>
		<td colspan="3">
		<input type="text" value="${orderMember.member_info_post1}" size="5" maxlength="4" > -
		<input type="text" value="${orderMember.member_info_post2}" size="5" maxlength="4" ><br>
        <input type="text" value="${orderMember.member_info_address1}" size="80" maxlength="100" ><br>
        <input type="text" value="${orderMember.member_info_address2}" size="80" maxlength="80">
		</td>
		</tr>
	</table><br>
	<input type="button" align="center" name="chk1" id="chk1" onClick="member_order()" value="��������� �ֹ��� ������ ��ġ" />&nbsp;
	<input type="button" align="center" name="chk" id="chk" onClick="new_order()" value="�� ������� �Է�" />

<form action="order_insert.do">
	<input type="hidden" name="product_price" value="${order_detail.product_price}" />
	<input type="hidden" name="order_detail_quantity" value="${order_detail.order_detail_quantity}" /> 
	<input type="hidden" name="product_no" value="${order_detail.product_no}" /> 
	<input type="hidden" name="stock_no" value="${order_detail.stock_no}" /> 
<div id="new_order">
	<hr><h4>��� ���� �Է�</h4>
	<table border="1" align="center">
		<tr>
			<td>�̸� :</td>
			<td><input type="text" name="order_name" size="10"></td>
		</tr>
		<tr>
			<td>����ó :</td>
			<td><input type="text" name="order_tel" size="20"></td>
		</tr>
	<tr>
		<td>�ּ��Է�</td>
		<td colspan="2">
		<input type="text" id="order_post1" name="order_post1" size="5" maxlength="4" > -
		<input type="text" id="order_post2" name="order_post2" size="5" maxlength="4" >
        <input type="button" value="�����ȣ �˻�" onClick="openDaumPostcode()"><br>
        <input type="text" id="order_address1" name="order_address1" size="80" maxlength="100" ><br>
        <input type="text" id="order_address2" name="order_address2" size="80" maxlength="80">
		</td>
	</tr>
		<tr>
			<td>��� �޽��� :</td>
			<td><input type="text" name="order_message" size="40"></td>
		</tr>
		<tr>
			<td>���� ��� :</td>
			<td>
			<select name="order_payment">
				<option value="no">��������� �������ּ���</option>
				<option value="�ſ�ī��">�ſ�ī��</option>
				<option value="�������Ա�">�������Ա�</option>
				<option value="�ڵ�������">�ڵ�������</option>
			</select>
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" value="�����ܰ��">&nbsp;<input type="reset" value="�ٽ��ۼ�">
	</div>
</form>

<form action="order_insert.do">
	<input type="hidden" name="product_price" value="${order_detail.product_price}" />
	<input type="hidden" name="order_detail_quantity" value="${order_detail.order_detail_quantity}" /> 
	<input type="hidden" name="product_no" value="${order_detail.product_no}" /> 
	<input type="hidden" name="stock_no" value="${order_detail.stock_no}" /> 
<div id="member_order">
	<hr><h4>��� ���� �Է�</h4>
	<table border="1" align="center">
		<tr>
			<td>�̸� :</td>
			<td><input type="text" name="order_name" size="10" value="${orderMember.member_info_name}"></td>
		</tr>
		<tr>
			<td>����ó :</td>
			<td><input type="text" name="order_tel" size="20" value="${orderMember.member_info_phone}"></td>
		</tr>
	<tr>
		<td>�ּ��Է�</td>
		<td colspan="2">
		<input type="text" id="order_post1" name="order_post1" size="5" maxlength="4" value="${orderMember.member_info_post1}" > -
		<input type="text" id="order_post2" name="order_post2" size="5" maxlength="4" value="${orderMember.member_info_post2}" ><br>
        <input type="text" id="order_address1" name="order_address1" size="80" maxlength="100" value="${orderMember.member_info_address1}" ><br>
        <input type="text" id="order_address2" name="order_address2" size="80" maxlength="80" value="${orderMember.member_info_address2}">
		</td>
	</tr>
		<tr>
			<td>��� �޽��� :</td>
			<td><input type="text" name="order_message" size="40"></td>
		</tr>
		<tr>
			<td>���� ��� :</td>
			<td>
			<select name="order_payment">
				<option value="no">��������� �������ּ���</option>
				<option value="�ſ�ī��">�ſ�ī��</option>
				<option value="�������Ա�">�������Ա�</option>
				<option value="�ڵ�������">�ڵ�������</option>
			</select>
			</td>
		</tr>
	</table>
	<br>
<input type="submit" value="�����ܰ��">&nbsp;<input type="reset" value="�ٽ��ۼ�">
</div>
</form>
</c:otherwise>
</c:choose>
</body>
</html>