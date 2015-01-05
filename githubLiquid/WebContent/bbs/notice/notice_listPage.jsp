<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
/***********************************************************************
 * 작업자 : 이묘화 정경환,최승환 
 * 작업일자 : 2014.11.03~07 2014.11.25(JKH)
 * 어떤 파일에 호출받는가 :  notice_list.jsp
 * 어떤 파일을 호출하는가 :  notice_listPage.jsp,notice_write.jsp,notice_retrievetest.jsp
 * 파일 타입 : 틀
 * 작업사항 : 정경환 관리자만 공지사항글쓸수있게 변경
 		     최승환 표 디자인 구현중
 ***********************************************************************/
  -->  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>목록보기</title>
<link rel="stylesheet" href="./css/table.css" type="text/css"> 
</head>
<body>
<%
String mode=request.getParameter("mode");
String member_info_no=request.getParameter("member_info_no");
System.out.println("리스트페이지에서의 모드"+mode);
System.out.println("리스트페이지에서의 아이디번호"+member_info_no);
if("manager".equals(mode)){
	
	request.setAttribute("mode",mode);
%>


	<h1 align="center"><span class="glyphicon glyphicon-flag"></span> 공지사항</h1> 
	<hr>
	<div align="center">
	<table class="ex1" border="0" align="center" width="650">
	<thead>
		<tr>
			<td colspan="5">
		<form action="manager_notice_search.do">
			<select name="searchName" size="1">
				<option value="board_notice_title">글제목</option>
				<option value="member_info_nickname">작성자</option>
			</select>
			<input type="text" name="searchValue">
			<input type="submit" value="찾기">
			</form>
			</td>
		</tr>
		<tr class="menu">
			<td id="no">번호</td>
			<td id="title">제   목</td>
			<td id="writer">작성자</td>
			<td id="date">작성일</td>
			<td id="review">조회수</td>
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
	<!-- 회원등급이 관리자면 글쓰기 버튼을 볼수있다. -->
	<div align="center">
	<c:choose>
		<c:when test="${s_member_grade_no == '10'}">
			<a href="manager_notice_writeui.do?mode=manager"><button type="button"  class="btn btn-info">글쓰기 </button></a>
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
	
	<h1 align="center"><span class="glyphicon glyphicon-flag"></span> 공지사항</h1> 
	<hr>
	<div align="center">
	<table class="ex1" border="0" align="center" width="650">
	<thead>
		<tr>
			<td colspan="5">
		<form action="notice_search.do">
			<select name="searchName" size="1">
				<option value="board_notice_title">글제목</option>
				<option value="member_info_nickname">작성자</option>
			</select>
			<input type="text" name="searchValue">
			<input type="submit" value="찾기">
			</form>
			</td>
		</tr>
		<tr class="menu">
			<td id="no">번호</td>
			<td id="title">제   목</td>
			<td id="writer">작성자</td>
			<td id="date">작성일</td>
			<td id="review">조회수</td>
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
	<!-- 회원등급이 관리자면 글쓰기 버튼을 볼수있다. -->
	<div align="center">
	<c:choose>
		<c:when test="${s_member_grade_no == '10'}">
			<a href="notice_writeui.do"><button type="button"  class="btn btn-info">글쓰기 </button></a>
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