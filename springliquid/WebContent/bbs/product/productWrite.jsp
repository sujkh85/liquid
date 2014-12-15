<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상품 등록 화면</title>
</head>
<body>
	<form action="productWrite.do" method="post" enctype="multipart/form-data">
	<div align="center">
	<table border="1" align="center">
		<tr>
			<td>상품이름</td>
			<td><input type="text" name="product_title" size="100" maxlength="100"></td>
		</tr>
		<tr>
			<td>상품분류</td>
			<td><select name="product_type_no">
			<option value="1">OUTER</option>
			<option value="2">TOP</option>
			<option value="3">BOTTOMS</option>			
			<option value="4">OPNPIECE</option>			
			<option value="6">SALE</option>			
			<option value="5">ETC</option>			
			</select>
			<label>남</label><input type="radio" name="member_info_gender" value="남" />
			<label>여</label><input type="radio" name="member_info_gender" value="여" />
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
			<td colspan="2">첨부파일1 : <input type="file" name="product_imgsrc1"></td>
		</tr>
		<tr>
			<td colspan="2">첨부파일2 : <input type="file" name="product_imgsrc2"></td>
		</tr>
		<tr>
			<td colspan="2">첨부파일3 : <input type="file" name="product_imgsrc3"></td>
		</tr>
		<tr>
			<td colspan="2">첨부파일4 : <input type="file" name="product_imgsrc4"></td>
		</tr>
		<tr>
			<td colspan="2">첨부파일5 : <input type="file" name="product_imgsrc5"></td>
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