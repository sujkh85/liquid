package com.catalogue;
/***********************************************************************
 * 작업자 : 이승우 
 * 작업일자 : 2014.11.06
 * 어떤 파일에 호출받는가 : ProductCatalogueDAO.java
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 : 메인화면 상품 카탈로그에 보여지는 정보를 담을 컨테이너 DTO
 ***********************************************************************/
public class ProductCatalogueDTO {
	 private int    rownum=0; 	// 상품수 8개로 제한, 판매순위
	 private int    no    =0; 	// 상품번호
	 private String name  =""; 	// 상품명
	 private String img   =""; 	// 상품이미지경로1
	 private int    price =0; 	// 상품가격
	 private int    sales =0; 	// 상품판매량
	 
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