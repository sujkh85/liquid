<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Member Part Message</title>
<script type="text/javascript">
	function relocale(){
		 setTimeout('location.href="manager_main.do"',1000);
	}
</script>
</head>
<body onLoad="relocale()">
<c:choose>
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
</c:choose>
</body>
</html>