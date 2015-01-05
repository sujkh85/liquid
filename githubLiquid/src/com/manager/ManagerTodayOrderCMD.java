package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  FC
 * � ������ ȣ���ϴ°� :  ManagerDAO �� todayOrder()�޼ҵ� ȣ��
 * ���� Ÿ�� :  
 ***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class ManagerTodayOrderCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		/*ManagerDAO dao = new ManagerDAO();
		ArrayList<ManagerTodayOrderDTO> list = new ArrayList<ManagerTodayOrderDTO>();
		list=dao.todayOrder();
		
		req.setAttribute("list", list);*/
		ManagerDAO dao = new ManagerDAO();
		String order_date = req.getParameter("order_date");
		String page="";		//�ʱⰪ
		int curPage =1; //���� ������(ó���� 1)
		if(req.getParameter("curPage")!=null){  
			curPage = Integer.parseInt(req.getParameter("curPage")); //���� ������ �޾ƿ�
	}
		
		ManagerPageTO list = new ManagerPageTO();
		list = dao.todayOrder(curPage,order_date);
		
		int perPage = list.getPerPage(); 
		int totalCount = list.getTotalCount();
		int totalPage = totalCount/perPage;  //������ ������ ��ȣ����
		if(totalCount % perPage != 0) totalPage++; //�������� 0�̾ƴϸ� �������� �� ������� ��
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>"; //���������� ���ڰ� ������size5ũ��
			}else{
				page +="<a href='manager_todayorder.do?curPage="+i+"&order_date="+order_date+"'>"+i +"</a>&nbsp;";
			}//end if
		}
		req.setAttribute("list", list.getList_todayorder());
		req.setAttribute("pg",page); //productlist.jsp�� ${pg}
		
		
		

	}

}
