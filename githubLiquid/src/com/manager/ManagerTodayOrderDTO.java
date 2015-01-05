package com.manager;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 어떤 파일에 호출받는가 :  ManagerTodayOrderCMD
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 :  
 ***********************************************************************/
public class ManagerTodayOrderDTO { //일 매출량 데이터 담을 DTO 
	
	private int    rownum             ;
	private int    order_no            ;//주문번호
    private String member_info_name    ;//회원이름
    private String order_date          ;//주문날짜
    private String order_paystatus     ;//주문상태
    private String order_payment       ;//결제수단
    private String member_info_phone   ;//핸드폰번호
    public ManagerTodayOrderDTO(){}
    public ManagerTodayOrderDTO(int rownum, int order_no, String member_info_name,
			String order_date, String order_paystatus, String order_payment,
			String member_info_phone, int order_final_money) {
		super();
		this.rownum=rownum;
		this.order_no = order_no;
		this.member_info_name = member_info_name;
		this.order_date = order_date;
		this.order_paystatus = order_paystatus;
		this.order_payment = order_payment;
		this.member_info_phone = member_info_phone;
		this.order_final_money = order_final_money;
	}
    public int getRownum() {
    	return rownum;
    }
    public void setRownum(int rownum) {
    	this.rownum = rownum;
    }
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getMember_info_name() {
		return member_info_name;
	}
	public void setMember_info_name(String member_info_name) {
		this.member_info_name = member_info_name;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_paystatus() {
		return order_paystatus;
	}
	public void setOrder_paystatus(String order_paystatus) {
		this.order_paystatus = order_paystatus;
	}
	public String getOrder_payment() {
		return order_payment;
	}
	public void setOrder_payment(String order_payment) {
		this.order_payment = order_payment;
	}
	public String getMember_info_phone() {
		return member_info_phone;
	}
	public void setMember_info_phone(String member_info_phone) {
		this.member_info_phone = member_info_phone;
	}
	public int getOrder_final_money() {
		return order_final_money;
	}
	public void setOrder_final_money(int order_final_money) {
		this.order_final_money = order_final_money;
	}
	private int    order_final_money   ;
    
}
