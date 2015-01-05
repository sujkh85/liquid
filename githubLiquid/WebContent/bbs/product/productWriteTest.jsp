<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상품정보등록</title>
<link rel="stylesheet" type="text/css" href="../../css/easyui.css">
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		hide();
		
		function hide(){
		$(".hide").hide();
		}
	});
		function sizeAdd(){
			//$(".hide").show();
			$(".hide").write();
			
		}
	
	function loadLocal(){
	    $('#f_productInsert').form('load',{
	    	product_name:'상품명을 입력하세요',
	    	product_price:'상품 판매가를 입력하세요',
	    	product_cost:'상품 원가를 입력하세요',
	    	product_detail:'상품 상세설명을 입력하세요',
	    	product_type_no:'1'
	    });
	}
	
	function clearForm(){
	    $('#f_productInsert').form('clear');
	}
	
	function productWrite(){
		$('#f_productInsert').attr("method","post");
		$('#f_productInsert').attr("action","productWrite.do");
		$('#f_productInsert').submit();;
	}
</script>
</head>
<body>
    <div class="easyui-panel" title="New Product Regist" style="width:400px">
        <div style="padding:10px 60px 20px 60px">
        <form id="f_productInsert" method="post">
            <table cellpadding="5">
            	 <tr>
                	<th colspan="2" align="center">Product Info</th>
                </tr>
                <tr>
                    <td>ProductName:</td>
                    <td><input class="easyui-textbox" type="text" name="product_name" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>ProductType:</td>
                    <td>
                        <select class="easyui-combobox" name="product_type_no">
							<option value="1">OUTER</option>
							<option value="2">TOP</option>
							<option value="3">BOTTOMS</option>			
							<option value="4">OPNPIECE</option>			
							<option value="6">SALE</option>			
							<option value="5">ETC</option>			
						</select>	
                    </td>
                </tr>	
                <tr>
                    <td>GendetType:</td>
                    <td><label>Man</label><input class="easyui-radiobox" type="radio" name="gender_tpye" value="남" data-options="required:true"/>
						<label>Girl</label><input class="easyui-radiobox" type="radio" name="gender_tpye" value="여" data-options="required:true"/></td>
                </tr>
                <tr>
                    <td>ProductPrice:</td>
                    <td><input class="easyui-textbox" type="text" name="product_price" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>ProductCost:</td>
                    <td><input class="easyui-textbox" type="text" name="product_cost" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>ProductDetail:</td>
                    <td><input class="easyui-textbox" name="product_detail" data-options="multiline:true" style="height:60px"></input></td>
                </tr>
           		<tr>
					<td>ProductImage1</td>
					<td><input type="text" class="easyui-filebox" name="product_imgsrc1">
					<input type="text" class="easyui-filebox" name="product_imgsrc1">
					<input type="text" class="easyui-filebox" name="product_imgsrc1">
					<input type="text" class="easyui-filebox" name="product_imgsrc1">
					<input type="text" class="easyui-filebox" name="product_imgsrc1">
					</td>
				</tr>
				    <tr>
                <th colspan="2" align="center">Stock Info</th>
                </tr>
                <tr class="hide">
                	<td>
                		<input type="text" name="h_size" readonly size="3"/>
                		<input type="text" name="h_quantity" readonly size="5"/>
                	</td>
                </tr>
                <tr>
                	<td>
						<select class="easyui-combobox" name="product_type_no">
							<option value="size1">L</option>
							<option value="size2">S</option>
							<option value="size3">M</option>			
						</select>	
						
					</td>
					<td>
						<input type="text" size="5"/>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="sizeAdd()">Add</a>
						
					</td>
				</tr> 
            </table>
              <div style="margin:20px 0;margin-left: 100px">
       			 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="productWrite()">Save</a> 
       			 <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
       			 <!-- <a href="javascript:void(0)" class="easyui-linkbutton" onclick="loadLocal()">Method</a> -->
   			 </div>
        </form>
        </div>
    </div>
</body>
</html>
