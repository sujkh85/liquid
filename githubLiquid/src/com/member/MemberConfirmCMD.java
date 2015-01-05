package com.member;
/***********************************************************************
 * �۾��� : �̽¿�
 * �۾����� :  ID �ߺ��˻� �۾�����
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� : 
 ***********************************************************************/


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



import com.controller.Command;

public class MemberConfirmCMD implements Command{
	Logger logger = Logger.getLogger(MemberConfirmCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberConfirmIdCMD ȣ�� ����");
		
		String member_info_nickname = req.getParameter("nickname");
		System.out.println("�ߺ�üũ�� �г��� :"+member_info_nickname);
		
	
		String member_info_id = req.getParameter("id");
		System.out.println("�ߺ�üũ�� ���̵� :"+member_info_id);
		MemberDAO dao = new MemberDAO();
		
		int check = dao.confirm(member_info_id,member_info_nickname);
		System.out.println("�ߺ����̵�üũ ������ 1, ������ 0 �����??"+check);
		if (member_info_id != null)
			req.setAttribute("member_info_id", member_info_id);
		else if (member_info_nickname != null)
			req.setAttribute("member_info_nickname", member_info_nickname);
		req.setAttribute("check", new Integer(check));
	}   

}
