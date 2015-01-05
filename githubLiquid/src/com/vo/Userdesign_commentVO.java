package com.vo;

public class Userdesign_commentVO {
	  private int    board_comment_no        =0;
	  private String board_comment_date      ="";
	  private String board_comment_content   ="";
	  private int    board_userdesign_no     =0;
	  private int    board_comment_replay    =0;
	  
	public Userdesign_commentVO(int board_comment_no,
			String board_comment_date, String board_comment_content,
			int board_userdesign_no, int board_comment_replay) {
		super();
		this.board_comment_no = board_comment_no;
		this.board_comment_date = board_comment_date;
		this.board_comment_content = board_comment_content;
		this.board_userdesign_no = board_userdesign_no;
		this.board_comment_replay = board_comment_replay;
	}
	
	public Userdesign_commentVO() {
		super();
	}
	
	public int getBoard_comment_no() {
		return board_comment_no;
	}
	public void setBoard_comment_no(int board_comment_no) {
		this.board_comment_no = board_comment_no;
	}
	public String getBoard_comment_date() {
		return board_comment_date;
	}
	public void setBoard_comment_date(String board_comment_date) {
		this.board_comment_date = board_comment_date;
	}
	public String getBoard_comment_content() {
		return board_comment_content;
	}
	public void setBoard_comment_content(String board_comment_content) {
		this.board_comment_content = board_comment_content;
	}
	public int getBoard_userdesign_no() {
		return board_userdesign_no;
	}
	public void setBoard_userdesign_no(int board_userdesign_no) {
		this.board_userdesign_no = board_userdesign_no;
	}
	public int getBoard_comment_replay() {
		return board_comment_replay;
	}
	public void setBoard_comment_replay(int board_comment_replay) {
		this.board_comment_replay = board_comment_replay;
	}
	  
	  
}
