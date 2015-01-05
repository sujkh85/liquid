
<!--
/***********************************************************************
 * �۾��� : ������
 * �۾����� : 2014.11.03~10
 * � ���Ͽ� ȣ��޴°� : main_top.jsp
 * � ������ ȣ���ϴ°� : qna_detail.jsp, qna_write.jsp
 * 11/18�� ����
 * �α����� �Ǿ��־��(member_info_no != null) �۾��� ��ư�� Ȱ��ȭ �ǵ��� ����
 ***********************************************************************/
  --> 
    
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="./css/table.css" type="text/css"> 
<title>��Ϻ���</title>
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
<!-- ������ �Խ��� Q&A -->
	<h1 align="center"> <span class="glyphicon glyphicon-pencil"></span> Q&A</h1> 
	<hr>
	<div align="center">
	<table class="ex1" border="0" align="center" width="650">
		<thead>
			<tr>
				<td colspan="5">
					<form action="manager_qna_search.do?mode=manager">
						<select name="searchName" size="1">
							<option value="member_info_nickname">�ۼ���</option>
							<option value="board_question_title">������</option>
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
			<input type="hidden" name="member_info_no" value="${dto.member_info_no }">
		<tbody>	
			<tr class="data" >
				<td>${dto.board_question_no}</td>
				<td align="left">
			<c:choose>
				<c:when test="${dto.board_question_repindent != 0}">
					<c:forEach begin="1" end="${dto.board_question_repindent}">
						 <img src="./img/icon_faq2.png"/> 
					</c:forEach>
				</c:when> 
				<c:otherwise>
						  <img src="./img/icon_faq.png" />
				</c:otherwise>
			</c:choose>
				<a href="manager_qna_detail.do?mode=manager&board_question_no=${dto.board_question_no}">${dto.board_question_title}</a></td>		
				<td>${dto.member_info_no_nickname}</td>
				<td>${dto.board_question_date}</td>
				<td>${dto.board_question_viewcount}</td>	
			</tr>
			</c:forEach>
		</tbody>	
			<!-- page -->
		<tfoot>	
			<tr>
				<td colspan="5"><div align="left" id="pageView">${pg}</div>
	<div align="center">
	<c:choose>
	<c:when test="${s_member_info_no != null}">
		<a href="manager_qna_writeui.do?mode=manager"><button type="button" class="btn btn-info">�۾���</button></a>
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
	<h1 align="center"> <span class="glyphicon glyphicon-pencil"></span>  Q&A</h1> 
	<hr>
	<div align="center">
	<table class="ex1" border="0" align="center" width="650">
		<thead>	
			<tr>
				<td colspan="5">
					<form action="qna_search.do">
						<select name="searchName" size="1">
							<option value="member_info_nickname">�ۼ���</option>
							<option value="board_question_title">������</option>
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
			<input type="hidden" name="member_info_no" value="${dto.member_info_no }">
		<tbody>		
			<tr>
				<td>${dto.board_question_no}</td>
				<td align="left">
				<c:choose>
					<c:when test="${dto.board_question_repindent != 0}">
						<c:forEach begin="1" end="${dto.board_question_repindent}">
						 <img src="./img/icon_faq2.png"/> 
						</c:forEach>
					</c:when> 
					<c:otherwise>
						  <img src="./img/icon_faq.png" />
					</c:otherwise>
				</c:choose>
				<a href="qna_detail.do?board_question_no=${dto.board_question_no}">${dto.board_question_title}</a></td>
				<td>${dto.member_info_no_nickname}</td>
				<td>${dto.board_question_date}</td>
				<td>${dto.board_question_viewcount}</td>	
			</tr>
			</c:forEach>
		</tbody>	 
			<!-- page -->
		<tfoot>		
			<tr>
				<td colspan="5"><div align="left" id="pageView">${pg}</div>
	<div align="center">
	<c:choose>
	<c:when test="${s_member_info_no != null}">
		<a href="qna_writeui.do"><button type="button" class="btn btn-info" >�۾���</button></a>
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

