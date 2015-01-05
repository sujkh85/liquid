package com.catalogue;
/***********************************************************************
 * 작업자 : 이승우 
 * 작업일자 : 2014.11.03 - 14.11.08
 * 어떤 파일에 호출받는가 : CatalogueFC.java
 * 어떤 파일을 호출하는가 : 
 * 파일 타입 : 
 ***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class CatalogueCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
	 	CatalogueDAO dao = new CatalogueDAO();
	 	
	 	//상품 카탈로그
		ArrayList<ProductCatalogueDTO> proList = dao.productCatalogueList();
		req.setAttribute("productCatalogueList",proList);
		
		//유저 디자인 카탈로그
		ArrayList<UserDesignCatalogueDTO> userList = dao.UserDesignCatalogueList();
		req.setAttribute("UserDesignCatalogueList",userList);
	}	
}
