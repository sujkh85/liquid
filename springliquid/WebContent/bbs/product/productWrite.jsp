<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ǰ ��� ȭ��</title>
</head>
<body>
	<form action="productWrite.do" method="post" enctype="multipart/form-data">
	<div align="center">
	<table border="1" align="center">
		<tr>
			<td>��ǰ�̸�</td>
			<td><input type="text" name="product_title" size="100" maxlength="100"></td>
		</tr>
		<tr>
			<td>��ǰ�з�</td>
			<td><select name="product_type_no">
			<option value="1">OUTER</option>
			<option value="2">TOP</option>
			<option value="3">BOTTOMS</option>			
			<option value="4">OPNPIECE</option>			
			<option value="6">SALE</option>			
			<option value="5">ETC</option>			
			</select>
			<label>��</label><input type="radio" name="member_info_gender" value="��" />
			<label>��</label><input type="radio" name="member_info_gender" value="��" />
			</td>
		</tr>
		<tr>
			<td>
				��������
			</td>
			<td>
				<input type="text" name="product_cost" placeholder="��ǰ������ �Է����ּ���">
				<input type="text" name="product_price" placeholder="��ǰ �ǸŰ��� �Է����ּ���">
			</td>
		</tr>
		<tr>
			<td>��ǰ�� : </td>
			<td><textarea rows="20" cols="150" name="product_detail" rows="5"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">÷������1 : <input type="file" name="product_imgsrc1"></td>
		</tr>
		<tr>
			<td colspan="2">÷������2 : <input type="file" name="product_imgsrc2"></td>
		</tr>
		<tr>
			<td colspan="2">÷������3 : <input type="file" name="product_imgsrc3"></td>
		</tr>
		<tr>
			<td colspan="2">÷������4 : <input type="file" name="product_imgsrc4"></td>
		</tr>
		<tr>
			<td colspan="2">÷������5 : <input type="file" name="product_imgsrc5"></td>
		</tr>
	</table>
		<div align="center">
			<input type="submit" value="����">
			<input type="reset" value="�ٽþ���">
		</div>
	
	</div>
	</form>
</body>
</html>