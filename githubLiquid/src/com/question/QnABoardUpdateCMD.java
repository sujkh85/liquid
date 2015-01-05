package com.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class QnABoardUpdateCMD implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String board_question_no=request.getParameter("board_question_no");
		String board_question_title = request.getParameter("board_question_title");
		String member_info_no = request.getParameter("member_info_no");
		String board_question_content = request.getParameter("board_question_content");
		board_question_content = board_question_content.replaceAll("\r\n", "<br>"); // ¿£ÅÍÅ° => <br>

		QnABoardDAO dao = new QnABoardDAO();
		dao.update(board_question_no, board_question_title, member_info_no, board_question_content);
		
	}

}