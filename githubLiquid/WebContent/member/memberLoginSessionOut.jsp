<!--
/***********************************************************************
 * �۾��� :  �̽¿� 
 * �۾����� : 2014.11.15~
 * � ���Ͽ� ȣ��޴°� : main_Top.jsp : �ֻ�� �޴� �α׾ƿ� ��ư Ŭ���� 
 * � ������ ȣ���ϴ°� : index.jsp : �α׾ƿ� �� ������������ �̵���
 * ��� : ���Ǿƿ����� ���� ������
  ***********************************************************************/
  --> 
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/main.css" type="text/css">
</head>
<body>
<% 
	request.getSession().removeAttribute("s_member_info_no");  
	request.getSession().removeAttribute("s_member_info_nickname");  
	request.getSession().removeAttribute("s_member_grade_no");  
	
	response.sendRedirect("main.do");
%>
	
</body>
</html>