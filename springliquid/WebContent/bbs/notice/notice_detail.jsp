<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
/***********************************************************************
 * 작업자 : 이묘화 정경환
 * 작업일자 : 2014.11.03~07 2014.11.26(JKH)
 * 어떤 파일에 호출받는가 :  notice_list.jsp
 * 어떤 파일을 호출하는가 :  notice_listPage.jsp,notice_write.jsp,notice_retrievetest.jsp
 * 파일 타입 : 틀
 * 작업사항 : 정경환 관리자만 공지사항글수정할수있게 변경
 ***********************************************************************/
  -->  
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
	<h1 align="center"> <span class="glyphicon glyphicon-flag"></span> 공지사항</h1>
	<hr> 
		<input type="hidden" name="board_notice_no" value="${retrievetest.board_notice_no}">
			글번호: ${retrievetest.board_notice_no} &nbsp;&nbsp;&nbsp;&nbsp; 조회수:${retrievetest.board_notice_views}<br><p>
	<table class="ex1" border="1" width="300" >
	 <colgroup>
     <col width="10%"/>
     </colgroup>
	  <thead>
	  <tbody>
	  	<tr class="menu3">
			<td align="center" colspan="1" width="200">제목 : </td>
			<td>${retrievetest.board_notice_title}</td>
		</tr>
		<tr class="menu3">
		<td>내용 : </td> 
			<td height="200" valign="top"><br><font color="red"><b>${retrievetest.board_notice_content}</b></font></td>
		</tr>
		<tr class="menu3">
			<td align="center" colspan="1">작성자 : </td>
			<td>${retrievetest.member_info_nickname}</td>
		</tr>
	</thead>	
	<!--이미지 경로 널 값 처리-->
	<c:choose>
		<c:when test="${retrievetest.board_notice_imgsrc1 == './bbs/notice/img/null' && retrievetest.board_notice_imgsrc2 != './bbs/notice/img/null'}">
			<tr>
			<td colspan="2" align="center" width="600" height="300"><img src="${retrievetest.board_notice_imgsrc2}"></td>
			</tr>
		</c:when>
		<c:when test="${retrievetest.board_notice_imgsrc2 == './bbs/notice/img/null' && retrievetest.board_notice_imgsrc1 != './bbs/notice/img/null'}">
			<tr>
			<td colspan="2" align="center"width="600" height="300"><img src="${retrievetest.board_notice_imgsrc1}"></td>
			</tr>
		</c:when>
		<c:when test="${retrievetest.board_notice_imgsrc2 == './bbs/notice/img/null' && retrievetest.board_notice_imgsrc1 == './bbs/notice/img/null'}">
			<br>
		</c:when>
		<c:otherwise>
			<tr>
			<td colspan="2" align="center" width="600" height="300"><img src="${retrievetest.board_notice_imgsrc1}"></td>
			</tr>
			<tr>
			<td colspan="2" align="center" width="600" height="300"><img src="${retrievetest.board_notice_imgsrc2}"></td>
			</tr>		
		</c:otherwise>
	</c:choose>
	</tbody>
	</table>
	
	<!-- 회원등급이 관리자면 글쓰기 버튼을 볼수있다. -->
	<c:choose>
		<c:when test="${s_member_grade_no == '10'}">
		<div align="center">
				<input class="btn btn-info" type="button" value="수정" onclick="location.href='manager_notice_retrieve.do?mode=manager&board_notice_no=${retrievetest.board_notice_no}'">
				<input class="btn btn-info" type="button" value="목록" onclick="location.href='manager_notice_list.do?mode=manager'">
		</div>
		</c:when> 
	<c:otherwise>
	</c:otherwise>
	</c:choose> 
	
	
	<%}else{ %>	
	
	<h1 align="center"> <span class="glyphicon glyphicon-flag"></span> 공지사항</h1>
	<hr> 
		<input type="hidden" name="board_notice_no" value="${retrievetest.board_notice_no}">
			글번호: ${retrievetest.board_notice_no} &nbsp;&nbsp;&nbsp;&nbsp; 조회수:${retrievetest.board_notice_views}<br><p>
	<table class="ex1" border="1" width="300" >
	 <colgroup>
     <col width="10%"/>
     </colgroup>
	  <thead>
	  <tbody>
	  	<tr class="menu3">
			<td align="center" colspan="1" width="200">제목 : </td>
			<td>${retrievetest.board_notice_title}</td>
		</tr>
		<tr class="menu3">
		<td>내용 : </td> 
			<td height="200" valign="top"><br><font color="red"><b>${retrievetest.board_notice_content}</b></font></td>
		</tr>
		<tr class="menu3">
			<td align="center" colspan="1">작성자 : </td>
			<td>${retrievetest.member_info_nickname}</td>
		</tr>
	</thead>	
	<!--이미지 경로 널 값 처리-->
	<c:choose>
		<c:when test="${retrievetest.board_notice_imgsrc1 == './bbs/notice/img/null' && retrievetest.board_notice_imgsrc2 != './bbs/notice/img/null'}">
			<tr>
			<td colspan="2" align="center" width="600" height="300"><img src="${retrievetest.board_notice_imgsrc2}"></td>
			</tr>
		</c:when>
		<c:when test="${retrievetest.board_notice_imgsrc2 == './bbs/notice/img/null' && retrievetest.board_notice_imgsrc1 != './bbs/notice/img/null'}">
			<tr>
			<td colspan="2" align="center"width="600" height="300"><img src="${retrievetest.board_notice_imgsrc1}"></td>
			</tr>
		</c:when>
		<c:when test="${retrievetest.board_notice_imgsrc2 == './bbs/notice/img/null' && retrievetest.board_notice_imgsrc1 == './bbs/notice/img/null'}">
			<br>
		</c:when>
		<c:otherwise>
			<tr>
			<td colspan="2" align="center" width="600" height="300"><img src="${retrievetest.board_notice_imgsrc1}"></td>
			</tr>
			<tr>
			<td colspan="2" align="center" width="600" height="300"><img src="${retrievetest.board_notice_imgsrc2}"></td>
			</tr>		
		</c:otherwise>
	</c:choose>
	</tbody>
	</table>
	
	<!-- 회원등급이 관리자면 글쓰기 버튼을 볼수있다. -->
	<c:choose>
		<c:when test="${s_member_grade_no == '10'}">
		<div align="center">
				<input class="btn btn-info" type="button" value="수정" onclick="location.href='notice_retrieve.do?board_notice_no=${retrievetest.board_notice_no}'">
				<input class="btn btn-info" type="button" value="목록" onclick="location.href='notice_list.do'">
		</div>
		</c:when> 
	<c:otherwise>
	</c:otherwise>
	</c:choose> 
	
	<%} %>
</body>
</html>