package com.wishlist;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 2014.11.18
 * � ���Ͽ� ȣ��޴°� : wishlistInsertCMD,wishlistDeletCMD,wishlistViewCMD
 * � ������ ȣ���ϴ°� :  
 * Ŭ���� �뵵 : DB���� ������ ó��
 * ���� Ÿ�� :
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
	Connection con = null; //�������
	PreparedStatement pstmt = null;  //����������
	//Ŀ�ؼ� Ǯ DB����
		/*public WishListDAO(){
			try {
					Context ctx = new InitialContext();
					dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*///end of ������
		
		
		//����� �ڿ� �ݳ��ϱ�
		/*public static void endConnection(Connection con, PreparedStatement pstmt, ResultSet rs){
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(con !=null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		
		//���ǿ� ����� ���̵�� ȸ��������ȣ ��ȸ
		/*public int search(String id){
			logger.info("ȸ����ȣ��ȸ");
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
		
		
		//WishList��� ��ȸ
		
		public ArrayList<WishListDTO> list(int member_info_no){//ȸ����ȣ�� �޾Ƽ� wishlist�����ȸ
			logger.info("�����ȸ");
			dbMgr = DBConnectionMgr.getInstance(); //�ν��Ͻ� ȹ��
			ArrayList<WishListDTO> list=new ArrayList<WishListDTO>();//��ϴ��� ArrayList����
			ResultSet rs = null; // �������
			try {
				con=dbMgr.getConnection(); // connection ��ü ����
				StringBuffer query=new StringBuffer(); //StringBuffer ��ü ����
				query.append("select c.wishlist_no,b.member_info_no,a.product_name,a.product_no,a.product_price,a.product_date,a.product_imgsrc1 from product a,member_info b,(select * from wishlist where member_info_no=?) c where a.product_no=c.product_no and b.member_info_no=c.member_info_no");
				//���������
				
				pstmt=con.prepareStatement(query.toString()); //preparedstatement��ü ����
				pstmt.setInt(1, member_info_no); //���ε������� �� ����
				rs=pstmt.executeQuery();//���� ����
				
				while(rs.next()){ //���� ��������� ������ rs.next�ؼ�
					WishListDTO dto=new WishListDTO();//����� ���� dto����
					dto.setWishlist_no(rs.getInt("wishlist_no")); //dto�� rs���� ������ wishlist_no�� ��´�
					dto.setProduct_imgsrc1(rs.getString("product_imgsrc1"));
					dto.setMember_info_no(rs.getInt("member_info_no"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setProduct_no(rs.getInt("product_no"));
					dto.setProduct_price(rs.getInt("product_price"));
					dto.setProduct_date(rs.getString("product_date"));
					
					list.add(dto); //dto�� ������ list�� ��´�
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(rs!=null) rs.close();      //��� �������� �ݴ´�
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return list; //���� �����  ArrayList<WishListDTO> list���·� ����
		}
		
		//insert WishList
		public void insertWishList(WishListVO dto){ //��ٱ��� ���!! 
			logger.info("insertſ����");
			dbMgr = DBConnectionMgr.getInstance();//�ν��Ͻ� ȹ��
			Connection con=null;  //�������
			PreparedStatement pstmt = null;  //����������
			try {
				con=dbMgr.getConnection(); //connection ��ü ����
				StringBuffer query=new StringBuffer();//StringBuffer ��ü ����
				query.append("insert into wishlist (wishlist_no,product_no,member_info_no) values (wishlist_seq.nextval,?,?)");
				//query�� ���������
				
				pstmt=con.prepareStatement(query.toString());//preparedStatement��ü ����
				pstmt.setInt(1, dto.getProduct_no());      //���ε����� ����
				pstmt.setInt(2, dto.getMember_info_no());
				pstmt.executeUpdate();//����������
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {  //��� �������� �ݱ�
					if(pstmt!=null) pstmt.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		//delete WishList
		public void deleteWishList(String wishlist_no){ //��ٱ��� ����,wishlist_no�� �޾Ƽ�..
			dbMgr = DBConnectionMgr.getInstance();  //�ν��Ͻ� ȹ��
			try {
				con=dbMgr.getConnection(); //connection ��ü ����
				StringBuffer query=new StringBuffer();//StringBuffer��ü ����
				query.append("delete from wishlist where wishlist_no=?");
				//������ ���
				
				pstmt=con.prepareStatement(query.toString());//preparedStatement��ü ����
				pstmt.setInt(1, Integer.parseInt(wishlist_no));//���ε����� �� ����
				pstmt.executeUpdate();//��������
				logger.info("deleteWishList ���� ����Ϸ�");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {//��뿪������ �ݱ�
					if(pstmt!=null) pstmt.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
}
