package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  ManagerProductSalesCMD
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� :  
 ***********************************************************************/
public class ManagerProductSalesDTO { //��ǰ�� �Ǹŷ� ������ ���� DTO
	private int 	rownum          ;
	private String  product_name    ;//��ǰ��
	private String  stock_size      ;//������
	private int     price           ;//��ǰ�ǸŰ�
	private int     quantity        ;//��ǰ�Ǹŷ�
	private int     finalmoney      ;//�� �Ǹŷ�
	private int     product_no      ;//��ǰ��ȣ
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getStock_size() {
		return stock_size;
	}
	public void setStock_size(String stock_size) {
		this.stock_size = stock_size;
	}
	public ManagerProductSalesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerProductSalesDTO(int rownum, String product_name, int price,
			int quantity, int finalmoney) {
		super();
		this.rownum = rownum;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
		this.finalmoney = finalmoney;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getFinalmoney() {
		return finalmoney;
	}
	public void setFinalmoney(int finalmoney) {
		this.finalmoney = finalmoney;
	}
	
	
}
