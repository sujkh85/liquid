<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
/***********************************************************************
 * �۾��� : �̽¿�
 * �۾����� : 2014.11.11
 * � ���Ͽ� ȣ��޴°� :  
 * � ������ ȣ���ϴ°� :  main.jsp
 * ���� Ÿ�� : ��üƲ �ε���
 ***********************************************************************/
  -->    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������������Ʈ</title>
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