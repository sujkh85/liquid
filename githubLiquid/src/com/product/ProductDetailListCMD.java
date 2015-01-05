package com.product;
/***********************************************************************
* �۾��� : �̽¿�
* �۾����� : 14.11.18 
* � ���Ͽ� ȣ��޴°� : ProductFC.java 
* � ������ ȣ���ϴ°� :  
* ���� Ÿ�� : 
***********************************************************************/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.apache.log4j.Logger;

import com.controller.Command;

public class ProductDetailListCMD implements Command{
	Logger logger = Logger.getLogger(ProductDetailListCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
	 	logger.info("ProductCMD ȣ�� ����");
	 	
	 	//main_ProductCatalogue.jsp ���� ��ǰ��ȣ�� �޾ƿ´�
		ProductDTO dto = new ProductDTO();
		dto.setProduct_no(new Integer(req.getParameter("product_no")));
		
		//��ǰ ��ȣ�� ��ġ�ϴ� �������� �޾ƿ�.
		ProductDAO dao = new ProductDAO(); 
		dto = dao.productList(dto);
		req.setAttribute("product_List",dto);
		
	}
}
