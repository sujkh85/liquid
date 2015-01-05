package com.member;
/***********************************************************************
 * 작업자 : 이승우
 * 작업일자 : 회원가입 구현예정
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 :  
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;
import com.util.EncryptUtil;

//회원가입 
public class MemberInfoInsertCMD implements Command{
	Logger logger = Logger.getLogger(MemberInfoInsertCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String member_info_id= req.getParameter("member_info_id"); 
		String member_info_nickname= req.getParameter("member_info_nickname"); 
		String password_SHA = EncryptUtil.getSHA256(req.getParameter("member_info_pw"));
		String member_info_name= req.getParameter("member_info_name"); 
		String member_info_birthday 
		= req.getParameter("year")+	req.getParameter("month") +req.getParameter("day"); 
		String member_info_gender= req.getParameter("member_info_gender"); 
		String member_info_address1= req.getParameter("member_info_address1"); 
		String member_info_address2= req.getParameter("member_info_address2"); 
		String member_info_post1= req.getParameter("member_info_post1"); 
		String member_info_post2= req.getParameter("member_info_post2"); 
		String member_info_phone= req.getParameter("member_info_phone"); 
		String member_info_email= req.getParameter("member_info_email"); 
		
		MemberDTO data = new MemberDTO(member_info_id,member_info_nickname,password_SHA,member_info_name,
				member_info_birthday,member_info_gender,member_info_address1,member_info_address2,
				member_info_post1,member_info_post2,member_info_phone,member_info_email);
		MemberDAO dao = new MemberDAO();
		int insert_result = dao.memberInfoInsert(data);
		req.setAttribute("insert_result",new Integer(insert_result));
	}
	
}
