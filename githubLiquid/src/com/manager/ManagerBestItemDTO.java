package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  ManagerBestItemCMD
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� :  
 ***********************************************************************/
public class ManagerBestItemDTO {//�α��ǰ ������ ���� DTO
	
	private int 	rownum ;//��ȣ
	private int 	no     ;//��ǰ��ȣ
	private String  name   ;//��ǰ�̸�
	private int 	price  ;//��ǰ����
	private int 	sales  ;//�Ǹŷ�
	public ManagerBestItemDTO(int rownum, int no, String name, int price,
			int sales) {
		super();
		this.rownum = rownum;
		this.no = no;
		this.name = name;
		this.price = price;
		this.sales = sales;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public ManagerBestItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
