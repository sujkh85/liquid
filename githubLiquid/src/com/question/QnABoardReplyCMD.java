package com.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class QnABoardReplyCMD implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String board_question_no=request.getParameter("board_question_no");
		String board_question_title = request.getParameter("board_question_title");
		String member_info_no = request.getParameter("member_info_no");
		String board_question_content= request.getParameter("board_question_content");
		board_question_content = board_question_content.replaceAll("\r\n", "<br>"); // ¿£ÅÍÅ° => <br>

		String board_question_reproot = request.getParameter("board_question_reproot");
		String board_question_repstep = request.getParameter("board_question_repstep");
		String board_question_repindent = request.getParameter("board_question_repindent");
		String board_question_date = request.getParameter("board_question_date");
		String board_question_viewcount = request.getParameter("board_question_viewcount");
		QnABoardDAO dao = new QnABoardDAO();
		dao.reply(board_question_no, board_question_title, member_info_no,
				board_question_content, board_question_reproot, board_question_repstep,
				board_question_repindent, board_question_date, board_question_viewcount);
		
	}

}
