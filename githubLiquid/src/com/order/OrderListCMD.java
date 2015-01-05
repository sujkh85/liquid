package com.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.controller.Command;

public class OrderListCMD implements Command{
	public void execute(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		String memNo = (String) session.getAttribute("s_member_info_no");
		
		OrderDAO dao =new OrderDAO();
		ArrayList<OrderDTO> orderList = dao.list(memNo);
		request.setAttribute("orderList",orderList);
		
	}//end execute
}