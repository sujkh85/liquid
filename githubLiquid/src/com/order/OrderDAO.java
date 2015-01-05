package com.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.product.ProductDTO;
import com.util.DBConnectionMgr;

public class OrderDAO {
	Connection con = null;//연결통로
	PreparedStatement pstmt = null;//쿼리문 전달|요청
	ResultSet rs = null;//open-cursor-fetch
	DBConnectionMgr dbMgr = null;

	//목록보기
	public ArrayList<OrderDTO> list(String memNo){
	
		 dbMgr = DBConnectionMgr.getInstance();
		 ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
		 try{
			 con = dbMgr.getConnection();
			 String query =  "SELECT a.order_cancel,a.order_date as order_date,a.order_no as order_no"
				      +",d.product_name as product_name"
				      +",d.product_imgsrc1 as product_imgsrc1"
				      +",d.product_price as product_price"
				      +",b.order_detail_quantity as order_detail_quantity"
				      +",a.order_paystatus as order_paystatus"
				      +",a.order_payment as order_payment"
				      +",a.order_waybillno as order_waybillno"
				      +",a.order_address1 as order_address1"
				      +",a.order_address2 as order_address2"
				      +",a.order_post1 as order_post1"
				      +",a.order_post2 as order_post2"
				      +",a.order_message as order_message"
				      + ",d.product_no as product_no,c.stock_no"
				      +" FROM PRODUCT_ORDER_MASTER a, PRODUCT_ORDER_DETAIL b, STOCK c,PRODUCT d"
				      +" WHERE a.member_info_no = ?"
				      +" AND a.order_no = b.order_no" 
				      +" AND b.stock_no = c.stock_no"
				      +" AND c.product_no = d.product_no"
				      +" ORDER BY a.order_no desc"; 
			 
			 pstmt = con.prepareStatement(query);
			 pstmt.setString(1,memNo);
			 
			 rs = pstmt.executeQuery();

			 while(rs.next()){
				 String order_date =rs.getString("order_date");
				 String product_name = rs.getString("product_name");
				 String product_imgsrc1 = rs.getString("product_imgsrc1");
				 int product_price = rs.getInt("product_price");
				 int order_detail_quantity = rs.getInt("order_detail_quantity");
				 String order_paystatus = rs.getString("order_paystatus");
				 String order_payment = rs.getString("order_payment");
				 int order_waybillno = rs.getInt("order_waybillno");
				 String order_address1 = rs.getString("order_address1");
				 String order_message = rs.getString("order_message");
				 int product_no = rs.getInt("product_no");
				 int order_no = rs.getInt("order_no");
				 int stock_no = rs.getInt("stock_no");
				 String order_address2 = rs.getString("order_address2");
				 String order_post1 = rs.getString("order_post1");
				 String order_post2 = rs.getString("order_post2");
				 String order_cancel = rs.getString("order_cancel");
				 
				 OrderDTO data = new OrderDTO();
				 
				 data.setOrder_date(order_date);
				 data.setProduct_name(product_name);
				 data.setProduct_imgsrc1(product_imgsrc1);
				 data.setProduct_price(product_price);
				 data.setOrder_detail_quantity(order_detail_quantity);
				 data.setOrder_paystatus(order_paystatus);
				 data.setOrder_payment(order_payment);
				 data.setOrder_waybillno(order_waybillno);
				 data.setOrder_address1(order_address1);
				 data.setOrder_address2(order_address2);
				 data.setOrder_post1(order_post1);
				 data.setOrder_post2(order_post2);
				 data.setOrder_message(order_message);
				 data.setProduct_no(product_no);
				 data.setOrder_no(order_no);
				 data.setStock_no(stock_no);
				 data.setOrder_cancel(order_cancel);
				 
				 list.add(data);
				 
			 }//end while
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 dbMgr.freeContection(rs, pstmt, con);
		 }
		 return list;
	}//end list
	
