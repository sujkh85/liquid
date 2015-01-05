package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  FC
 * � ������ ȣ���ϴ°� :  ��/���� �Ű������� �޾Ƽ� 
 *					 ManagerDAO�� daySales(),monthSales()�޼ҵ� ȣ��
 * ���� Ÿ�� :  
 ***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class ManagerSalesCMD implements Command {
	Logger logger = Logger.getLogger("ManagerSalesCMD");
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		/*ManagerDAO dao = new ManagerDAO();
		ArrayList<ManagerSalesDTO> list = new ArrayList<ManagerSalesDTO>();
		String date = req.getParameter("date");
		
		if("day".equals(date)){
			list = dao.daySales();
		}else if("month".equals(date)){
			list = dao.monthSales();
		}
		
		req.setAttribute("list", list);
	}*/
		ManagerDAO dao = new ManagerDAO();
		
		String page="";		//�ʱⰪ
		int curPage =1; //���� ������(ó���� 1)
		if(req.getParameter("curPage")!=null){  
				curPage = Integer.parseInt(req.getParameter("curPage")); //���� ������ �޾ƿ�
		}
		
		String date = req.getParameter("date");
		ManagerPageTO list_sales = new ManagerPageTO();
		if("day".equals(date)){
			logger.info("dayȣ��");
			list_sales = dao.daySales(curPage);
		}else if("month".equals(date)){
			logger.info("monthȣ��");
			list_sales = dao.monthSales(curPage);
		}
		
		int perPage = list_sales.getPerPage(); 
		int totalCount = list_sales.getTotalCount();
		int totalPage = totalCount/perPage;  //������ ������ ��ȣ����
		if(totalCount % perPage != 0) totalPage++; //�������� 0�̾ƴϸ� �������� �� ������� ��
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>"; //���������� ���ڰ� ������size3ũ��
			}else{
				page +="<a href='manager_sales.do?curPage="+i+"'>"+i +"</a>&nbsp;";
			}//end if
		}
		req.setAttribute("list", list_sales.getList_sales());
		req.setAttribute("pg",page); //BestItem.jsp�� ${pg}
		
		
		//req.setAttribute("list", list);

	}
		
		
		
		
		
}
