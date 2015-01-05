package com.vo;

public class Sales_managementVO {
	  private int sales_no          =0;// 
	  private int sales_daily_total =0;// 
	  private int sales_earnings    =0;// 
	  
	public Sales_managementVO(int sales_no, int sales_daily_total,
			int sales_earnings) {
		super();
		this.sales_no = sales_no;
		this.sales_daily_total = sales_daily_total;
		this.sales_earnings = sales_earnings;
	}
	
	public Sales_managementVO() {
		super();
	}

	public int getSales_no() {
		return sales_no;
	}
	public void setSales_no(int sales_no) {
		this.sales_no = sales_no;
	}
	public int getSales_daily_total() {
		return sales_daily_total;
	}
	public void setSales_daily_total(int sales_daily_total) {
		this.sales_daily_total = sales_daily_total;
	}
	public int getSales_earnings() {
		return sales_earnings;
	}
	public void setSales_earnings(int sales_earnings) {
		this.sales_earnings = sales_earnings;
	}
	  
	  
}
