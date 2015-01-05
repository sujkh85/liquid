<!--
/***********************************************************************
 * 작업자 : 전종우  -> 최승환
 * 작업일자 : 2014.11.03~10 ,12.08~11
 * 어떤 파일에 호출받는가 :  qna_listPage.jsp,
 * 어떤 파일을 호출하는가 :  qna_reply.jsp qna_retrieve.jsp
 * 파일 타입 : qna게시판 관련 부품..
 ***********************************************************************/
  -->    


<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 상세보기</title>
<link rel="stylesheet" href="./css/table.css" type="text/css"> 
</head>
<body>
<%
String mode = request.getParameter("mode");
if("manager".equals(mode)){
%>
<div align="center">
<h1><span class="glyphicon glyphicon-pencil"></span> 글 상세보기</h1>
	 <form action="manager_qna_retrieve.do?mode=manager">
	 <input type="hidden" name="board_question_no" value="${detail.board_question_no}">
	글번호${detail.board_question_no}&nbsp; 조회수${detail.board_question_viewcount}<br />
	<table border="1" align="center" width="600" class="ex1">
	<thead>
	<tbody>
	<!-- 답변글 필요  -->
	<tr class="menu1">                                                                                                                          
		<th align="center">&nbsp;${detail.board_question_title} </th>
	</tr>
	<tr class="menu0">
		<td>등록일 : ${detail.board_question_date} <br>
			작성자 : ${detail.member_info_no_nickname} &nbsp; | &nbsp; 조회수 : ${detail.board_question_viewcount}</td>
	</tr>
	<tr  class="menu0">
		<td height="100" valign="top"><b>내용</b> <br> ${detail.board_question_content}</td>
	</tr>
	
	<c:choose>
		<c:when test="${detail.board_question_imgsrc1 != null}">
			<tr class="menu0">
				<th align="left">첨부이미지1</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc1}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${detail.board_question_imgsrc2 != null}">
			<tr class="menu0">
				<th align="left">첨부이미지2</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc2}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc3 != null}">
			<tr class="menu0">
				<th align="left">첨부이미지3</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc3}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc4 != null}">
			<tr class="menu0">
				<th align="left">첨부이미지4</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc4}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc5 != null}">
			<tr class="menu0">
				<th align="left">첨부이미지5</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc5}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		
	
	<tr><!-- 로그인 상태이고, 글쓴이 닉네임과 로그인 한 사람의 닉네임이 일치하면  -->
		<td><c:choose>
 				<c:when test="${(s_member_info_no != null && detail.member_info_no_nickname == member_info_nickname) || s_member_grade_no == '10' }"> 
					<input class="btn btn-info" type="submit"  value="수정하기">
					<a href="manager_qna_delete.do?board_question_no=${detail.board_question_no}"><button type="button" class="btn btn-info">삭제</button></a>
				</c:when> 
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<div align="right">
			<a href="manager_qna_list.do?mode=manager"><button type="button" class="btn btn-info">목록보기</button></a>
			<c:choose>
				<c:when test="${s_member_info_no != null}">
					<a href="manager_qna_replyui.do?mode=manager&board_question_no=${detail.board_question_no}"><button type="button" class="btn btn-info">답변글달기</button></a>
				</c:when> 
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			
			</div>
		</td>
		</tr>
		</tbody>
	</thead>	
	</table>
	</form>
</div> 


<%}else{ %>	
	<div align="center">
<h1>글 상세보기</h1>
	 <form action="qna_retrieve.do">
	 <input type="hidden" name="board_question_no" value="${detail.board_question_no}">
	글번호${detail.board_question_no}&nbsp; 조회수${detail.board_question_viewcount}<br />
	<table border="1" align="center" width="600" class="ex1">
	<thead>	
	<tbody>
	<!-- 답변글 필요  -->
	<tr class="menu0">                                                                                                                          
		<th align="center">&nbsp;${detail.board_question_title} </th>
	</tr>
	<tr class="menu0">
		<td>등록일 : ${detail.board_question_date} <br>
			작성자 : ${detail.member_info_no_nickname} &nbsp; | &nbsp; 조회수 : ${detail.board_question_viewcount}</td>
	</tr>
	<tr class="menu0">
		<td height="100" valign="top"><b>내용</b> <br> ${detail.board_question_content}</td>
	</tr>
	
<%-- 	<tr>
	<td>
	<c:forEach begin="1" var="i"  end="5" >
	${detail.board_question_imgsrc1}
	</c:forEach>
	</td>
	</tr> --%>
	
	
	
	<c:choose>
		<c:when test="${detail.board_question_imgsrc1 != null}">
			<tr class="menu0">
				<th align="left">첨부이미지1</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc1}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${detail.board_question_imgsrc2 != null}">
			<tr class="menu0">
				<th align="left">첨부이미지2</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc2}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc3 != null}">
			<tr class="menu0">
				<th align="left">첨부이미지3</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc3}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc4 != null}">
			<tr class="menu0">
				<th align="left">첨부이미지4</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc4}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc5 != null}">
			<tr class="menu0">
				<th align="left">첨부이미지5</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc5}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		
	
	<tr><!-- 로그인 상태이고, 글쓴이 닉네임과 로그인 한 사람의 닉네임이 일치하면  -->
		<td><c:choose>
 				<c:when test="${(s_member_info_no != null && detail.member_info_no_nickname == s_member_info_nickname)  }"> 
					<input class="btn btn-info" type="submit" value="수정하기">
					<a href="qna_delete.do?mode=manager&board_question_no=${detail.board_question_no}"><button class="btn btn-info" type="button">삭제</button></a>
				</c:when> 
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<div align="right">
			<a href="qna_list.do"><button type="button" class="btn btn-info">목록보기</button></a>
			<c:choose>
				<c:when test="${s_member_info_no != null}">
					<a href="qna_replyui.do?board_question_no=${detail.board_question_no}"><button type="button" class="btn btn-info">답변글달기</button></a>
				</c:when> 
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			
			</div>
		</td>
		</tr>
		</tbody>
		</thead>
	</table> 
	</form>
</div> 
	
<%} %>

</body>
</html>