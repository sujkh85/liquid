package com.product;
/***********************************************************************
* 작업자 : 이승우
* 작업일자 : 14.11.18 
* 어떤 파일에 호출받는가 : 
* 어떤 파일을 호출하는가 :  
* 파일 타입 : 상품상세정보를 담을 변수 컨테이너
* 상품관리번호가 같고 사이즈가 다른 상품을 구분해야 할 때는, 
* 재고관리번호를 가지고 구분해야된다.
***********************************************************************/
public class ProductDTO {
	private int 	product_no 			= 0;	//상품번호
	private String	product_name 		= "";   //상품명
	private int		product_type_no 	= 0;    //상품등급번호
	private String	product_type_name 	= "";   //상품명
	private String 	product_detail 		= "";   //상품상세정보
	private String 	product_date 		= "";   //상품등록일자
	private String 	gender_type 		= "";   //성별타입
	private int 	product_cost 		= 0;    //상품원가
	private int 	product_price 		= 0;    //상품판매가
	private String 	product_imgsrc1 	= "";   //상품이미지경로1
	private String 	product_imgsrc2 	= "";   //상품이미지경로2
	private String 	product_imgsrc3 	= "";   //상품이미지경로3
	private String 	product_imgsrc4 	= "";   //상품이미지경로4
	private String 	product_imgsrc5 	= "";   //상품이미지경로5
	private int 	stock_no        	= 0;    //재고관리번호 
	private int		stock_quantity  	= 0;    //재고관리 번호당 수량
	private String 	stock_size      	= "";   //재고관리 번호당 사이즈
	private double	product_besong		= 0;	//상품 배송평점
	private double	product_sangpum		= 0;	//상품 평점
	private int 	product_review_count =0;	//상품평 갯수
	
	public int getProduct_no() {          
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_type_no() {
		return product_type_no;
	}
	public void setProduct_type_no(int product_type_no) {
		this.product_type_no = product_type_no;
	}
	public String getProduct_type_name() {
		return product_type_name;
	}
	public void setProduct_type_name(String product_type_name) {
		this.product_type_name = product_type_name;
	}
	public String getProduct_detail() {
		return product_detail;
	}
	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}
	public String getProduct_date() {
		return product_date;
	}
	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}
	public String getGender_type() {
		return gender_type;
	}
	public void setGender_type(String gender_type) {
		this.gender_type = gender_type;
	}
	public int getProduct_cost() {
		return product_cost;
	}
	public void setProduct_cost(int product_cost) {
		this.product_cost = product_cost;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_imgsrc1() {
		return product_imgsrc1;
	}
	public void setProduct_imgsrc1(String product_imgsrc1) {
		this.product_imgsrc1 = product_imgsrc1;
	}
	public String getProduct_imgsrc2() {
		return product_imgsrc2;
	}
	public void setProduct_imgsrc2(String product_imgsrc2) {
		this.product_imgsrc2 = product_imgsrc2;
	}
	public String getProduct_imgsrc3() {
		return product_imgsrc3;
	}
	public void setProduct_imgsrc3(String product_imgsrc3) {
		this.product_imgsrc3 = product_imgsrc3;
	}
	public String getProduct_imgsrc4() {
		return product_imgsrc4;
	}
	public void setProduct_imgsrc4(String product_imgsrc4) {
		this.product_imgsrc4 = product_imgsrc4;
	}
	public String getProduct_imgsrc5() {
		return product_imgsrc5;
	}
	public void setProduct_imgsrc5(String product_imgsrc5) {
		this.product_imgsrc5 = product_imgsrc5;
	}
	public int getStock_no() {
		return stock_no;
	}
	public void setStock_no(int stock_no) {
		this.stock_no = stock_no;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public String getStock_size() {
		return stock_size;
	}
	public void setStock_size(String stock_size) {
		this.stock_size = stock_size;
	}
	public double getProduct_besong() {
		return product_besong;
	}
	public void setProduct_besong(double product_besong) {
		this.product_besong = product_besong;
	}
	public double getProduct_sangpum() {
		return product_sangpum;
	}
	public void setProduct_sangpum(double product_sangpum) {
		this.product_sangpum = product_sangpum;
	}
	public int getProduct_review_count() {
		return product_review_count;
	}
	public void setProduct_review_count(int product_review_count) {
		this.product_review_count = product_review_count;
	}
	
}
