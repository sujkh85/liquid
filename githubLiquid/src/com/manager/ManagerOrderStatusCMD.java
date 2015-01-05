package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  FC
 * � ������ ȣ���ϴ°� :  ���� ���¸� �޾Ƽ� �Ű�������
 * 					 ManagerDAO�� orderstatus()ȣ��
 * ���� Ÿ�� :  
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class ManagerOrderStatusCMD implements Command {
	Logger logger = Logger.getLogger(ManagerOrderStatusCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String status = req.getParameter("status");
		ManagerDAO dao = new ManagerDAO();
		String page="";		//�ʱⰪ
		int curPage =1; //���� ������(ó���� 1)
		if(req.getParameter("curPage")!=null){  
			curPage = Integer.parseInt(req.getParameter("curPage")); //���� ������ �޾ƿ�
	}
		
		ManagerPageTO list = new ManagerPageTO();
		System.out.println(status);
		if("��۴��".equals(status)){
			list = dao.orderStatus(status, curPage);
		}else if("��ǰ�غ���".equals(status)){
			list = dao.orderStatus(status, curPage);
		}else if("��ǰ�����".equals(status)){
			list = dao.orderStatus(status, curPage);
		}else if("��ۿϷ�".equals(status)){
			list=dao.orderStatus(status, curPage);
		}else if("��ü�ֹ���ȸ".equals(status)){
			list=dao.ordersearchlist(curPage);
		}else if("�Աݴ��".equals(status)){
			list = dao.orderStatus(status, curPage);
		}else if("�ֹ����".equals(status)){
			list = dao.orderStatus(status, curPage);
		}
		
		int perPage = list.getPerPage(); 
		int totalCount = list.getTotalCount();
		int totalPage = totalCount/perPage;  //������ ������ ��ȣ����
		if(totalCount % perPage != 0) totalPage++; //�������� 0�̾ƴϸ� �������� �� ������� ��
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>"; //���������� ���ڰ� ������size5ũ��
			}else{
				page +="<a href='manager_orderstatus.do?status="+status+"&curPage="+i+"'>"+i +"</a>&nbsp;";
			}//end if			
		}
			
		req.setAttribute("list", list.getList_orderstatus());
		req.setAttribute("pg",page); // .jsp�� ${pg}
		
	}

}
