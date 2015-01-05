package com.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;
import com.notice.NoticeDTO;

public class NoticeSearchCMD implements Command {
	public void execute(HttpServletRequest request, HttpServletResponse response){
		
		String searchName = request.getParameter("searchName"); //작성자,글제목
		String searchValue = request.getParameter("searchValue");
		
		NoticeDAO dao =  new NoticeDAO();
		
		ArrayList<NoticeDTO> list = dao.search(searchName,searchValue);
		request.setAttribute("list", list);

	}
}
