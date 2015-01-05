<!--
/***********************************************************************
 * �۾��� : ������  -> �ֽ�ȯ
 * �۾����� : 2014.11.03~10 ,12.08~11
 * � ���Ͽ� ȣ��޴°� :  qna_listPage.jsp,
 * � ������ ȣ���ϴ°� :  qna_reply.jsp qna_retrieve.jsp
 * ���� Ÿ�� : qna�Խ��� ���� ��ǰ..
 ***********************************************************************/
  -->    


<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� �󼼺���</title>
<link rel="stylesheet" href="./css/table.css" type="text/css"> 
</head>
<body>
<%
String mode = request.getParameter("mode");
if("manager".equals(mode)){
%>
<div align="center">
<h1><span class="glyphicon glyphicon-pencil"></span> �� �󼼺���</h1>
	 <form action="manager_qna_retrieve.do?mode=manager">
	 <input type="hidden" name="board_question_no" value="${detail.board_question_no}">
	�۹�ȣ${detail.board_question_no}&nbsp; ��ȸ��${detail.board_question_viewcount}<br />
	<table border="1" align="center" width="600" class="ex1">
	<thead>
	<tbody>
	<!-- �亯�� �ʿ�  -->
	<tr class="menu1">                                                                                                                          
		<th align="center">&nbsp;${detail.board_question_title} </th>
	</tr>
	<tr class="menu0">
		<td>����� : ${detail.board_question_date} <br>
			�ۼ��� : ${detail.member_info_no_nickname} &nbsp; | &nbsp; ��ȸ�� : ${detail.board_question_viewcount}</td>
	</tr>
	<tr  class="menu0">
		<td height="100" valign="top"><b>����</b> <br> ${detail.board_question_content}</td>
	</tr>
	
	<c:choose>
		<c:when test="${detail.board_question_imgsrc1 != null}">
			<tr class="menu0">
				<th align="left">÷���̹���1</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc1}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${detail.board_question_imgsrc2 != null}">
			<tr class="menu0">
				<th align="left">÷���̹���2</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc2}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc3 != null}">
			<tr class="menu0">
				<th align="left">÷���̹���3</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc3}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc4 != null}">
			<tr class="menu0">
				<th align="left">÷���̹���4</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc4}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc5 != null}">
			<tr class="menu0">
				<th align="left">÷���̹���5</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc5}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		
	
	<tr><!-- �α��� �����̰�, �۾��� �г��Ӱ� �α��� �� ����� �г����� ��ġ�ϸ�  -->
		<td><c:choose>
 				<c:when test="${(s_member_info_no != null && detail.member_info_no_nickname == member_info_nickname) || s_member_grade_no == '10' }"> 
					<input class="btn btn-info" type="submit"  value="�����ϱ�">
					<a href="manager_qna_delete.do?board_question_no=${detail.board_question_no}"><button type="button" class="btn btn-info">����</button></a>
				</c:when> 
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<div align="right">
			<a href="manager_qna_list.do?mode=manager"><button type="button" class="btn btn-info">��Ϻ���</button></a>
			<c:choose>
				<c:when test="${s_member_info_no != null}">
					<a href="manager_qna_replyui.do?mode=manager&board_question_no=${detail.board_question_no}"><button type="button" class="btn btn-info">�亯�۴ޱ�</button></a>
				</c:when> 
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			
			</div>
		</td>
		</tr>
		</tbody>
	</thead>	
	</table>
	</form>
</div> 


<%}else{ %>	
	<div align="center">
<h1>�� �󼼺���</h1>
	 <form action="qna_retrieve.do">
	 <input type="hidden" name="board_question_no" value="${detail.board_question_no}">
	�۹�ȣ${detail.board_question_no}&nbsp; ��ȸ��${detail.board_question_viewcount}<br />
	<table border="1" align="center" width="600" class="ex1">
	<thead>	
	<tbody>
	<!-- �亯�� �ʿ�  -->
	<tr class="menu0">                                                                                                                          
		<th align="center">&nbsp;${detail.board_question_title} </th>
	</tr>
	<tr class="menu0">
		<td>����� : ${detail.board_question_date} <br>
			�ۼ��� : ${detail.member_info_no_nickname} &nbsp; | &nbsp; ��ȸ�� : ${detail.board_question_viewcount}</td>
	</tr>
	<tr class="menu0">
		<td height="100" valign="top"><b>����</b> <br> ${detail.board_question_content}</td>
	</tr>
	
<%-- 	<tr>
	<td>
	<c:forEach begin="1" var="i"  end="5" >
	${detail.board_question_imgsrc1}
	</c:forEach>
	</td>
	</tr> --%>
	
	
	
	<c:choose>
		<c:when test="${detail.board_question_imgsrc1 != null}">
			<tr class="menu0">
				<th align="left">÷���̹���1</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc1}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${detail.board_question_imgsrc2 != null}">
			<tr class="menu0">
				<th align="left">÷���̹���2</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc2}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc3 != null}">
			<tr class="menu0">
				<th align="left">÷���̹���3</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc3}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc4 != null}">
			<tr class="menu0">
				<th align="left">÷���̹���4</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc4}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${detail.board_question_imgsrc5 != null}">
			<tr class="menu0">
				<th align="left">÷���̹���5</th>
			</tr>	
			<tr class="menu0">
				<td><img src="${detail.board_question_imgsrc5}" width="600" height="600"></td>
			</tr>
		</c:when> 
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		
	
	<tr><!-- �α��� �����̰�, �۾��� �г��Ӱ� �α��� �� ����� �г����� ��ġ�ϸ�  -->
		<td><c:choose>
 				<c:when test="${(s_member_info_no != null && detail.member_info_no_nickname == s_member_info_nickname)  }"> 
					<input class="btn btn-info" type="submit" value="�����ϱ�">
					<a href="qna_delete.do?mode=manager&board_question_no=${detail.board_question_no}"><button class="btn btn-info" type="button">����</button></a>
				</c:when> 
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<div align="right">
			<a href="qna_list.do"><button type="button" class="btn btn-info">��Ϻ���</button></a>
			<c:choose>
				<c:when test="${s_member_info_no != null}">
					<a href="qna_replyui.do?board_question_no=${detail.board_question_no}"><button type="button" class="btn btn-info">�亯�۴ޱ�</button></a>
				</c:when> 
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			
			</div>
		</td>
		</tr>
		</tbody>
		</thead>
	</table> 
	</form>
</div> 
	
<%} %>

</body>
</html>