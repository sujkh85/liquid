package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  ManagerSalesCMD
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� :  
 ***********************************************************************/
public class ManagerMonthSalesDTO {//�� ���ⷮ ������ ���� DTO
	
	private int     rownum	 	;
	private String  orderdate   ;//��¥
	private int 	finalmoney  ;//���Ǹŷ�
	private int	    quantity    ;//��ǰ�Ǹż���
	private int	    ordercount  ;//�ֹ���
	public ManagerMonthSalesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerMonthSalesDTO(int rownum, String orderdate, int finalmoney,
			int quantity, int ordercount) {
		super();
		this.rownum = rownum;
		this.orderdate = orderdate;
		this.finalmoney = finalmoney;
		this.quantity = quantity;
		this.ordercount = ordercount;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
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
