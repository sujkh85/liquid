<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Member Part Message</title>
</head>
<body>
<c:choose>
	<c:when test="${insert_result == 1}">
		<div align="center" >
<!-- ȸ������ ���� �޽��� -->
		ȸ��������  ���ϵ帳�ϴ� !!!!
		<p>ȸ���Ե��� ���� ���� ���� ���񽺸� ���� ����ϰڽ��ϴ�.</p>
		<p>�����Ϸ�Ǽ���!</p>
		<a href="main.do"> Ȩ���� </a>
		</div>
	</c:when>
	<c:when test="${insert_result == 0 }">
		<div align="center">
<!-- ȸ������ ���� �޽��� -->
		ȸ�����Կ� ���� �Ͽ����ϴ�. ��� �� �ٽ� �õ����ֽʽÿ�.
		</div>
	</c:when>
	<c:when test="${update_result == 1 }">
		<div align="center">
<!-- ȸ������ ���� ���� �޽��� -->	
		ȸ������ ������ �����Ͽ����ϴ�.
		</div>
	</c:when>
	<c:when test="${update_result == 0 }">
		<div align="center">
<!-- ȸ������ ���� ���� �޽��� -->	
		ȸ������ ������ ���� �Ͽ����ϴ�. ��� �� �ٽ� �õ����ֽʽÿ�.
		</div>
	</c:when>
	<c:when test="${delete_result == 1 }">
		<div align="center">
<!-- ȸ��Ż�� ���� �޽���  -->
		ȸ�� Ż�� ���� �Ͽ����ϴ�. ���ݱ��� Liquid ���θ��� �̿����ּż� �����մϴ�.
		</div>
	</c:when>
</c:choose>
</body>
</html>