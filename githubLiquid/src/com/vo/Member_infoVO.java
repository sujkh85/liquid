package com.vo;

public class Member_infoVO {
	  private int    member_info_no        =0;//
	  private String member_info_name      ="";//
	  private String member_info_address   ="";//
	  private String member_info_phone     ="";//
	  private String member_info_gender    ="";//
	  private String member_info_birtday   ="";//
	  private String member_info_date      ="";//
	  private String member_info_id        ="";//
	  private String member_info_pw        ="";//
	  private String member_info_nickname  ="";//
	  private String member_info_email     ="";//
	  private int    member_grade_no       =0;//
	  
	public Member_infoVO(int member_info_no, String member_info_name,
			String member_info_address, String member_info_phone,
			String member_info_gender, String member_info_birtday,
			String member_info_date, String member_info_id,
			String member_info_pw, String member_info_nickname,
			String member_info_email, int member_grade_no) {
		super();
		this.member_info_no = member_info_no;
		this.member_info_name = member_info_name;
		this.member_info_address = member_info_address;
		this.member_info_phone = member_info_phone;
		this.member_info_gender = member_info_gender;
		this.member_info_birtday = member_info_birtday;
		this.member_info_date = member_info_date;
		this.member_info_id = member_info_id;
		this.member_info_pw = member_info_pw;
		this.member_info_nickname = member_info_nickname;
		this.member_info_email = member_info_email;
		this.member_grade_no = member_grade_no;
	}
	public Member_infoVO() {
		super();
	}
	
	public int getMember_info_no() {
		return member_info_no;
	}
	public void setMember_info_no(int member_info_no) {
		this.member_info_no = member_info_no;
	}
	public String getMember_info_name() {
		return member_info_name;
	}
	public void setMember_info_name(String member_info_name) {
		this.member_info_name = member_info_name;
	}
	public String getMember_info_address() {
		return member_info_address;
	}
	public void setMember_info_address(String member_info_address) {
		this.member_info_address = member_info_address;
	}
	public String getMember_info_phone() {
		return member_info_phone;
	}
	public void setMember_info_phone(String member_info_phone) {
		this.member_info_phone = member_info_phone;
	}
	public String getMember_info_gender() {
		return member_info_gender;
	}
	public void setMember_info_gender(String member_info_gender) {
		this.member_info_gender = member_info_gender;
	}
	public String getMember_info_birtday() {
		return member_info_birtday;
	}
	public void setMember_info_birtday(String member_info_birtday) {
		this.member_info_birtday = member_info_birtday;
	}
	public String getMember_info_date() {
		return member_info_date;
	}
	public void setMember_info_date(String member_info_date) {
		this.member_info_date = member_info_date;
	}
	public String getMember_info_id() {
		return member_info_id;
	}
	public void setMember_info_id(String member_info_id) {
		this.member_info_id = member_info_id;
	}
	public String getMember_info_pw() {
		return member_info_pw;
	}
	public void setMember_info_pw(String member_info_pw) {
		this.member_info_pw = member_info_pw;
	}
	public String getMember_info_nickname() {
		return member_info_nickname;
	}
	public void setMember_info_nickname(String member_info_nickname) {
		this.member_info_nickname = member_info_nickname;
	}
	public String getMember_info_email() {
		return member_info_email;
	}
	public void setMember_info_email(String member_info_email) {
		this.member_info_email = member_info_email;
	}
	public int getMember_grade_no() {
		return member_grade_no;
	}
	public void setMember_grade_no(int member_grade_no) {
		this.member_grade_no = member_grade_no;
	}
	  
	  
}
