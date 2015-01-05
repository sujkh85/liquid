<!--
/***********************************************************************
 * 작업자 :  이승우 
 * 작업일자 : 2014.11.15~
 * 어떤 파일에 호출받는가 : memberTerms.jsp : 약관 동의시에만 호출 받음
 * 어떤 파일을 호출하는가 : memberCheck.jsp : 가입 전 아이디/닉네임 중복검사시
 * 파일 타입 : 틀
 * 기능 : 회원가입 insert
  ***********************************************************************/
  --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script> 
<script type="text/JavaScript"> 
function openDaumPostcode() { 
	new daum.Postcode({
		oncomplete: function(data){
			document.getElementById('member_info_post1').value = data.postcode1; 
			document.getElementById('member_info_post2').value = data.postcode2; 
			document.getElementById('member_info_address1').value = data.address; 
			document.getElementById('member_info_address2').focus();
		}
	}).open();  
}	
function inputcheck(){
	with(document.member_info_form){
        if(member_info_id.value.replace(/\s/g,"") == ""){
            alert("ID를 입력해 주세요");
            member_info_id.focus();
            return false;
        }
        if(member_info_nickname.value.replace(/\s/g,"") == "") {
            alert("닉네임을 입력해 주세요");
            member_info_nickname.focus();
            return false;
        }
        
        if(member_info_pw.value.replace(/\s/g,"") == "" ){
            alert("비밀번호를 입력해 주세요");
            member_info_pw.focus();
            return false;
        }
        
        if(member_info_pw.value != member_info_pw2.value){
            alert("비밀번호를 동일하게 입력해 주세요");
            member_info_pw.value="";
            member_info_pw2.value="";
            member_info_pw.focus();
            return false;
        }
       
        if(member_info_name.value.replace(/\s/g,"") == "") {
            alert("사용자 이름을 입력해 주세요");
            member_info_name.focus();
            return false;
        }
    
        if(member_info_address2.value.replace(/\s/g,"") == "") {
            alert("상세주소를 입력해 주세요");
            address2.focus();
            return false;
        }
        
        if(member_info_phone.value.replace(/\s/g,"") == "") {
            alert("연락처를 입력하세요");
            member_info_phone.focus();
            return false;
        }
	}          
}

function openconfirmId(form) {
	// 아이디를 입력했는지 검사
    if (form.member_info_id.value.replace(/\s/g,"") == "") {
        alert("아이디를 입력해 주세요");
        form.member_info_id.focus();
        return;
    }
	// 아이디 형식제한 영소문자 숫자조합 5~12자리만 가능
    var reg = new RegExp("(^[a-z0-9-_]{5}[a-z0-9-_]+$)");
    if(!reg.test(form.member_info_id.value)) {
	    alert('아이디 형식이 맞지 않습니다.'); 
	    return false; 
    }   
     // 아이디 중복검사 새창 (DB탄다) 
		var url = "membercheck.do?id="+form.member_info_id.value;
		/* form.member_info_id.value.method ="POST";
		form.member_info_id.value.target ="confirm"; */
	    window.open(url, "confirm", "resizable=no, width=300, height=200");
		/* form.member_info_id.value.submit();  */
    
    }
	
function openconfirmNickname(form) {	
	// 닉네임을 입력했는지 검사
	if (form.member_info_nickname.value.replace(/\s/g,"") == "") {
        alert("닉네임을 입력해 주세요");
        form.member_info_nickname.focus();
        return;
	}
	
      
    // 닉네임 중복검사 새창열기 (DB탄다)
		var url = "membercheck.do?nickname="+form.member_info_nickname.value; 
		//form.member_info_nickname.value.method ="POST";
		//form.member_info_nickname.value.target ="confirm";
	    window.open(url, "confirm", "resizable=no, width=300, height=200");
		//form.member_info_nickname.value.submit();
    
}
</script>
</head>
<body>
<div align="center">
<h2>회원가입</h2>
</div>
<hr>
<form method="post" name="member_info_form" action="membermessage.do" onSubmit="return inputcheck()">

