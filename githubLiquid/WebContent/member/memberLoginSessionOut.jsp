<!--
/***********************************************************************
 * 작업자 :  이승우 
 * 작업일자 : 2014.11.15~
 * 어떤 파일에 호출받는가 : main_Top.jsp : 최상단 메뉴 로그아웃 버튼 클릭시 
 * 어떤 파일을 호출하는가 : index.jsp : 로그아웃 후 메인페이지로 이동함
 * 기능 : 세션아웃만을 위한 페이지
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