package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  FC
 * � ������ ȣ���ϴ°� :  ManagerDAO �� productSales()ȣ��
 * ���� Ÿ�� :  
 ***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class ManagerProductSalesCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		/*ManagerDAO dao = new ManagerDAO();
		ArrayList<ManagerProductSalesDTO> list = new ArrayList<ManagerProductSalesDTO>();
		
		list = dao.productSales();
		req.setAttribute("list", list);*/
		ManagerDAO dao = new ManagerDAO();
		String page="";		//�ʱⰪ
		int curPage =1; //���� ������(ó���� 1)
		if(req.getParameter("curPage")!=null){  
			curPage = Integer.parseInt(req.getParameter("curPage")); //���� ������ �޾ƿ�
		}
		
		ManagerPageTO list = new ManagerPageTO();
		
		list=dao.productSales(curPage);
		
		int perPage = list.getPerPage(); 
		int totalCount = list.getTotalCount();
		int totalPage = totalCount/perPage;  //������ ������ ��ȣ����
		if(totalCount % perPage != 0) totalPage++; //�������� 0�̾ƴϸ� �������� �� ������� ��
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>"; //���������� ���ڰ� ������size5ũ��
			}else{
				page +="<a href='manager_productsales.do?curPage="+i+"'>"+i +"</a>&nbsp;";
			}//end if			
		}
			
		req.setAttribute("list", list.getList_productsales());
		req.setAttribute("pg",page); // .jsp�� ${pg}
		

	}

}
