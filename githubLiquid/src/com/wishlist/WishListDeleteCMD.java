package com.wishlist;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 2014.11.18
 * � ���Ͽ� ȣ��޴°� : wishListFC
 * � ������ ȣ���ϴ°� : WishListDAO 
 * Ŭ���� �뵵 : FC���� ȣ��޾Ƽ� dao�� deleteWishList�޼ҵ� ȣ��
 * ���� Ÿ�� : 
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class WishListDeleteCMD implements Command { //wishlist ���� ����ó�� Ŭ����
	Logger logger =Logger.getLogger(WishListDeleteCMD.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WishListDAO dao=new WishListDAO(); //dao����
		String wishlist_no=request.getParameter("wishlist_no"); //�Ķ���ͷ� �޾ƿ� wishlist_no�ޱ�
		logger.info(wishlist_no);
		dao.deleteWishList(wishlist_no);//dao�� deleteWishList�޼ҵ� ȣ��(wishlist_no�� �Ű�������)

	}

}
