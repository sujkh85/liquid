package com.wishlist;
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 2014.11.18
 * 어떤 파일에 호출받는가 : wishlistInsertCMD,wishlistDeletCMD,wishlistViewCMD
 * 어떤 파일을 호출하는가 :  
 * 클래스 용도 : DB연동 데이터 처리
 * 파일 타입 :
 ***********************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.util.DBConnectionMgr;
import com.wishlist.WishListDTO;
import com.wishlist.WishListVO;

public class WishListDAO {
	Logger logger=Logger.getLogger(WishListDAO.class);
	DataSource dataFactory;
	DBConnectionMgr dbMgr = null;
	Connection con = null; //연결통로
	PreparedStatement pstmt = null;  //쿼리문전달
	//커넥션 풀 DB연동
		/*public WishListDAO(){
			try {
					Context ctx = new InitialContext();
					dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*///end of 생성자
		
		
		//사용한 자원 반납하기
		/*public static void endConnection(Connection con, PreparedStatement pstmt, ResultSet rs){
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(con !=null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		
		//세션에 저장된 아이디로 회원관리번호 조회
		/*public int search(String id){
			logger.info("회원번호조회");
			dbMgr = DBConnectionMgr.getInstance();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int number= 0;
			try {
				con=dbMgr.getConnection();
				StringBuffer query=new StringBuffer();
				query.append("select member_info_no from member_info where member_info_id=?");
				pstmt=con.prepareStatement(query.toString());
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				if(rs.next()){
					
					number=Integer.parseInt(rs.getString(1));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return number;
		}*/
		
		
		//WishList목록 조회
		
		public ArrayList<WishListDTO> list(int member_info_no){//회원번호를 받아서 wishlist목록조회
			logger.info("목록조회");
			dbMgr = DBConnectionMgr.getInstance(); //인스턴스 획득
			ArrayList<WishListDTO> list=new ArrayList<WishListDTO>();//목록담을 ArrayList생성
			ResultSet rs = null; // 결과집합
			try {
				con=dbMgr.getConnection(); // connection 객체 생성
				StringBuffer query=new StringBuffer(); //StringBuffer 객체 생성
				query.append("select c.wishlist_no,b.member_info_no,a.product_name,a.product_no,a.product_price,a.product_date,a.product_imgsrc1 from product a,member_info b,(select * from wishlist where member_info_no=?) c where a.product_no=c.product_no and b.member_info_no=c.member_info_no");
				//쿼리문담기
				
				pstmt=con.prepareStatement(query.toString()); //preparedstatement객체 생성
				pstmt.setInt(1, member_info_no); //바인딩변수에 값 세팅
				rs=pstmt.executeQuery();//쿼리 실행
				
				while(rs.next()){ //만약 결과집합이 있으면 rs.next해서
					WishListDTO dto=new WishListDTO();//결과를 담을 dto생성
					dto.setWishlist_no(rs.getInt("wishlist_no")); //dto에 rs에서 가져온 wishlist_no를 담는다
					dto.setProduct_imgsrc1(rs.getString("product_imgsrc1"));
					dto.setMember_info_no(rs.getInt("member_info_no"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setProduct_no(rs.getInt("product_no"));
					dto.setProduct_price(rs.getInt("product_price"));
					dto.setProduct_date(rs.getString("product_date"));
					
					list.add(dto); //dto에 담은걸 list에 담는다
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(rs!=null) rs.close();      //사용 역순으로 닫는다
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return list; //최종 결과를  ArrayList<WishListDTO> list형태로 리턴
		}
		
		//insert WishList
		public void insertWishList(WishListVO dto){ //장바구니 담기!! 
			logger.info("insert탓나요");
			dbMgr = DBConnectionMgr.getInstance();//인스턴스 획득
			Connection con=null;  //연결통로
			PreparedStatement pstmt = null;  //쿼리문전달
			try {
				con=dbMgr.getConnection(); //connection 객체 생성
				StringBuffer query=new StringBuffer();//StringBuffer 객체 생성
				query.append("insert into wishlist (wishlist_no,product_no,member_info_no) values (wishlist_seq.nextval,?,?)");
				//query에 쿼리문담기
				
				pstmt=con.prepareStatement(query.toString());//preparedStatement객체 생성
				pstmt.setInt(1, dto.getProduct_no());      //바인딩변수 세팅
				pstmt.setInt(2, dto.getMember_info_no());
				pstmt.executeUpdate();//쿼리문실행
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {  //사용 역순으로 닫기
					if(pstmt!=null) pstmt.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		//delete WishList
		public void deleteWishList(String wishlist_no){ //장바구니 삭제,wishlist_no를 받아서..
			dbMgr = DBConnectionMgr.getInstance();  //인스턴스 획득
			try {
				con=dbMgr.getConnection(); //connection 객체 생성
				StringBuffer query=new StringBuffer();//StringBuffer객체 생성
				query.append("delete from wishlist where wishlist_no=?");
				//쿼리문 담기
				
				pstmt=con.prepareStatement(query.toString());//preparedStatement객체 생성
				pstmt.setInt(1, Integer.parseInt(wishlist_no));//바인딩변수 값 세팅
				pstmt.executeUpdate();//쿼리실행
				logger.info("deleteWishList 쿼리 실행완료");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {//사용역순으로 닫기
					if(pstmt!=null) pstmt.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
}
