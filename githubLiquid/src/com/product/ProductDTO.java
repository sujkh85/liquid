package com.product;
/***********************************************************************
* �۾��� : �̽¿�
* �۾����� : 14.11.18 
* � ���Ͽ� ȣ��޴°� : 
* � ������ ȣ���ϴ°� :  
* ���� Ÿ�� : ��ǰ�������� ���� ���� �����̳�
* ��ǰ������ȣ�� ���� ����� �ٸ� ��ǰ�� �����ؾ� �� ����, 
* ��������ȣ�� ������ �����ؾߵȴ�.
***********************************************************************/
public class ProductDTO {
	private int 	product_no 			= 0;	//��ǰ��ȣ
	private String	product_name 		= "";   //��ǰ��
	private int		product_type_no 	= 0;    //��ǰ��޹�ȣ
	private String	product_type_name 	= "";   //��ǰ��
	private String 	product_detail 		= "";   //��ǰ������
	private String 	product_date 		= "";   //��ǰ�������
	private String 	gender_type 		= "";   //����Ÿ��
	private int 	product_cost 		= 0;    //��ǰ����
	private int 	product_price 		= 0;    //��ǰ�ǸŰ�
	private String 	product_imgsrc1 	= "";   //��ǰ�̹������1
	private String 	product_imgsrc2 	= "";   //��ǰ�̹������2
	private String 	product_imgsrc3 	= "";   //��ǰ�̹������3
	private String 	product_imgsrc4 	= "";   //��ǰ�̹������4
	private String 	product_imgsrc5 	= "";   //��ǰ�̹������5
	private int 	stock_no        	= 0;    //��������ȣ 
	private int		stock_quantity  	= 0;    //������ ��ȣ�� ����
	private String 	stock_size      	= "";   //������ ��ȣ�� ������
	private double	product_besong		= 0;	//��ǰ �������
	private double	product_sangpum		= 0;	//��ǰ ����
	private int 	product_review_count =0;	//��ǰ�� ����
	
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
