<!--
/***********************************************************************
 * �۾��� :  ������&�̽¿� �� �ֽ�ȯ
 * �۾����� : 2014.11.15~
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� : loginSession.jsp / loginSessionOut.jsp
 * ���� Ÿ�� : Ʋ
 * ������&�̽¿� : �α���(..Session.jsp) / �α׾ƿ�(..SessionOut.jsp) ��ɱ���
 * �ֽ�ȯ : �α��� �� CSS ������
  ***********************************************************************/
  --> 
<%@ page language= "java" contentType ="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title> Login Form </title >
<link rel="stylesheet" href="./css/login.css" type="text/css">
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script >
</head>
<body>
	<div id= "wrapper">
  	<form class="login-form" action="logingo.do" method="post" onSubmit="return check()">
   		<div class="header">
	   		<h1 align="center" >Login</h1>
	   		<span>ȸ�� �α����� �Ͻø� ���� ���� �� ������ ���� ������ �� �ֽ��ϴ�.</span> 
  		</div>
  		
  		<div class="content">
    			<input type="text" name="member_info_id" class="input username"  placeholder="���̵�"></li>
     			<div class="user-icon"></div>
     			<input type="password" name="member_info_pw" class="input password"  placeholder="��й�ȣ" ></li>
    			<div class="pass-icon"></div>	
    	</div>			
    	<div class="footer">
    			<input type="submit" name="submit" value="Login" class="button" />
    			<input type="button"  class="button" value="SIGN UP" onclick="document.location.href='memberagree.do'">
    			<input type="submit" class="register" value="FIND PASSWORD" >
  		</div>
 	</form>
  </div>
 <div class="grdient"> </div> 
</body>
</html> 