<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상품 등록 화면</title>
<link rel="stylesheet" type="text/css" href="./css/easyui.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
	<form action="productWrite.do" method="post" enctype="multipart/form-data">
	<div align="center">
	<table border="1" align="center">
		<tr>
			<th colspan="4">상품정보 입력</th>
		</tr>
		<tr>
			<td rowspan="2">상품 타입</td>
			<td rowspan="2">성별 타입</td>
			<td><select name="product_type_no">
			<option value="1">OUTER</option>
			<option value="2">TOP</option>
			<option value="3">BOTTOMS</option>			
			<option value="4">OPNPIECE</option>			
			<option value="6">SALE</option>			
			<option value="5">ETC</option>			
			</select></td>
			<td>
			<label>남</label><input type="radio" name="member_info_gender" value="남" />
			<label>여</label><input type="radio" name="member_info_gender" value="여" />
			</td>
		</tr>
		<tr>	
			<td><input type="text" name="product_title" size="100" maxlength="100"></td>
			
			
			</td>
		</tr>
		<tr>
			<td>
				가격정보
			</td>
			<td>
				<input type="text" name="product_cost" placeholder="상품원가를 입력해주세요">
				<input type="text" name="product_price" placeholder="상품 판매가를 입력해주세요">
			</td>
		</tr>
		
		
		<tr>
			<td>상품상세 : </td>
			<td><textarea rows="20" cols="150" name="product_detail" rows="5"></textarea></td>
		</tr>
		<tr>
			<td>
				<input type="file" name="product_imgsrc1">
				<input type="file" name="product_imgsrc2">
	 			<input type="file" name="product_imgsrc3">
		 		<input type="file" name="product_imgsrc4">
				<input type="file" name="product_imgsrc5">
			</td>
		</tr>
	</table>
		<div align="center">
			<input type="submit" value="저장">
			<input type="reset" value="다시쓰기">
		</div>
	
	</div>
	</form>
</body>
</html>