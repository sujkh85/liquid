<!--
/***********************************************************************
 * �۾��� : ������
 * �۾����� : 2014.11.03~10
 * � ���Ͽ� ȣ��޴°� : qna_detail.jsp 
 * � ������ ȣ���ϴ°� : qna_listPage.jsp
 * ���� Ÿ�� : qna�Խ��� ���� ��ǰ..
 ***********************************************************************/
  -->    

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�亯�� ���� ȭ��</title>
<link rel="stylesheet" href="./css/table.css" type="text/css"> 
</head>
<body> 

<%
String mode = request.getParameter("mode");
if("manager".equals(mode)){
%>

<div align="center">
<h1> <span class="glyphicon glyphicon-pencil"></span> �亯�� ���� ȭ��</h1>
	<form action="manager_qna_reply.do?mode=manager" method="post">
	<!-- �亯�� �ʿ�  -->
	<input type="hidden" name="board_question_no" value="${replyui.board_question_no}">
	<input type="hidden" name="board_question_reproot" value="${replyui.board_question_reproot}">
	<input type="hidden" name="board_question_repstep" value="${replyui.board_question_repstep}">
	<input type="hidden" name="board_question_repindent" value="${replyui.board_question_repindent}">
	<input type="hidden" name="board_question_date" value="${replyui.board_question_date}">
 <table width="600" border="1" align="center" class="ex1">
	<thead>
	<tbody>
	<tr class="menu0">
		<td align="right" colspan="2">�����۹�ȣ${replyui.board_question_no}&nbsp; ��ȸ��${replyui.board_question_viewcount}</td>
	</tr>
	<tr class="menu0">
		<td width="70">����</td>
		<td><input type="text" name="board_question_title" value="->re:${replyui.board_question_title}"></td>
	</tr>
	<tr class="menu0">
		<td>�ۼ���</td>
		<td>${s_member_info_nickname}
			<input type="hidden" name="member_info_no" value="${s_member_info_no }" >
		</td>
	</tr>
	<tr class="menu0">
		<td>����</td>
		<td><textarea name="board_question_content" cols="80" rows="25">${replyui.board_question_content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2"><input class="btn btn-info" type="submit" value="�亯�ޱ�">
		<div align="right">
		<input class="btn btn-info" type="reset" value="�ٽþ���">
		<a href="manager_qna_list.do"><button class="btn btn-info" type="button">��Ϻ���</button></a>
		</div></td>
	</tr>
	</tbody>
	</thead>
	</table>
	</form>
</div>

<%}else{ %>			
<div align="center">
<h1>�亯�� ���� ȭ��</h1>
	<form action="qna_reply.do" method="post">
	<!-- �亯�� �ʿ�  -->
	<input type="hidden" name="board_question_no" value="${replyui.board_question_no}">
	<input type="hidden" name="board_question_reproot" value="${replyui.board_question_reproot}">
	<input type="hidden" name="board_question_repstep" value="${replyui.board_question_repstep}">
	<input type="hidden" name="board_question_repindent" value="${replyui.board_question_repindent}">
	<input type="hidden" name="board_question_date" value="${replyui.board_question_date}">
	<table width="600" border="1" align="center" class="ex1">
	<thead>
	<tbody>
	<tr class="menu0">
		<td align="right" colspan="2">�����۹�ȣ${replyui.board_question_no}&nbsp; ��ȸ��${replyui.board_question_viewcount}</td>
	</tr>
	<tr class="menu0">
		<td width="70">����</td>
		<td><input type="text" name="board_question_title" value="->re:${replyui.board_question_title}"></td>
	</tr>
	<tr class="menu0">
		<td>�ۼ���</td>
		<td>${s_member_info_nickname}
			<input type="hidden" name="member_info_no" value="${s_member_info_no }" >
		</td>
	</tr>
	<tr class="menu0">
		<td>����</td>
		<td><textarea name="board_question_content" cols="80" rows="25">${replyui.board_question_content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2"><input class="btn btn-info" type="submit" value="�亯�ޱ�">
		<div align="right">
		<input class="btn btn-info" type="reset" value="�ٽþ���">
		<a href="qna_list.do"><button class="btn btn-info" type="button">��Ϻ���</button></a>
		</div></td>
	</tr>
	</tbody>
	</thead>
	</table>
	</form>
</div>			
			
<%} %>			

</body>
</html>