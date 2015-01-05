package com.manager;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 어떤 파일에 호출받는가 :  FC
 * 어떤 파일을 호출하는가 :  일/월을 매개변수로 받아서 
 *					 ManagerDAO의 daySales(),monthSales()메소드 호출
 * 파일 타입 :  
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
		
		String page="";		//초기값
		int curPage =1; //현재 페이지(처음에 1)
		if(req.getParameter("curPage")!=null){  
				curPage = Integer.parseInt(req.getParameter("curPage")); //현재 페이지 받아옴
		}
		
		String date = req.getParameter("date");
		ManagerPageTO list_sales = new ManagerPageTO();
		if("day".equals(date)){
			logger.info("day호출");
			list_sales = dao.daySales(curPage);
		}else if("month".equals(date)){
			logger.info("month호출");
			list_sales = dao.monthSales(curPage);
		}
		
		int perPage = list_sales.getPerPage(); 
		int totalCount = list_sales.getTotalCount();
		int totalPage = totalCount/perPage;  //보여줄 페이지 번호개수
		if(totalCount % perPage != 0) totalPage++; //나머지가 0이아니면 한페이지 더 보여줘야 함
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>"; //현재페이지 숫자가 빨간색size3크기
			}else{
				page +="<a href='manager_sales.do?curPage="+i+"'>"+i +"</a>&nbsp;";
			}//end if
		}
		req.setAttribute("list", list_sales.getList_sales());
		req.setAttribute("pg",page); //BestItem.jsp의 ${pg}
		
		
		//req.setAttribute("list", list);

	}
		
		
		
		
		
}
