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
<title>ȸ���� ����</title>
</head>
<body>
<h3>ȸ���� ����</h3>
<hr>
<div id="d_memberForm" align="center">
<table class="table">
<c:forEach items="${list}" var="dto">
<form id="f_memberForm" name="member_info_form"  action="manager_myinfoform.do?member_info_no=${dto.member_info_no}" method="post">
	<tr>
		<td><h5><strong>ȸ����ȣ</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.member_info_no}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>ȸ�� ��� ��ȣ</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.member_grade_no}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>ȸ�����</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.member_grade_name}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>���̵�</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_id}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>�г���</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_nickname}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>ȸ���̸�</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_name}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>�������</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_birthday}</strong></h5></td>
							
	</tr>
	<tr>
		<td><h5><strong>����</strong></h5></td>						
		<td colspan="2"><h5><strong>${dto.member_info_gender}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>�����ȣ</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_post1}-${dto.member_info_post2}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>�⺻�ּ�</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_address1}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>���ּ�</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_address2}</strong></h5></td>
	</tr>
	<tr>
	<td><h5><strong>��й�ȣ</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_pw}</strong></h5></td>
		
	</tr>
	<tr>
	<td><h5><strong>�̸���</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_id}</strong></h5></td>
		
	</tr>
	<tr>
		<td></td>
		<td colspan="2">
		<input class="btn btn-success" type="submit" value="�����ϱ�" >
		<input class="btn btn-success" type="button" value="���ư���" onclick="location.href='manager_main.do'">
		</td>  
	</tr>
	</c:forEach>
</table>
</form>
</div>
</body>
</html>