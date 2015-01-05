package com.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;
import com.notice.NoticeDTO;


class NoticeListCMD implements Command{
	public void execute(HttpServletRequest request,HttpServletResponse response)
	{
		NoticeDAO dao =new NoticeDAO();
		ArrayList<NoticeDTO> list = dao.list();
		request.setAttribute("list",list);
		
	}//end execute
}
