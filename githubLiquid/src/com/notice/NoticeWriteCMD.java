package com.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Command;
import com.oreilly.servlet.MultipartRequest; 

public class NoticeWriteCMD implements Command{
	public void execute(HttpServletRequest request, HttpServletResponse response){
 
		//String savePath = "D:/JSPEX/liquid/WebContent/bbs/notice/img";// ������ ����� ������ ���
		String savePath = request.getServletContext().getRealPath("/bbs/notice/img");
		int sizeLimit = 1024*1024*15;	// ���� ũ�� 15MB�� ����
		System.out.println(savePath);
		//  �� request ��ü,               �� ����� ���� ���,       �� ���� �ִ� ũ��,    �� ���ڵ� ���,       �� ���� �̸��� ���ϸ� ���� ó��
		// (HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding, FileRenamePolicy policy)
		// �Ʒ��� ���� MultipartRequest�� ������ ���ָ� ������ ���ε� �ȴ�.(���� ��ü�� ���ε� �Ϸ�)
		
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit,"euc-kr");
			String board_notice_title = multi.getParameter("board_notice_title");
			String board_notice_content = multi.getParameter("board_notice_content");
			board_notice_content = board_notice_content.replaceAll("\r\n", "<br>"); // ����Ű => <br>
			
			HttpSession session = request.getSession();
			String member_info_no = (String) session.getAttribute("s_member_info_no");
			
			// ���۹��� �����Ͱ� ������ ��� getFilesystemName()���� ���� �̸��� �޾ƿ� �� �ִ�.
			String fileName1 = multi.getFilesystemName("board_notice_imgsrc1");
			String fileName2 = multi.getFilesystemName("board_notice_imgsrc2");
			
			// ���ε��� ������ ��ü ��θ� DB�� �����ϱ� ���Ԥ�
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
		
		// MultipartRequest�� ���۹��� �����͸� �ҷ��´�.
		// enctype�� "multipart/form-data"�� �����ϰ� submit�� �����͵��� request��ü�� �ƴ� MultipartRequest��ü�� �ҷ��;� �Ѵ�.

	}
}
