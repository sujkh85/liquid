package com.member;
/***********************************************************************
 * �۾��� : �̽¿�
 * �۾����� : 14.11.16 
 * � ���Ͽ� ȣ��޴°� : MemberFC.java
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� : ���� �ֻ�� �޴� Mypage ��ȸ ���� Ŀ�ǵ�
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;

public class MemberPageCMD implements Command{
	Logger logger = Logger.getLogger(MemberPageCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MypageCMD ȣ�� ����");
		//�α��ν� ���ǿ� ���� ȸ����ȣ�� ����ϰ��� �Ѵ�.
		HttpSession session = req.getSession();
		String member_info_no = (String) session.getAttribute("s_member_info_no");
		
		//�ι���, ��ȸ���ϰ�� ���⼭ ����.
		//���� �ƴѰ�� ���� ���� ȸ����ȣ�� ��ġ�ϴ� ������������ �ʿ��� ���� ��ȸ&����&�� 
		if (member_info_no != null){ 
			MemberDAO dao = new MemberDAO();
			MemberDTO infoList = dao.memberPageList(member_info_no);
			req.setAttribute("infoList", infoList);
		}	
	}
}
