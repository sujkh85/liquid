package com.design;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class DesignDeleteCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String board_userdesign_no = req.getParameter("board_userdesign_no");
		DesignDAO dao = new DesignDAO();
		dao.delete(board_userdesign_no);
	}

}
