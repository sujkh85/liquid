package com.wishlist;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 2014.11.18
 * � ���Ͽ� ȣ��޴°� : WishListFC
 * � ������ ȣ���ϴ°� : WishLIstDAO,WishListVO 
 * Ŭ���� �뵵 : FCȣ��޾� dao�� insertWishList�޼ҵ� ȣ��
 * ���� Ÿ�� : 
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
		//wishList ��� ����ó�� Ŭ����
		Logger logger = Logger.getLogger(WishListInsertCMD.class);
		logger.info("WishListInsertCMD ȣ�⼺��");
		
		HttpSession session = request.getSession();	//���ǰ�ü ����
		String member_info_no = (String)session.getAttribute("s_member_info_no"); //���ǿ� ��� ȸ����ȣ ���
		System.out.println("ȸ����ȣ: "+member_info_no);
		
		if(member_info_no != null){			
			String product_no = request.getParameter("product_no"); //�Ķ���ͷ� �Ѱ��� ��ǰ������ȣ �ޱ�
			System.out.println("��ǰ��ȣ: "+product_no);
			
			WishListDAO dao = new WishListDAO();//�޼ҵ������� dao����
			WishListVO vo = new WishListVO();	  //insert�� ������ ���� vo����
			vo.setMember_info_no(Integer.parseInt(member_info_no)); //vo�� ȸ����ȣ���
			vo.setProduct_no(Integer.parseInt(product_no));//vo�� ��ǰ������ȣ ���
			dao.insertWishList(vo); //���� ���� 2���� �Ű�������  insertWishList ȣ��
		}

	}

}
