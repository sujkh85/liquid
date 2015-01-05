<!--
/***********************************************************************
 * 작업자 :  이승우 
 * 작업일자 : 2014.11.15~
 * 어떤 파일에 호출받는가 : memberLoginForm.jsp : 로그인시 
 * 어떤 파일을 호출하는가 : 로그인 성공시 세션에 정보를 담고, 실패시 경고문 
 * 기능 : 로그인정보 일치 여부를 판단하여 세션에 담을지 경고문을 띄울지를 선택하는 곳
  ***********************************************************************/
  --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="0;url=main.jsp?menu=login" >
<title>Insert title here</title>
</head>
<body> 
<c:choose>
	<c:when test="${loginInfo != null}">
		<c:set var="s_member_info_no" scope="session" value="${loginInfo.getMember_info_no()}"></c:set>
		<c:set var="s_member_info_nickname" scope="session" value="${loginInfo.getMember_info_nickname()}"></c:set>
		<c:set var="s_member_grade_no" scope="session" value="${loginInfo.getMember_grade_no()}"></c:set>
		<script>
			location.href = "main.do";
		</script>
	</c:when> 
	<c:otherwise>
		<script>
			alert("아이디와 비밀번호를 확인해주세요");
			location.href = "loginform.do";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>