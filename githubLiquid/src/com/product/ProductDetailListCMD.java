package com.product;
/***********************************************************************
* 작업자 : 이승우
* 작업일자 : 14.11.18 
* 어떤 파일에 호출받는가 : ProductFC.java 
* 어떤 파일을 호출하는가 :  
* 파일 타입 : 
***********************************************************************/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.apache.log4j.Logger;

import com.controller.Command;

public class ProductDetailListCMD implements Command{
	Logger logger = Logger.getLogger(ProductDetailListCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
	 	logger.info("ProductCMD 호출 성공");
	 	
	 	//main_ProductCatalogue.jsp 에서 상품번호를 받아온다
		ProductDTO dto = new ProductDTO();
		dto.setProduct_no(new Integer(req.getParameter("product_no")));
		
		//상품 번호와 일치하는 상세정보를 받아옴.
		ProductDAO dao = new ProductDAO(); 
		dto = dao.productList(dto);
		req.setAttribute("product_List",dto);
		
	}
}
