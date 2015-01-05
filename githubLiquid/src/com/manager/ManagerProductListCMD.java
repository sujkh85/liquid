package com.manager;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 어떤 파일에 호출받는가 :  FC
 * 어떤 파일을 호출하는가 :  상품이름 받아서 
 * 					 null이면 ManagerDAO의 productList()호출(전체상품목록)
 * 					  아니면  ManagerDAO의  SearchProduct(product_name)호출
 * 파일 타입 :  
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class ManagerProductListCMD implements Command {
	Logger logger = Logger.getLogger(ManagerProductListCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		
		ManagerDAO dao = new ManagerDAO();
		
		String product_name=req.getParameter("product_name");
		String page="";		//초기값
		int curPage =1; //현재 페이지(처음에 1)
		if(req.getParameter("curPage")!=null){  
			curPage = Integer.parseInt(req.getParameter("curPage")); //현재 페이지 받아옴
	}
		
		ManagerPageTO list = new ManagerPageTO();
		if(product_name==null){
			list = dao.productList(curPage);
		}else{
			list = dao.searchProduct(curPage, product_name);
		}	
		
		int perPage = list.getPerPage_productlist(); 
		int totalCount = list.getTotalCount();
		int totalPage = totalCount/perPage;  //보여줄 페이지 번호개수
		if(totalCount % perPage != 0) totalPage++; //나머지가 0이아니면 한페이지 더 보여줘야 함
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>"; //현재페이지 숫자가 빨간색size5크기
			}else{
				page +="<a href='manager_productlist.do?curPage="+i+"'>"+i +"</a>&nbsp;";
			}//end if
		}
		req.setAttribute("list", list.getList_productlist());
		req.setAttribute("pg",page); //productlist.jsp의 ${pg}
		
		
		
		
		
		
		
		
	}
	
}
