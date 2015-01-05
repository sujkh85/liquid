package com.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;

public class OrderPayListCMD implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Logger logger = Logger.getLogger(OrderPayListCMD.class);
		logger.info("OrderPayListCMD 호출성공");
		
		HttpSession session = request.getSession();
		String memNo = (String) session.getAttribute("s_member_info_no");
		
		OrderDAO dao =new OrderDAO();
		ArrayList<OrderDTO> orderPayList = dao.orderPayList(memNo);
		request.setAttribute("orderPayList",orderPayList);

	} 

}
