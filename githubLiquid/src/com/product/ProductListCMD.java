package com.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class ProductListCMD implements Command{
	//상품 타입번호 선언
	int product_type_no; 
	
	// 기본생성자
	public ProductListCMD(){} 
	
	// 상품 타입번호 지정
	public ProductListCMD(int product_type_no){
		this.product_type_no = product_type_no;
	}

	// 위에서 지정되는 타입번호에 따라 상품타입별로 리스트를 조회함	
	public void execute(HttpServletRequest request,HttpServletResponse response)
	{
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductDTO> list = dao.typeList(product_type_no);
		request.setAttribute("list",list);
		
	}//end execute
}
