package com.notice;

public class NoticeDTO {

	private int board_notice_no;
	private String board_notice_title;
	private String board_notice_writer;
	private String board_notice_content;
	private String board_notice_date;
	private int board_notice_views;
	private String board_notice_imgsrc1;
	private String board_notice_imgsrc2;
	private int member_info_no;
	private String member_info_nickname;
	private String filename1;
	private String filename2;

	public NoticeDTO(){}

	

	public NoticeDTO(int board_notice_no, String board_notice_title,
			String board_notice_writer, String board_notice_content,
			String board_notice_date, int board_notice_views,
			String board_notice_imgsrc1, String board_notice_imgsrc2,
			int member_info_no, String member_info_nickname, String filename1,
			String filename2) {
		super();
		this.board_notice_no = board_notice_no;
		this.board_notice_title = board_notice_title;
		this.board_notice_writer = board_notice_writer;
		this.board_notice_content = board_notice_content;
		this.board_notice_date = board_notice_date;
		this.board_notice_views = board_notice_views;
		this.board_notice_imgsrc1 = board_notice_imgsrc1;
		this.board_notice_imgsrc2 = board_notice_imgsrc2;
		this.member_info_no = member_info_no;
		this.member_info_nickname = member_info_nickname;
		this.filename1 = filename1;
		this.filename2 = filename2;
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



	public String getBoard_notice_writer() {
		return board_notice_writer;
	}



	public void setBoard_notice_writer(String board_notice_writer) {
		this.board_notice_writer = board_notice_writer;
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



	public int getBoard_notice_views() {
		return board_notice_views;
	}



	public void setBoard_notice_views(int board_notice_views) {
		this.board_notice_views = board_notice_views;
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



	public int getMember_info_no() {
		return member_info_no;
	}



	public void setMember_info_no(int member_info_no) {
		this.member_info_no = member_info_no;
	}



	public String getMember_info_nickname() {
		return member_info_nickname;
	}



	public void setMember_info_nickname(String member_info_nickname) {
		this.member_info_nickname = member_info_nickname;
	}



	public String getFilename1() {
		return filename1;
	}



	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}



	public String getFilename2() {
		return filename2;
	}



	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}


	

}
