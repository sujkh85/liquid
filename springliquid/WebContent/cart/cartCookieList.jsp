<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> 장바구니 </title>
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	    $("#allcheck").on("click", function(){
	        var isChecked = $("#allcheck").prop("checked");
	        $("input:checkbox[name=check]").prop("checked",isChecked);
	    });
	});
	
	function c_plus(form){
		form.order_detail_quantity.value++;
		form.price.value = form.price.value + form.price.value;
	}
	
	function c_minus(form){
		if ( form.order_detail_quantity.value == 1 ){
			alert('선택 할 수 없습니다');
		} else {
			form.order_detail_quantity.value--;
			form.price.value = form.price.value;
		}
		 
	}

</script>
</head>
<body>
<div align="center">
<h3>장바구니</h3>
<hr>
</div>
<div>
<form action="">
<table border="1" width="900" align="center">
<thead>
<tr align="center">
	<th> 
		<input type="checkbox" id="allcheck">
	</th>
	<th>
		
	</th>
	<th>
		상품명
	</th>
	<th>
		수량
	</th>
	<th>
		판매가
	</th>
	<th>
		소계
	</th>
	<th>
		삭제
	</th>
</tr>
</thead>
<tbody>
<c:choose>
<c:when test="${product_info.size() > 0 }">
<c:forEach items="${product_info}" var="cart">
<tr align="center" height="180">
	<td width="5%">
		<input type="checkbox" name="check" >
	</td>
	<td width="20%">
		<img src ="${cart.product_imgsrc1 }" width="140" height="180">
	</td>
	<td width="40%">
		${cart.product_name }, <b>${cart.stock_size }</b> 사이즈
	</td>
	<td width="10%">
		<input type="text" size="5" value="${quantity}" name="order_detail_quantity" readonly><br>
		(재고: ${cart.stock_quantity })
	</td>
	<td width="10%">
		${ cart.product_price } 원
	</td>
	<td width="15%" >
		${cart.product_price * quantity } 원
	</td>
	<td>
		<input type="button" value="수정" >
		<input type="button" value="삭제" >
	</td>
</tr>
</c:forEach>

</c:when>
<c:otherwise>
<tr height="150">
	<td colspan="7" align="center">장바구니가 비어 있습니다</td>
</tr>

</c:otherwise>
</c:choose>
</tbody>
<tfoot>
<tr>
	<td colspan="5" align="right">
		총계  
	</td>
	<td colspan="2">
		0
	</td>
</tr>
</tfoot>
</table>
</form>
</div>
<div align="center">
		<input type="button" value="주문하기"> 		
		<input type="button" value="삭제하기"> 		
</div>




</body>
</html>