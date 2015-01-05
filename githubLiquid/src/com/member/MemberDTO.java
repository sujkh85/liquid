package com.member;
/***********************************************************************
 * �۾��� : ������
 * �۾����� : 14.11.10 - 14.11.13 
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� :   
 * �̽¿� : 14.11.14 - 14.11.16 ����������, ȸ������������ ��� �߰��� ���� ���� �߰�
 ***********************************************************************/
public class MemberDTO {
	private String member_info_id       = ""; // ���̵� (�����Ұ���)
	private String member_info_nickname = ""; // �г���
	private String member_info_pw       = ""; // ��й�ȣ
	private String member_info_name     = ""; // �̸�
	private String member_info_birthday = ""; // �������
	private String member_info_gender   = ""; // ����
	private String member_info_address1 = ""; // �ּ�
	private String member_info_address2 = ""; // ���ּ�
	private String member_info_post1    = ""; // �����ȣ �տ�3�ڸ� 
	private String member_info_post2    = ""; // �����ȣ �ڿ�3�ڸ�
	private String member_info_phone    = ""; // ����ó
	private String member_info_email    = ""; // �̸���
	private int orderCount = 0;				// ������������ ������ ���� �ֹ�����
	private String member_grade_name = "";	// ������������ ������ ����̸�
	private String member_info_no = "";    //�α��μ����� ���� ȸ����ȣ
	private String member_grade_no = "";	//�α��μ����� ���� ȸ����޹�ȣ
	
	MemberDTO(){}
	
	//ȸ������ ��ü
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
