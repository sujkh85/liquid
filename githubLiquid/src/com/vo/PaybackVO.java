package com.vo;

public class PaybackVO {
	  private int    payback_no     =0;//
	  private int    payback_money  =0;//
	  private String payback_reason ="";//
	  private String payback_day    ="";//
	  private int    order_no       =0;//
	public PaybackVO(int payback_no, int payback_money, String payback_reason,
			String payback_day, int order_no) {
		super();
		this.payback_no = payback_no;
		this.payback_money = payback_money;
		this.payback_reason = payback_reason;
		this.payback_day = payback_day;
		this.order_no = order_no;
	}
	public PaybackVO() {
		super();
	}
	public int getPayback_no() {
		return payback_no;
	}
	public void setPayback_no(int payback_no) {
		this.payback_no = payback_no;
	}
	public int getPayback_money() {
		return payback_money;
	}
	public void setPayback_money(int payback_money) {
		this.payback_money = payback_money;
	}
	public String getPayback_reason() {
		return payback_reason;
	}
	public void setPayback_reason(String payback_reason) {
		this.payback_reason = payback_reason;
	}
	public String getPayback_day() {
		return payback_day;
	}
	public void setPayback_day(String payback_day) {
		this.payback_day = payback_day;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	  
	  
}
