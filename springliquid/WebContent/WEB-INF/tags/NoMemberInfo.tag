<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:if test="${member_info_no == null}">
	<div align="center">
		<font color="red">�α��� �� �̿� �����մϴ�</font>
	</div>
	<jsp:include page="/member/memberLoginForm.jsp"></jsp:include>
</c:if>