package com.wishlist;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 2014.11.18
 * 어떤 파일에 호출받는가 : WishListViewCMD
 * 어떤 파일을 호출하는가 :  
 * 클래스 용도 : 위시리스트 목록 검색하고 담을 DTO
 * 파일 타입 : 
 ***********************************************************************/
public class WishListDTO { //위시리스트 목록 검색하고 담을 DTO
	private int wishlist_no;  	 //위시리스트번호
	private int member_info_no;  //회원번호
	private String product_name; //상품명
	private int product_no;   //상품번호
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	private int product_price;	 //상품가격
	private String product_date; //상품등록일자
	private String product_imgsrc1;//상품이미지
	
	public String getProduct_imgsrc1() {
		return product_imgsrc1;
	}
	public void setProduct_imgsrc1(String product_imgsrc1) {
		this.product_imgsrc1 = product_imgsrc1;
	}
	public WishListDTO(){}
	public WishListDTO(int wishlist_no, String member_info_name,
			String product_name,int product_no, int product_price, String product_date, String product_imgsrc1, int member_info_no) {
		this.wishlist_no = wishlist_no;
		this.member_info_no = member_info_no;
		this.product_name = product_name;
		this.product_no = product_no;
		this.product_price = product_price;
		this.product_date = product_date;
		this.product_imgsrc1=product_imgsrc1;
	}
	public int getWishlist_no() {
		return wishlist_no;
	}
	public void setWishlist_no(int wishlist_no) {
		this.wishlist_no = wishlist_no;
	}
	public int getMember_info_no() {
		return member_info_no;
	}
	public void setMember_info_no(int member_info_no) {
		this.member_info_no = member_info_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_date() {
		return product_date;
	}
	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}
	
}
