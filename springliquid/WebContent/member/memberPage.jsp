<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>my page</title>
</head>
<body>
<div class="" align="center">
<c:choose>
	<c:when test="${infoList!=null}">
<h2>Mypge</h2>
<hr>
	<div class="message">
		�α��ο� �����Ͽ����ϴ�. ${s_member_info_nickname}�� ȯ���մϴ�<p>
	</div>
	<div class="">
		<ul> 
			<li>ȸ�� ��� :[${infoList.getMember_info_name()}] ���� [${infoList.getMember_grade_name()}] ȸ�� �Դϴ�.</li>
			<li>������ �ֹ� :<input type="text" value="${infoList.getOrderCount()}" size="3" disabled />�� �Դϴ�.</li>
			<li><a href="myinfoform.do">ȸ������ ����</a></li>
			<li><a href="pwform.do">�н����� ����</a></li>
		</ul>
	</div>
	</c:when>
	<c:otherwise>
	<div class="message">
	<!-- �α����� ȸ���� ���� �ִ� ȭ�������� �ּ�â�� ������
	��ȸ���� mypage.do�� ���� ��û �� �� �ֱ� ������ �̷� ��츦 �����
	����ǥ�� ���� �������� �ʿ��ϴ�. 14.11.25 00:38 ������ -->
		<ul>
			<li>ȸ������ ���� �Դϴ�.</li>
			<li>�α��� �� �̿� ��Ź�帳�ϴ�.</li>
			<li><a href="memberagree.do">���� ȸ������</a></li>
		</ul>
	</div>
</c:otherwise>
</c:choose>
</div>
</body>

</html>