package com.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;

public class DetailreviewListCMD implements Command{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		
		//
		String product_no = req.getParameter("product_no");
		DetailreviewListDAO dao = new DetailreviewListDAO();
		ArrayList<DetailReviewDTO> reviewList = dao.reviewList(product_no);
		 
		req.setAttribute("reviewList", reviewList);
		
	}

}