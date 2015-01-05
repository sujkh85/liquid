package com.member;
/***********************************************************************
 * 작업자 : 전종우
 * 작업일자 : 14.11.10 - 14.11.13 
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 :   
 * 이승우 : 14.11.14 - 14.11.16 마이페이지, 회원정보수정등 기능 추가에 따른 변수 추가
 ***********************************************************************/
public class MemberDTO {
	private String member_info_id       = ""; // 아이디 (수정불가능)
	private String member_info_nickname = ""; // 닉네임
	private String member_info_pw       = ""; // 비밀번호
	private String member_info_name     = ""; // 이름
	private String member_info_birthday = ""; // 생년월일
	private String member_info_gender   = ""; // 성별
	private String member_info_address1 = ""; // 주소
	private String member_info_address2 = ""; // 상세주소
	private String member_info_post1    = ""; // 우편번호 앞에3자리 
	private String member_info_post2    = ""; // 우편번호 뒤에3자리
	private String member_info_phone    = ""; // 연락처
	private String member_info_email    = ""; // 이메일
	private int orderCount = 0;				// 마이페이지에 보여줄 현재 주문수량
	private String member_grade_name = "";	// 마이페이지에 보여줄 등급이름
	private String member_info_no = "";    //로그인성공시 담을 회원번호
	private String member_grade_no = "";	//로그인성공시 담을 회원등급번호
	
	MemberDTO(){}
	
	//회원정보 전체
	MemberDTO(String member_info_id,String member_info_nickname,String member_info_pw,String member_info_name,   
			String member_info_birthday,String member_info_gender,String member_info_address1, String member_info_address2,
			String member_info_post1,String member_info_post2,String member_info_phone,String member_info_email )
	{
		this.member_info_id         = member_info_id	   ;
		this.member_info_nickname   = member_info_nickname ;
		this.member_info_pw         = member_info_pw       ;             
		this.member_info_name       = member_info_name     ;             
		this.member_info_birthday   = member_info_birthday ;             
		this.member_info_gender     = member_info_gender   ;             
		this.member_info_address1   = member_info_address1 ;             
		this.member_info_address2   = member_info_address2 ;             
		this.member_info_post1      = member_info_post1    ;             
		this.member_info_post2      = member_info_post2    ;             
		this.member_info_phone      = member_info_phone    ;             
		this.member_info_email      = member_info_email    ;             
		
	}

	public String getMember_info_id() {
		return member_info_id;
	}

	public void setMember_info_id(String member_info_id) {
		this.member_info_id = member_info_id;
	}

	public String getMember_info_nickname() {
		return member_info_nickname;
	}

	public void setMember_info_nickname(String member_info_nickname) {
		this.member_info_nickname = member_info_nickname;
	}

	public String getMember_info_pw() {
		return member_info_pw;
	}

	public void setMember_info_pw(String member_info_pw) {
		this.member_info_pw = member_info_pw;
	}

	public String getMember_info_name() {
		return member_info_name;
	}

	public void setMember_info_name(String member_info_name) {
		this.member_info_name = member_info_name;
	}

	public String getMember_info_birthday() {
		return member_info_birthday;
	}

	public void setMember_info_birthday(String member_info_birthday) {
		this.member_info_birthday = member_info_birthday;
	}

	public String getMember_info_gender() {
		return member_info_gender;
	}

	public void setMember_info_gender(String member_info_gender) {
		this.member_info_gender = member_info_gender;
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

	public String getMember_info_email() {
		return member_info_email;
	}

	public void setMember_info_email(String member_info_email) {
		this.member_info_email = member_info_email;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getMember_grade_name() {
		return member_grade_name;
	}

	public void setMember_grade_name(String member_grade_name) {
		this.member_grade_name = member_grade_name;
	}

	public String getMember_info_no() {
		return member_info_no;
	}

	public void setMember_info_no(String member_info_no) {
		this.member_info_no = member_info_no;
	}

	public String getMember_grade_no() {
		return member_grade_no;
	}

	public void setMember_grade_no(String member_grade_no) {
		this.member_grade_no = member_grade_no;
	}
}
