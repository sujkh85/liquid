<!--
/***********************************************************************
 * �۾��� : �̹�ȭ , �ֽ�ȯ
 * �۾����� : 2014.11.03~07 , 2014.12.04~
 * � ���Ͽ� ȣ��޴°� :  notice_list.jsp
 * � ������ ȣ���ϴ°� :  notice_listPage.jsp,notice_write.jsp,notice_retrievetest.jsp
 * ���� Ÿ�� : Ʋ
 * �۾����� : �ֽ�ȯ ǥ ������ ������
 ***********************************************************************/
  -->  
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�۾���</title>
<link rel="stylesheet" href="./css/table.css" type="text/css">
</head>
<body>
<%
String mode = request.getParameter("mode");
if("manager".equals(mode)){ 
%>	
	<h1 align="center"> <span class="glyphicon glyphicon-flag"></span> �������� �ۼ�</h1>
	<hr>
	<form action="manager_notice_write.do?mode=manager" method="post" enctype="multipart/form-data">
	<div align="center">
	<table class="ex1" border="1" cellspacing="0" cellpadding="20" align="center">
    <colgroup>
  <col width = "130px" />
  <col width = "500px" />
 	</colgroup> 
	<tbody>
	<thead>
		<tr class="menu0">
			<td class="date2">���� : </td>
			<td><input type="text" name="board_notice_title" size=130 maxlength=200 autofocus></td>
		</tr>
		<tr class="menu0">
			<td class="date2">�ۼ��� : </td>
			<td>${s_member_info_nickname}</td>
		<tr class="menu4">
			<td class="date2">���� : </td>
			<td><textarea name="board_notice_content" cols=110 rows=25></textarea></td>
		</tr>
	</thead>	
	</tbody>		
		<tr>
			<td class="date1" colspan="2">÷������1 : <input type="file" name="board_notice_imgsrc1" ><br></td>
		</tr>
		<tr>
			<td class="date1" colspan="2">÷������2 : <input type="file" name="board_notice_imgsrc2" ><br></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
		<input class="btn btn-info" type="submit" value="����">
			<a href="manager_notice_list.do?mode=manager"><button type="button" class="btn btn-info">��Ϻ���</button></a>
		
		</td>
		</tr>
	</table>
	</div>
	</form>

<%}else{ %>

<h1 align="center"> <span class="glyphicon glyphicon-flag"></span> �������� �ۼ�</h1>
	<hr>
	<form action="notice_write.do" method="post" enctype="multipart/form-data">
	<div align="center">
	<table class="ex1" border="1" cellspacing="0" cellpadding="20" align="center">
    <colgroup>
  <col width = "130px" />
  <col width = "500px" />
 	</colgroup> 
	<tbody>
	<thead>
		<tr class="menu0">
			<td class="date2">���� : </td>
			<td><input type="text" name="board_notice_title" size=130 maxlength=200 autofocus></td>
		</tr>
		<tr class="menu0">
			<td class="date2">�ۼ��� : </td>
			<td>${s_member_info_nickname}</td>
		<tr class="menu4">
			<td class="date2">���� : </td>
			<td><textarea name="board_notice_content" cols=110 rows=25></textarea></td>
		</tr>
	</thead>	
	</tbody>		
		<tr>
			<td class="date1" colspan="2">÷������1 : <input type="file" name="board_notice_imgsrc1" ><br></td>
		</tr>
		<tr>
			<td class="date1" colspan="2">÷������2 : <input type="file" name="board_notice_imgsrc2" ><br></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
		<input class="btn btn-info" type="submit" value="����">
				<a href="notice_list.do"><button type="button" class="btn btn-info">��Ϻ���</button></a>
		
		</td>
		</tr>
	</table>
	</div>
	</form>

<%} %>

</body>
</html> 