package com.member;
/***********************************************************************
 * 작업자 : 이승우
 * 작업일자 :  ID 중복검사 작업예정
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 : 
 ***********************************************************************/


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



import com.controller.Command;

public class MemberConfirmCMD implements Command{
	Logger logger = Logger.getLogger(MemberConfirmCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberConfirmIdCMD 호출 성공");
		
		String member_info_nickname = req.getParameter("nickname");
		System.out.println("중복체크할 닉네임 :"+member_info_nickname);
		
	
		String member_info_id = req.getParameter("id");
		System.out.println("중복체크할 아이디 :"+member_info_id);
		MemberDAO dao = new MemberDAO();
		
		int check = dao.confirm(member_info_id,member_info_nickname);
		System.out.println("중복아이디체크 있으면 1, 없으면 0 결과는??"+check);
		if (member_info_id != null)
			req.setAttribute("member_info_id", member_info_id);
		else if (member_info_nickname != null)
			req.setAttribute("member_info_nickname", member_info_nickname);
		req.setAttribute("check", new Integer(check));
	}   

}
