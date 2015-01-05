<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * ������ �뵵 : �ֹ����º� ���(�Աݴ��,�ֹ��Ϸ�,�����Ϸ�..���..)������ ������
 ***********************************************************************/
 -->       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#allcheck").on("click", function(){
        var isChecked = $("#allcheck").prop("checked");
        $("input:checkbox[name=check]").prop("checked",isChecked);
    });
});

</script>

</head>
<body>
<div id="orderstatus" align="center">
<c:choose>
	<c:when test="${param.status=='�Աݴ��'}"><h2>�Աݴ�� </h2></c:when>
	<c:when test="${param.status=='��۴��'}"><h2>��۴�� </h2></c:when>
	<c:when test="${param.status=='��ǰ�غ���'}"><h2>��ǰ�غ��� </h2></c:when>
	<c:when test="${param.status=='��ǰ�����'}"><h2>��ǰ����� </h2></c:when>
	<c:when test="${param.status=='��ۿϷ�'}"><h2>��ۿϷ� </h2></c:when>
	<c:when test="${param.status=='��ü�ֹ���ȸ'}"><h2>��ü�ֹ���ȸ </h2></c:when>
</c:choose>
<hr>
<form name="order_paystatus" action="manager_orderstatuschange.do">
		<input type="radio" name="order_paystatus" value="�Աݴ��" onclick="location.href='manager_orderstatus.do?status=�Աݴ��'">�Աݴ��
		<input type="radio" name="order_paystatus" value="��۴��" onclick="location.href='manager_orderstatus.do?status=��۴��'">��۴��
		<input type="radio" name="order_paystatus" value="��ǰ�غ���" onclick="location.href='manager_orderstatus.do?status=��ǰ�غ���'">��ǰ�غ���
		<input type="radio" name="order_paystatus" value="��ǰ�����" onclick="location.href='manager_orderstatus.do?status=��ǰ�����'">��ǰ�����
		<input type="radio" name="order_paystatus" value="��ۿϷ�" onclick="location.href='manager_orderstatus.do?status=��ۿϷ�'">��ۿϷ�
		<input type="radio" name="order_paystatus" value="�ֹ����" onclick="location.href='manager_orderstatus.do?status=�ֹ����'">�ֹ����<p>
		<table border="1" align="center" width="1000">

		<tr align="center" bgcolor="gray">
				<!-- <td>No</td> -->
				<td>�ֹ���ȣ</td>
				<td>ȸ����</td>
				<td>�ֹ�����</td>
				<td>�ֹ�����</td>
				<td>��������</td>
				<td>ȸ�� ��ȭ��ȣ</td>
				<c:choose>
					<c:when test="${param.status=='�Աݴ��' }">
						<td>���� ���� �ݾ�</td>
					</c:when>
				</c:choose>
				<td>���� ���� �ݾ�</td>
				<c:choose>
				<c:when test="${param.status!='��ü�ֹ���ȸ'&&param.status!='��ۿϷ�'&&param.status!='�ֹ����' }">
				 <td><input type="checkbox" name="allcheck" id="allcheck"></td>
				</c:when>
				</c:choose>
		</tr>
		<c:if test="${empty list}">
				<tr>
					<td colspan="9" align="center"><h2>�����Ͱ� �����ϴ�.</h2></td>
				</tr>
			</c:if>

		<c:forEach items="${list}" var="dto">
			<tr onmouseover="this.style.backgroundColor='gray'" onMouseOut="this.style.backgroundColor='white'">
				<%-- <td align="center">${dto.rownum}</td> --%>
				<td align="center">${dto.order_no}</td>
				<td align="center">${dto.member_info_name}</td>
				<td align="center">${dto.order_date}</td>
				<td align="center">${dto.order_paystatus}</td>
				<td align="center">${dto.order_payment}</td>
				<td align="center">${dto.member_info_phone}</td>
				<c:choose>
					<c:when test="${param.status=='�Աݴ��' }">
						<td align="center">${dto.order_money}</td>
					</c:when>
				</c:choose>
				<td align="center">${dto.order_final_money}</td>
		<c:choose>
		<c:when test="${param.status!='��ü�ֹ���ȸ'&&param.status!='��ۿϷ�'&&param.status!='�ֹ����' }">
		<td align="center">
	        <input type="checkbox" name="check" id="check" value="${dto.order_no}" >
	        <input type="hidden" name="order_paystatus" value="${dto.order_paystatus}">
	        <input type="hidden" name="order_money" value="${dto.order_money}">
        </td>
		</c:when>
		</c:choose>
			</tr>
		</c:forEach>
		
			<tr>
			<c:if test="${param.status=='�Աݴ��' }">
					<td colspan="8">${pg }
			</c:if>
			<c:if test="${param.status!='�Աݴ��' }">
				<td colspan="7">${pg }</td>
			</c:if>
			<c:choose>
			<c:when test="${param.status!='��ü�ֹ���ȸ'&&param.status!='��ۿϷ�'&&param.status!='�ֹ����' }">
				<td align="center">
			<c:choose>
			<c:when test="${param.status=='�Աݴ��' }">
        		<input type="submit" value="�Ա�Ȯ��"  >
			</c:when>
			<c:when test="${param.status=='��۴��' }">
        		<input type="submit" value="��ǰ�غ�"  >
			</c:when>
			<c:when test="${param.status=='��ǰ�غ���' }">
        		<input type="submit" value="��ǰ���"  >
			</c:when>
			<c:when test="${param.status=='��ǰ�����' }">
        		<input type="submit" value="��ۿϷ�"  >
			</c:when>
		 </c:choose>	
		 	
		   </td>
			</c:when>
			</c:choose>
			
			</tr>
		</table>
</form>
</div>
</body>
</html>