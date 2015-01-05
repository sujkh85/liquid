package com.design;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.Command;
import com.oreilly.servlet.MultipartRequest;

public class DesignWriteCMD implements Command{
	Logger logger = Logger.getLogger(DesignWriteCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("DesignWriteCMD 호출 성공");
		DesignDTO dto = new DesignDTO();
		DesignDAO dao = new DesignDAO();
		HashMap<String,String> pMap = new HashMap<String,String>();
		HttpSession session = req.getSession();
		dto.setMember_info_no(Integer.parseInt((String)session.getAttribute("s_member_info_no")));
		
		//실제 저장되는 서버 경로
		String savePath = req.getServletContext().getRealPath("/bbs/design/img"); 
		String dbsrc = "./bbs/design/img/";
		//파일크기  
		int sizeLimit = 1024*1024*15;	
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(req, savePath, sizeLimit,"euc-kr");
			dto.setBoard_userdesign_title(multi.getParameter("board_userdesign_title"));
			dto.setBoard_userdesign_content(multi.getParameter("board_userdesign_content"));
			
			for(int i=1;i<6;i++){
				String fileName = multi.getFilesystemName("board_userdesign_imgsrc"+i);
				if(fileName != null)
					pMap.put("board_userdesign_imgsrc"+i, dbsrc+fileName);
				else{
					pMap.put("board_userdesign_imgsrc"+i, "");
				}
				System.out.println(fileName);
			}
		} catch (IOException e) { 
				e.printStackTrace();
		} int insertDesign = dao.insertDesign(dto,pMap);
		System.out.println(insertDesign);
		req.setAttribute("insertDesign",new Integer(insertDesign));
	}
}
