package com.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class ManagerOrderStatusChangeCMD implements Command {
	Logger logger = Logger.getLogger(ManagerOrderStatusChangeCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
			//int order_no=Integer.parseInt(req.getParameter("order_no"));
			//logger.info(order_no);
				String next = null ; //�ֹ����°��� ���� ���������� ������ ����
				String[] order_no = req.getParameterValues("check"); //üũ�ڽ����� ���߰��� �޾ƿ��Ƿ� �迭�� ����
			String order_paystatus = req.getParameter("order_paystatus");//hidden���� �Ѱ��ذ� ����
			String order_money = req.getParameter("order_money");
			logger.info(order_money);
			//logger.info(order_paystatus);
			ManagerDAO dao = new ManagerDAO();
			
			for(int i=0;i<order_no.length;i++){ //üũ�� �� ��ŭ ������Ʈ ����
				
				next = dao.orderStatusChange(order_no[i], order_paystatus); //�޼ҵ� ��ȯ���� �ֹ����¿� ���� ����������
				
				if("�Աݴ��".equals(order_paystatus)){
					dao.managerorderPayment(Integer.parseInt(order_no[i]), Integer.parseInt(order_money));
				}
				
			}
			
			
			//logger.info(next);
			
			req.setAttribute("next", next); //FC���� �������б��ϱ����� ����
	}

}
