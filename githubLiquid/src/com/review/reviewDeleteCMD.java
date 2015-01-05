package com.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class reviewDeleteCMD implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		DetailReviewDTO dto = new DetailReviewDTO();
		DetailreviewListDAO dao = new DetailreviewListDAO();
		dto.setBoard_review_no(Integer.parseInt(req.getParameter("board_no")));
		int comp = dao.reviewDelete(dto);
		req.setAttribute("comp", comp);

	}

}
