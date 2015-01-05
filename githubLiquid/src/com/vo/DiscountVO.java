package com.vo;

public class DiscountVO {
	  private int    discount_no         =0;// 
	  private String discount_name       ="";// 
	  private int    discount_contents   =0;// 
	  private String discount_type       ="";// 
	  private String discount_date_start ="";// 
	  private String discount_date_end   ="";// 
	  
	public DiscountVO(int discount_no, String discount_name,
			int discount_contents, String discount_type,
			String discount_date_start, String discount_date_end) {
		super();
		this.discount_no = discount_no;
		this.discount_name = discount_name;
		this.discount_contents = discount_contents;
		this.discount_type = discount_type;
		this.discount_date_start = discount_date_start;
		this.discount_date_end = discount_date_end;
	}
	public DiscountVO() {
		super();
	}
	public int getDiscount_no() {
		return discount_no;
	}
	public void setDiscount_no(int discount_no) {
		this.discount_no = discount_no;
	}
	public String getDiscount_name() {
		return discount_name;
	}
	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}
	public int getDiscount_contents() {
		return discount_contents;
	}
	public void setDiscount_contents(int discount_contents) {
		this.discount_contents = discount_contents;
	}
	public String getDiscount_type() {
		return discount_type;
	}
	public void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}
	public String getDiscount_date_start() {
		return discount_date_start;
	}
	public void setDiscount_date_start(String discount_date_start) {
		this.discount_date_start = discount_date_start;
	}
	public String getDiscount_date_end() {
		return discount_date_end;
	}
	public void setDiscount_date_end(String discount_date_end) {
		this.discount_date_end = discount_date_end;
	}
	  
	  
}
