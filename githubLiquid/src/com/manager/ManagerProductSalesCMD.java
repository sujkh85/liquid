package com.manager;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 어떤 파일에 호출받는가 :  FC
 * 어떤 파일을 호출하는가 :  ManagerDAO 의 productSales()호출
 * 파일 타입 :  
 ***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class ManagerProductSalesCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		/*ManagerDAO dao = new ManagerDAO();
		ArrayList<ManagerProductSalesDTO> list = new ArrayList<ManagerProductSalesDTO>();
		
		list = dao.productSales();
		req.setAttribute("list", list);*/
		ManagerDAO dao = new ManagerDAO();
		String page="";		//초기값
		int curPage =1; //현재 페이지(처음에 1)
		if(req.getParameter("curPage")!=null){  
			curPage = Integer.parseInt(req.getParameter("curPage")); //현재 페이지 받아옴
		}
		
		ManagerPageTO list = new ManagerPageTO();
		
		list=dao.productSales(curPage);
		
		int perPage = list.getPerPage(); 
		int totalCount = list.getTotalCount();
		int totalPage = totalCount/perPage;  //보여줄 페이지 번호개수
		if(totalCount % perPage != 0) totalPage++; //나머지가 0이아니면 한페이지 더 보여줘야 함
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>"; //현재페이지 숫자가 빨간색size5크기
			}else{
				page +="<a href='manager_productsales.do?curPage="+i+"'>"+i +"</a>&nbsp;";
			}//end if			
		}
			
		req.setAttribute("list", list.getList_productsales());
		req.setAttribute("pg",page); // .jsp의 ${pg}
		

	}

}
