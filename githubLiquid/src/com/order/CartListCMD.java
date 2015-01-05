package com.order;
/***************************
 * - ��Ű�� get�ϸ� ������ �迭�� �����´�. 
 * - ��Ű�� name�� cart1,cart2,cart3,cart4...... �̴�.
 * - ��Ű���� "stock_no:quantity" �� �ϳ��� ���ڿ��� ��� �ִ�. 
 * ex > cart1 - 9:1		>> cart1�̶�� �̸��� ��ǰ��ȣ 9�� ���ü��� 1�� :���� ���� �Ͽ� ��� �ִ�
 * 		cart2 - 10:2    
 * 		cart3 - 12:1 
 * 			.
 * 			.
 * 			.
 * -------------------------------
 * ��Ű�� ��� ������ :�� �������� �յڷ� �и��Ͽ�
 * ��ǰ������ȣ(=��������ȣ)�� ��ǰ������ �����ͼ�
 * ����� list�� ��� for�� �ۿ��� �ѹ��� ȭ������ �����ְų� 
 * ����� �ٷιٷ� for���ȿ��� ȭ������ �����ش� 
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
		logger.info("CartListCMD ȣ�� ���� ");
		OrderDAO dao = new OrderDAO();
		ArrayList<OrderDTO> cart_info = new ArrayList<OrderDTO>();
	
			//��� ��Ű������ ������.
			Cookie[] isCart = req.getCookies();
			
			logger.info("��� ��Ű�� ���� requset.getCookies() : "+isCart);
			for(int j=1; j<=isCart.length; j++){
				for (int i=0; i<isCart.length; i++){
						if (("cart"+j).equals(isCart[i].getName())){
							String cookieName = isCart[i].getName();
							String str[] = (isCart[i].getValue()).split(":");
							
							logger.info(str.length);
							//���������� ��ٱ��� ������ dto�� ArrayList�� ��´�.
							cart_info.add(dao.cartList(cookieName,str[0],new Integer (str[1])));
							req.setAttribute("cart_info", cart_info);
						}
				}
			}
	}
}
