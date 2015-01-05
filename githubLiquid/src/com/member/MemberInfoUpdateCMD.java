package com.member;
/***********************************************************************
 * 작업자 : 이승우
 * 작업일자 : 14.11.16 
 * 어떤 파일에 호출받는가 : MemberFC.java
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 :  
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;
import com.manager.ManagerDAO;

//회원정보수정
public class MemberInfoUpdateCMD implements Command{
	Logger logger = Logger.getLogger(MemberInfoUpdateCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("MemberInfoUpdateCMD 호출성공");
		int update_result;
		//로그인 후 세션에 담긴 회원번호를 쓰기위한 세션 사용
		HttpSession session = req.getSession();
		//수정페이지에서 가져온 데이터를 data에  담는다
		MemberDTO data = new MemberDTO();
		if(req.getParameter("member_grade_no")==null){//관리자페이지에서 수정할때 회원등급 넘겨주니까
			logger.info("회원정보수정");
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
			//infoData를 가지고 DB에서 업데이트를 실행한다
			MemberDAO update = new MemberDAO();
			update_result = update.memberInfoUpdate(data);
		}else{
			logger.info("관리자 회원정보수정");
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
		
		//업데이트 결과 없는 경우 여기서 끝 
		
			req.setAttribute("update_result", new Integer(update_result));
		
	}

}
