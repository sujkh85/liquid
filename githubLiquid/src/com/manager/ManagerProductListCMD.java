package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  FC
 * � ������ ȣ���ϴ°� :  ��ǰ�̸� �޾Ƽ� 
 * 					 null�̸� ManagerDAO�� productList()ȣ��(��ü��ǰ���)
 * 					  �ƴϸ�  ManagerDAO��  SearchProduct(product_name)ȣ��
 * ���� Ÿ�� :  
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class ManagerProductListCMD implements Command {
	Logger logger = Logger.getLogger(ManagerProductListCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		
		ManagerDAO dao = new ManagerDAO();
		
		String product_name=req.getParameter("product_name");
		String page="";		//�ʱⰪ
		int curPage =1; //���� ������(ó���� 1)
		if(req.getParameter("curPage")!=null){  
			curPage = Integer.parseInt(req.getParameter("curPage")); //���� ������ �޾ƿ�
	}
		
		ManagerPageTO list = new ManagerPageTO();
		if(product_name==null){
			list = dao.productList(curPage);
		}else{
			list = dao.searchProduct(curPage, product_name);
		}	
		
		int perPage = list.getPerPage_productlist(); 
		int totalCount = list.getTotalCount();
		int totalPage = totalCount/perPage;  //������ ������ ��ȣ����
		if(totalCount % perPage != 0) totalPage++; //�������� 0�̾ƴϸ� �������� �� ������� ��
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>"; //���������� ���ڰ� ������size5ũ��
			}else{
				page +="<a href='manager_productlist.do?curPage="+i+"'>"+i +"</a>&nbsp;";
			}//end if
		}
		req.setAttribute("list", list.getList_productlist());
		req.setAttribute("pg",page); //productlist.jsp�� ${pg}
		
		
		
		
		
		
		
		
	}
	
}