	//즉시 구매  DB: 입금대기 / 화면단: 주문완료
		public void write(String order_name,String order_tel,String order_address1,String order_address2,String order_post1,String order_post2
				,String order_message,String member_info_no,int order_money,int order_detail_quantity,String order_payment,int stock_no){
			dbMgr = DBConnectionMgr.getInstance();
			try{
				con = dbMgr.getConnection();
				String query = " INSERT ALL INTO product_order_master(order_no,"
						+ "order_date,order_name,order_tel,order_address1,order_address2,order_post1,order_post2,order_message"
						+ ",member_info_no,order_money,order_paystatus,order_payment)"
	                    + " VALUES(product_order_master_seq.NEXTVAL,to_char(sysdate,'YYYY/MM/DD'),?,?,?,?,?,?,?,?,?,'입금대기',?)"
	                    + " INTO product_order_detail(order_detail_no,order_detail_quantity,stock_no,order_no)"
	                    + " VALUES(product_order_detail_seq.NEXTVAL,?,?,product_order_master_seq.NEXTVAL) SELECT * FROM dual";
					    
				pstmt = con.prepareStatement(query);
				pstmt.setString(1,order_name);
				pstmt.setString(2,order_tel);
				pstmt.setString(3,order_address1);
				pstmt.setString(4,order_address2);
				pstmt.setString(5,order_post1);
				pstmt.setString(6,order_post2);
				pstmt.setString(7,order_message);
				pstmt.setString(8,member_info_no);
				pstmt.setInt(9,order_money);
				pstmt.setString(10,order_payment);
				pstmt.setInt(11,order_detail_quantity);
				pstmt.setInt(12,stock_no);
				
				pstmt.executeUpdate();
				
				query = "UPDATE STOCK"
						+ " SET stock_quantity = (stock_quantity-1)"
						+ " WHERE stock_no=?";
						
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1,stock_no);		
				
				pstmt.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				dbMgr.freeContection(rs, pstmt,con);
			}//end finally
		}//end write
		
	//결제예정상품 목록보기
	public ArrayList<OrderDTO> orderPayList(String memNo){
	
		 dbMgr = DBConnectionMgr.getInstance();
		 ArrayList<OrderDTO> orderPayList = new ArrayList<OrderDTO>();
		 try{
			 con = dbMgr.getConnection();
			 String query =  "SELECT a.order_no, a.order_date"
				      +",d.product_name as product_name"
				      +",d.product_imgsrc1 as product_imgsrc1"
				      +",d.product_price as product_price"
				      +",b.order_detail_quantity as order_detail_quantity"
				      +",a.order_paystatus as order_paystatus"
				      +",a.order_payment as order_payment"
				      +",a.order_waybillno as order_waybillno"
				      +",a.order_address1 as order_address1"
				      +",a.order_address2 as order_address2"
				      +",a.order_post1 as order_post1"
				      +",a.order_post2 as order_post2"
				      +",a.order_message as order_message"
				      + ",d.product_no as product_no"
				      +" FROM PRODUCT_ORDER_MASTER a, PRODUCT_ORDER_DETAIL b, STOCK c,PRODUCT d"
				      +" WHERE a.member_info_no = ?"
				      +" AND a.order_paystatus = '입금대기'"
				      +" AND a.order_no = b.order_no" 
				      +" AND b.stock_no = c.stock_no"
				      +" AND c.product_no = d.product_no";
			 
			 pstmt = con.prepareStatement(query);
			 pstmt.setString(1,memNo);
			 
			 rs = pstmt.executeQuery();

			 while(rs.next()){
				 int order_no = rs.getInt("order_no");
				 String order_date =rs.getString("order_date");
				 String product_name = rs.getString("product_name");
				 String product_imgsrc1 = rs.getString("product_imgsrc1");
				 int product_price = rs.getInt("product_price");
				 int order_detail_quantity = rs.getInt("order_detail_quantity");
				 String order_paystatus = rs.getString("order_paystatus");
				 String order_payment = rs.getString("order_payment");
				 int order_waybillno = rs.getInt("order_waybillno");
				 String order_address1 = rs.getString("order_address1");
				 String order_address2 = rs.getString("order_address2");
				 String order_post1 = rs.getString("order_post1");
				 String order_post2 = rs.getString("order_post2");
				 String order_message = rs.getString("order_message");
				 int product_no = rs.getInt("product_no");
				 
				 OrderDTO data = new OrderDTO();
				 
				 data.setOrder_no(order_no);
				 data.setOrder_date(order_date);
				 data.setProduct_name(product_name);
				 data.setProduct_imgsrc1(product_imgsrc1);
				 data.setProduct_price(product_price);
				 data.setOrder_detail_quantity(order_detail_quantity);
				 data.setOrder_paystatus(order_paystatus);
				 data.setOrder_payment(order_payment);
				 data.setOrder_waybillno(order_waybillno);
				 data.setOrder_message(order_message);
				 data.setProduct_no(product_no);
				 data.setOrder_address1(order_address1);
				 data.setOrder_address2(order_address2);
				 data.setOrder_post1(order_post1);
				 data.setOrder_post2(order_post2);
				 
				 orderPayList.add(data);
				 
			 }//end while
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 dbMgr.freeContection(rs, pstmt, con);
		 }
		 return orderPayList;
	}//end orderPayList
	
	
	//결제하기 DB:배송대기 / 화면단:결제완료
	public void orderPayment(int order_no,int order_money){
		
		dbMgr = DBConnectionMgr.getInstance();
		 
		 try{
			 con = dbMgr.getConnection();
			 
			 String query =  "UPDATE product_order_master"
			 		+ " SET order_paydate=to_char(sysdate,'YYYY/MM/DD')"
			 		+ ",order_waybillno=order_waybillno_seq.NEXTVAL"
			 		+ ",order_final_money=?"
			 		+ ",order_paystatus='배송대기'"
			 		+ " WHERE order_no=?"; 
			 
			 pstmt = con.prepareStatement(query);
			 pstmt.setInt(1,order_money);
			 pstmt.setInt(2,order_no);
			 pstmt.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				dbMgr.freeContection(rs, pstmt,con);
			}//end finally
		}//end orderPayment 
	
	
	//주문상세보기
	public OrderDTO order_detail(int product_no,String product_name,int order_detail_quantity,String product_imgsrc1,int product_price){
		
		dbMgr = DBConnectionMgr.getInstance();
		OrderDTO data = null;
		
		 try{
			 con = dbMgr.getConnection();
			 String query = "SELECT product_name,product_price"
					 +" FROM PRODUCT WHERE product_no=?";
			 
			 pstmt = con.prepareStatement(query);
			 pstmt.setInt(1,product_no);
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 product_name =rs.getString("product_name");
				 product_price = rs.getInt("product_price");
				 
				 data = new OrderDTO();
				 
				 data.setProduct_no(product_no);
				 data.setProduct_name(product_name);
				 data.setProduct_price(product_price);
				 data.setOrder_detail_quantity(order_detail_quantity);
				 data.setProduct_imgsrc1(product_imgsrc1);
				 
			 }//end while
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 dbMgr.freeContection(rs, pstmt, con);
		 }
		 return data;
	}//end order_detail

	//주문자 정보  조회
	public OrderDTO order_member(String member_info_no) {
		
		dbMgr = DBConnectionMgr.getInstance();
		OrderDTO data = null;
		
		 try{
			 con = dbMgr.getConnection();
			 String query = "SELECT member_info_name,member_info_phone,"
			 		+ "member_info_post1,member_info_post2,member_info_address1,member_info_address2"
			 		+ " FROM member_info WHERE member_info_no=?";
			 
			 pstmt = con.prepareStatement(query);
			 pstmt.setString(1,member_info_no);
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 data = new OrderDTO();
				 data.setMember_info_name(rs.getString("member_info_name"));
				 data.setMember_info_phone(rs.getString("member_info_phone"));
				 data.setMember_info_post1(rs.getString("member_info_post1"));
				 data.setMember_info_post2(rs.getString("member_info_post2"));
				 data.setMember_info_address1(rs.getString("member_info_address1"));
				 data.setMember_info_address2(rs.getString("member_info_address2"));
			 }//end while
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 dbMgr.freeContection(rs, pstmt, con);
		 }
		 return data;
	}//end order_member

	//주문마스터의 주문번호와 같은 주문상세정보 
	public ArrayList<OrderDTO> orderDetailInfo(int order_no) {
		
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
		
		 try{
			 con = dbMgr.getConnection();
			 String query = "SELECT a.order_date,a.order_no,b.order_detail_no,d.product_name"
			 		+ ",c.stock_size,d.product_imgsrc1,d.product_price,b.order_detail_quantity"
			 		+ ",a.order_paystatus,a.order_payment,a.order_waybillno,a.order_address1"
			 		+ ",a.order_address2,a.order_post1,a.order_post2,a.order_message,d.product_no"
			 		+ " FROM PRODUCT_ORDER_MASTER a, PRODUCT_ORDER_DETAIL b, STOCK c,PRODUCT d"
			 		+ " WHERE b.order_no=?"
			 		+ " AND a.order_no = b.order_no"
			 		+ " AND b.stock_no = c.stock_no"
			 		+ " AND c.product_no = d.product_no";
			 
			 pstmt = con.prepareStatement(query);
			 
			 pstmt.setInt(1,order_no);
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 String order_date =rs.getString("order_date");
				 String product_name = rs.getString("product_name");
				 String product_imgsrc1 = rs.getString("product_imgsrc1");
				 int product_price = rs.getInt("product_price");
				 int order_detail_quantity = rs.getInt("order_detail_quantity");
				 String order_paystatus = rs.getString("order_paystatus");
				 String order_payment = rs.getString("order_payment");
				 int order_waybillno = rs.getInt("order_waybillno");
				 String order_address1 = rs.getString("order_address1");
				 String order_message = rs.getString("order_message");
				 int product_no = rs.getInt("product_no");
				 String order_address2 = rs.getString("order_address2");
				 String order_post1 = rs.getString("order_post1");
				 String order_post2 = rs.getString("order_post2");
				 String stock_size = rs.getString("stock_size");
				 
				 OrderDTO data = new OrderDTO();
				 
				 data.setOrder_date(order_date);
				 data.setProduct_name(product_name);
				 data.setProduct_imgsrc1(product_imgsrc1);
				 data.setProduct_price(product_price);
				 data.setOrder_detail_quantity(order_detail_quantity);
				 data.setOrder_paystatus(order_paystatus);
				 data.setOrder_payment(order_payment);
				 data.setOrder_waybillno(order_waybillno);
				 data.setOrder_address1(order_address1);
				 data.setOrder_address2(order_address2);
				 data.setOrder_post1(order_post1);
				 data.setOrder_post2(order_post2);
				 data.setOrder_message(order_message);
				 data.setProduct_no(product_no);
				 data.setStock_size(stock_size);
				 
				 list.add(data);
				 
			 }//end while
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 dbMgr.freeContection(rs, pstmt, con);
		 }
		 return list;
	}//end orderDetailInfo

	public OrderDTO cartList(String cookieName, String stock_no, int quantity) {
		OrderDTO dto = new OrderDTO();
		dbMgr = DBConnectionMgr.getInstance();
		 try{
				 con = dbMgr.getConnection();
				 StringBuffer sql = new StringBuffer();
				 sql.append("SELECT a.stock_no, a.stock_quantity,a.product_no,a.stock_size,b.product_name,b.product_price,b.product_imgsrc1 FROM STOCK A, PRODUCT B WHERE A.STOCK_NO = ? AND A.PRODUCT_NO = B.PRODUCT_NO");
				 pstmt = con.prepareStatement(sql.toString());
				 pstmt.setString(1,stock_no);
				 rs = pstmt.executeQuery();
				 //선택수량은 매개변수로 받아서 바로 dto에 담는다.
				 dto.setCookieName(cookieName); 
				 dto.setOrder_detail_quantity(quantity);
				 while(rs.next()){
					dto.setStock_no(rs.getInt("stock_no"));
					dto.setProduct_no(rs.getInt("product_no"));
					dto.setStock_size(rs.getString("stock_size"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setProduct_price(rs.getInt("product_price"));
					dto.setProduct_imgsrc1(rs.getString("product_imgsrc1"));
					dto.setStock_quantity(rs.getInt("stock_quantity"));
				 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 dbMgr.freeContection(rs, pstmt, con);
		 }
		 return dto; 
	}
	
	//주문취소
	public void orderDelete(int order_no,int stock_no) {
		
		dbMgr = DBConnectionMgr.getInstance();
		 
		 try{
			 con = dbMgr.getConnection();
			 
			 String query =  "UPDATE PRODUCT_ORDER_MASTER"
			 			   + " SET order_cancel = 'Y',order_paystatus='주문취소'"
			 			   + " WHERE order_no=?"; 
			 
			 pstmt = con.prepareStatement(query);
			 pstmt.setInt(1,order_no);
			 pstmt.executeUpdate();
				
			query = "UPDATE STOCK"
					+ " SET stock_quantity = (stock_quantity+1)"
					+ " WHERE stock_no=?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,stock_no);		
			pstmt.executeUpdate();
			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				dbMgr.freeContection(rs, pstmt,con);
			}//end finally
		}//end orderDelete 
		
	}
