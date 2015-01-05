<!--
/***********************************************************************
 * 작업자 : 전종우  -> 
 * 작업일자 : 
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 : 
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
<title>글 상세보기</title>
</head>
<body>
<div align="center">
<h1>글 상세보기</h1>
	 <form action="designRetrieve.do">
	 <input type="hidden" name="board_userdesign_no" value="${detailDesign.board_userdesign_no}">
	<table border="1" align="center" width="600">	
	<!-- 답변글 필요  -->
	<tr >                                                                                                                          
		<th align="left">&nbsp;${detailDesign.board_userdesign_title} </th>
	</tr>
	<tr>
		<td>등록일 : ${detailDesign.board_userdesign_date} <br>
			작성자 : ${detailDesign.member_info_nickname} &nbsp; | &nbsp; 조회수 : ${detailDesign.board_userdesign_viewcount}</td>
	</tr>
	<tr>
		<td height="100" valign="top"><b>내용</b> ${detailDesign.board_userdesign_imgsrc3}<br> ${detailDesign.board_userdesign_content}</td>
	</tr>
	<tr align="center">
		<td>
	<img src="${detailDesign.board_userdesign_imgsrc1}"><br>
	<img src="${detailDesign.board_userdesign_imgsrc2}"><br>
	<img src="${detailDesign.board_userdesign_imgsrc3}"><br>
	<img src="${detailDesign.board_userdesign_imgsrc4}"><br>
	<img src="${detailDesign.board_userdesign_imgsrc5}"><br>
		</td>
	</tr>
		
	
	<tr><!-- 로그인 상태이고, 글쓴이 닉네임과 로그인 한 사람의 닉네임이 일치하면  
			 아니면 관리자가 로그인 한 상태이면-->
		<td><c:choose>
 				<c:when test="${(s_member_info_no != null && detailDesign.member_info_nickname == s_member_info_nickname) || s_member_grade_no == '10' }"> 
					<input class="btn btn-primary" type="submit"  value="수정하기">
					<a href="designDelete.do?board_userdesign_no=${detailDesign.board_userdesign_no}"><button class="btn btn-success" type="button">삭제</button></a>
			이 옷이 마음에 들었다면?<a href="designfavorite.do?board_userdesign_no=${detailDesign.board_userdesign_no}&member_info_no=${s_member_info_no}"><button  class="btn btn-danger" type="button">추천</button></a>
				</c:when> 
				<c:otherwise>
				회원이 되시면 디자인 추천을 할 수 있습니다.
				</c:otherwise>
			</c:choose>
			<div align="right">
			<a href="designList.do"><button class="btn btn-primary" type="button">목록보기</button></a>
			</div>
		</td>
		</tr>
	</table> 
	</form>
</div> 
</body>
</html>