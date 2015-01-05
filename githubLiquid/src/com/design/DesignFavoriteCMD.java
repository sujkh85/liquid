package com.design;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class DesignFavoriteCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String board_userdesign_no = req.getParameter("board_userdesign_no");
		String member_info_no = req.getParameter("member_info_no");

		DesignDAO dao = new DesignDAO();
		
		
		//값의 유무를 판단 1,2를 저장
				if(dao.favorite(board_userdesign_no, member_info_no)==1){
					req.setAttribute("review", 1);
				}else{
					req.setAttribute("review", 2);
				}
		
	}

}
