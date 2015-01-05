<!--
/***********************************************************************
 * 작업자 :  이승우 
 * 작업일자 : 2014.11.15~
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 : memberCheck.jsp : 닉네임 중복검사시
 * 파일 타입 : 틀
 * 기능 : 비밀번호를 제외한 회원정보수정 가능. 
  ***********************************************************************/
  --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://dmaps.daum.net/map_js_init/postcode.js"></script> 
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
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
function openconfirmNickname(form) {	
	// 닉네임을 입력했는지 검사
	if (form.member_info_nickname.value.replace(/\s/g,"") == "") {
        alert("닉네임을 입력해 주세요");
        form.member_info_nickname.focus();
        return;
	}
    // 닉네임 중복검사 새창열기 (DB탄다)
		var url = "membercheck.do?nickname="+form.member_info_nickname.value; 
		form.member_info_nickname.value.method ="POST";
		form.member_info_nickname.value.target ="confirm";
	    window.open(url, "confirm", "resizable=no, width=300, height=200");
		form.member_info_nickname.value.submit();
}

</script>
<title>회원정보 수정</title>
</head>
<body>
<h3>회원정보 수정</h3>
<hr>
<div id="d_memberForm" align="center">
<form id="f_memberForm" name="member_info_form"  action="manager_myinfogo.do?${infoList.getMember_info_no()}" method="post">
<table class="table">
	<tr>
		<td><h5><strong>회원등급</strong></h5></td>
		<td colspan="2">
		<select name="member_grade_no">
			<option value="10">관리자</option>
			<option value="20">일반</option>
		</select>
		</td>
	</tr>
	<tr>
		<td><h5><strong>아이디</strong></h5></td>
		<td colspan="2"><h5><strong>${infoList.getMember_info_id()}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>닉네임</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="닉네임을 입력해주세요" type="text" size="10" maxlength="12" id="member_info_nickname" name="member_info_nickname" value="${infoList.getMember_info_nickname()}">
		</td>
		<td>
		<input class="btn btn-primary btn-sm" type="button" value="닉네임중복확인"   OnClick="openconfirmNickname(this.form)" /></td> 
	</tr>
	<tr>
	<td><h5><strong>비밀번호</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="비밀번호를 입력해주세요" type="password" size="15" maxlength="12" name="member_info_pw" >
		</td>
		</td></td>
	</tr>
	<tr>
		<td><h5><strong>비밀번호확인</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="다시 비밀번호를 입력해주세요" type="password" size="15" maxlength="12" name="member_info_pw2">
		</td>
		<td>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><strong>개인정보 입력</strong></td>
	</tr>
	<tr>
		<td><h5><strong>이름</strong></h5></td>
		<td colspan="2"><h5><strong>${infoList.getMember_info_name()}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>생일</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="생일을 입력해주세요" type="text" value="${infoList.getMember_info_birthday()}" name="member_info_birthday">
							
	</tr>
	<tr>
		<td><h5><strong>성별</strong></h5></td>						
		<td>
			<c:choose>
			<c:when test="${infoList.getMember_info_gender() == '남' || infoList.getMember_info_gender() == '남자'}">
			<label>남</label><input type="radio" name="member_info_gender" value="남" checked/>
			<label>여</label><input type="radio" value="여" disabled/>
			</c:when>
			<c:when test="${infoList.getMember_info_gender() == '여' || infoList.getMember_info_gender() == '여자'}">
			<label>남</label><input type="radio" value="남" disabled />
			<label>여</label><input type="radio" name="member_info_gender" value="여" checked/>
			</c:when>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td><h5><strong>주소입력</strong></h5></td>
		<td colspan="2">
		<input type="text" id="member_info_post1" name="member_info_post1" size="5" maxlength="4" value="${infoList.getMember_info_post1()}" readonly> -
		<input type="text" id="member_info_post2" name="member_info_post2" size="5" maxlength="4" value="${infoList.getMember_info_post2()}" readonly>
        <input type="button" value="우편번호 검색" onClick="openDaumPostcode()"><br>
        <input type="text" id="member_info_address1" name="member_info_address1" value="${infoList.getMember_info_address1()}" size="80" maxlength="100" readonly><br>
        <input type="text" id="member_info_address2" name="member_info_address2" value="${infoList.getMember_info_address2()}" size="80" maxlength="80">
		</td>
	</tr>
	<tr>
		<td><h5><strong>연락처</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="연락처를 입력해주세요" type="text" value="${infoList.getMember_info_phone()}" name="member_info_phone"></td>
	</tr>
	<tr>
		<td><h5><strong>이메일</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="이메일을 입력해주세요" type="text" value="${infoList.getMember_info_email()}" name="member_info_email"></td>
	</tr>
	<tr>
		<td></td>
		<td colspan="2">
		<input class="btn btn-success" type="submit" value="회원정보수정" >
		<input class="btn btn-success" type="button" value="비밀번호변경" onclick="location.href='pwform.do'"> 
		<input class="btn btn-success" type="button" value="돌아가기" onclick="location.href='manager_main.do'">
		</td>  
	</tr>
</table>
</form>
</div>
</body>
</html>