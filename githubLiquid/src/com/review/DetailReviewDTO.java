package com.review;
/**************************************************************
 *	작업자 : 김용민 
 *	작업일자 : 14.11.22
 *	상품상세에서 상품평글을 가져올때 필요한 dto
 *
 *************************************************/

public class DetailReviewDTO {
	  private int board_review_no       	;// 리뷰게시판 번호      
	  private String board_review_content   ;//	리뷰게시판 내용
	  private String board_review_date      ;// 리뷰게시판 날짜
	  private String member_info_nickname	;// 리뷰게시판 작성자 닉네임
	  private int product_no				;// 상품번호	
	  private int member_info_no			;// 작정자 번호
	  private int besong		;// 배송평점 등록시 사용
	  private int sangpum		;// 상풍평점 등록시 사용
	  
	  //뿌려주는 사이즈로 인해 잠시 보류
	  /*BOARD_REVIEW_IMGSRC1   
	  BOARD_REVIEW_IMGSRC2   
	  BOARD_REVIEW_IMGSRC3   
	  BOARD_REVIEW_IMGSRC4   
	  BOARD_REVIEW_IMGSRC5*/   
	  /*BOARD_REVIEW_REPROOT*/ //미구현   
	  /*BOARD_REVIEW_REPSTEP   */ //미구현
	  
	public int getBoard_review_no() {
		return board_review_no;
	}
	public void setBoard_review_no(int board_review_no) {
		this.board_review_no = board_review_no;
	}
	public String getBoard_review_content() {
		return board_review_content;
	}
	public void setBoard_review_content(String board_review_content) {
		this.board_review_content = board_review_content;
	}
	public String getBoard_review_date() {
		return board_review_date;
	}
	public void setBoard_review_date(String board_review_date) {
		this.board_review_date = board_review_date;
	}
	public String getMember_info_nickname() {
		return member_info_nickname;
	}
	public void setMember_info_nickname(String member_info_nickname) {
		this.member_info_nickname = member_info_nickname;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getMember_info_no() {
		return member_info_no;
	}
	public void setMember_info_no(int member_info_no) {
		this.member_info_no = member_info_no;
	}
	public int getBesong() {
		return besong;
	}
	public void setBesong(int besong) {
		this.besong = besong;
	}
	public int getSangpum() {
		return sangpum;
	}
	public void setSangpum(int sangpum) {
		this.sangpum = sangpum;
	}


}
