<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>my page</title>
</head>
<body>
<div class="" align="center">
<c:choose>
	<c:when test="${infoList!=null}">
<h2>Mypge</h2>
<hr>
	<div class="message">
		로그인에 성공하였습니다. ${s_member_info_nickname}님 환영합니다<p>
	</div>
	<div class="">
		<ul> 
			<li>회원 등급 :[${infoList.getMember_info_name()}] 님은 [${infoList.getMember_grade_name()}] 회원 입니다.</li>
			<li>진행중 주문 :<input type="text" value="${infoList.getOrderCount()}" size="3" disabled />건 입니다.</li>
			<li><a href="myinfoform.do">회원정보 수정</a></li>
			<li><a href="pwform.do">패스워드 변경</a></li>
		</ul>
	</div>
	</c:when>
	<c:otherwise>
	<div class="message">
	<!-- 로그인한 회원만 볼수 있는 화면이지만 주소창에 괴씸한
	비회원이 mypage.do를 직접 요청 할 수 있기 때문에 이런 경우를 대비한
	에러표시 전용 페이지가 필요하다. 14.11.25 00:38 깨달음 -->
		<ul>
			<li>회원전용 서비스 입니다.</li>
			<li>로그인 후 이용 부탁드립니다.</li>
			<li><a href="memberagree.do">무료 회원가입</a></li>
		</ul>
	</div>
</c:otherwise>
</c:choose>
</div>
</body>

</html>