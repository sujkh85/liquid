package com.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;
import com.notice.NoticeDTO;

public class NoticeRetrieveupdateCMD implements Command{
	public void execute(HttpServletRequest request, HttpServletResponse response){
		String board_notice_no = request.getParameter("board_notice_no");
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO data = dao.retrieve(board_notice_no);
		request.setAttribute("retrieve",data);
	}
}
