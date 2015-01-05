package com.manager;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 어떤 파일에 호출받는가 :  ManagerSalesCMD
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 :  
 ***********************************************************************/
public class ManagerDaySalesDTO { //일 매출량 데이터 담을 DTO
	
	private int     rownum	 	;//번호
	private String  orderdate   ;//날짜
	private int 	finalmoney  ;//총판매량
	private int	    quantity    ;//상품판매수량
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	private int	    ordercount  ;//주문수
	public ManagerDaySalesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerDaySalesDTO(int rownum, String orderdate, int finalmoney, int quantity,
			int ordercount) {
		super();
		this.rownum=rownum;
		this.orderdate = orderdate;
		this.finalmoney = finalmoney;
		this.quantity = quantity;
		this.ordercount = ordercount;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getFinalmoney() {
		return finalmoney;
	}
	public void setFinalmoney(int finalmoney) {
		this.finalmoney = finalmoney;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}
	
}
