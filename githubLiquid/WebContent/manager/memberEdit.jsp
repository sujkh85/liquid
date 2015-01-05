<!--
/***********************************************************************
 * �۾��� :  �̽¿� 
 * �۾����� : 2014.11.15~
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� : memberCheck.jsp : �г��� �ߺ��˻��
 * ���� Ÿ�� : Ʋ
 * ��� : ��й�ȣ�� ������ ȸ���������� ����. 
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
	// �г����� �Է��ߴ��� �˻�
	if (form.member_info_nickname.value.replace(/\s/g,"") == "") {
        alert("�г����� �Է��� �ּ���");
        form.member_info_nickname.focus();
        return;
	}
    // �г��� �ߺ��˻� ��â���� (DBź��)
		var url = "membercheck.do?nickname="+form.member_info_nickname.value; 
		form.member_info_nickname.value.method ="POST";
		form.member_info_nickname.value.target ="confirm";
	    window.open(url, "confirm", "resizable=no, width=300, height=200");
		form.member_info_nickname.value.submit();
}

</script>
<title>ȸ������ ����</title>
</head>
<body>
<h3>ȸ������ ����</h3>
<hr>
<div id="d_memberForm" align="center">
<form id="f_memberForm" name="member_info_form"  action="manager_myinfogo.do?${infoList.getMember_info_no()}" method="post">
<table class="table">
	<tr>
		<td><h5><strong>ȸ�����</strong></h5></td>
		<td colspan="2">
		<select name="member_grade_no">
			<option value="10">������</option>
			<option value="20">�Ϲ�</option>
		</select>
		</td>
	</tr>
	<tr>
		<td><h5><strong>���̵�</strong></h5></td>
		<td colspan="2"><h5><strong>${infoList.getMember_info_id()}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>�г���</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="�г����� �Է����ּ���" type="text" size="10" maxlength="12" id="member_info_nickname" name="member_info_nickname" value="${infoList.getMember_info_nickname()}">
		</td>
		<td>
		<input class="btn btn-primary btn-sm" type="button" value="�г����ߺ�Ȯ��"   OnClick="openconfirmNickname(this.form)" /></td> 
	</tr>
	<tr>
	<td><h5><strong>��й�ȣ</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="��й�ȣ�� �Է����ּ���" type="password" size="15" maxlength="12" name="member_info_pw" >
		</td>
		</td></td>
	</tr>
	<tr>
		<td><h5><strong>��й�ȣȮ��</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="�ٽ� ��й�ȣ�� �Է����ּ���" type="password" size="15" maxlength="12" name="member_info_pw2">
		</td>
		<td>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><strong>�������� �Է�</strong></td>
	</tr>
	<tr>
		<td><h5><strong>�̸�</strong></h5></td>
		<td colspan="2"><h5><strong>${infoList.getMember_info_name()}</strong></h5></td>
	</tr>
	<tr>
		<td><h5><strong>����</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="������ �Է����ּ���" type="text" value="${infoList.getMember_info_birthday()}" name="member_info_birthday">
							
	</tr>
	<tr>
		<td><h5><strong>����</strong></h5></td>						
		<td>
			<c:choose>
			<c:when test="${infoList.getMember_info_gender() == '��' || infoList.getMember_info_gender() == '����'}">
			<label>��</label><input type="radio" name="member_info_gender" value="��" checked/>
			<label>��</label><input type="radio" value="��" disabled/>
			</c:when>
			<c:when test="${infoList.getMember_info_gender() == '��' || infoList.getMember_info_gender() == '����'}">
			<label>��</label><input type="radio" value="��" disabled />
			<label>��</label><input type="radio" name="member_info_gender" value="��" checked/>
			</c:when>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td><h5><strong>�ּ��Է�</strong></h5></td>
		<td colspan="2">
		<input type="text" id="member_info_post1" name="member_info_post1" size="5" maxlength="4" value="${infoList.getMember_info_post1()}" readonly> -
		<input type="text" id="member_info_post2" name="member_info_post2" size="5" maxlength="4" value="${infoList.getMember_info_post2()}" readonly>
        <input type="button" value="�����ȣ �˻�" onClick="openDaumPostcode()"><br>
        <input type="text" id="member_info_address1" name="member_info_address1" value="${infoList.getMember_info_address1()}" size="80" maxlength="100" readonly><br>
        <input type="text" id="member_info_address2" name="member_info_address2" value="${infoList.getMember_info_address2()}" size="80" maxlength="80">
		</td>
	</tr>
	<tr>
		<td><h5><strong>����ó</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="����ó�� �Է����ּ���" type="text" value="${infoList.getMember_info_phone()}" name="member_info_phone"></td>
	</tr>
	<tr>
		<td><h5><strong>�̸���</strong></h5></td>
		<td colspan="2"><input class="form-control" placeholder="�̸����� �Է����ּ���" type="text" value="${infoList.getMember_info_email()}" name="member_info_email"></td>
	</tr>
	<tr>
		<td></td>
		<td colspan="2">
		<input class="btn btn-success" type="submit" value="ȸ����������" >
		<input class="btn btn-success" type="button" value="��й�ȣ����" onclick="location.href='pwform.do'"> 
		<input class="btn btn-success" type="button" value="���ư���" onclick="location.href='manager_main.do'">
		</td>  
	</tr>
</table>
</form>
</div>
</body>
</html>