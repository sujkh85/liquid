<!--
/***********************************************************************
 * 작업자 : 전종우
 * 작업일자 : 2014.11.03~10
 * 어떤 파일에 호출받는가 : qna_detail.jsp
 * 어떤 파일을 호출하는가 : qna_listPage.jsp
 * 파일 타입 :
 ***********************************************************************/
  --> 

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
<body> 
<%
String mode = request.getParameter("mode");
if("manager".equals(mode)){
%>
<div align="center">
<h1> <span class="glyphicon glyphicon-pencil"></span> 글 수정하기</h1>
<form action="manager_qna_update.do?mode=manager" method="post">
	<input type="hidden" name="board_question_no" value="${retrieve.board_question_no}">
		<table width="600" border="1" align="center" class="ex1">
		<thead>
		<tbody>
		<tr class="menu0"> 
			<td align="right" colspan="2">글번호:${retrieve.board_question_no} &nbsp;&nbsp;&nbsp;&nbsp; 조회수 : ${retrieve.board_question_viewcount}</td>
		</tr>
		<tr class="menu0">
			<td width="130">제목</td>
			<td><input type="text" size="100" name="board_question_title" value="${retrieve.board_question_title}"></td>
		</tr>
		<tr class="menu0">
			<td>작성자</td>
			<td>${s_member_info_nickname}
				<input type="hidden" name="member_info_no" value="${s_member_info_no}">
			</td>
		</tr>
		<tr class="menu0">
			<td>내용</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr>
		<%-- <tr class="menu0">
			<td>첨부파일</td>
			<td>현재 파일 : ${retrieve.board_question_imgsrc1} <br>
			<input type="file" size="100" name="board_question_imgsrc1" value="${retrieve.board_question_imgsrc1}">
			</td>
		</tr>
		<tr class="menu0">
			<td>내용</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr>
		<tr class="menu0">
			<td>내용</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr>
		<tr class="menu0">
			<td>내용</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr>
		<tr class="menu0">
			<td>내용</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr> --%>
		<tr>
			<td colspan="2">
			
			<input type="submit"  class="btn btn-info"  value="수정하기">
			<a href="manager_qna_delete.do?mode=manager&board_question_no=${retrieve.board_question_no}"><button class="btn btn-info"  type="button">삭제하기</button></a>
			
			<!-- 	(String)session.getAttrute("member_info_no") == request.getparameter("member_info_no")
			 -->
			<div align="right">
			<!-- <input type="reset" class="btn btn-info" value="다시쓰기"> -->
			<a href="manager_qna_list.do?mode=manager"><button class="btn btn-info"  type="button">목록보기</button></a>
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
<h1>글 수정하기</h1>
<form action="qna_update.do" method="post">
	<input type="hidden" name="board_question_no" value="${retrieve.board_question_no}">
		<table width="600" border="1" align="center" class="ex1">
		<thead>
		<tbody>
		<tr class="menu0">
			<td align="right" colspan="2">글번호:${retrieve.board_question_no} &nbsp;&nbsp;&nbsp;&nbsp; 조회수 : ${retrieve.board_question_viewcount}</td>
		</tr>
		<tr class="menu0">
			<td width="130">제목</td>
			<td><input type="text" size="100" name="board_question_title" value="${retrieve.board_question_title}"></td>
		</tr>
		<tr class="menu0">
			<td>작성자</td>
			<td>${s_member_info_nickname}
				<input type="hidden" name="member_info_no" value="${s_member_info_no}">
			</td>
		</tr>
		<tr class="menu0">
			<td>내용</td>
			<td><textarea name="board_question_content" cols="80" rows="25">${retrieve.board_question_content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			
			<input class="btn btn-info" type="submit" value="수정하기">
			<a href="qna_delete.do?board_question_no=${retrieve.board_question_no}"><button class="btn btn-info" type="button">삭제하기</button></a>
			
			<!-- 	(String)session.getAttrute("member_info_no") == request.getparameter("member_info_no")
					// 세션의 member_info_no를 s_member_info_no로 수정했으므로 jstl을 사용할 수 있습니다 
			 -->
			<div align="right">
			<input class="btn btn-info" type="reset" value="다시쓰기">
			<a href="qna_list.do"><button class="btn btn-info" type="button">목록보기</button></a>
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