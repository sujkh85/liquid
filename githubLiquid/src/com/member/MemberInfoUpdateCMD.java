package com.member;
/***********************************************************************
 * �۾��� : �̽¿�
 * �۾����� : 14.11.16 
 * � ���Ͽ� ȣ��޴°� : MemberFC.java
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� :  
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;
import com.manager.ManagerDAO;

//ȸ����������
public class MemberInfoUpdateCMD implements Command{
	Logger logger = Logger.getLogger(MemberInfoUpdateCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberInfoUpdateCMD ȣ�⼺��");
		int update_result;
		//�α��� �� ���ǿ� ��� ȸ����ȣ�� �������� ���� ���
		HttpSession session = req.getSession();
		//�������������� ������ �����͸� data��  ��´�
		MemberDTO data = new MemberDTO();
		if(req.getParameter("member_grade_no")==null){//���������������� �����Ҷ� ȸ����� �Ѱ��ִϱ�
			logger.info("ȸ����������");
			data.setMember_info_no((session.getAttribute("s_member_info_no")).toString());
			data.setMember_grade_no(req.getParameter("member_grade_no"));
			data.setMember_info_nickname(req.getParameter("member_info_nickname"));
			data.setMember_info_birthday(req.getParameter("member_info_birthday"));
			data.setMember_info_gender(req.getParameter("member_info_gender"));
			data.setMember_info_address1(req.getParameter("member_info_address1"));
			data.setMember_info_address2(req.getParameter("member_info_address2"));
			data.setMember_info_post1(req.getParameter("member_info_post1"));
			data.setMember_info_post2(req.getParameter("member_info_post2"));
			data.setMember_info_phone(req.getParameter("member_info_phone"));
			data.setMember_info_email(req.getParameter("member_info_email"));
			//infoData�� ������ DB���� ������Ʈ�� �����Ѵ�
			MemberDAO update = new MemberDAO();
			update_result = update.memberInfoUpdate(data);
		}else{
			logger.info("������ ȸ����������");
			data.setMember_info_no(req.getParameter("member_info_no"));
			data.setMember_grade_no(req.getParameter("member_grade_no"));
			data.setMember_info_nickname(req.getParameter("member_info_nickname"));
			data.setMember_info_birthday(req.getParameter("member_info_birthday"));
			data.setMember_info_gender(req.getParameter("member_info_gender"));
			data.setMember_info_address1(req.getParameter("member_info_address1"));
			data.setMember_info_address2(req.getParameter("member_info_address2"));
			data.setMember_info_post1(req.getParameter("member_info_post1"));
			data.setMember_info_post2(req.getParameter("member_info_post2"));
			data.setMember_info_phone(req.getParameter("member_info_phone"));
			data.setMember_info_email(req.getParameter("member_info_email"));
			ManagerDAO dao = new ManagerDAO();
			update_result = dao.managermemberInfoUpdate(data);
		}
		
		//������Ʈ ��� ���� ��� ���⼭ �� 
		
			req.setAttribute("update_result", new Integer(update_result));
		
	}

}
