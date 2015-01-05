package com.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class NoticeDeleteCMD implements Command{
	public void execute(HttpServletRequest request, HttpServletResponse response){
		String board_notice_no = request.getParameter("board_notice_no");
		NoticeDAO dao = new NoticeDAO();
		dao.delete(board_notice_no);
	}
}
