<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 페이지 용도 : 주문상태별 목록(입금대기,주문완료,결제완료..등등..)보여줄 페이지
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
	<c:when test="${param.status=='입금대기'}"><h2>입금대기 </h2></c:when>
	<c:when test="${param.status=='배송대기'}"><h2>배송대기 </h2></c:when>
	<c:when test="${param.status=='상품준비중'}"><h2>상품준비중 </h2></c:when>
	<c:when test="${param.status=='상품배송중'}"><h2>상품배송중 </h2></c:when>
	<c:when test="${param.status=='배송완료'}"><h2>배송완료 </h2></c:when>
	<c:when test="${param.status=='전체주문조회'}"><h2>전체주문조회 </h2></c:when>
</c:choose>
<hr>
<form name="order_paystatus" action="manager_orderstatuschange.do">
		<input type="radio" name="order_paystatus" value="입금대기" onclick="location.href='manager_orderstatus.do?status=입금대기'">입금대기
		<input type="radio" name="order_paystatus" value="배송대기" onclick="location.href='manager_orderstatus.do?status=배송대기'">배송대기
		<input type="radio" name="order_paystatus" value="상품준비중" onclick="location.href='manager_orderstatus.do?status=상품준비중'">상품준비중
		<input type="radio" name="order_paystatus" value="상품배송중" onclick="location.href='manager_orderstatus.do?status=상품배송중'">상품배송중
		<input type="radio" name="order_paystatus" value="배송완료" onclick="location.href='manager_orderstatus.do?status=배송완료'">배송완료
		<input type="radio" name="order_paystatus" value="주문취소" onclick="location.href='manager_orderstatus.do?status=주문취소'">주문취소<p>
		<table border="1" align="center" width="1000">

		<tr align="center" bgcolor="gray">
				<!-- <td>No</td> -->
				<td>주문번호</td>
				<td>회원명</td>
				<td>주문일자</td>
				<td>주문상태</td>
				<td>결제수단</td>
				<td>회원 전화번호</td>
				<c:choose>
					<c:when test="${param.status=='입금대기' }">
						<td>결제 예정 금액</td>
					</c:when>
				</c:choose>
				<td>최종 결제 금액</td>
				<c:choose>
				<c:when test="${param.status!='전체주문조회'&&param.status!='배송완료'&&param.status!='주문취소' }">
				 <td><input type="checkbox" name="allcheck" id="allcheck"></td>
				</c:when>
				</c:choose>
		</tr>
		<c:if test="${empty list}">
				<tr>
					<td colspan="9" align="center"><h2>데이터가 없습니다.</h2></td>
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
					<c:when test="${param.status=='입금대기' }">
						<td align="center">${dto.order_money}</td>
					</c:when>
				</c:choose>
				<td align="center">${dto.order_final_money}</td>
		<c:choose>
		<c:when test="${param.status!='전체주문조회'&&param.status!='배송완료'&&param.status!='주문취소' }">
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
			<c:if test="${param.status=='입금대기' }">
					<td colspan="8">${pg }
			</c:if>
			<c:if test="${param.status!='입금대기' }">
				<td colspan="7">${pg }</td>
			</c:if>
			<c:choose>
			<c:when test="${param.status!='전체주문조회'&&param.status!='배송완료'&&param.status!='주문취소' }">
				<td align="center">
			<c:choose>
			<c:when test="${param.status=='입금대기' }">
        		<input type="submit" value="입금확인"  >
			</c:when>
			<c:when test="${param.status=='배송대기' }">
        		<input type="submit" value="상품준비"  >
			</c:when>
			<c:when test="${param.status=='상품준비중' }">
        		<input type="submit" value="상품배송"  >
			</c:when>
			<c:when test="${param.status=='상품배송중' }">
        		<input type="submit" value="배송완료"  >
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