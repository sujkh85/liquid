package com.order;
/*
 * 작업자 : 이승우
 * 해당 CMD는 쿠키생성.do 요청시 카트리스트.do를 탈때 타는 커맨드인데 카트리스트.do요청이 이루어지 않는 문제가 있어,
 * 쿠키를 생성하는 이 커맨드는 createCookie.jsp 로 이전하였다. 
 */

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class CookieCreateCMD implements Command {
	Logger logger = Logger.getLogger(CookieCreateCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		/*logger.info("CookieCreateCMD 장바구니 쿠키 cart생성");
		//재고관리번호
		String stock_no = req.getParameter("stock_no");
		//선택수량 
		int quantity = Integer.parseInt(req.getParameter("order_detail_quantity"));
		*//***********************************************
		 *  
		 *  여기서는 재고관리번호별로 새로운 쿠키 객체를 생성.
		 *  중복되는 재고관리번호가 있을경우 선택수량만을 업데이트.
		 *  
		 **********************************************//*
		//모든 쿠키정보를 가져옴.
		Cookie[] isCart = req.getCookies();
		
		//재고관리번호와 선택수량이 합쳐진 문자열을 담을 변수
		String[] str_cookie = new String[isCart.length];
		
		//재고관리번호와 선택수량을 분리하여 중복체크를 거친뒤 키값을 정한다 
		String cart = "cart1";	
		if (isCart.length != 0){
			for (int i=0; i<isCart.length; i++){
				if((cart).equals(isCart[i].getName())){
					//똑같은 쿠키의 이름이 있으면 값을 가져와서 중복인지 확인한다.
					str_cookie[i] = isCart[i].getValue();
					String str[] = str_cookie[i].split(":");
					//String str[] = (isCart[i].getValue()).split(":");
					if(str[0].equals(stock_no)){
						quantity += Integer.parseInt(str[1]);
						cart = isCart[i].getName();
					}else {
						cart = "cart";
						cart +=i+1;
					}
				}
			}
		}
		String cookie = stock_no + ":"+Integer.toString(quantity);
		Cookie c_cart = new Cookie(cart,cookie);
		c_cart.setMaxAge(60*30);
		res.addCookie(c_cart); */
	}
}
