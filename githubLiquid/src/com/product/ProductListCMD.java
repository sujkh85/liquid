package com.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class ProductListCMD implements Command{
	//��ǰ Ÿ�Թ�ȣ ����
	int product_type_no; 
	
	// �⺻������
	public ProductListCMD(){} 
	
	// ��ǰ Ÿ�Թ�ȣ ����
	public ProductListCMD(int product_type_no){
		this.product_type_no = product_type_no;
	}

	// ������ �����Ǵ� Ÿ�Թ�ȣ�� ���� ��ǰŸ�Ժ��� ����Ʈ�� ��ȸ��	
	public void execute(HttpServletRequest request,HttpServletResponse response)
	{
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductDTO> list = dao.typeList(product_type_no);
		request.setAttribute("list",list);
		
	}//end execute
}
