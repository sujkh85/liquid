package com.manager;
/***********************************************************************
 * 작업자 : 이홍수, 전종우
 * 작업일자 : 14.11.26
 * 어떤 파일에 호출받는가 :  FC
 * 어떤 파일을 호출하는가 :  회원번호를 받아서 있으면,매개변수로 
 * 					 ManagerDAO의 memberList()나 memberDetailList()호출
 * 파일 타입 :  
 ***********************************************************************/
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class ManagerMemberListCMD implements Command {
	Logger logger = Logger.getLogger(ManagerMemberListCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String align = req.getParameter("align");
		//logger.info(align);
		String member_info_no=req.getParameter("member_info_no"); //member_info_no를 받아옴
		ManagerDAO dao = new ManagerDAO();
		if(member_info_no==null){ //기본 리스트 볼때.(member_info_no를 받아오지 않아서 null)
			String page="";		//초기값
			int curPage =1; //현재 페이지(처음에 1)
			if(req.getParameter("curPage")!=null){  
					curPage = Integer.parseInt(req.getParameter("curPage")); //현재 페이지 받아옴
			}
			
			ManagerPageTO list = new ManagerPageTO();
			list = dao.memberList(curPage,align);	
			
			int perPage = list.getPerPage(); 
			int totalCount = list.getTotalCount();
			int totalPage = totalCount/perPage;  //보여줄 페이지 번호개수
			if(totalCount % perPage != 0) totalPage++; //나머지가 0이아니면 한페이지 더 보여줘야 함
			for(int i=1; i<=totalPage; i++){
				if(curPage ==i){
					page +="<font size='5' color='red'>"+i+"</font>"; //현재페이지 숫자가 빨간색size3크기
				}else{
					page +="<a href='manager_list.do?curPage="+i+"&align="+align+"'>"+i +"</a>&nbsp;";
				}//end if
			}
			req.setAttribute("list", list.getList());
			req.setAttribute("pg",page); //MemberList.jsp의 ${pg}
		}else{ //member_info_id값이 널이 아닐때(페이징 처리가 필요없음)
			ArrayList<ManagerMemberListDTO> list = new ArrayList<ManagerMemberListDTO>();
			list=dao.memberDetailList(Integer.parseInt(member_info_no));
			req.setAttribute("list", list);
		}

	}

}
