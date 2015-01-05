<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Member Part Message</title>
</head>
<body>
<c:choose>
	<c:when test="${insert_result == 1}">
		<div align="center" >
<!-- 회원가입 성공 메시지 -->
		회원가입을  축하드립니다 !!!!
		<p>회원님들을 위한 보다 나은 서비스를 위해 노력하겠습니다.</p>
		<p>좋은하루되세요!</p>
		<a href="main.do"> 홈으로 </a>
		</div>
	</c:when>
	<c:when test="${insert_result == 0 }">
		<div align="center">
<!-- 회원가입 실패 메시지 -->
		회원가입에 실패 하였습니다. 잠시 후 다시 시도해주십시오.
		</div>
	</c:when>
	<c:when test="${update_result == 1 }">
		<div align="center">
<!-- 회원정보 수정 성공 메시지 -->	
		회원정보 수정에 성공하였습니다.
		</div>
	</c:when>
	<c:when test="${update_result == 0 }">
		<div align="center">
<!-- 회원정보 수정 실패 메시지 -->	
		회원정보 수정에 실패 하였습니다. 잠시 후 다시 시도해주십시오.
		</div>
	</c:when>
	<c:when test="${delete_result == 1 }">
		<div align="center">
<!-- 회원탈퇴 성공 메시지  -->
		회원 탈퇴에 성공 하였습니다. 지금까지 Liquid 쇼핑몰을 이용해주셔서 감사합니다.
		</div>
	</c:when>
</c:choose>
</body>
</html>