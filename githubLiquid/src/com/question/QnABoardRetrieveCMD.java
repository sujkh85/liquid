package com.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class QnABoardRetrieveCMD implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String board_question_no = request.getParameter("board_question_no");
		QnABoardDAO dao = new QnABoardDAO();
		QnABoardDTO data = dao.retrieve(board_question_no);
		request.setAttribute("retrieve",data);
	}

}
