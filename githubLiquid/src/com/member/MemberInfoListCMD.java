package com.member;
/***********************************************************************
 * �۾��� : �̽¿�
 * �۾����� : 14.11.10 - 14.11.16 
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� :  *.do ��û�� ���°�!
 ***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;

public class MemberInfoListCMD implements Command {
	Logger logger = Logger.getLogger(MemberInfoListCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberInfoSelectCMD ȣ�� ����");
		MemberDTO infoList = null;
		HttpSession session = req.getSession();
		String member_info_no = (String) session.getAttribute("s_member_info_no");
		String m_member_info_no = req.getParameter("member_info_no");
		//logger.info(m_member_info_no);
		//logger.info(member_info_no);
		MemberDAO dao = new MemberDAO();
		
		if(m_member_info_no!=null){
			 infoList = dao.memberInfoList(m_member_info_no);
		}else{
			infoList = dao.memberInfoList(member_info_no);
		}
		
		req.setAttribute("infoList", infoList);
	}

}
