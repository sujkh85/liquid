package com.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;
import com.question.QnABoardDAO;
import com.question.QnABoardPageTO;

public class NoticePageCMD implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page="";
		String mode = request.getParameter("mode"); //������ ������ ������ ���� ����
		int curPage =1; //���� ������
		if(request.getParameter("curPage")!=null){
				curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		NoticeDAO dao = new NoticeDAO();
		NoticePageTO list = dao.page(curPage);
		
		int perPage = list.getPerPage(); 
		int totalCount = list.getTotalCount();
		
		int totalPage = totalCount/perPage;  //������ ������ ��ȣ����
		if(totalCount % perPage != 0) totalPage++;
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<span id='pg'>"+i+"</span>";
			}else{
				if("manager".equals(mode)){ //���������������� �����ټ� �ְ� �߰�
					page +="<a href='manager_notice_list.do?mode=manager&curPage="+i+"'>"+i +"</a>&nbsp;";	
				}else{
					page +="<a href='notice_list.do?curPage="+i+"'>"+i +"</a>&nbsp;";
				}
			}//end if
		}
		
		
		request.setAttribute("list", list.getList());
		request.setAttribute("pg",page);
	}
	
}
