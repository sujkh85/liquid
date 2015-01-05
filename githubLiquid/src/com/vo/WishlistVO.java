package com.vo;

public class WishlistVO {
	  private int wishlist_no        =0;//
	  private int product_no         =0;//
	  private int wishlist_quantity  =0;//
	  private int member_info_no     =0;//
	  
	public WishlistVO(int wishlist_no, int product_no, int wishlist_quantity,
			int member_info_no) {
		super();
		this.wishlist_no = wishlist_no;
		this.product_no = product_no;
		this.wishlist_quantity = wishlist_quantity;
		this.member_info_no = member_info_no;
	}
	
	public WishlistVO() {
		super();
	}
	
	public int getWishlist_no() {
		return wishlist_no;
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
	public int getWishlist_quantity() {
		return wishlist_quantity;
	}
	public void setWishlist_quantity(int wishlist_quantity) {
		this.wishlist_quantity = wishlist_quantity;
	}
	public int getMember_info_no() {
		return member_info_no;
	}
	public void setMember_info_no(int member_info_no) {
		this.member_info_no = member_info_no;
	}
	  
}
