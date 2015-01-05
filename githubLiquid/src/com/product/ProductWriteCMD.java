package com.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class ProductWriteCMD implements Command {
	Logger logger = Logger.getLogger(ProductWriteCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("ProductWriteCMD 호출 성공");
		
		ProductDTO dto = new ProductDTO();
		ProductDAO dao = new ProductDAO();
		
		
		
		
		dto.setProduct_name(req.getParameter("product_name"));
		dto.setProduct_type_no(Integer.parseInt(req.getParameter("product_type_no")));
		dto.setGender_type(req.getParameter("gender_type"));
		dto.setProduct_cost(Integer.parseInt(req.getParameter("product_cost")));
		dto.setProduct_price(Integer.parseInt(req.getParameter("product_price")));
	/*	dto.setProduct_imgsrc1(product_imgsrc1);
		dto.setProduct_imgsrc2(product_imgsrc1);
		dto.setProduct_imgsrc3(product_imgsrc1);
		dto.setProduct_imgsrc4(product_imgsrc1);
		dto.setProduct_imgsrc5(product_imgsrc1);*/
		dao.productInsert(dto);
		
	}

}
