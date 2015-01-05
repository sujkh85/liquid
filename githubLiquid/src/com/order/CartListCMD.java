package com.order;
/***************************
 * - 쿠키는 get하면 무조건 배열로 가져온다. 
 * - 쿠키의 name은 cart1,cart2,cart3,cart4...... 이다.
 * - 쿠키에는 "stock_no:quantity" 가 하나의 문자열로 담겨 있다. 
 * ex > cart1 - 9:1		>> cart1이라는 이름에 상품번호 9와 선택수량 1을 :으로 구분 하여 담고 있다
 * 		cart2 - 10:2    
 * 		cart3 - 12:1 
 * 			.
 * 			.
 * 			.
 * -------------------------------
 * 쿠키에 담긴 정보를 :을 기준으로 앞뒤로 분리하여
 * 상품관리번호(=재고관리번호)는 상품정보를 가져와서
 * 방법① list에 담아 for문 밖에서 한번에 화면으로 보내주거나 
 * 방법② 바로바로 for문안에서 화면으로 보내준다 
 ***************************/
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class CartListCMD implements Command{

	Logger logger = Logger.getLogger(CartListCMD.class);

	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("CartListCMD 호출 성공 ");
		OrderDAO dao = new OrderDAO();
		ArrayList<OrderDTO> cart_info = new ArrayList<OrderDTO>();
	
			//모든 쿠키정보를 가져옴.
			Cookie[] isCart = req.getCookies();
			
			logger.info("모든 쿠키의 정보 requset.getCookies() : "+isCart);
			for(int j=1; j<=isCart.length; j++){
				for (int i=0; i<isCart.length; i++){
						if (("cart"+j).equals(isCart[i].getName())){
							String cookieName = isCart[i].getName();
							String str[] = (isCart[i].getValue()).split(":");
							
							logger.info(str.length);
							//최종적으로 장바구니 보여줄 dto를 ArrayList에 담는다.
							cart_info.add(dao.cartList(cookieName,str[0],new Integer (str[1])));
							req.setAttribute("cart_info", cart_info);
						}
				}
			}
	}
}
