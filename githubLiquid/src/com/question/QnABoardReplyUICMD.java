package com.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class QnABoardReplyUICMD implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String board_question_no = request.getParameter("board_question_no");
		QnABoardDAO dao = new QnABoardDAO();
		QnABoardDTO data = dao.replyui(board_question_no);
		request.setAttribute("replyui",data);
	}

}
