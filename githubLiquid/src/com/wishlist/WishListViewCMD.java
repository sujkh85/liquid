package com.wishlist;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 2014.11.18
 * 어떤 파일에 호출받는가 : WishListFC
 * 어떤 파일을 호출하는가 : WishListDAO
 * 클래스 용도 : FC에서 호출받아서 dao의 list메소드 호출한후 결과값 리턴받아서 request객체에 "list"로 저장
 * 파일 타입 : 
 ***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;
import com.product.ProductDAO;
import com.product.ProductDTO;

public class WishListViewCMD implements Command {
	Logger logger = Logger.getLogger(WishListViewCMD.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession(); //새션객체 생성
		String member_info_no=(String)session.getAttribute("s_member_info_no"); //새션에 담겨있는 회원번호담기
		//logger.info(member_info_no);
		WishListDAO dao = new WishListDAO(); //dao생성
		
		ArrayList<WishListDTO> list = new ArrayList<WishListDTO>(); //결과담을 ArrayList생성
		
		if (member_info_no != null){
			
		list=dao.list(Integer.parseInt(member_info_no)); //새션에 담겨있는 회원번호를 매개변수로 dao의 list메소드 호출해서 list에 담기
		//logger.info(list.get(1).getProduct_name());
		request.setAttribute("list", list); //list에 담긴 결과값을 request객체에 list란 이름으로 담기
			
		}
	}

}
