<!--
/***********************************************************************
 * �۾��� :  �̽¿� 
 * �۾����� : 2014.11.15~
 * � ���Ͽ� ȣ��޴°� : memberLoginForm.jsp : �α��ν� 
 * � ������ ȣ���ϴ°� : �α��� ������ ���ǿ� ������ ���, ���н� ��� 
 * ��� : �α������� ��ġ ���θ� �Ǵ��Ͽ� ���ǿ� ������ ����� ������� �����ϴ� ��
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
			alert("���̵�� ��й�ȣ�� Ȯ�����ּ���");
			location.href = "loginform.do";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>