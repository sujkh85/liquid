package com.wishlist;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 2014.11.18
 * � ���Ͽ� ȣ��޴°� : WishListFC
 * � ������ ȣ���ϴ°� : WishListDAO
 * Ŭ���� �뵵 : FC���� ȣ��޾Ƽ� dao�� list�޼ҵ� ȣ������ ����� ���Ϲ޾Ƽ� request��ü�� "list"�� ����
 * ���� Ÿ�� : 
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
		HttpSession session=request.getSession(); //���ǰ�ü ����
		String member_info_no=(String)session.getAttribute("s_member_info_no"); //���ǿ� ����ִ� ȸ����ȣ���
		//logger.info(member_info_no);
		WishListDAO dao = new WishListDAO(); //dao����
		
		ArrayList<WishListDTO> list = new ArrayList<WishListDTO>(); //������� ArrayList����
		
		if (member_info_no != null){
			
		list=dao.list(Integer.parseInt(member_info_no)); //���ǿ� ����ִ� ȸ����ȣ�� �Ű������� dao�� list�޼ҵ� ȣ���ؼ� list�� ���
		//logger.info(list.get(1).getProduct_name());
		request.setAttribute("list", list); //list�� ��� ������� request��ü�� list�� �̸����� ���
			
		}
	}

}
