package com.vo;

public class Board_noticeVO {
	 private int    board_notice_no       =0;//
	 private String board_notice_title    ="";//
	 private String board_notice_content  ="";//
	 private String board_notice_date     ="";//
	 private String board_notice_imgsrc1  ="";//
	 private String board_notice_imgsrc2  ="";//
	 private int    board_notice_views    =0;//
	 private int    member_info_no        =0;//
	 
	 
	 
	public Board_noticeVO(int board_notice_no, String board_notice_title,
			String board_notice_content, String board_notice_date,
			String board_notice_imgsrc1, String board_notice_imgsrc2,
			int board_notice_views, int member_info_no) {
		super();
		this.board_notice_no = board_notice_no;
		this.board_notice_title = board_notice_title;
		this.board_notice_content = board_notice_content;
		this.board_notice_date = board_notice_date;
		this.board_notice_imgsrc1 = board_notice_imgsrc1;
		this.board_notice_imgsrc2 = board_notice_imgsrc2;
		this.board_notice_views = board_notice_views;
		this.member_info_no = member_info_no;
	}
	
	
	
	public Board_noticeVO() {
		super();
	}



	public int getBoard_notice_no() {
		return board_notice_no;
	}
	public void setBoard_notice_no(int board_notice_no) {
		this.board_notice_no = board_notice_no;
	}
	public String getBoard_notice_title() {
		return board_notice_title;
	}
	public void setBoard_notice_title(String board_notice_title) {
		this.board_notice_title = board_notice_title;
	}
	public String getBoard_notice_content() {
		return board_notice_content;
	}
	public void setBoard_notice_content(String board_notice_content) {
		this.board_notice_content = board_notice_content;
	}
	public String getBoard_notice_date() {
		return board_notice_date;
	}
	public void setBoard_notice_date(String board_notice_date) {
		this.board_notice_date = board_notice_date;
	}
	public String getBoard_notice_imgsrc1() {
		return board_notice_imgsrc1;
	}
	public void setBoard_notice_imgsrc1(String board_notice_imgsrc1) {
		this.board_notice_imgsrc1 = board_notice_imgsrc1;
	}
	public String getBoard_notice_imgsrc2() {
		return board_notice_imgsrc2;
	}
	public void setBoard_notice_imgsrc2(String board_notice_imgsrc2) {
		this.board_notice_imgsrc2 = board_notice_imgsrc2;
	}
	public int getBoard_notice_views() {
		return board_notice_views;
	}
	public void setBoard_notice_views(int board_notice_views) {
		this.board_notice_views = board_notice_views;
	}
	public int getMember_info_no() {
		return member_info_no;
	}
	public void setMember_info_no(int member_info_no) {
		this.member_info_no = member_info_no;
	}
	 
	 
	 
	
	 
}
