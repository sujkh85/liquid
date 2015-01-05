package com.manager;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 어떤 파일에 호출받는가 :  ManagerProductSalesCMD
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 :  
 ***********************************************************************/
public class ManagerProductSalesDTO { //상품별 판매량 데이터 담을 DTO
	private int 	rownum          ;
	private String  product_name    ;//상품명
	private String  stock_size      ;//사이즈
	private int     price           ;//상품판매가
	private int     quantity        ;//상품판매량
	private int     finalmoney      ;//총 판매량
	private int     product_no      ;//상품번호
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
