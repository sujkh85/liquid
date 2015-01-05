<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>디자인 등록 화면</title>
</head>
<body>
	<div align="center" style="margin-top:100px; width:100%;padding: 10px; ">
	<form action="designWrite.do" method="post" enctype="multipart/form-data">
	<div>
	<h1>디자인 글쓰기</h1>
	<table class="table" border="1" align="center">
		<tr>
			<td align="center">작품명</td>
			<td><input type="text" name="board_userdesign_title" size="100" maxlength="100"></td>
		</tr>
		<tr>
			<td align="center">
				디자이너</td>
			<td><c:out value="${s_member_info_nickname}" /></td>
		</tr>
		<tr>
			<td align="center">작품상세</td>
			<td><textarea rows="20" cols="100" name="board_userdesign_content" rows="5"></textarea></td>
		</tr>
		<tr>
			<td align="center">첨부파일1</td><td><input type="file" name="board_userdesign_imgsrc1"></td>
		</tr>
		<tr>
			<td align="center">첨부파일2</td><td><input type="file" name="board_userdesign_imgsrc2"></td>
		</tr>
		<tr>
			<td align="center">첨부파일3</td><td><input type="file" name="board_userdesign_imgsrc3"></td>
		</tr>
		<tr>
			<td align="center">첨부파일4</td><td><input type="file" name="board_userdesign_imgsrc4"></td>
		</tr>
		<tr>
			<td align="center">첨부파일5</td><td><input type="file" name="board_userdesign_imgsrc5"></td>
		</tr>
	</table>
	</div>
		<div align="center">
			<input class="btn btn-info" type="submit" value="저장">
			<input class="btn btn-info" type="reset" value="다시쓰기">
		</div>
	
	</form>
	</div>
</body>
</html>