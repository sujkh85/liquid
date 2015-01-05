package com.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class reviewWriteCMD implements Command {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		
		Logger logger = Logger.getLogger(reviewWriteCMD.class);
		
		System.out.println("aa");
		DetailReviewDTO dto = new DetailReviewDTO();
		dto.setBoard_review_content(req.getParameter("review"));
		dto.setMember_info_nickname(req.getParameter("nick_name"));
		dto.setProduct_no(Integer.parseInt(req.getParameter("product_no")));
		dto.setBesong(Integer.parseInt(req.getParameter("besong")));
		dto.setSangpum(Integer.parseInt(req.getParameter("sangpum")));
		dto.setMember_info_no(Integer.parseInt(req.getParameter("member_no")));
		DetailreviewListDAO dao = new DetailreviewListDAO();
		
		//값의 유무를 판단 1,2를 저장
		if(dao.reviewWrite(dto)==1){
			req.setAttribute("review", 1);
			logger.info("중복됨");
		}else{
			req.setAttribute("review", dto.getProduct_no());
			logger.info("중복안됨");
		}
	
			
	}

}