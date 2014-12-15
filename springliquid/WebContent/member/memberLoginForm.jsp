<!--
/***********************************************************************
 * 작업자 :  전종우&이승우 → 최승환
 * 작업일자 : 2014.11.15~
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 : loginSession.jsp / loginSessionOut.jsp
 * 파일 타입 : 틀
 * 전종우&이승우 : 로그인(..Session.jsp) / 로그아웃(..SessionOut.jsp) 기능구현
 * 최승환 : 로그인 폼 CSS 디자인
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
	   		<span>회원 로그인을 하시면 각종 혜택 및 정보를 제공 받으실 수 있습니다.</span> 
  		</div>
  		
  		<div class="content">
    			<input type="text" name="member_info_id" class="input username"  placeholder="아이디"></li>
     			<div class="user-icon"></div>
     			<input type="password" name="member_info_pw" class="input password"  placeholder="비밀번호" ></li>
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