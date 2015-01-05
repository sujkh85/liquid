package com.wishlist;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 2014.11.18
 * 어떤 파일에 호출받는가 : wishListFC
 * 어떤 파일을 호출하는가 : WishListDAO 
 * 클래스 용도 : FC에서 호출받아서 dao의 deleteWishList메소드 호출
 * 파일 타입 : 
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class WishListDeleteCMD implements Command { //wishlist 삭제 로직처리 클래스
	Logger logger =Logger.getLogger(WishListDeleteCMD.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WishListDAO dao=new WishListDAO(); //dao생성
		String wishlist_no=request.getParameter("wishlist_no"); //파라미터로 받아온 wishlist_no받기
		logger.info(wishlist_no);
		dao.deleteWishList(wishlist_no);//dao의 deleteWishList메소드 호출(wishlist_no를 매개변수로)

	}

}
