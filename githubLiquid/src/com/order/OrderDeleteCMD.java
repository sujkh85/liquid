package com.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class OrderDeleteCMD implements Command{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		int stock_no = Integer.parseInt(request.getParameter("stock_no"));
		
		OrderDAO dao =new OrderDAO();
		dao.orderDelete(order_no,stock_no);
	}
}
