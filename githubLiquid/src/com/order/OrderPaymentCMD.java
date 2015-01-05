package com.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;

public class OrderPaymentCMD implements Command{
	public void execute(HttpServletRequest request, HttpServletResponse response){
		Logger logger = Logger.getLogger(OrderWriteCMD.class);
		logger.info("OrderPaymentCMD 호출성공");
		
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		int order_money = Integer.parseInt(request.getParameter("order_money"));
		
		OrderDAO dao =new OrderDAO();
		dao.orderPayment(order_no,order_money);

	}
}