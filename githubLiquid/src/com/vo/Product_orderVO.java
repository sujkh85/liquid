package com.vo;

public class Product_orderVO {
	  private int    order_no          =0; 
	  private String order_date        =""; 
	  private String order_paystatus   =""; 
	  private String order_paydate     =""; 
	  private String order_payment     =""; 
	  private String order_address     =""; 
	  private String order_message     =""; 
	  private int    order_quantity    =0; 
	  private int    order_waybillno   =0; 
	  private int    member_info_no    =0; 
	  private int    order_money       =0; 
	  private int    discount_no       =0; 
	  private int    order_final_money =0; 
	  private int    stock_no          =0;
	public Product_orderVO(int order_no, String order_date,
			String order_paystatus, String order_paydate, String order_payment,
			String order_address, String order_message, int order_quantity,
			int order_waybillno, int member_info_no, int order_money,
			int discount_no, int order_final_money, int stock_no) {
		super();
		this.order_no = order_no;
		this.order_date = order_date;
		this.order_paystatus = order_paystatus;
		this.order_paydate = order_paydate;
		this.order_payment = order_payment;
		this.order_address = order_address;
		this.order_message = order_message;
		this.order_quantity = order_quantity;
		this.order_waybillno = order_waybillno;
		this.member_info_no = member_info_no;
		this.order_money = order_money;
		this.discount_no = discount_no;
		this.order_final_money = order_final_money;
		this.stock_no = stock_no;
	}
	public Product_orderVO() {
		super();
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_paystatus() {
		return order_paystatus;
	}
	public void setOrder_paystatus(String order_paystatus) {
		this.order_paystatus = order_paystatus;
	}
	public String getOrder_paydate() {
		return order_paydate;
	}
	public void setOrder_paydate(String order_paydate) {
		this.order_paydate = order_paydate;
	}
	public String getOrder_payment() {
		return order_payment;
	}
	public void setOrder_payment(String order_payment) {
		this.order_payment = order_payment;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public String getOrder_message() {
		return order_message;
	}
	public void setOrder_message(String order_message) {
		this.order_message = order_message;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	public int getOrder_waybillno() {
		return order_waybillno;
	}
	public void setOrder_waybillno(int order_waybillno) {
		this.order_waybillno = order_waybillno;
	}
	public int getMember_info_no() {
		return member_info_no;
	}
	public void setMember_info_no(int member_info_no) {
		this.member_info_no = member_info_no;
	}
	public int getOrder_money() {
		return order_money;
	}
	public void setOrder_money(int order_money) {
		this.order_money = order_money;
	}
	public int getDiscount_no() {
		return discount_no;
	}
	public void setDiscount_no(int discount_no) {
		this.discount_no = discount_no;
	}
	public int getOrder_final_money() {
		return order_final_money;
	}
	public void setOrder_final_money(int order_final_money) {
		this.order_final_money = order_final_money;
	}
	public int getStock_no() {
		return stock_no;
	}
	public void setStock_no(int stock_no) {
		this.stock_no = stock_no;
	} 
	  
	
}
