package com.manager;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 어떤 파일에 호출받는가 :  ManagerBestItemCMD
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 :  
 ***********************************************************************/
public class ManagerBestItemDTO {//인기상품 데이터 담을 DTO
	
	private int 	rownum ;//번호
	private int 	no     ;//상품번호
	private String  name   ;//상품이름
	private int 	price  ;//상품가격
	private int 	sales  ;//판매량
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
