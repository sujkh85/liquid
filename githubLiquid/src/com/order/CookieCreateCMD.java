package com.order;
/*
 * �۾��� : �̽¿�
 * �ش� CMD�� ��Ű����.do ��û�� īƮ����Ʈ.do�� Ż�� Ÿ�� Ŀ�ǵ��ε� īƮ����Ʈ.do��û�� �̷���� �ʴ� ������ �־�,
 * ��Ű�� �����ϴ� �� Ŀ�ǵ�� createCookie.jsp �� �����Ͽ���. 
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
		/*logger.info("CookieCreateCMD ��ٱ��� ��Ű cart����");
		//��������ȣ
		String stock_no = req.getParameter("stock_no");
		//���ü��� 
		int quantity = Integer.parseInt(req.getParameter("order_detail_quantity"));
		*//***********************************************
		 *  
		 *  ���⼭�� ��������ȣ���� ���ο� ��Ű ��ü�� ����.
		 *  �ߺ��Ǵ� ��������ȣ�� ������� ���ü������� ������Ʈ.
		 *  
		 **********************************************//*
		//��� ��Ű������ ������.
		Cookie[] isCart = req.getCookies();
		
		//��������ȣ�� ���ü����� ������ ���ڿ��� ���� ����
		String[] str_cookie = new String[isCart.length];
		
		//��������ȣ�� ���ü����� �и��Ͽ� �ߺ�üũ�� ��ģ�� Ű���� ���Ѵ� 
		String cart = "cart1";	
		if (isCart.length != 0){
			for (int i=0; i<isCart.length; i++){
				if((cart).equals(isCart[i].getName())){
					//�Ȱ��� ��Ű�� �̸��� ������ ���� �����ͼ� �ߺ����� Ȯ���Ѵ�.
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
