<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- ���� ������ �Խ��� crud ���� -->
<!-- insert -->
<c:if test="${insertDesign == 1 }" >
	<script>
		alert("������ ��ǰ ��Ͽ� ���� �Ͽ����ϴ�.");
		location.href="designList.do";
	</script>
</c:if>
<c:if test="${insertDesign == 0 }" >
	<script>
		alert("������ ��ǰ ��Ͽ� ���� �Ͽ����ϴ�.");
		location.href="designWriteForm.do";
	</script>
</c:if>
<!-- update -->
<c:if test="${updateDesign == 1 }" >
	<script>
		alert("������ ��ǰ ������ ���� �Ͽ����ϴ�.");
		location.href="designDetail.do";
	</script>
</c:if>
<c:if test="${updateDesign == 0 }" >
	<script>
		alert("������ ��ǰ ������ ���� �Ͽ����ϴ�.");
		location.href="designDetail.do";
	</script>
</c:if>
<!-- delete -->
<c:if test="${deleteDesign == 1 }" >
	<script>
		alert("������ ��ǰ ������ ���� �Ͽ����ϴ�.");
		location.href="designList.do";
	</script>
</c:if>
<c:if test="${deleteDesign == 0 }" >
	<script>
		alert("������ ��ǰ ��Ͽ� ���� �Ͽ����ϴ�.");
		location.href="designDetail.do";
	</script>
</c:if>
<!-- ���� ������ �Խ��� crud �� -->

</body>
</html>