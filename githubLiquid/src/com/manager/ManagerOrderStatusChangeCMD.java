package com.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class ManagerOrderStatusChangeCMD implements Command {
	Logger logger = Logger.getLogger(ManagerOrderStatusChangeCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
			//int order_no=Integer.parseInt(req.getParameter("order_no"));
			//logger.info(order_no);
				String next = null ; //주문상태값에 따른 다음페이지 저장할 변수
				String[] order_no = req.getParameterValues("check"); //체크박스에서 다중값을 받아오므로 배열로 받음
			String order_paystatus = req.getParameter("order_paystatus");//hidden에서 넘겨준값 받음
			String order_money = req.getParameter("order_money");
			logger.info(order_money);
			//logger.info(order_paystatus);
			ManagerDAO dao = new ManagerDAO();
			
			for(int i=0;i<order_no.length;i++){ //체크한 수 만큼 업데이트 수행
				
				next = dao.orderStatusChange(order_no[i], order_paystatus); //메소드 반환값이 주문상태에 따른 다음페이지
				
				if("입금대기".equals(order_paystatus)){
					dao.managerorderPayment(Integer.parseInt(order_no[i]), Integer.parseInt(order_money));
				}
				
			}
			
			
			//logger.info(next);
			
			req.setAttribute("next", next); //FC에서 페이지분기하기위해 저장
	}

}
