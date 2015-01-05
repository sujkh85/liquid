<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
/***********************************************************************
 * �۾��� : �̹�ȭ ����ȯ,�ֽ�ȯ 
 * �۾����� : 2014.11.03~07 2014.11.25(JKH)
 * � ���Ͽ� ȣ��޴°� :  notice_list.jsp
 * � ������ ȣ���ϴ°� :  notice_listPage.jsp,notice_write.jsp,notice_retrievetest.jsp
 * ���� Ÿ�� : Ʋ
 * �۾����� : ����ȯ �����ڸ� �������ױ۾����ְ� ����
 		     �ֽ�ȯ ǥ ������ ������
 ***********************************************************************/
  -->  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��Ϻ���</title>
<link rel="stylesheet" href="./css/table.css" type="text/css"> 
</head>
<body>
<%
String mode=request.getParameter("mode");
String member_info_no=request.getParameter("member_info_no");
System.out.println("����Ʈ������������ ���"+mode);
System.out.println("����Ʈ������������ ���̵��ȣ"+member_info_no);
if("manager".equals(mode)){
	
	request.setAttribute("mode",mode);
%>


	<h1 align="center"><span class="glyphicon glyphicon-flag"></span> ��������</h1> 
	<hr>
	<div align="center">
	<table class="ex1" border="0" align="center" width="650">
	<thead>
		<tr>
			<td colspan="5">
		<form action="manager_notice_search.do">
			<select name="searchName" size="1">
				<option value="board_notice_title">������</option>
				<option value="member_info_nickname">�ۼ���</option>
			</select>
			<input type="text" name="searchValue">
			<input type="submit" value="ã��">
			</form>
			</td>
		</tr>
		<tr class="menu">
			<td id="no">��ȣ</td>
			<td id="title">��   ��</td>
			<td id="writer">�ۼ���</td>
			<td id="date">�ۼ���</td>
			<td id="review">��ȸ��</td>
		</tr>
	</thead>	
		<c:forEach items="${list}" var="dto">
	<tbody>
			<tr class="data" >
				<td>${dto.board_notice_no}</td>
				<td align="left"><img src="./img/new1.gif" /><a href="manager_notice_detail.do?mode=manager&board_notice_no=${dto.board_notice_no}">${dto.board_notice_title}</a></td>
				<td>${dto.member_info_nickname}</td>
				<td>${dto.board_notice_date}</td>		
				<td>${dto.board_notice_views}</td>
			</tr>
		</c:forEach>
	</tbody>
		<!-- page -->
	<tfoot>
		<tr>
			<td colspan="5"><div align="left" id="pageView">${pg}
			</div>
	<!-- ȸ������� �����ڸ� �۾��� ��ư�� �����ִ�. -->
	<div align="center">
	<c:choose>
		<c:when test="${s_member_grade_no == '10'}">
			<a href="manager_notice_writeui.do?mode=manager"><button type="button"  class="btn btn-info">�۾��� </button></a>
		</c:when> 
	<c:otherwise>
	</c:otherwise>  
	</c:choose>	
	</div>
	      </td>
		</tr>
	</tfoot>		
	</table>
	</div>
	
	<%}else{ %>	
	
	<h1 align="center"><span class="glyphicon glyphicon-flag"></span> ��������</h1> 
	<hr>
	<div align="center">
	<table class="ex1" border="0" align="center" width="650">
	<thead>
		<tr>
			<td colspan="5">
		<form action="notice_search.do">
			<select name="searchName" size="1">
				<option value="board_notice_title">������</option>
				<option value="member_info_nickname">�ۼ���</option>
			</select>
			<input type="text" name="searchValue">
			<input type="submit" value="ã��">
			</form>
			</td>
		</tr>
		<tr class="menu">
			<td id="no">��ȣ</td>
			<td id="title">��   ��</td>
			<td id="writer">�ۼ���</td>
			<td id="date">�ۼ���</td>
			<td id="review">��ȸ��</td>
		</tr>
	</thead>	
		<c:forEach items="${list}" var="dto">
	<tbody>
			<tr class="data" >
				<td>${dto.board_notice_no}</td>
				<td align="left"><img src="./img/new1.gif" /><a href="notice_detail.do?board_notice_no=${dto.board_notice_no}">${dto.board_notice_title}</a></td>
				<td>${dto.member_info_nickname}</td>
				<td>${dto.board_notice_date}</td>		
				<td>${dto.board_notice_views}</td>
			</tr>
		</c:forEach>
	</tbody>
		<!-- page -->
	<tfoot>
		<tr>
			<td colspan="5"><div align="left" id="pageView">${pg}
			</div>
	<!-- ȸ������� �����ڸ� �۾��� ��ư�� �����ִ�. -->
	<div align="center">
	<c:choose>
		<c:when test="${s_member_grade_no == '10'}">
			<a href="notice_writeui.do"><button type="button"  class="btn btn-info">�۾��� </button></a>
		</c:when> 
	<c:otherwise>
	</c:otherwise>  
	</c:choose>	
	</div>
	      </td>
		</tr>
	</tfoot>		
	</table>
	</div>
	
	
	<%} %>	
</body>
</html> 