<table class="table" align="center">
	<tr> 
		<td><h5><strong>아이디</strong></h5></td>
		<td><input size="10" class="form-control" placeholder="아이디를 입력해주세요" type="text"  maxlength="12" id="member_info_id" name="member_info_id">
		</td>
		<td>
			<input class="btn btn-primary btn-sm" type="button" value="ID중복확인"  OnClick="openconfirmId(this.form)" />
		</td>
	</tr> 
	<tr>
		<td><h5><strong>닉네임</strong></h5></td>
		<td><input class="form-control" placeholder="닉네임을 입력해주세요" type="text" size="10" maxlength="12" id="member_info_nickname" name="member_info_nickname" >
		</td>
		<td>
		<input class="btn btn-primary btn-sm" type="button" value="닉네임중복확인"   OnClick="openconfirmNickname(this.form)" /></td> 
	</tr>
	<tr>
		<td><h5><strong>비밀번호</strong></h5></td>
		<td><input class="form-control" placeholder="비밀번호를 입력해주세요" type="password" size="15" maxlength="12" name="member_info_pw">
		</td>
		<td>
		</td>
	</tr>
	<tr>
		<td><h5><strong>비밀번호확인</strong></h5></td>
		<td><input class="form-control" placeholder="다시 비밀번호를 입력해주세요" type="password" size="15" maxlength="12" name="member_info_pw2">
		</td>
		<td>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><h2>개인정보 입력</h2></td>
	</tr>
	<tr>
		<td><h5><strong>이름</strong></h5></td>
		<td><input class="form-control" placeholder="이름을 입력해주세요" type="text" size="10" maxlength="12" name="member_info_name"/></td>
	</tr>
	<tr><td><h5><strong>생년월일</strong></h5></td>
		<td>
						<select name="year">
							<c:forEach begin="1950" end="2014" var="year">
							<option value="${year}">${year}년</option>
							</c:forEach>
						</select>
						<select name="month">
							<c:forEach begin="1" end="12" var="month">
							<option value="${month}" >${month}월</option>
							</c:forEach>
						</select>
						<select name="day">
							<c:forEach begin="1" end="31" var="day">
							<option value="${day}" >${day}일</option>
							</c:forEach>
						</select>
						</td>
	</tr>
	<tr>
		<td><h5><strong>성별</strong></h5></td>
		<td colspan="2">
		    <label>남</label><input type="radio" name="member_info_gender" value="남" />
			<label>여</label><input type="radio" name="member_info_gender" value="여" /></td>
	</tr>
	<tr>
		<td><h5><strong>주소입력</strong></h5></td>
		<td colspan="2">
		<input type="text" id="member_info_post1" name="member_info_post1" size="5" maxlength="4" readonly> -
		<input type="text" id="member_info_post2" name="member_info_post2" size="5" maxlength="4" readonly>
        <input type="button" value="우편번호 검색" onClick="openDaumPostcode()"><br>
        <input type="text" id="member_info_address1" name="member_info_address1" size="80" maxlength="100" readonly><br>
        <input type="text" id="member_info_address2" name="member_info_address2" size="80" maxlength="80">
		</td>
	</tr>
	<tr>
		<td><h5><strong>연락처</strong></h5></td>
		<td><input class="form-control" placeholder="연락처를 입력해주세요"type="text" name="member_info_phone" size="15" maxlength="15"></td>
	</tr>
	<tr>
		<td><h5><strong>이메일</strong></h5></td>
		<td><input class="form-control" placeholder="이메일을 입력해주세요" type="text" name="member_info_email" size="40" maxlength="30"></td>
	</tr>
	<tr>
		<td colspan="3" align ="center">
		<input class="btn btn-primary btn-sm" type="submit" value="등록하기">
		<input class="btn btn-primary btn-sm" type="button" value="취소하기" onclick="location.href='main.do'">
		</td>
	</tr>
</table>
</form>
</body>
</html>