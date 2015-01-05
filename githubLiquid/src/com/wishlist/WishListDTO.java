package com.wishlist;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 2014.11.18
 * � ���Ͽ� ȣ��޴°� : WishListViewCMD
 * � ������ ȣ���ϴ°� :  
 * Ŭ���� �뵵 : ���ø���Ʈ ��� �˻��ϰ� ���� DTO
 * ���� Ÿ�� : 
 ***********************************************************************/
public class WishListDTO { //���ø���Ʈ ��� �˻��ϰ� ���� DTO
	private int wishlist_no;  	 //���ø���Ʈ��ȣ
	private int member_info_no;  //ȸ����ȣ
	private String product_name; //��ǰ��
	private int product_no;   //��ǰ��ȣ
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	private int product_price;	 //��ǰ����
	private String product_date; //��ǰ�������
	private String product_imgsrc1;//��ǰ�̹���
	
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
