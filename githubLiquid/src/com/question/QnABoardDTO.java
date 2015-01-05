package com.question;

public class QnABoardDTO {
	public QnABoardDTO(){}
	public QnABoardDTO(int board_question_no, int member_info_no, String board_question_title,
			String board_question_content, String board_question_date, int board_question_viewcount,
			int board_question_reproot, int board_question_repstep, int board_question_repindent,
			String board_question_imgsrc1, String board_question_imgsrc2, String board_question_imgsrc3, String board_question_imgsrc4, String board_question_imgsrc5){
		this.board_question_no = board_question_no;
		this.member_info_no = member_info_no;
		this.board_question_title = board_question_title;
		this.board_question_content = board_question_content;
		this.board_question_date = board_question_date;
		this.board_question_viewcount = board_question_viewcount;
		this.board_question_reproot = board_question_reproot;
		this.board_question_repstep = board_question_repstep;
		this.board_question_repindent = board_question_repindent;
		this.board_question_imgsrc1 = board_question_imgsrc1;
		this.board_question_imgsrc2 = board_question_imgsrc2;
		this.board_question_imgsrc3 = board_question_imgsrc3;
		this.board_question_imgsrc4 = board_question_imgsrc4;
		this.board_question_imgsrc5 = board_question_imgsrc5;
	}
	 
	private String member_info_no_nickname; //member_info의 member_info_no로 작성자를 가져오기 위한 변수
	
	public String getMember_info_no_nickname() {
		return member_info_no_nickname;
	}
	public void setMember_info_no_nickname(String member_info_no_nickname) {
		this.member_info_no_nickname = member_info_no_nickname;
	}

	private int curBoardNumber;//파일첨부시 현재 최대 글 번호를 받기위한 변수
	
	private int board_question_no;
	private int member_info_no;
	private String board_question_title;
	private String board_question_content;
	private String board_question_date;
	private int board_question_viewcount;
	private int board_question_reproot;
	private int board_question_repstep;
	private int board_question_repindent;
	private String board_question_imgsrc1;
	private String board_question_imgsrc2;
	private String board_question_imgsrc3;
	private String board_question_imgsrc4;
	private String board_question_imgsrc5;
	
	public int getBoard_question_no() {
		return board_question_no;
	}
	public void setBoard_question_no(int board_question_no) {
		this.board_question_no = board_question_no;
	}
	public int getMember_info_no() {
		return member_info_no;
	}
	public void setMember_info_no(int member_info_no) {
		this.member_info_no = member_info_no;
	}
	public String getBoard_question_title() {
		return board_question_title;
	}
	public void setBoard_question_title(String board_question_title) {
		this.board_question_title = board_question_title;
	}
	public String getBoard_question_content() {
		return board_question_content;
	}
	public void setBoard_question_content(String board_question_content) {
		this.board_question_content = board_question_content;
	}
	public String getBoard_question_date() {
		return board_question_date;
	}
	public void setBoard_question_date(String board_question_date) {
		this.board_question_date = board_question_date;
	}
	public int getBoard_question_viewcount() {
		return board_question_viewcount;
	}
	public void setBoard_question_viewcount(int board_question_viewcount) {
		this.board_question_viewcount = board_question_viewcount;
	}
	public int getBoard_question_reproot() {
		return board_question_reproot;
	}
	public void setBoard_question_reproot(int board_question_reproot) {
		this.board_question_reproot = board_question_reproot;
	}
	public int getBoard_question_repstep() {
		return board_question_repstep;
	}
	public void setBoard_question_repstep(int board_question_repstep) {
		this.board_question_repstep = board_question_repstep;
	}
	public int getBoard_question_repindent() {
		return board_question_repindent;
	}
	public void setBoard_question_repindent(int board_question_repindent) {
		this.board_question_repindent = board_question_repindent;
	}
	public String getBoard_question_imgsrc1() {
		return board_question_imgsrc1;
	}
	public void setBoard_question_imgsrc1(String board_question_imgsrc1) {
		this.board_question_imgsrc1 = board_question_imgsrc1;
	}
	public String getBoard_question_imgsrc2() {
		return board_question_imgsrc2;
	}
	public void setBoard_question_imgsrc2(String board_question_imgsrc2) {
		this.board_question_imgsrc2 = board_question_imgsrc2;
	}
	public String getBoard_question_imgsrc3() {
		return board_question_imgsrc3;
	}
	public void setBoard_question_imgsrc3(String board_question_imgsrc3) {
		this.board_question_imgsrc3 = board_question_imgsrc3;
	}
	public String getBoard_question_imgsrc4() {
		return board_question_imgsrc4;
	}
	public void setBoard_question_imgsrc4(String board_question_imgsrc4) {
		this.board_question_imgsrc4 = board_question_imgsrc4;
	}
	public String getBoard_question_imgsrc5() {
		return board_question_imgsrc5;
	}
	public void setBoard_question_imgsrc5(String board_question_imgsrc5) {
		this.board_question_imgsrc5 = board_question_imgsrc5;
	}
	public int getCurBoardNumber() {
		return curBoardNumber;
	}
	public void setCurBoardNumber(int curBoardNumber) {
		this.curBoardNumber = curBoardNumber;
	}

	
}
