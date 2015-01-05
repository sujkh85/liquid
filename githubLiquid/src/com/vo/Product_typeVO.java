package com.vo;

public class Product_typeVO {
	  private int    product_type_no =0;    
	  private String product_type_name="";
	public Product_typeVO(int product_type_no, String product_type_name) {
		super();
		this.product_type_no = product_type_no;
		this.product_type_name = product_type_name;
	}
	
	public Product_typeVO() {
		super();
	}
	public int getProduct_type_no() {
		return product_type_no;
	}
	public void setProduct_type_no(int product_type_no) {
		this.product_type_no = product_type_no;
	}
	public String getProduct_type_name() {
		return product_type_name;
	}
	public void setProduct_type_name(String product_type_name) {
		this.product_type_name = product_type_name;
	}  
	  
	  
}
