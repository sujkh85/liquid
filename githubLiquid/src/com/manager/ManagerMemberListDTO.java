package com.manager;

import java.sql.Date;

/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 어떤 파일에 호출받는가 :  ManagerMemberListCMD
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 :  
 ***********************************************************************/
public class ManagerMemberListDTO { //회원 상세정보 담을 DTO
private int    rownum                ;
private int    member_info_no        ;//회원번호
private String member_info_name      ;//회원이름
private String member_info_address1   ;//회원주소
private String member_info_address2   ;//상세주소
private String member_info_post1   ;//우편번호1
private String member_info_post2   ;//우편번호2
private String member_info_phone     ;//회원전화번호
private String member_info_gender    ;//성별
private String member_info_birthday  ;//생일
private Date member_info_date      ;//가입일
private String member_info_id        ;//아이디
private String member_info_pw        ;//비밀번호
private String member_info_nickname  ;//닉네임
private String member_info_email     ;//이메일
private int    member_grade_no       ;//회원등급번호
private String member_grade_name     ;//회원등급명
public int getRownum() {
	return rownum;
}
public void setRownum(int rownum) {
	this.rownum = rownum;
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
public String getMember_info_address1() {
	return member_info_address1;
}
public void setMember_info_address1(String member_info_address1) {
	this.member_info_address1 = member_info_address1;
}
public String getMember_info_address2() {
	return member_info_address2;
}
public void setMember_info_address2(String member_info_address2) {
	this.member_info_address2 = member_info_address2;
}
public String getMember_info_post1() {
	return member_info_post1;
}
public void setMember_info_post1(String member_info_post1) {
	this.member_info_post1 = member_info_post1;
}
public String getMember_info_post2() {
	return member_info_post2;
}
public void setMember_info_post2(String member_info_post2) {
	this.member_info_post2 = member_info_post2;
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
public String getMember_info_birthday() {
	return member_info_birthday;
}
public void setMember_info_birthday(String member_info_birthday) {
	this.member_info_birthday = member_info_birthday;
}
public Date getMember_info_date() {
	return member_info_date;
}
public void setMember_info_date(Date date) {
	this.member_info_date = date;
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
public String getMember_grade_name() {
	return member_grade_name;
}
public void setMember_grade_name(String member_grade_name) {
	this.member_grade_name = member_grade_name;
}

}
