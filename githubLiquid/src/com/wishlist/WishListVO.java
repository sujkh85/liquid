package com.wishlist;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 2014.11.18
 * 어떤 파일에 호출받는가 : WishListInsertCMD
 * 어떤 파일을 호출하는가 :  
 * 클래스 용도 : 위시리스트에 인서트 할때 쓸 VO
 * 파일 타입 : 
 ***********************************************************************/
public class WishListVO {  //위시리스트에 인서트 할때 쓸 VO
	private int wishlist_no;   //위시리스트번호
	private int product_no;		//상품번호
	private int member_info_no; //회원번호
	
	
	public int getWishlist_no() {
		return wishlist_no;
	}
	public WishListVO(){}
	public WishListVO(int wishlist_no, int product_no, int member_info_no) {
		this.wishlist_no = wishlist_no;
		this.product_no = product_no;
		this.member_info_no = member_info_no;
	}
	public void setWishlist_no(int wishlist_no) {
		this.wishlist_no = wishlist_no;
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
	
}
