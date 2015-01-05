package com.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class QnABoardSearchCMD implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		/*String searchName = request.getParameter("searchName"); //작성자,글제목
		String searchValue = request.getParameter("searchValue");
		QnABoardDAO dao = new QnABoardDAO();
		ArrayList<QnABoardDTO> list = dao.search(searchName, searchValue);
		request.setAttribute("list",list);*/
		
		String mode = request.getParameter("mode");
		String page="";
		String searchName = request.getParameter("searchName"); //작성자,글제목
		String searchValue = request.getParameter("searchValue");
		int curPage =1; //현재 페이지
		if(request.getParameter("curPage")!=null){
				curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		QnABoardDAO dao = new QnABoardDAO();
		QnABoardPageTO list = dao.search(curPage, searchName, searchValue);
		System.out.println("list"+list);
		int perPage = list.getPerPage(); 
		int totalCount = list.getTotalCount_search(searchName, searchValue);
		int totalPage = totalCount/perPage;  //보여줄 페이지 번호개수
		if(totalCount % perPage != 0) totalPage++;
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<span style='color:red' id='pg'>"+i+"</span>";
			}else{
				if("manager".equals(mode)){
					page +="<a href='qna_search.do?mode=manager&searchName="+searchName+"&searchValue="+searchValue+"&curPage="+i+"'>"+i +"</a>&nbsp;";
				}else{
					page +="<a href='qna_search.do?searchName="+searchName+"&searchValue="+searchValue+"&curPage="+i+"'>"+i +"</a>&nbsp;";
				}
			}//end if
		}
		
		
		request.setAttribute("list", list.getList());
		request.setAttribute("pg",page);
		
		
		
	}

}
