package com.manager;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 어떤 파일에 호출받는가 :  FC
 * 어떤 파일을 호출하는가 :  결제 상태를 받아서 매개변수로
 * 					 ManagerDAO의 orderstatus()호출
 * 파일 타입 :  
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class ManagerOrderStatusCMD implements Command {
	Logger logger = Logger.getLogger(ManagerOrderStatusCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String status = req.getParameter("status");
		ManagerDAO dao = new ManagerDAO();
		String page="";		//초기값
		int curPage =1; //현재 페이지(처음에 1)
		if(req.getParameter("curPage")!=null){  
			curPage = Integer.parseInt(req.getParameter("curPage")); //현재 페이지 받아옴
	}
		
		ManagerPageTO list = new ManagerPageTO();
		System.out.println(status);
		if("배송대기".equals(status)){
			list = dao.orderStatus(status, curPage);
		}else if("상품준비중".equals(status)){
			list = dao.orderStatus(status, curPage);
		}else if("상품배송중".equals(status)){
			list = dao.orderStatus(status, curPage);
		}else if("배송완료".equals(status)){
			list=dao.orderStatus(status, curPage);
		}else if("전체주문조회".equals(status)){
			list=dao.ordersearchlist(curPage);
		}else if("입금대기".equals(status)){
			list = dao.orderStatus(status, curPage);
		}else if("주문취소".equals(status)){
			list = dao.orderStatus(status, curPage);
		}
		
		int perPage = list.getPerPage(); 
		int totalCount = list.getTotalCount();
		int totalPage = totalCount/perPage;  //보여줄 페이지 번호개수
		if(totalCount % perPage != 0) totalPage++; //나머지가 0이아니면 한페이지 더 보여줘야 함
		for(int i=1; i<=totalPage; i++){
			if(curPage ==i){
				page +="<font size='5' color='red'>"+i+"</font>"; //현재페이지 숫자가 빨간색size5크기
			}else{
				page +="<a href='manager_orderstatus.do?status="+status+"&curPage="+i+"'>"+i +"</a>&nbsp;";
			}//end if			
		}
			
		req.setAttribute("list", list.getList_orderstatus());
		req.setAttribute("pg",page); // .jsp의 ${pg}
		
	}

}
