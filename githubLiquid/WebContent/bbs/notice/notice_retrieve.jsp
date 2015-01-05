<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 자세히 보기</title>
<link rel="stylesheet" href="./css/table.css" type="text/css">
</head>
<body>
<%
String mode = request.getParameter("mode");
if("manager".equals(mode)){
%>
	<h1 align="center">공지사항</h1>
	<hr>
	<form action="manager_notice_update.do?mode=manager" method="post">
		<input type="hidden" name="board_notice_no" value="${retrieve.board_notice_no}">
			글번호: ${retrieve.board_notice_no} &nbsp;&nbsp;&nbsp;&nbsp; 조회수:${retrieve.board_notice_views}<br>
		<div align="center">
		<table class="ex1" border="1" align="center">
		<thead>
		<tbody>
			<tr class="menu3">
			<td align="center">제목 : </td>
			<td><input type="text" size=130 maxlength=30 name="board_notice_title" value="${retrieve.board_notice_title}"></td>
			</tr>
			
			<tr class="menu3">
			<td align="center">작성자 : </td>
			<td align="center">${retrieve.member_info_nickname}</td>
			</tr>
			
			<tr class="menu3">
			<td align="center">내용</td>
			<td><textarea name="board_notice_content" cols=115 rows=10>${retrieve.board_notice_content}</textarea></td>
			<tr><td colspan="2" align="center">
			<input class="btn btn-info" type="submit" value="수정"></td></tr>
		</tbody>
		</thead>		
		</table>
		 </div>
	</form>
	<div align ="center">
		<a href="manager_notice_list.do?mode=manager"><button type="button" class="btn btn-info">목록</button></a>
		<a href="manager_notice_delete.do?mode=manager&board_notice_no=${retrieve.board_notice_no}"><button type="button" class="btn btn-info">삭제</button></a>
	</div>
	
	<%}else{ %>	
	
	<h1 align="center">공지사항</h1>
	<hr>
	<form action="notice_update.do" method="post">
		<input type="hidden" name="board_notice_no" value="${retrieve.board_notice_no}">
			글번호: ${retrieve.board_notice_no} &nbsp;&nbsp;&nbsp;&nbsp; 조회수:${retrieve.board_notice_views}<br>
		<div align="center">
		<table class="ex1" border="1" align="center">
		<thead>
		<tbody>
			<tr class="menu3">
			<td align="center">제목 : </td>
			<td><input type="text" size=130 maxlength=30 name="board_notice_title" value="${retrieve.board_notice_title}"></td>
			</tr>
			
			<tr class="menu3">
			<td align="center">작성자 : </td>
			<td align="center">${retrieve.member_info_nickname}</td>
			</tr>
			
			<tr class="menu3">
			<td align="center">내용</td>
			<td><textarea name="board_notice_content" cols=115 rows=10>${retrieve.board_notice_content}</textarea></td>
			<tr><td colspan="2" align="center">
			<input class="btn btn-info" type="submit" value="수정"></td></tr>
		</tbody>
		</thead>		
		</table>
		 </div>
	</form>
	<div align ="center">
		<a href="notice_list.do"><button type="button" class="btn btn-info">목록</button></a>
		<a href="notice_delete.do?board_notice_no=${retrieve.board_notice_no}"><button type="button" class="btn btn-info">삭제</button></a>
	</div>
	
	<%} %>
	
</body>
</html>