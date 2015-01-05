package com.wishlist;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 2014.11.18
 * 어떤 파일에 호출받는가 : WishListFC
 * 어떤 파일을 호출하는가 : WishLIstDAO,WishListVO 
 * 클래스 용도 : FC호출받아 dao의 insertWishList메소드 호출
 * 파일 타입 : 
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;
import com.order.OrderWriteCMD;

public class WishListInsertCMD implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//wishList 담기 로직처리 클래스
		Logger logger = Logger.getLogger(WishListInsertCMD.class);
		logger.info("WishListInsertCMD 호출성공");
		
		HttpSession session = request.getSession();	//세션객체 생성
		String member_info_no = (String)session.getAttribute("s_member_info_no"); //세션에 담긴 회원번호 담기
		System.out.println("회원번호: "+member_info_no);
		
		if(member_info_no != null){			
			String product_no = request.getParameter("product_no"); //파라미터로 넘겨준 상품관리번호 받기
			System.out.println("상품번호: "+product_no);
			
			WishListDAO dao = new WishListDAO();//메소드사용위해 dao생성
			WishListVO vo = new WishListVO();	  //insert한 정보를 담을 vo생성
			vo.setMember_info_no(Integer.parseInt(member_info_no)); //vo에 회원번호담고
			vo.setProduct_no(Integer.parseInt(product_no));//vo에 상품관리번호 담고
			dao.insertWishList(vo); //위에 담은 2개를 매개변수로  insertWishList 호출
		}

	}

}
