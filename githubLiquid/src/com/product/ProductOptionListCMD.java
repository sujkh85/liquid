package com.product;
/***********************************************************************
* 작업자 : 이승우
* 작업일자 : 14.11.18 
* 어떤 파일에 호출받는가 : ProductFC.java
* 어떤 파일을 호출하는가 :  
* 파일 타입 : 구현중
***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;
import com.product.ProductDTO;

public class ProductOptionListCMD implements Command{
	Logger logger = Logger.getLogger(ProductOptionListCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
	 	logger.info("ProductOptionListCMD 호출 성공");
	 	int product_no = Integer.parseInt(req.getParameter("product_no"));
		ProductDAO dao = new ProductDAO(); 
		ArrayList<ProductDTO> option_List = dao.optionList(product_no);
		req.setAttribute("option_List",option_List);
	}
}
