package com.vo;

public class StockVO {
	  private int    stock_no        =0;//
	  private int    stock_quantity  =0;//
	  private String stock_size      ="";//
	  private int    product_no      =0;//
	  
	public StockVO(int stock_no, int stock_quantity, String stock_size,
			int product_no) {
		super();
		this.stock_no = stock_no;
		this.stock_quantity = stock_quantity;
		this.stock_size = stock_size;
		this.product_no = product_no;
	}
	
	public StockVO() {
		super();
	}
	
	public int getStock_no() {
		return stock_no;
	}
	
	public void setStock_no(int stock_no) {
		this.stock_no = stock_no;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public String getStock_size() {
		return stock_size;
	}
	public void setStock_size(String stock_size) {
		this.stock_size = stock_size;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	  
	  
}
