package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  ManagerSalesCMD
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� :  
 ***********************************************************************/
public class ManagerDaySalesDTO { //�� ���ⷮ ������ ���� DTO
	
	private int     rownum	 	;//��ȣ
	private String  orderdate   ;//��¥
	private int 	finalmoney  ;//���Ǹŷ�
	private int	    quantity    ;//��ǰ�Ǹż���
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	private int	    ordercount  ;//�ֹ���
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
