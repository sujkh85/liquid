package com.design;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class DesignDetailCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String board_userdesign_no = req.getParameter("board_userdesign_no");
		DesignDAO dao = new DesignDAO();
		DesignDTO dto = dao.detailDesign(board_userdesign_no);
		req.setAttribute("detailDesign", dto);
		
	}

}
