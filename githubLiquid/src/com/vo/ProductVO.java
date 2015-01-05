package com.vo;

public class ProductVO {
	  private int    product_no        =0;//
	  private String product_name      ="";//
	  private int    product_type_no   =0;//
	  private String product_detail    ="";//
	  private String product_date      ="";//
	  private String gender_type       ="";//
	  private int    product_cost      =0;//
	  private int    product_price     =0;//
	  private String product_imgsrc1   ="";//
	  private String product_imgsrc2   ="";//
	  private String product_imgsrc3   ="";//
	  private String product_imgsrc4   ="";//
	  private String product_imgsrc5   ="";//
	public ProductVO(int product_no, String product_name, int product_type_no,
			String product_detail, String product_date, String gender_type,
			int product_cost, int product_price, String product_imgsrc1,
			String product_imgsrc2, String product_imgsrc3,
			String product_imgsrc4, String product_imgsrc5) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_type_no = product_type_no;
		this.product_detail = product_detail;
		this.product_date = product_date;
		this.gender_type = gender_type;
		this.product_cost = product_cost;
		this.product_price = product_price;
		this.product_imgsrc1 = product_imgsrc1;
		this.product_imgsrc2 = product_imgsrc2;
		this.product_imgsrc3 = product_imgsrc3;
		this.product_imgsrc4 = product_imgsrc4;
		this.product_imgsrc5 = product_imgsrc5;
	}
	
	 
	public ProductVO() {
		super();
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_type_no() {
		return product_type_no;
	}
	public void setProduct_type_no(int product_type_no) {
		this.product_type_no = product_type_no;
	}
	public String getProduct_detail() {
		return product_detail;
	}
	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}
	public String getProduct_date() {
		return product_date;
	}
	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}
	public String getGender_type() {
		return gender_type;
	}
	public void setGender_type(String gender_type) {
		this.gender_type = gender_type;
	}
	public int getProduct_cost() {
		return product_cost;
	}
	public void setProduct_cost(int product_cost) {
		this.product_cost = product_cost;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_imgsrc1() {
		return product_imgsrc1;
	}
	public void setProduct_imgsrc1(String product_imgsrc1) {
		this.product_imgsrc1 = product_imgsrc1;
	}
	public String getProduct_imgsrc2() {
		return product_imgsrc2;
	}
	public void setProduct_imgsrc2(String product_imgsrc2) {
		this.product_imgsrc2 = product_imgsrc2;
	}
	public String getProduct_imgsrc3() {
		return product_imgsrc3;
	}
	public void setProduct_imgsrc3(String product_imgsrc3) {
		this.product_imgsrc3 = product_imgsrc3;
	}
	public String getProduct_imgsrc4() {
		return product_imgsrc4;
	}
	public void setProduct_imgsrc4(String product_imgsrc4) {
		this.product_imgsrc4 = product_imgsrc4;
	}
	public String getProduct_imgsrc5() {
		return product_imgsrc5;
	}
	public void setProduct_imgsrc5(String product_imgsrc5) {
		this.product_imgsrc5 = product_imgsrc5;
	}
	  
	  
}
