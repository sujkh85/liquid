package com.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Command;

public class OrderDetailInfoCMD implements Command{
	public void execute(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		String member_info_no = (String) session.getAttribute("s_member_info_no");
		
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		
		OrderDAO dao =new OrderDAO();
		ArrayList<OrderDTO> orderDetailInfo = dao.orderDetailInfo(order_no);
		
		request.setAttribute("orderDetailInfo",orderDetailInfo);
		
	}//end execute
}