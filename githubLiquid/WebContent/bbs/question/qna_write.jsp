<!--
/***********************************************************************
 * 작업자 : 전종우
 * 작업일자 : 2014.11.03~10
 * 어떤 파일에 호출받는가 : qna_write.jsp
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
<title>글쓰기</title>
<link rel="stylesheet" href="./css/table.css" type="text/css"> 
</head> 
<body>

<%
String mode = request.getParameter("mode");
if("manager".equals(mode)){ 
%>	
	
<div align="center">
	<h1> <span class="glyphicon glyphicon-pencil"></span> 게시판 글쓰기 화면</h1>
	<form action="manager_qna_write.do" method="post" enctype="multipart/form-data">
	<table width="600" border="1" align="center" class="ex1">
	<thead>
	<tbody>
	<tr class="menu0">
		<td width="130">제목</td>
		<td><input type="text" name="title" maxlength="200" size="100" autofocus></td>
	</tr>
		<!-- 작성자 표시는 nickname으로 실제 벨류값은 no로  -->
	<tr class="menu0">
		<td>작성자</td>
		<td>${s_member_info_nickname}
			<input type="hidden" name="member_info_no" value="${s_member_info_no}">
		</td>
	</tr>
	<tr class="menu0">
		<td>내용</td>
		<td><textarea name="content" cols="80" rows="25"></textarea></td>
	</tr>
	<tr class="menu0">
		<td>첨부파일1</td>
		<td><input type="file" name="imgsrc1"></td>
	</tr>
	<tr class="menu0">
		<td>첨부파일2</td>
		<td><input type="file" name="imgsrc2"></td>
	</tr>
	<tr class="menu0">
		<td>첨부파일3</td>
		<td><input type="file" name="imgsrc3"></td>
	</tr>
	<tr class="menu0">
		<td>첨부파일4</td>
		<td><input type="file" name="imgsrc4"></td>
	</tr>
	<tr class="menu0">
		<td>첨부파일5</td>
		<td><input type="file" name="imgsrc5"></td>
	</tr>
	<tr>
		<td colspan="2"><input class="btn btn-info" type="submit" value="저장">
		<div align="right">
		<input class="btn btn-info" type="reset" value="다시쓰기">
		<a href="manager_qna_list.do?mode=manager"><button class="btn btn-info" type="button">목록보기</button></a>
		</div></td>
		
	</tr>
	</tbody>
	</thead>
	</table>
	</form>
</div>

<%}else{ %>	

	<div align="center">
	<h1>게시판 글쓰기 화면</h1>
	<form action="qna_write.do" method="post" enctype="multipart/form-data">
	<table width="700" border="1" align="center" class="ex1">
	<thead>
	<tbody>
	<tr class="menu0">
		<td width="130">제목</td>
		<td><input type="text" name="title" maxlength="200" size="100" autofocus></td>
	</tr>
		<!-- 작성자 표시는 nickname으로 실제 벨류값은 no로  -->
	<tr class="menu0">
		<td>작성자</td>
		<td>${s_member_info_nickname}
			<input type="hidden" name="member_info_no" value="${s_member_info_no}">
		</td>
	</tr>
	<tr class="menu0">
		<td>내용</td>
		<td><textarea name="content" cols="80" rows="25"></textarea></td>
	</tr>
	<tr class="menu0">
		<td>첨부파일1</td>
		<td><input type="file" name="imgsrc1"></td>
	</tr>
	<tr class="menu0">
		<td>첨부파일2</td>
		<td><input type="file" name="imgsrc2"></td>
	</tr>
	<tr class="menu0">
		<td>첨부파일3</td>
		<td><input type="file" name="imgsrc3"></td>
	</tr>
	<tr class="menu0">
		<td>첨부파일4</td>
		<td><input type="file" name="imgsrc4"></td>
	</tr>
	<tr class="menu0">
		<td>첨부파일5</td>
		<td><input type="file" name="imgsrc5"></td>
	</tr>
	<tr>
		<td colspan="2"><input class="btn btn-info" type="submit" value="저장">
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
