package com.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class NoticeUpdateCMD implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String board_notice_no=request.getParameter("board_notice_no");
		String board_notice_title=request.getParameter("board_notice_title");
		String board_notice_content=request.getParameter("board_notice_content");
		board_notice_content=board_notice_content.replaceAll("\r\n", "<br>"); // ¿£ÅÍÅ° => <br>
		
		NoticeDAO dao = new NoticeDAO();
		dao.update(board_notice_no,board_notice_title,board_notice_content);

	}

}
