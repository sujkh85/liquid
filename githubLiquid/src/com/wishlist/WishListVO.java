package com.wishlist;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 2014.11.18
 * � ���Ͽ� ȣ��޴°� : WishListInsertCMD
 * � ������ ȣ���ϴ°� :  
 * Ŭ���� �뵵 : ���ø���Ʈ�� �μ�Ʈ �Ҷ� �� VO
 * ���� Ÿ�� : 
 ***********************************************************************/
public class WishListVO {  //���ø���Ʈ�� �μ�Ʈ �Ҷ� �� VO
	private int wishlist_no;   //���ø���Ʈ��ȣ
	private int product_no;		//��ǰ��ȣ
	private int member_info_no; //ȸ����ȣ
	
	
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
