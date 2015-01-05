package com.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Command;
import com.oreilly.servlet.MultipartRequest; 

public class NoticeWriteCMD implements Command{
	public void execute(HttpServletRequest request, HttpServletResponse response){
 
		//String savePath = "D:/JSPEX/liquid/WebContent/bbs/notice/img";// 파일이 저장될 서버의 경로
		String savePath = request.getServletContext().getRealPath("/bbs/notice/img");
		int sizeLimit = 1024*1024*15;	// 파일 크기 15MB로 제한
		System.out.println(savePath);
		//  ↓ request 객체,               ↓ 저장될 서버 경로,       ↓ 파일 최대 크기,    ↓ 인코딩 방식,       ↓ 같은 이름의 파일명 방지 처리
		// (HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding, FileRenamePolicy policy)
		// 아래와 같이 MultipartRequest를 생성만 해주면 파일이 업로드 된다.(파일 자체의 업로드 완료)
		
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit,"euc-kr");
			String board_notice_title = multi.getParameter("board_notice_title");
			String board_notice_content = multi.getParameter("board_notice_content");
			board_notice_content = board_notice_content.replaceAll("\r\n", "<br>"); // 엔터키 => <br>
			
			HttpSession session = request.getSession();
			String member_info_no = (String) session.getAttribute("s_member_info_no");
			
			// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
			String fileName1 = multi.getFilesystemName("board_notice_imgsrc1");
			String fileName2 = multi.getFilesystemName("board_notice_imgsrc2");
			
			// 업로드한 파일의 전체 경로를 DB에 저장하기 위함ㄴ
			String board_notice_imgsrc1 = "./bbs/notice/img/" + fileName1;
			String board_notice_imgsrc2 = "./bbs/notice/img/" + fileName2;
			
			NoticeDAO dao = new NoticeDAO();
			dao.write(board_notice_title,board_notice_content,board_notice_imgsrc1
					,board_notice_imgsrc2,member_info_no);
			
			NoticeDTO dto = new NoticeDTO();
			
			System.out.println(board_notice_imgsrc1);
			System.out.println(board_notice_imgsrc2);
			/*
			dto.setFilename1(fileName1);
			dto.setFilename2(fileName2);
			*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// MultipartRequest로 전송받은 데이터를 불러온다.
		// enctype을 "multipart/form-data"로 선언하고 submit한 데이터들은 request객체가 아닌 MultipartRequest객체로 불러와야 한다.

	}
}
