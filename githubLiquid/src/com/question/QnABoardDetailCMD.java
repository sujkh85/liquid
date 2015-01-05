package com.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class QnABoardDetailCMD implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String board_question_no = request.getParameter("board_question_no");
		String mode = request.getParameter("mode");
		System.out.println("¸ðµå:"+mode);
		QnABoardDAO dao = new QnABoardDAO();
		QnABoardDTO data = dao.detail(board_question_no);
		request.setAttribute("detail",data);
	}

}
