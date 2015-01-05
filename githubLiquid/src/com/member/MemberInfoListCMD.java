package com.member;
/***********************************************************************
 * 작업자 : 이승우
 * 작업일자 : 14.11.10 - 14.11.16 
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 :  *.do 요청시 오는곳!
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
		logger.info("MemberInfoSelectCMD 호출 성공");
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
