<!--
/***********************************************************************
 * �۾��� : ������  -> 
 * �۾����� : 
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� : 
 * ���� Ÿ�� :
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
</head>
<body>
<div align="center">
<h1>�� �󼼺���</h1>
	 <form action="designRetrieve.do">
	 <input type="hidden" name="board_userdesign_no" value="${detailDesign.board_userdesign_no}">
	<table border="1" align="center" width="600">	
	<!-- �亯�� �ʿ�  -->
	<tr >                                                                                                                          
		<th align="left">&nbsp;${detailDesign.board_userdesign_title} </th>
	</tr>
	<tr>
		<td>����� : ${detailDesign.board_userdesign_date} <br>
			�ۼ��� : ${detailDesign.member_info_nickname} &nbsp; | &nbsp; ��ȸ�� : ${detailDesign.board_userdesign_viewcount}</td>
	</tr>
	<tr>
		<td height="100" valign="top"><b>����</b> ${detailDesign.board_userdesign_imgsrc3}<br> ${detailDesign.board_userdesign_content}</td>
	</tr>
	<tr align="center">
		<td>
	<img src="${detailDesign.board_userdesign_imgsrc1}"><br>
	<img src="${detailDesign.board_userdesign_imgsrc2}"><br>
	<img src="${detailDesign.board_userdesign_imgsrc3}"><br>
	<img src="${detailDesign.board_userdesign_imgsrc4}"><br>
	<img src="${detailDesign.board_userdesign_imgsrc5}"><br>
		</td>
	</tr>
		
	
	<tr><!-- �α��� �����̰�, �۾��� �г��Ӱ� �α��� �� ����� �г����� ��ġ�ϸ�  
			 �ƴϸ� �����ڰ� �α��� �� �����̸�-->
		<td><c:choose>
 				<c:when test="${(s_member_info_no != null && detailDesign.member_info_nickname == s_member_info_nickname) || s_member_grade_no == '10' }"> 
					<input class="btn btn-primary" type="submit"  value="�����ϱ�">
					<a href="designDelete.do?board_userdesign_no=${detailDesign.board_userdesign_no}"><button class="btn btn-success" type="button">����</button></a>
			�� ���� ������ ����ٸ�?<a href="designfavorite.do?board_userdesign_no=${detailDesign.board_userdesign_no}&member_info_no=${s_member_info_no}"><button  class="btn btn-danger" type="button">��õ</button></a>
				</c:when> 
				<c:otherwise>
				ȸ���� �ǽø� ������ ��õ�� �� �� �ֽ��ϴ�.
				</c:otherwise>
			</c:choose>
			<div align="right">
			<a href="designList.do"><button class="btn btn-primary" type="button">��Ϻ���</button></a>
			</div>
		</td>
		</tr>
	</table> 
	</form>
</div> 
</body>
</html>