<!--
/***********************************************************************
 * 작업자 :  이승우 
 * 작업일자 : 2014.11.21~
 * 어떤 파일에 호출받는가 : memberForm.jsp:가입 중 체크 / memberFormEdit.jsp:수정 중 체크
 * 어떤 파일을 호출하는가 : 없음
 * 파일 타입 : 틀
 * 기능 : 아이디/닉네임 중복검사시 팝업창 ,jstl 태그 사이에 주석 사용시 오류 발생함.
  ***********************************************************************/
  --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>중복확인</title>
<script src="js/jquery-1.11.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/respond.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- <link href="style.css" rel="stylesheet" type="text/css"> -->
<script type="text/javascript">
	//팝업창에서 아이디 중복검사 or 사용하기
	function confirmId(id)
    {		
		opener.member_info_form.member_info_id.value = id;
		self.close();   
	}
	function confirmIdcheck(){
		with(document.checkForm){
	        if(id.value.replace(/\s/g,"") == ""){
	            alert("ID를 입력해 주세요");
	            id.focus();
	            return false;
	        } 
	        var reg = new RegExp("(^[a-z0-9-_]{5}[a-z0-9-_]+$)");
	        if(!reg.test(id.value)) {
			    alert("아이디 형식이 맞지 않습니다.");
			    return false;
			}
		}
	}		     
	//팝업창에서 닉네임 중복검사 or 사용하기
	function confirmNickname(nickname)
    {		
		opener.member_info_form.member_info_nickname.value = nickname;
		self.close();   
	}
	function confirmNicknamecheck(){
		with(document.checkForm){
	        if(nickname.value.replace(/\s/g,"") == ""){
	            alert("닉네임을 입력해 주세요");
	            nickname.focus();
	            return false;
	        }
		}
	}		     
</script>
<body>

<c:choose>
 <c:when test="${member_info_id != null}">  
 <c:if test="${check == 1}">  
<table width="270" border="1" cellspacing="0" cellpadding="5">
  <tr> 
    <td height="39"><strong><span style="color:red;">${member_info_id}</span></strong> 는 이미 사용중인 아이디입니다.</td>
  </tr>
</table>
<form name="checkForm" method="post" action="membercheck.do" onsubmit="return confirmIdcheck()">
<table width="270" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center"> 다른 아이디를 선택하세요.<p>
       <input class="btn btn-primary" type="text" size="10" maxlength="12" name="id"> 
       <input class="btn btn-primary" type="submit" value="ID중복확인" >
    </td>
  </tr>
</table>
</form>
</c:if> 
<c:if test="${check == 0}"> 
<form action="">
<table width="270" border="1" cellspacing="0" cellpadding="5">
  <tr>  
    <td align="center"> 
      <p>입력하신 <strong><span style="color:blue;">${member_info_id}</span></strong> 는<br>
      사용하실 수 있는 ID입니다. </p>
      <input class="btn btn-primary" type="button" value="사용하기" onclick="confirmId('${member_info_id}')" />
    </td>
  </tr>
</table>
</form>
</c:if> 
 </c:when>
 
 <c:when test="${member_info_nickname != null}">  
 <c:if test="${check == 1 && s_member_info_nickname != member_info_nickname}">  
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr> 
    <td height="39"><strong><span style="color:red;">${member_info_nickname}</span></strong> 는 이미 사용중인 닉네임입니다.</td>
  </tr>
</table> 
<form name="checkForm" method="post" action="membercheck.do" onsubmit="return confirmNicknamecheck()">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center"> 다른 닉네임을 입력하세요.<p>
       <input class="btn btn-primary" type="text" size="10" maxlength="12" name="nickname"> 
       <input class="btn btn-primary" type="submit" value="닉네임중복확인">
    </td>
  </tr> 
</table>
</form>
</c:if>
	<c:if test="${check == 1 && s_member_info_nickname == member_info_nickname }">
	<table width="270" border="0" cellspacing="0" cellpadding="5">
		<tr>		
	    	<td height="39"><strong><span style="color:blue;">${s_member_info_nickname}</span></strong> 는 현재 회원님이 사용중인 닉네임입니다.</td>
		</tr>
		<tr> 
    		<td align="center"> 
     	 	<input class="btn btn-primary" type="button" value="계속 사용하기" onclick="confirmNickname('${s_member_info_nickname}')">
    		</td>
	  	</tr>
	</table>
	</c:if>
<c:if test="${check == 0}"> 
<form action="">
<table width="270" border="1" cellspacing="0" cellpadding="5">
  <tr> 
    <td align="center"> 
      <p>입력하신 <strong><span style="color:blue;">${member_info_nickname}</span></strong> 는<br>
      사용하실 수 있는 닉네임입니다. </p>
      <input class="btn btn-primary" type="button" value="사용하기" onclick="confirmNickname('${member_info_nickname}')">
    </td>
  </tr>
</table>
</form>
</c:if> 
</c:when> 
</c:choose>
</body>
</html>
 
