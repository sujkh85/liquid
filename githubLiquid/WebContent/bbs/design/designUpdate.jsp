<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 자세히 보기</title>
<link rel="stylesheet" href="./css/table.css" type="text/css"> 
</head>
<%-- <%
String mode = request.getParameter("mode");
if("manager".equals(mode)){
%>
<body> 
<div align="center">
<h1>글 수정하기</h1>
<form action="manager_qna_update.do" method="post">
	<input type="hidden" name="board_userdesign_no" value="${retrieve.board_userdesign_no}">
		<table width="600" border="1" align="center" class="ex1">
		<thead>
		<tbody>
		<tr class="menu0">
			<td align="right" colspan="2">글번호:${retrieve.board_userdesign_no} &nbsp;&nbsp;&nbsp;&nbsp; 조회수 : ${retrieve.board_userdesign_viewcount}</td>
		</tr>
		<tr class="menu0">
			<td width="70">제목</td>
			<td><input type="text" name="board_userdesign_title" value="${retrieve.board_userdesign_title}"></td>
		</tr>
		<tr class="menu0">
			<td>작성자</td>
			<td>${s_member_info_nickname}
				<input type="hidden" name="member_info_no" value="${s_member_info_no}">
			</td>
		</tr>
		<tr class="menu0">
			<td>내용</td>
			<td><textarea name="board_userdesign_content" cols="80" rows="25">${retrieve.board_userdesign_content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			
			<input type="submit" value="수정하기">
			<a href="manager_qna_delete.do?board_userdesign_no=${retrieve.board_userdesign_no}"><button type="button">삭제하기</button></a>
			
			<!-- 	(String)session.getAttrute("member_info_no") == request.getparameter("member_info_no")
			 -->
			<div align="right">
			<input type="reset" value="다시쓰기">
			<a href="manager_qna_list.do"><button type="button">목록보기</button></a>
			</div></td>
		</tr>
		</tbody>
		</thead>
		</table>
	</form>

</div>

<%}else{ %>		 --%>		
<body>
<div align="center">
<h1>글 수정하기</h1>
<form action="designUpdate.do" method="post">
	<input type="hidden" name="board_userdesign_no" value="${retrieve.board_userdesign_no}">
		<table  width="600" border="1" align="center" class="ex1">
		<thead>
		<tbody>
		<tr class="menu0">
			<td align="right" colspan="2">글번호:${retrieve.board_userdesign_no} &nbsp;&nbsp;&nbsp;&nbsp; 조회수 : ${retrieve.board_userdesign_viewcount}</td>
		</tr>
		<tr class="menu0">
			<td width="70">제목</td>
			<td><input type="text" name="board_userdesign_title" value="${retrieve.board_userdesign_title}"></td>
		</tr>
		<tr class="menu0">
			<td>작성자</td>
			<td>${s_member_info_nickname}
				<input type="hidden" name="member_info_no" value="${s_member_info_no}">
			</td>
		</tr>
		<tr class="menu0">
			<td>내용</td>
			<td><textarea name="board_userdesign_content" cols="80" rows="25">${retrieve.board_userdesign_content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			
			<input class="btn btn-primary" type="submit" value="수정하기">
			<a href="designDelete.do?board_userdesign_no=${retrieve.board_userdesign_no}"><button class="btn btn-success" type="button">삭제하기</button></a>
			
			<div align="right">
			<input class="btn btn-primary" type="reset" value="다시쓰기">
			<a href="designList.do"><button  class="btn btn-success" type="button">목록보기</button></a>
			</div></td>
		</tr>
		</tbody>
		</thead>
		</table>
	</form>

</div> 

<%-- <%} %>	 --%>		

</body>
</html>
