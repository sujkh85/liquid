package com.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class QnABoardPageCMD implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page="";
		int curPage =1; //현재 페이지
		if(request.getParameter("curPage")!=null){
				curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		QnABoardDAO dao = new QnABoardDAO();
		QnABoardPageTO list = dao.page(curPage);
		
		int perPage = list.getPerPage(); 
		int totalCount = list.getTotalCount();
		int totalPage = totalCount/perPage;  //보여줄 페이지 번호개수
		if(totalCount % perPage != 0) totalPage++;
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>";
			}else{
				String mode = request.getParameter("mode");
				if("manager".equals(mode)){
				page +="<a href='manager_qna_list.do?mode=manager&curPage="+i+"'>"+i +"</a>&nbsp;";
				}else{
				page +="<a href='qna_list.do?curPage="+i+"'>"+i +"</a>&nbsp;";
				}
			}//end if
		}
		
		
		request.setAttribute("list", list.getList());
		//request.setAttribute("page",list);
		request.setAttribute("pg",page);
	}

}


