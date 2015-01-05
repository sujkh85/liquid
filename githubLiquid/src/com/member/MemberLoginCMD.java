package com.member;

/***********************************************************************
 * 작업자 : 이승우 
 * 작업일자 : 14.11.14
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 : 비밀번호 암호화해서, 아이디/비밀번호가 모두 일치하는 경우 로그인정보 받아옴.
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
		logger.info("LoginCMD 호출 성공"); 
		MemberDAO dao = new MemberDAO();
		String member_info_id = req.getParameter("member_info_id");
		//비밀번호 암호화
		String password_SHA = EncryptUtil.getSHA256(req.getParameter("member_info_pw"));
		System.out.println("암호화된 비밀번호 password_SHA: "+EncryptUtil.getSHA256(req.getParameter("member_info_pw")));

		//비암호화
//		String password_SHA = req.getParameter("member_info_pw");
//		System.out.println("입력한 비밀번호 password: "+req.getParameter("member_info_pw"));
		
		
		MemberDTO loginInfo  = dao.loginCheck(member_info_id, password_SHA);
		req.setAttribute("loginInfo", loginInfo); 
			
	}
} 


