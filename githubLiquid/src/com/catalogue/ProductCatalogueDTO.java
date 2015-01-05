package com.catalogue;
/***********************************************************************
 * �۾��� : �̽¿� 
 * �۾����� : 2014.11.06
 * � ���Ͽ� ȣ��޴°� : ProductCatalogueDAO.java
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� : ����ȭ�� ��ǰ īŻ�α׿� �������� ������ ���� �����̳� DTO
 ***********************************************************************/
public class ProductCatalogueDTO {
	 private int    rownum=0; 	// ��ǰ�� 8���� ����, �Ǹż���
	 private int    no    =0; 	// ��ǰ��ȣ
	 private String name  =""; 	// ��ǰ��
	 private String img   =""; 	// ��ǰ�̹������1
	 private int    price =0; 	// ��ǰ����
	 private int    sales =0; 	// ��ǰ�Ǹŷ�
	 
	public ProductCatalogueDTO(){} 

	public ProductCatalogueDTO(int rowunum, int no, String name, String img, int price, int sales){
		this.rownum = rowunum;
		this.no = no;
		this.name = name;
		this.img = img;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
	 
	 
}