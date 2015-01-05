<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> ��ٱ��� </title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="./js/bootstrap.min.js"></script>
<!-- <script src="./js/respond.js"></script> -->
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	    $("#allcheck").on("click", function(){
	        var isChecked = $("#allcheck").prop("checked");
	        $("input:checkbox[name=check]").prop("checked",isChecked);
	    });
	    
	    $("#cartDelete").click(function(){
	    	if (!($("#check").is(":checked"))){
		    	alert("�����Ͻ� ��ǰ�� �����ϼ���")
	    	}else{
	    		$("#cartList").attr("method","POST");
				$("#cartList").attr("action","cartCookieOut.jsp");
				$("#cartList").submit(); 
	    	}
	    });
	});
		 
	

</script>
</head>
<body>
<div align="center">
<h3>��ٱ���</h3>
<hr>
</div>
<div>
<form id="cartList">
<table width="900" class="table">
<thead>
<tr>
	<th> 
		<input type="checkbox" id="allcheck">
	</th>
	<th>
		
	</th>
	<th>
		��ǰ��
	</th>
	<th>
		����
	</th>
	<th>
		�ǸŰ�
	</th>
	<th>
		�Ұ�
	</th>
	<th>
		����
	</th>
</tr>
</thead>
<tbody>
<c:choose>
<c:when test="${cart_info.size() != null}">
<c:forEach items="${cart_info}" var="cart">
<tr style="text-align:center ;margin-top:80;" height="180">
	<td width="5%">
		<input type="checkbox"  id="check" name="check" >
	</td>
	<td width="20%" >
		<img src ="${cart.product_imgsrc1 }" width="140" height="180">
	</td>
	<td width="40%" style="text-align:center ;padding-top:80px;">
		${cart.product_name }, <b>${cart.stock_size }</b> ������
	</td>
	<td width="10%" style="text-align:center ;padding-top:80px;">
		<input type="text" size="5" value="${cart.order_detail_quantity }" name="order_detail_quantity" readonly><br>
		(���: ${cart.stock_quantity })
	</td>
	<td width="10%" style="text-align:center ;padding-top:80px;">
		${ cart.product_price } ��
	</td>
	<td width="15%" style="text-align:center ;padding-top:80px;">
		${cart.product_price * cart.order_detail_quantity } ��
	</td>
	<td style="text-align:center ;padding-top:80px;">
		<input type="button" id="cartDelete" name="cartDelete" value="����" class="btn btn-default" >
		<input type="hidden" id="cookieName" name="cookieName" value="${cart.cookieName}">
	</td>
</tr>
</c:forEach>

</c:when>
<c:otherwise>
<tr>
	<td height="150" colspan="7" align="center" style="text-align:center ;padding-top:80px;">��ٱ��ϰ� ��� �ֽ��ϴ�</td>
</tr>

</c:otherwise>
</c:choose>
</tbody>
<tfoot>
</tfoot>
</table>
</form>
</div>
<div align="center" >
		<input type="button" value="�ֹ��ϱ�" class="btn btn-default">		
		<input type="button" value="�����ϱ�" class="btn btn-default"> 		
</div>




</body>
</html>