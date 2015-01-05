<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- /***********************************************************************
 * �۾��� : �̽¿�
 * �۾����� : 14.11.18 
 * � ���Ͽ� ȣ��޴°� : main_ProductCatalogue.jsp
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� : ��ǰ,�������� ���� ����, ����/������/��� �ɼ� ��������
 * �̹�ȭ : �ֹ����� �Ѱܹ���.
 ***********************************************************************/ -->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="./css/product.css" type="text/css"> 
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<script type="text/javascript">	
	function orderGo(){
		$('#f_productDetail').attr("method","POST");
		$('#f_productDetail').attr("action","order_writeForm.do");
		$('#f_productDetail').submit();
	}
	function wishGo(){
		$('#f_productDetail').attr("method","POST");
		$('#f_productDetail').attr("action","wishlist_insert.do");
		$('#f_productDetail').submit();
	}
	function cartGo(){
		$('#f_productDetail').attr("method","POST");
		$('#f_productDetail').attr("action","./createCookie.jsp");
		$('#f_productDetail').submit();
		
	}	 

		
		 
</script>
</head>
<body>

<form id="f_productDetail" name="f_productDetail">
	<div>
		<input type="hidden" name="product_no" value="${product_List.getProduct_no()}" />
		<input type="hidden" name="product_name" value="${product_List.getProduct_name()}" />
		<input type="hidden" name="product_price" value="${product_List.getProduct_price()}" />
		<input type="hidden" name="product_imgsrc1" value="${product_List.getProduct_imgsrc1()}" />
	</div>
	<div id="img_main" align="center">
		<img src="${product_List.getProduct_imgsrc1()}" height="50%" width="50%">
	</div>
	<div class="product_detail" >
		<p>${product_List.getProduct_name()} 
		<p><font color="red">�ǸŰ���: ${product_List.getProduct_price()}�� </font>
		<p><select name ="stock_no">
			<option>�ɼ��� �������ּ���</option>
			<c:forEach items="${option_List}" var="option">
			<option value="${option.stock_no}"> ${option.stock_size}������ (���: ${option.stock_quantity})	</option>
			</c:forEach>
		</select>
		<ul>
			<li><input type="text" size="5" value="1" name="order_detail_quantity" >
				<input type="button" value="��" onclick="javascript:this.form.order_detail_quantity.value++">
				<input type="button" value="��" onclick="javascript:this.form.order_detail_quantity.value--">
			</li>
			<li><input type="button" class="btn btn-primary" value="�ֹ��ϱ�" onclick="orderGo()">
				<input type="button" class="btn btn-success" value="��ٱ���" onclick="cartGo()">
				<input type="button" class="btn btn-info" value="���ø���Ʈ" onclick="wishGo()"> 
			</li>	
		</ul>
		<p>
	</div>
</form>
		<hr>
<div id="content_detail" align="left">
	<h3>�󼼼���</h3>
	<c:if test="${product_List.getProduct_detail() == '' || product_List.getProduct_detail() == null }">
	������ �����ϴ�.
	</c:if>
	${product_List.getProduct_detail()}
	
	<p>
</div>




<jsp:include page="productDtag.jsp"/>


</body>
</html>