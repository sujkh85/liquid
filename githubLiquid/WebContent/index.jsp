<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
/***********************************************************************
 * 작업자 : 이승우
 * 작업일자 : 2014.11.11
 * 어떤 파일에 호출받는가 :  
 * 어떤 파일을 호출하는가 :  main.jsp
 * 파일 타입 : 전체틀 인덱스
 ***********************************************************************/
  -->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>리퀴드프로젝트</title>
</head>
<body>
<%  
	String mode=request.getParameter("mode");
	if(mode==null){		
		response.sendRedirect("main.do"); 
	}else if("manager".equals(mode)){
		response.sendRedirect("manager_main.do");
	}
	System.out.println(mode);
%>   
</body>
</html>