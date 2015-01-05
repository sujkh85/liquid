package com.member;
/***********************************************************************
 * 작업자 : 이승우
 * 작업일자 : 14.11.16 
 * 어떤 파일에 호출받는가 : MemberFC.java
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 : 메인 최상단 메뉴 Mypage 조회 구현 커맨드
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
		logger.info("MypageCMD 호출 성공");
		//로그인시 세션에 담은 회원번호를 사용하고자 한다.
		HttpSession session = req.getSession();
		String member_info_no = (String) session.getAttribute("s_member_info_no");
		
		//널방지, 비회원일경우 여기서 끝남.
		//널이 아닌경우 위의 세션 회원번호와 일치하는 마이페이지에 필요한 정보 조회&리턴&셋 
		if (member_info_no != null){ 
			MemberDAO dao = new MemberDAO();
			MemberDTO infoList = dao.memberPageList(member_info_no);
			req.setAttribute("infoList", infoList);
		}	
	}
}
