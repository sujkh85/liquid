<!--
/***********************************************************************
 * �۾��� :  �̽¿� 
 * �۾����� : 2014.11.21~
 * � ���Ͽ� ȣ��޴°� : memberForm.jsp:���� �� üũ / memberFormEdit.jsp:���� �� üũ
 * � ������ ȣ���ϴ°� : ����
 * ���� Ÿ�� : Ʋ
 * ��� : ���̵�/�г��� �ߺ��˻�� �˾�â ,jstl �±� ���̿� �ּ� ���� ���� �߻���.
  ***********************************************************************/
  --> 

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>�ߺ�Ȯ��</title>
<script src="js/jquery-1.11.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/respond.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<!-- <link href="style.css" rel="stylesheet" type="text/css"> -->
<script type="text/javascript">
	//�˾�â���� ���̵� �ߺ��˻� or ����ϱ�
	function confirmId(id)
    {		
		opener.member_info_form.member_info_id.value = id;
		self.close();   
	}
	function confirmIdcheck(){
		with(document.checkForm){
	        if(id.value.replace(/\s/g,"") == ""){
	            alert("ID�� �Է��� �ּ���");
	            id.focus();
	            return false;
	        } 
	        var reg = new RegExp("(^[a-z0-9-_]{5}[a-z0-9-_]+$)");
	        if(!reg.test(id.value)) {
			    alert("���̵� ������ ���� �ʽ��ϴ�.");
			    return false;
			}
		}
	}		     
	//�˾�â���� �г��� �ߺ��˻� or ����ϱ�
	function confirmNickname(nickname)
    {		
		opener.member_info_form.member_info_nickname.value = nickname;
		self.close();   
	}
	function confirmNicknamecheck(){
		with(document.checkForm){
	        if(nickname.value.replace(/\s/g,"") == ""){
	            alert("�г����� �Է��� �ּ���");
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
    <td height="39"><strong><span style="color:red;">${member_info_id}</span></strong> �� �̹� ������� ���̵��Դϴ�.</td>
  </tr>
</table>
<form name="checkForm" method="post" action="membercheck.do" onsubmit="return confirmIdcheck()">
<table width="270" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center"> �ٸ� ���̵� �����ϼ���.<p>
       <input class="btn btn-primary" type="text" size="10" maxlength="12" name="id"> 
       <input class="btn btn-primary" type="submit" value="ID�ߺ�Ȯ��" >
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
      <p>�Է��Ͻ� <strong><span style="color:blue;">${member_info_id}</span></strong> ��<br>
      ����Ͻ� �� �ִ� ID�Դϴ�. </p>
      <input class="btn btn-primary" type="button" value="����ϱ�" onclick="confirmId('${member_info_id}')" />
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
    <td height="39"><strong><span style="color:red;">${member_info_nickname}</span></strong> �� �̹� ������� �г����Դϴ�.</td>
  </tr>
</table> 
<form name="checkForm" method="post" action="membercheck.do" onsubmit="return confirmNicknamecheck()">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center"> �ٸ� �г����� �Է��ϼ���.<p>
       <input class="btn btn-primary" type="text" size="10" maxlength="12" name="nickname"> 
       <input class="btn btn-primary" type="submit" value="�г����ߺ�Ȯ��">
    </td>
  </tr> 
</table>
</form>
</c:if>
	<c:if test="${check == 1 && s_member_info_nickname == member_info_nickname }">
	<table width="270" border="0" cellspacing="0" cellpadding="5">
		<tr>		
	    	<td height="39"><strong><span style="color:blue;">${s_member_info_nickname}</span></strong> �� ���� ȸ������ ������� �г����Դϴ�.</td>
		</tr>
		<tr> 
    		<td align="center"> 
     	 	<input class="btn btn-primary" type="button" value="��� ����ϱ�" onclick="confirmNickname('${s_member_info_nickname}')">
    		</td>
	  	</tr>
	</table>
	</c:if>
<c:if test="${check == 0}"> 
<form action="">
<table width="270" border="1" cellspacing="0" cellpadding="5">
  <tr> 
    <td align="center"> 
      <p>�Է��Ͻ� <strong><span style="color:blue;">${member_info_nickname}</span></strong> ��<br>
      ����Ͻ� �� �ִ� �г����Դϴ�. </p>
      <input class="btn btn-primary" type="button" value="����ϱ�" onclick="confirmNickname('${member_info_nickname}')">
    </td>
  </tr>
</table>
</form>
</c:if> 
</c:when> 
</c:choose>
</body>
</html>
 
