package com.design;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;
import com.question.QnABoardDAO;

public class DesignUpdateCMD implements Command{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String board_userdesign_no=req.getParameter("board_userdesign_no");
		String board_userdesign_title = req.getParameter("board_userdesign_title");
		String member_info_no = req.getParameter("member_info_no");
		String board_userdesign_content = req.getParameter("board_userdesign_content");
		//board_userdesign_content = board_userdesign_content.replaceAll("\r\n", "<br>"); // ¿£ÅÍÅ° => <br>

		DesignDAO dao = new DesignDAO();
		dao.update(board_userdesign_no, board_userdesign_title, member_info_no, board_userdesign_content);
		
	}

}
