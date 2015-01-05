package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��, ������
 * �۾����� : 14.11.26
 * � ���Ͽ� ȣ��޴°� :  FC
 * � ������ ȣ���ϴ°� :  ȸ����ȣ�� �޾Ƽ� ������,�Ű������� 
 * 					 ManagerDAO�� memberList()�� memberDetailList()ȣ��
 * ���� Ÿ�� :  
 ***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class ManagerMemberListCMD implements Command {
	Logger logger = Logger.getLogger(ManagerMemberListCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String align = req.getParameter("align");
		//logger.info(align);
		String member_info_no=req.getParameter("member_info_no"); //member_info_no�� �޾ƿ�
		ManagerDAO dao = new ManagerDAO();
		if(member_info_no==null){ //�⺻ ����Ʈ ����.(member_info_no�� �޾ƿ��� �ʾƼ� null)
			String page="";		//�ʱⰪ
			int curPage =1; //���� ������(ó���� 1)
			if(req.getParameter("curPage")!=null){  
					curPage = Integer.parseInt(req.getParameter("curPage")); //���� ������ �޾ƿ�
			}
			
			ManagerPageTO list = new ManagerPageTO();
			list = dao.memberList(curPage,align);	
			
			int perPage = list.getPerPage(); 
			int totalCount = list.getTotalCount();
			int totalPage = totalCount/perPage;  //������ ������ ��ȣ����
			if(totalCount % perPage != 0) totalPage++; //�������� 0�̾ƴϸ� �������� �� ������� ��
			for(int i=1; i<=totalPage; i++){
				if(curPage ==i){
					page +="<font size='5' color='red'>"+i+"</font>"; //���������� ���ڰ� ������size3ũ��
				}else{
					page +="<a href='manager_list.do?curPage="+i+"&align="+align+"'>"+i +"</a>&nbsp;";
				}//end if
			}
			req.setAttribute("list", list.getList());
			req.setAttribute("pg",page); //MemberList.jsp�� ${pg}
		}else{ //member_info_id���� ���� �ƴҶ�(����¡ ó���� �ʿ����)
			ArrayList<ManagerMemberListDTO> list = new ArrayList<ManagerMemberListDTO>();
			list=dao.memberDetailList(Integer.parseInt(member_info_no));
			req.setAttribute("list", list);
		}

	}

}
