<!--
/***********************************************************************
 * 작업자 :  이승우 
 * 작업일자 : 2014.11.15~
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 : memberCheck.jsp : 닉네임 중복검사시
 * 파일 타입 : 틀
 * 기능 : 비밀번호를 제외한 회원정보수정 가능. 
  ***********************************************************************/
  --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script> 
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<title>회원상세 정보</title>
</head>
<body>
<h3>회원상세 정보</h3>
<hr>
<div id="d_memberForm" align="center">
<table class="table">
<c:forEach items="${list}" var="dto">
<form id="f_memberForm" name="member_info_form"  action="manager_myinfoform.do?member_info_no=${dto.member_info_no}" method="post">
	<tr>
		<td><h5><strong>회원번호</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.member_info_no}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>회원 등급 번호</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.member_grade_no}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>회원등급</strong></h5></td>
		<td colspan="2">
			<h5><strong>${dto.member_grade_name}</strong></h5>
		</td>
	</tr>
	<tr>
		<td><h5><strong>아이디</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_id}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>닉네임</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_nickname}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>회원이름</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_name}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>생년월일</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_birthday}</strong></h5></td>
							
	</tr>
	<tr>
		<td><h5><strong>성별</strong></h5></td>						
		<td colspan="2"><h5><strong>${dto.member_info_gender}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>우편번호</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_post1}-${dto.member_info_post2}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>기본주소</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_address1}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>상세주소</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_address2}</strong></h5></td>
	</tr>
	<tr>
	<td><h5><strong>비밀번호</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_pw}</strong></h5></td>
		
	</tr>
	<tr>
	<td><h5><strong>이메일</strong></h5></td>
		<td colspan="2"><h5><strong>${dto.member_info_id}</strong></h5></td>
		
	</tr>
	<tr>
		<td></td>
		<td colspan="2">
		<input class="btn btn-success" type="submit" value="수정하기" >
		<input class="btn btn-success" type="button" value="돌아가기" onclick="location.href='manager_main.do'">
		</td>  
	</tr>
	</c:forEach>
</table>
</form>
</div>
</body>
</html>