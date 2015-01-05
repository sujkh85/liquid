package com.vo;

public class Member_gradeVO {
	  private int    member_grade_no   = 0;    
	  private String member_grade_name = "";
	  
	public Member_gradeVO(int member_grade_no, String member_grade_name) {
		super();
		this.member_grade_no = member_grade_no;
		this.member_grade_name = member_grade_name;
	}
	public Member_gradeVO() {
		super();
	}
	public int getMember_grade_no() {
		return member_grade_no;
	}
	public void setMember_grade_no(int member_grade_no) {
		this.member_grade_no = member_grade_no;
	}
	public String getMember_grade_name() {
		return member_grade_name;
	}
	public void setMember_grade_name(String member_grade_name) {
		this.member_grade_name = member_grade_name;
	}
	
	  
	  
}
