package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  FC
 * � ������ ȣ���ϴ°� :  ManagerDAO �� bestItem()�޼ҵ� ȣ��
 * ���� Ÿ�� :  
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class ManagerBestItemCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		ManagerDAO dao = new ManagerDAO();
		
		String page="";		//�ʱⰪ
		int curPage =1; //���� ������(ó���� 1)
		if(req.getParameter("curPage")!=null){  
				curPage = Integer.parseInt(req.getParameter("curPage")); //���� ������ �޾ƿ�
		}
		
		ManagerPageTO list_bestitem = new ManagerPageTO();
		list_bestitem = dao.bestItem(curPage);
		
		int perPage = list_bestitem.getPerPage(); 
		int totalCount = list_bestitem.getTotalCount();
		int totalPage = totalCount/perPage;  //������ ������ ��ȣ����
		if(totalCount % perPage != 0) totalPage++; //�������� 0�̾ƴϸ� �������� �� ������� ��
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>"; //���������� ���ڰ� ������size3ũ��
			}else{
				page +="<a href='manager_bestitem.do?curPage="+i+"'>"+i +"</a>&nbsp;";
			}//end if
		}
		req.setAttribute("list", list_bestitem.getList_bestitem());
		req.setAttribute("pg",page); //BestItem.jsp�� ${pg}
		
		
		//req.setAttribute("list", list);

	}

}
