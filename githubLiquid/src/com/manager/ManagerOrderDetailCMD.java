package com.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class ManagerOrderDetailCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		
		String order_no = req.getParameter("order_no");
		ManagerDAO dao = new ManagerDAO();
		
		ArrayList<ManagerOrderDetailDTO> list = new ArrayList<ManagerOrderDetailDTO>();
		list = dao.orderdetail(Integer.parseInt(order_no));
		
		req.setAttribute("list", list);
	}
}
