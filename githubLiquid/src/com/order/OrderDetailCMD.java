package com.order;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;

public class OrderDetailCMD implements Command {
	Logger logger = Logger.getLogger(OrderWriteCMD.class);
	
	public void execute(HttpServletRequest request, HttpServletResponse response){
		//String order_name,String order_tel,String order_address,String order_message,int order_money,int member_info_no
		logger.info("OrderDetailCMD 호출성공");
		
		HttpSession session = request.getSession();
		String member_info_no = (String) session.getAttribute("s_member_info_no");
		
		int order_detail_quantity = Integer.parseInt(request.getParameter("order_detail_quantity"));
		int product_no = Integer.parseInt(request.getParameter("product_no"));
		String product_name = request.getParameter("product_name");
		int product_price = Integer.parseInt(request.getParameter("product_price"));
		String product_imgsrc1 = request.getParameter("product_imgsrc1");
		int stock_no = Integer.parseInt(request.getParameter("stock_no"));
		
		OrderDTO order_detail = new OrderDTO();
		
		order_detail.setOrder_detail_quantity(order_detail_quantity);
		order_detail.setProduct_no(product_no);
		order_detail.setProduct_name(product_name);
		order_detail.setProduct_price(product_price);
		order_detail.setProduct_imgsrc1(product_imgsrc1);
		order_detail.setStock_no(stock_no);
		
		OrderDAO dao =new OrderDAO();
		OrderDTO orderMember = dao.order_member(member_info_no);

		request.setAttribute("order_detail",order_detail);
		request.setAttribute("orderMember",orderMember);

	}
}
