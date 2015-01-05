package com.vo;

public class Board_questionVO {
	  private int	 board_question_no        =0;// 
	  private String board_question_title     ="";// 
	  private String board_question_content   ="";// 
	  private String board_question_date      ="";// 
	  private String board_question_imgsrc1   ="";// 
	  private String board_question_imgsrc2   ="";// 
	  private String board_question_imgsrc3   ="";// 
	  private String board_question_imgsrc4   ="";// 
	  private String board_question_imgsrc5   ="";// 
	  private int 	 board_question_viewcount =0;// 
	  private int  	 member_info_no           =0;// 
	  private int  	 board_question_reproot   =0;// 
	  private int  	 board_question_repstep   =0;// 
	  private int 	 board_question_repindent =0;// 
	  
	  
	  
	public Board_questionVO(int board_question_no, String board_question_title,
			String board_question_content, String board_question_date,
			String board_question_imgsrc1, String board_question_imgsrc2,
			String board_question_imgsrc3, String board_question_imgsrc4,
			String board_question_imgsrc5, int board_question_viewcount,
			int member_info_no, int board_question_reproot,
			int board_question_repstep, int board_question_repindent) {
		super();
		this.board_question_no = board_question_no;
		this.board_question_title = board_question_title;
		this.board_question_content = board_question_content;
		this.board_question_date = board_question_date;
		this.board_question_imgsrc1 = board_question_imgsrc1;
		this.board_question_imgsrc2 = board_question_imgsrc2;
		this.board_question_imgsrc3 = board_question_imgsrc3;
		this.board_question_imgsrc4 = board_question_imgsrc4;
		this.board_question_imgsrc5 = board_question_imgsrc5;
		this.board_question_viewcount = board_question_viewcount;
		this.member_info_no = member_info_no;
		this.board_question_reproot = board_question_reproot;
		this.board_question_repstep = board_question_repstep;
		this.board_question_repindent = board_question_repindent;
	}
	
	
	public Board_questionVO() {
		super();
	}


	public int getBoard_question_no() {
		return board_question_no;
	}
	public void setBoard_question_no(int board_question_no) {
		this.board_question_no = board_question_no;
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
	public int getBoard_question_viewcount() {
		return board_question_viewcount;
	}
	public void setBoard_question_viewcount(int board_question_viewcount) {
		this.board_question_viewcount = board_question_viewcount;
	}
	public int getMember_info_no() {
		return member_info_no;
	}
	public void setMember_info_no(int member_info_no) {
		this.member_info_no = member_info_no;
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
	  
	  
	  
}
