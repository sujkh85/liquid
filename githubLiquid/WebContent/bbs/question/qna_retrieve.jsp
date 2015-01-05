<!--
/***********************************************************************
 * �۾��� : ������
 * �۾����� : 2014.11.03~10
 * � ���Ͽ� ȣ��޴°� : qna_detail.jsp
 * � ������ ȣ���ϴ°� : qna_listPage.jsp
 * ���� Ÿ�� :
 ***********************************************************************/
  --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� �ڼ��� ����</title>
<link rel="stylesheet" href="./css/table.css" type="text/css"> 
</head>
<body> 
<%
String mode = request.getParameter("mode");
if("manager".equals(mode)){
%>
<div align="center">
<h1> <span class="glyphicon glyphicon-pencil"></span> �� �����ϱ�</h1>
<form action="manager_qna_update.do?mode=manager" method="post">
	<input type="hidden" name="board_question_no" value="${retrieve.board_question_no}">
		<table width="600" border="1" align="center" class="ex1">
		<thead>
		<tbody>
		<tr class="menu0"> 
			<td align="right" colspan="2">�۹�ȣ:${retrieve.board_question_no} &nbsp;&nbsp;&nbsp;&nbsp; ��ȸ�� : ${retrieve.board_question_viewcount}</td>
		</tr>
		<tr class="menu0">
			<td width="130">����</td>
			<td><input type="text" size="100" name="board_question_title" value="${retrieve.board_question_title}"></td>
		</tr>
		<tr class="menu0">
			<td>�ۼ���</td>
			<td>${s_member_info_nickname}
				<input type="hidden" name="member_info_no" value="${s_member_info_no}">
			</td>
		</tr>
		<tr class="menu0">
			<td>����</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr>
		<%-- <tr class="menu0">
			<td>÷������</td>
			<td>���� ���� : ${retrieve.board_question_imgsrc1} <br>
			<input type="file" size="100" name="board_question_imgsrc1" value="${retrieve.board_question_imgsrc1}">
			</td>
		</tr>
		<tr class="menu0">
			<td>����</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr>
		<tr class="menu0">
			<td>����</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr>
		<tr class="menu0">
			<td>����</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr>
		<tr class="menu0">
			<td>����</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr> --%>
		<tr>
			<td colspan="2">
			
			<input type="submit"  class="btn btn-info"  value="�����ϱ�">
			<a href="manager_qna_delete.do?mode=manager&board_question_no=${retrieve.board_question_no}"><button class="btn btn-info"  type="button">�����ϱ�</button></a>
			
			<!-- 	(String)session.getAttrute("member_info_no") == request.getparameter("member_info_no")
			 -->
			<div align="right">
			<!-- <input type="reset" class="btn btn-info" value="�ٽþ���"> -->
			<a href="manager_qna_list.do?mode=manager"><button class="btn btn-info"  type="button">��Ϻ���</button></a>
			</div></td>
		</tr>
		</tbody>
		</thead>
		</table>
	</form>

</div>

<%}else{ %>				
<body>
<div align="center">
<h1>�� �����ϱ�</h1>
<form action="qna_update.do" method="post">
	<input type="hidden" name="board_question_no" value="${retrieve.board_question_no}">
		<table width="600" border="1" align="center" class="ex1">
		<thead>
		<tbody>
		<tr class="menu0">
			<td align="right" colspan="2">�۹�ȣ:${retrieve.board_question_no} &nbsp;&nbsp;&nbsp;&nbsp; ��ȸ�� : ${retrieve.board_question_viewcount}</td>
		</tr>
		<tr class="menu0">
			<td width="130">����</td>
			<td><input type="text" size="100" name="board_question_title" value="${retrieve.board_question_title}"></td>
		</tr>
		<tr class="menu0">
			<td>�ۼ���</td>
			<td>${s_member_info_nickname}
				<input type="hidden" name="member_info_no" value="${s_member_info_no}">
			</td>
		</tr>
		<tr class="menu0">
			<td>����</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			
			<input class="btn btn-info" type="submit" value="�����ϱ�">
			<a href="qna_delete.do?board_question_no=${retrieve.board_question_no}"><button class="btn btn-info" type="button">�����ϱ�</button></a>
			
			<!-- 	(String)session.getAttrute("member_info_no") == request.getparameter("member_info_no")
					// ������ member_info_no�� s_member_info_no�� ���������Ƿ� jstl�� ����� �� �ֽ��ϴ� 
			 -->
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