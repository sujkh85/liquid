<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/product.css" type="text/css"> 
</head>
<body>
	<div align="center" style="margin-top:50px; ">
		<c:if test="${s_member_info_no == null }"> 작품 등록은 회원만 가능합니다. </c:if>
		<c:if test="${s_member_info_no != null }"><input type="button" value="등록하기" class="btn btn-info" onclick="location.href='designWriteForm.do'"></c:if>
		<form action="designSearch.do">
			<select name="searchName" size="1">
				<option value="member_info_nickname">작성자</option>
				<option value="board_question_title">글제목</option>
			</select>
			<input type="text" name="searchValue">
			<input type="submit" value="찾기">					
		</form>
	</div> 
	<div class="product">
		<!-- 페이지 번호 -->
		<div align="center" id="pageView">${pg}</div> 
		<!-- 표시할 상품이 있을 때 -->			
		<c:forEach items="${listDesign}" var="listDesign" varStatus="i">
			<div class="product-list" >
				<ul class="btn btn-default" >
					<c:if test="${listDesign != null}">
						<c:choose>
						<c:when test="${listDesign.getBoard_userdesign_imgsrc1() != null }">
							<li class="img"><a href="designDetail.do?board_userdesign_no=${listDesign.getBoard_userdesign_no()}"><img src="${listDesign.getBoard_userdesign_imgsrc1()}" width="200" height="240" ></a></li>
						</c:when>
						<c:when test="${listDesign.getBoard_userdesign_imgsrc1() == null }"> 
							<li class="img"><img src="./img/img_No.jpg" height="240"></li>
						</c:when>
						</c:choose>
							<li class="no">글 번호: ${listDesign.getBoard_userdesign_no()}</li>	
							<li class="title">타이틀: <a href="designDetail.do?board_userdesign_no=${listDesign.getBoard_userdesign_no()}" >${listDesign.getBoard_userdesign_title()}</a></li>
							<li class="nickname">디자이너: ${listDesign.getMember_info_nickname()} </li>	
							<li class="favorite">조회수 : ${listDesign.getBoard_userdesign_viewcount()} | 추천수: ${listDesign.getBoard_userdesign_favorite()}</li>	
					</c:if>
				</ul>
			</div>
		</c:forEach>
		
	</div>
</body>
</html>