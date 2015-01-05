package com.question;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;
import com.oreilly.servlet.MultipartRequest;

public class QnABoardWriteCMD implements Command{

	@Override 
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		QnABoardDAO dao = new QnABoardDAO();
		//String savePath = "D:/JSPEX/liquid/WebContent/bbs/notice/img";// 파일이 저장될 서버의 경로
		String savePath = request.getServletContext().getRealPath("/bbs/question/img");
		int sizeLimit = 400*400*15;	// 파일 크기 15MB로 제한
		String save_file_name ="";
		
		//  ↓ request 객체,               ↓ 저장될 서버 경로,       ↓ 파일 최대 크기,    ↓ 인코딩 방식,       ↓ 같은 이름의 파일명 방지 처리
		// (HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding, FileRenamePolicy policy)
		// 아래와 같이 MultipartRequest를 생성만 해주면 파일이 업로드 된다.(파일 자체의 업로드 완료)
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit,"euc-kr",new FileUploadRename(save_file_name));
			//multi = new MultipartRequest(request, savePath, sizeLimit,"euc-kr");
			
			String board_question_title = multi.getParameter("title");
			String member_info_no = multi.getParameter("member_info_no");
			String board_question_content = multi.getParameter("content");
			board_question_content = board_question_content.replaceAll("\r\n", "<br>"); // 엔터키 => <br>
			
			// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
			String fileName1 = multi.getFilesystemName("imgsrc1");
			String fileName2 = multi.getFilesystemName("imgsrc2");
			String fileName3 = multi.getFilesystemName("imgsrc3");
			String fileName4 = multi.getFilesystemName("imgsrc4");
			String fileName5 = multi.getFilesystemName("imgsrc5");
		
			
	//////////////////////////////////////////////////////////////////		
//			String fileNm1 = fileName1.substring(0,fileName1.lastIndexOf("."));//맨마지막의 .까지
//			String fileNameExt1 = fileName1.substring(fileName1.lastIndexOf("."));//.이후로 전부
			
			//ex) 글번호30_이미지경로1번파일 abc.jpg : 30_1_abc.jpg
		//////////////////////////////////////////////////////////	
			// 업로드한 파일의 전체 경로를 DB에 저장하기 위함
			String board_notice_imgsrc1 = fileName1;
			String board_notice_imgsrc2 = fileName2;
			String board_notice_imgsrc3 = fileName3;
			String board_notice_imgsrc4 = fileName4;
			String board_notice_imgsrc5 = fileName5;
			
			
			
			dao.write(board_question_title, board_question_content,member_info_no,board_notice_imgsrc1, board_notice_imgsrc2, board_notice_imgsrc3, board_notice_imgsrc4, board_notice_imgsrc5);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		// MultipartRequest로 전송받은 데이터를 불러온다.
		// enctype을 "multipart/form-data"로 선언하고 submit한 데이터들은 request객체가 아닌 MultipartRequest객체로 불러와야 한다.

			
	}		

}


/*
package com.question;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class QnABoardWriteCMD implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//String savePath = "D:/JSPEX/liquid/WebContent/bbs/notice/img";// 파일이 저장될 서버의 경로
		String savePath = request.getServletContext().getRealPath("/bbs/question/img");
		int sizeLimit = 400*400*15;	// 파일 크기 15MB로 제한
		
		//  ↓ request 객체,               ↓ 저장될 서버 경로,       ↓ 파일 최대 크기,    ↓ 인코딩 방식,       ↓ 같은 이름의 파일명 방지 처리
		// (HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding, FileRenamePolicy policy)
		// 아래와 같이 MultipartRequest를 생성만 해주면 파일이 업로드 된다.(파일 자체의 업로드 완료)
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit,"euc-kr",new DefaultFileRenamePolicy());
			
			String board_question_title = multi.getParameter("title");
			String member_info_no = multi.getParameter("member_info_no");
			String board_question_content = multi.getParameter("content");
			
			// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
			String fileName1 = multi.getFilesystemName("imgsrc1");
			String fileName2 = multi.getFilesystemName("imgsrc2");
			String fileName3 = multi.getFilesystemName("imgsrc3");
			String fileName4 = multi.getFilesystemName("imgsrc4");
			String fileName5 = multi.getFilesystemName("imgsrc5");
			
			// 업로드한 파일의 전체 경로를 DB에 저장하기 위함
			String board_notice_imgsrc1 = fileName1;
			String board_notice_imgsrc2 = fileName2;
			String board_notice_imgsrc3 = fileName3;
			String board_notice_imgsrc4 = fileName4;
			String board_notice_imgsrc5 = fileName5;
			
			QnABoardDAO dao = new QnABoardDAO();
			dao.write(board_question_title, board_question_content,member_info_no,board_notice_imgsrc1, board_notice_imgsrc2, board_notice_imgsrc3, board_notice_imgsrc4, board_notice_imgsrc5);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// MultipartRequest로 전송받은 데이터를 불러온다.
		// enctype을 "multipart/form-data"로 선언하고 submit한 데이터들은 request객체가 아닌 MultipartRequest객체로 불러와야 한다.

			
	}		

}
*/