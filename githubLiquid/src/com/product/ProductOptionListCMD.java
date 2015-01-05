package com.product;
/***********************************************************************
* �۾��� : �̽¿�
* �۾����� : 14.11.18 
* � ���Ͽ� ȣ��޴°� : ProductFC.java
* � ������ ȣ���ϴ°� :  
* ���� Ÿ�� : ������
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
	 	logger.info("ProductOptionListCMD ȣ�� ����");
	 	int product_no = Integer.parseInt(req.getParameter("product_no"));
		ProductDAO dao = new ProductDAO(); 
		ArrayList<ProductDTO> option_List = dao.optionList(product_no);
		req.setAttribute("option_List",option_List);
	}
}
