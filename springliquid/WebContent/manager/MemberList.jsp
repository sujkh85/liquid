<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- 
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * ������ �뵵 : ������ ������ �����ִ� ������
 ***********************************************************************/
 -->       
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="member_list" align="center">
<h2><span class="glyphicon glyphicon-hand-right"></span>ȸ������</h2>
<hr>
		<table border="1" align="center" width="1000">
		<tr align="center" bgcolor="gray">
				<td>No</td>
				<td>���̵�</td>
				<td>ȸ�����</td>
				<td>ȸ����� �̸�</td>
				<td>ȸ�� �̸�</td>
				<td>�������� <a href="manager_list.do?align=desc">��</a>
						  <a href="manager_list.do?align=asc">��</a></td>
				<td>��ȭ��ȣ</td>			
				<td>����</td>			
				
		</tr>

		<c:forEach items="${list}" var="dto">
			<tr onmouseover="this.style.backgroundColor='gray'" onMouseOut="this.style.backgroundColor='white'">
				<td align="center">${dto.rownum}</td>
				<td align="center">${dto.member_info_id}</td>
				<td align="center">${dto.member_grade_no}</td>
				<td align="center">${dto.member_grade_name}</td>
				<td align="center">${dto.member_info_name}</td>
				<td align="center">${dto.member_info_date}</td>
				<td align="center">${dto.member_info_phone}</td>
				<td align="center"><input type="button" value="�󼼺���" onclick="location.href='manager_detail_list.do?member_info_no=${dto.member_info_no}'"></td>
				
			</tr>
		</c:forEach>
			<tr>
				<td colspan="8">${pg }</td>
			</tr>
		</table>
</div>
</body>
</html>