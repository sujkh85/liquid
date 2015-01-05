package com.catalogue;
/***********************************************************************
 * �۾��� : �̽¿� 
 * �۾����� : 2014.11.03 - 14.11.08
 * � ���Ͽ� ȣ��޴°� : CatalogueFC.java
 * � ������ ȣ���ϴ°� : 
 * ���� Ÿ�� : 
 ***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class CatalogueCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
	 	CatalogueDAO dao = new CatalogueDAO();
	 	
	 	//��ǰ īŻ�α�
		ArrayList<ProductCatalogueDTO> proList = dao.productCatalogueList();
		req.setAttribute("productCatalogueList",proList);
		
		//���� ������ īŻ�α�
		ArrayList<UserDesignCatalogueDTO> userList = dao.UserDesignCatalogueList();
		req.setAttribute("UserDesignCatalogueList",userList);
	}	
}
