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
		//String savePath = "D:/JSPEX/liquid/WebContent/bbs/notice/img";// ������ ����� ������ ���
		String savePath = request.getServletContext().getRealPath("/bbs/question/img");
		int sizeLimit = 400*400*15;	// ���� ũ�� 15MB�� ����
		String save_file_name ="";
		
		//  �� request ��ü,               �� ����� ���� ���,       �� ���� �ִ� ũ��,    �� ���ڵ� ���,       �� ���� �̸��� ���ϸ� ���� ó��
		// (HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding, FileRenamePolicy policy)
		// �Ʒ��� ���� MultipartRequest�� ������ ���ָ� ������ ���ε� �ȴ�.(���� ��ü�� ���ε� �Ϸ�)
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit,"euc-kr",new FileUploadRename(save_file_name));
			//multi = new MultipartRequest(request, savePath, sizeLimit,"euc-kr");
			
			String board_question_title = multi.getParameter("title");
			String member_info_no = multi.getParameter("member_info_no");
			String board_question_content = multi.getParameter("content");
			board_question_content = board_question_content.replaceAll("\r\n", "<br>"); // ����Ű => <br>
			
			// ���۹��� �����Ͱ� ������ ��� getFilesystemName()���� ���� �̸��� �޾ƿ� �� �ִ�.
			String fileName1 = multi.getFilesystemName("imgsrc1");
			String fileName2 = multi.getFilesystemName("imgsrc2");
			String fileName3 = multi.getFilesystemName("imgsrc3");
			String fileName4 = multi.getFilesystemName("imgsrc4");
			String fileName5 = multi.getFilesystemName("imgsrc5");
		
			
	//////////////////////////////////////////////////////////////////		
//			String fileNm1 = fileName1.substring(0,fileName1.lastIndexOf("."));//�Ǹ������� .����
//			String fileNameExt1 = fileName1.substring(fileName1.lastIndexOf("."));//.���ķ� ����
			
			//ex) �۹�ȣ30_�̹������1������ abc.jpg : 30_1_abc.jpg
		//////////////////////////////////////////////////////////	
			// ���ε��� ������ ��ü ��θ� DB�� �����ϱ� ����
			String board_notice_imgsrc1 = fileName1;
			String board_notice_imgsrc2 = fileName2;
			String board_notice_imgsrc3 = fileName3;
			String board_notice_imgsrc4 = fileName4;
			String board_notice_imgsrc5 = fileName5;
			
			
			
			dao.write(board_question_title, board_question_content,member_info_no,board_notice_imgsrc1, board_notice_imgsrc2, board_notice_imgsrc3, board_notice_imgsrc4, board_notice_imgsrc5);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		// MultipartRequest�� ���۹��� �����͸� �ҷ��´�.
		// enctype�� "multipart/form-data"�� �����ϰ� submit�� �����͵��� request��ü�� �ƴ� MultipartRequest��ü�� �ҷ��;� �Ѵ�.

			
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
		
		//String savePath = "D:/JSPEX/liquid/WebContent/bbs/notice/img";// ������ ����� ������ ���
		String savePath = request.getServletContext().getRealPath("/bbs/question/img");
		int sizeLimit = 400*400*15;	// ���� ũ�� 15MB�� ����
		
		//  �� request ��ü,               �� ����� ���� ���,       �� ���� �ִ� ũ��,    �� ���ڵ� ���,       �� ���� �̸��� ���ϸ� ���� ó��
		// (HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding, FileRenamePolicy policy)
		// �Ʒ��� ���� MultipartRequest�� ������ ���ָ� ������ ���ε� �ȴ�.(���� ��ü�� ���ε� �Ϸ�)
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit,"euc-kr",new DefaultFileRenamePolicy());
			
			String board_question_title = multi.getParameter("title");
			String member_info_no = multi.getParameter("member_info_no");
			String board_question_content = multi.getParameter("content");
			
			// ���۹��� �����Ͱ� ������ ��� getFilesystemName()���� ���� �̸��� �޾ƿ� �� �ִ�.
			String fileName1 = multi.getFilesystemName("imgsrc1");
			String fileName2 = multi.getFilesystemName("imgsrc2");
			String fileName3 = multi.getFilesystemName("imgsrc3");
			String fileName4 = multi.getFilesystemName("imgsrc4");
			String fileName5 = multi.getFilesystemName("imgsrc5");
			
			// ���ε��� ������ ��ü ��θ� DB�� �����ϱ� ����
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
		
		// MultipartRequest�� ���۹��� �����͸� �ҷ��´�.
		// enctype�� "multipart/form-data"�� �����ϰ� submit�� �����͵��� request��ü�� �ƴ� MultipartRequest��ü�� �ҷ��;� �Ѵ�.

			
	}		

}
*/