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
		String mode = request.getParameter("mode"); //관리자 페이지 구분을 위한 변수
		int curPage =1; //현재 페이지
		if(request.getParameter("curPage")!=null){
				curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		NoticeDAO dao = new NoticeDAO();
		NoticePageTO list = dao.page(curPage);
		
		int perPage = list.getPerPage(); 
		int totalCount = list.getTotalCount();
		
		int totalPage = totalCount/perPage;  //보여줄 페이지 번호개수
		if(totalCount % perPage != 0) totalPage++;
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<span id='pg'>"+i+"</span>";
			}else{
				if("manager".equals(mode)){ //관리자페이지에서 보여줄수 있게 추가
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
