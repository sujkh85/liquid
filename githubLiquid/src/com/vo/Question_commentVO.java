package com.vo;

public class Question_commentVO {
	  private int    comment_question_no        =0;
	  private String comment_question_date      ="";
	  private String comment_question_content   ="";
	  private int    board_question_no          =0;
	  private int    comment_question_replay    =0;
	  
	public Question_commentVO(int comment_question_no,
			String comment_question_date, String comment_question_content,
			int board_question_no, int comment_question_replay) {
		super();
		this.comment_question_no = comment_question_no;
		this.comment_question_date = comment_question_date;
		this.comment_question_content = comment_question_content;
		this.board_question_no = board_question_no;
		this.comment_question_replay = comment_question_replay;
	}
	
	public Question_commentVO() {
		super();
	}
	
	public int getComment_question_no() {
		return comment_question_no;
	}
	public void setComment_question_no(int comment_question_no) {
		this.comment_question_no = comment_question_no;
	}
	public String getComment_question_date() {
		return comment_question_date;
	}
	public void setComment_question_date(String comment_question_date) {
		this.comment_question_date = comment_question_date;
	}
	public String getComment_question_content() {
		return comment_question_content;
	}
	public void setComment_question_content(String comment_question_content) {
		this.comment_question_content = comment_question_content;
	}
	public int getBoard_question_no() {
		return board_question_no;
	}
	public void setBoard_question_no(int board_question_no) {
		this.board_question_no = board_question_no;
	}
	public int getComment_question_replay() {
		return comment_question_replay;
	}
	public void setComment_question_replay(int comment_question_replay) {
		this.comment_question_replay = comment_question_replay;
	}
	  
	  
}
