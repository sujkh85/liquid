package com.design;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class DesignSearchCMD implements Command {
	Logger logger = Logger.getLogger(DesignListCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("DesignSearchCMD 호출성공");
		/*String searchName = req.getParameter("searchName"); //작성자,글제목
		String searchValue = req.getParameter("searchValue");
		DesignDAO dao = new DesignDAO();
		ArrayList<DesignDTO> listDesign = dao.search(searchName, searchValue);
		req.setAttribute("listDesign",listDesign);*/
	
		String page="";
		String searchName = req.getParameter("searchName"); //작성자,글제목
		String searchValue = req.getParameter("searchValue");
		int curPage =1; //현재 페이지
		if(req.getParameter("curPage")!=null){
				curPage = Integer.parseInt(req.getParameter("curPage"));
		}
		DesignDAO dao = new DesignDAO();
		DesignPageTO list = dao.search(curPage, searchName, searchValue);
		int perPage = list.getPerPage(); 
		int totalCount = list.getTotalCount_search(searchName, searchValue);
		int totalPage = totalCount/perPage;  //보여줄 페이지 번호개수
		if(totalCount % perPage != 0) totalPage++;
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>";
			}else{
				page +="<a href='designSearch.do?searchName="+searchName+"&searchValue="+searchValue+"&curPage="+i+"'>"+i +"</a>&nbsp;";
			}//end if
		}
		
		
		req.setAttribute("listDesign", list.getList());
		req.setAttribute("pg",page);
		
	}

}
