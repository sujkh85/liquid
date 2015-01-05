<!--
/***********************************************************************
 * �۾��� :  �̽¿� 
 * �۾����� : 2014.11.15~
 * � ���Ͽ� ȣ��޴°� : memberTerms.jsp : ��� ���ǽÿ��� ȣ�� ����
 * � ������ ȣ���ϴ°� : memberCheck.jsp : ���� �� ���̵�/�г��� �ߺ��˻��
 * ���� Ÿ�� : Ʋ
 * ��� : ȸ������ insert
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
            alert("ID�� �Է��� �ּ���");
            member_info_id.focus();
            return false;
        }
        if(member_info_nickname.value.replace(/\s/g,"") == "") {
            alert("�г����� �Է��� �ּ���");
            member_info_nickname.focus();
            return false;
        }
        
        if(member_info_pw.value.replace(/\s/g,"") == "" ){
            alert("��й�ȣ�� �Է��� �ּ���");
            member_info_pw.focus();
            return false;
        }
        
        if(member_info_pw.value != member_info_pw2.value){
            alert("��й�ȣ�� �����ϰ� �Է��� �ּ���");
            member_info_pw.value="";
            member_info_pw2.value="";
            member_info_pw.focus();
            return false;
        }
       
        if(member_info_name.value.replace(/\s/g,"") == "") {
            alert("����� �̸��� �Է��� �ּ���");
            member_info_name.focus();
            return false;
        }
    
        if(member_info_address2.value.replace(/\s/g,"") == "") {
            alert("���ּҸ� �Է��� �ּ���");
            address2.focus();
            return false;
        }
        
        if(member_info_phone.value.replace(/\s/g,"") == "") {
            alert("����ó�� �Է��ϼ���");
            member_info_phone.focus();
            return false;
        }
	}          
}

function openconfirmId(form) {
	// ���̵� �Է��ߴ��� �˻�
    if (form.member_info_id.value.replace(/\s/g,"") == "") {
        alert("���̵� �Է��� �ּ���");
        form.member_info_id.focus();
        return;
    }
	// ���̵� �������� ���ҹ��� �������� 5~12�ڸ��� ����
    var reg = new RegExp("(^[a-z0-9-_]{5}[a-z0-9-_]+$)");
    if(!reg.test(form.member_info_id.value)) {
	    alert('���̵� ������ ���� �ʽ��ϴ�.'); 
	    return false; 
    }   
     // ���̵� �ߺ��˻� ��â (DBź��) 
		var url = "membercheck.do?id="+form.member_info_id.value;
		/* form.member_info_id.value.method ="POST";
		form.member_info_id.value.target ="confirm"; */
	    window.open(url, "confirm", "resizable=no, width=300, height=200");
		/* form.member_info_id.value.submit();  */
    
    }
	
function openconfirmNickname(form) {	
	// �г����� �Է��ߴ��� �˻�
	if (form.member_info_nickname.value.replace(/\s/g,"") == "") {
        alert("�г����� �Է��� �ּ���");
        form.member_info_nickname.focus();
        return;
	}
	
      
    // �г��� �ߺ��˻� ��â���� (DBź��)
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
<h2>ȸ������</h2>
</div>
<hr>
<form method="post" name="member_info_form" action="membermessage.do" onSubmit="return inputcheck()">

<table class="table" align="center">
	<tr> 
		<td><h5><strong>���̵�</strong></h5></td>
		<td><input size="10" class="form-control" placeholder="���̵� �Է����ּ���" type="text"  maxlength="12" id="member_info_id" name="member_info_id">
		</td>
		<td>
			<input class="btn btn-primary btn-sm" type="button" value="ID�ߺ�Ȯ��"  OnClick="openconfirmId(this.form)" />
		</td>
	</tr> 
	<tr>
		<td><h5><strong>�г���</strong></h5></td>
		<td><input class="form-control" placeholder="�г����� �Է����ּ���" type="text" size="10" maxlength="12" id="member_info_nickname" name="member_info_nickname" >
		</td>
		<td>
		<input class="btn btn-primary btn-sm" type="button" value="�г����ߺ�Ȯ��"   OnClick="openconfirmNickname(this.form)" /></td> 
	</tr>
	<tr>
		<td><h5><strong>��й�ȣ</strong></h5></td>
		<td><input class="form-control" placeholder="��й�ȣ�� �Է����ּ���" type="password" size="15" maxlength="12" name="member_info_pw">
		</td>
		<td>
		</td>
	</tr>
	<tr>
		<td><h5><strong>��й�ȣȮ��</strong></h5></td>
		<td><input class="form-control" placeholder="�ٽ� ��й�ȣ�� �Է����ּ���" type="password" size="15" maxlength="12" name="member_info_pw2">
		</td>
		<td>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><h2>�������� �Է�</h2></td>
	</tr>
	<tr>
		<td><h5><strong>�̸�</strong></h5></td>
		<td><input class="form-control" placeholder="�̸��� �Է����ּ���" type="text" size="10" maxlength="12" name="member_info_name"/></td>
	</tr>
	<tr><td><h5><strong>�������</strong></h5></td>
		<td>
						<select name="year">
							<c:forEach begin="1950" end="2014" var="year">
							<option value="${year}">${year}��</option>
							</c:forEach>
						</select>
						<select name="month">
							<c:forEach begin="1" end="12" var="month">
							<option value="${month}" >${month}��</option>
							</c:forEach>
						</select>
						<select name="day">
							<c:forEach begin="1" end="31" var="day">
							<option value="${day}" >${day}��</option>
							</c:forEach>
						</select>
						</td>
	</tr>
	<tr>
		<td><h5><strong>����</strong></h5></td>
		<td colspan="2">
		    <label>��</label><input type="radio" name="member_info_gender" value="��" />
			<label>��</label><input type="radio" name="member_info_gender" value="��" /></td>
	</tr>
	<tr>
		<td><h5><strong>�ּ��Է�</strong></h5></td>
		<td colspan="2">
		<input type="text" id="member_info_post1" name="member_info_post1" size="5" maxlength="4" readonly> -
		<input type="text" id="member_info_post2" name="member_info_post2" size="5" maxlength="4" readonly>
        <input type="button" value="�����ȣ �˻�" onClick="openDaumPostcode()"><br>
        <input type="text" id="member_info_address1" name="member_info_address1" size="80" maxlength="100" readonly><br>
        <input type="text" id="member_info_address2" name="member_info_address2" size="80" maxlength="80">
		</td>
	</tr>
	<tr>
		<td><h5><strong>����ó</strong></h5></td>
		<td><input class="form-control" placeholder="����ó�� �Է����ּ���"type="text" name="member_info_phone" size="15" maxlength="15"></td>
	</tr>
	<tr>
		<td><h5><strong>�̸���</strong></h5></td>
		<td><input class="form-control" placeholder="�̸����� �Է����ּ���" type="text" name="member_info_email" size="40" maxlength="30"></td>
	</tr>
	<tr>
		<td colspan="3" align ="center">
		<input class="btn btn-primary btn-sm" type="submit" value="����ϱ�">
		<input class="btn btn-primary btn-sm" type="button" value="����ϱ�" onclick="location.href='main.do'">
		</td>
	</tr>
</table>
</form>
</body>
</html>