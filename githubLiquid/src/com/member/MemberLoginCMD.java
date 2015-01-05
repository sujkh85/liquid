package com.member;

/***********************************************************************
 * �۾��� : �̽¿� 
 * �۾����� : 14.11.14
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� : ��й�ȣ ��ȣȭ�ؼ�, ���̵�/��й�ȣ�� ��� ��ġ�ϴ� ��� �α������� �޾ƿ�.
 ***********************************************************************/

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;
import com.util.EncryptUtil;


public class MemberLoginCMD implements Command {
	Logger logger = Logger.getLogger(MemberLoginCMD.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res){
		logger.info("LoginCMD ȣ�� ����"); 
		MemberDAO dao = new MemberDAO();
		String member_info_id = req.getParameter("member_info_id");
		//��й�ȣ ��ȣȭ
		String password_SHA = EncryptUtil.getSHA256(req.getParameter("member_info_pw"));
		System.out.println("��ȣȭ�� ��й�ȣ password_SHA: "+EncryptUtil.getSHA256(req.getParameter("member_info_pw")));

		//���ȣȭ
//		String password_SHA = req.getParameter("member_info_pw");
//		System.out.println("�Է��� ��й�ȣ password: "+req.getParameter("member_info_pw"));
		
		
		MemberDTO loginInfo  = dao.loginCheck(member_info_id, password_SHA);
		req.setAttribute("loginInfo", loginInfo); 
			
	}
} 


