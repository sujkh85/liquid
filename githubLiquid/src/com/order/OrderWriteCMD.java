package com.order;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;


public class OrderWriteCMD implements Command{
	public void execute(HttpServletRequest request, HttpServletResponse response){
		//String order_name,String order_tel,String order_address,String order_message,int order_money,int member_info_no
		Logger logger = Logger.getLogger(OrderWriteCMD.class);
		logger.info("OrderWriteCMD 호출성공");
		
		HttpSession session = request.getSession();
		String member_info_no = (String) session.getAttribute("s_member_info_no");
		
		int order_detail_quantity = Integer.parseInt(request.getParameter("order_detail_quantity"));
		int product_price = Integer.parseInt(request.getParameter("product_price"));
		int order_money = product_price * order_detail_quantity;
		int stock_no = Integer.parseInt(request.getParameter("stock_no"));

		String order_name = request.getParameter("order_name");
		String order_tel = request.getParameter("order_tel");
		String order_address1 = request.getParameter("order_address1");
		String order_address2 = request.getParameter("order_address2");
		String order_post1 = request.getParameter("order_post1");
		String order_post2 = request.getParameter("order_post2");
		String order_message = request.getParameter("order_message");
		String order_payment = request.getParameter("order_payment");
		
		
		OrderDAO dao =new OrderDAO();
		dao.write(order_name,order_tel,order_address1,order_address2,order_post1,order_post2,order_message,member_info_no,order_money,order_detail_quantity,order_payment,stock_no);
	}
}
