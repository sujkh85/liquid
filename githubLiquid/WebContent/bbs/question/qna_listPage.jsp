
<!--
/***********************************************************************
 * 작업자 : 전종우
 * 작업일자 : 2014.11.03~10
 * 어떤 파일에 호출받는가 : main_top.jsp
 * 어떤 파일을 호출하는가 : qna_detail.jsp, qna_write.jsp
 * 11/18일 수정
 * 로그인이 되어있어야(member_info_no != null) 글쓰기 버튼이 활성화 되도록 변경
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
<title>목록보기</title>
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
<!-- 관리자 게시판 Q&A -->
	<h1 align="center"> <span class="glyphicon glyphicon-pencil"></span> Q&A</h1> 
	<hr>
	<div align="center">
	<table class="ex1" border="0" align="center" width="650">
		<thead>
			<tr>
				<td colspan="5">
					<form action="manager_qna_search.do?mode=manager">
						<select name="searchName" size="1">
							<option value="member_info_nickname">작성자</option>
							<option value="board_question_title">글제목</option>
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
		<a href="manager_qna_writeui.do?mode=manager"><button type="button" class="btn btn-info">글쓰기</button></a>
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
							<option value="member_info_nickname">작성자</option>
							<option value="board_question_title">글제목</option>
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
		<a href="qna_writeui.do"><button type="button" class="btn btn-info" >글쓰기</button></a>
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

