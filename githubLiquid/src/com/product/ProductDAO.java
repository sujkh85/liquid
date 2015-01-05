package com.product;
/***********************************************************************
* �۾��� : �̽¿�
* �۾����� : 14.11.18 
* � ���Ͽ� ȣ��޴°� : 
* � ������ ȣ���ϴ°� :  
* ���� Ÿ�� : 
***********************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnectionMgr;

public class ProductDAO {
	Connection con = null;//�������
	PreparedStatement pstmt = null;//������ ����|��û
	ResultSet rs = null;//open-cursor-fetch
	DBConnectionMgr dbMgr = null;
	StringBuffer sql = new StringBuffer();
	//��ǰ��ȣ�� ���� ��ǰ �������� SELECT 
		public ProductDTO productList(ProductDTO pto){
			dbMgr = DBConnectionMgr.getInstance();
			ProductDTO dto = null;
			try {
					con = dbMgr.getConnection();
					sql.append("SELECT product_no,product_name,product_detail, gender_type,product_price, product_imgsrc1,product_imgsrc2,product_imgsrc3, product_imgsrc4, product_imgsrc5, to_char(NVL(product_sangpum/DECODE(product_review_count,0,NULL,product_review_count),0), 9.9) as sangpum, to_char(NVL(product_besong/DECODE(product_review_count,0,NULL,product_review_count),0), 9.9) as besong, product_review_count FROM PRODUCT WHERE product_no = ?");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setInt(1, pto.getProduct_no());
					rs = pstmt.executeQuery();
					while (rs.next()){
						dto = new ProductDTO();
						dto.setProduct_no(rs.getInt("product_no"));
						dto.setProduct_name(rs.getString("product_name"));
						dto.setProduct_detail(rs.getString("product_detail"));
						dto.setGender_type(rs.getString("gender_type"));
						dto.setProduct_price(rs.getInt("product_price"));
						dto.setProduct_imgsrc1(rs.getString("product_imgsrc1"));
						dto.setProduct_imgsrc2(rs.getString("product_imgsrc2"));
						dto.setProduct_imgsrc3(rs.getString("product_imgsrc3"));
						dto.setProduct_imgsrc4(rs.getString("product_imgsrc4"));
						dto.setProduct_imgsrc5(rs.getString("product_imgsrc5"));
						dto.setProduct_besong(rs.getDouble("besong"));
						dto.setProduct_sangpum(rs.getDouble("sangpum"));
						dto.setProduct_review_count(rs.getInt("product_review_count"));
					}
			} catch (Exception e) {
					e.printStackTrace();
		
			} finally{
				dbMgr.freeContection(rs, pstmt, con);
			}
			return dto ; // ������ ��ǰ��ȣ�� �Ű������� �����Ƿ� �� ����
		}
		//��ǰ�� ���������� ������ �߰� ����(���,������)
		public ArrayList<ProductDTO> optionList(int pto){
			dbMgr = DBConnectionMgr.getInstance();
			ArrayList<ProductDTO> data = new ArrayList<ProductDTO>();
			try {
				con = dbMgr.getConnection();
				sql.append("SELECT stock_no,stock_quantity,product_no,stock_size FROM STOCK WHERE product_no = ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, pto); 
				rs = pstmt.executeQuery();
				while (rs.next()){
					ProductDTO dto = new ProductDTO();
					dto.setStock_no(rs.getInt("stock_no"));
					dto.setStock_quantity(rs.getInt("stock_quantity"));
					dto.setProduct_no(rs.getInt("product_no"));
					dto.setStock_size(rs.getString("stock_size"));
					data.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally{
				dbMgr.freeContection(rs, pstmt, con);
			}
			return data ; // ������ ��ǰ��ȣ�� �Ű������� �����Ƿ� �� ����
		}
	
	//��Ϻ���
	public ArrayList<ProductDTO> typeList(int product_type_no){
		 dbMgr = DBConnectionMgr.getInstance();
		 ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		 try{
			 con = dbMgr.getConnection();
			 sql.append("select a.product_no as product_no"
					 		+",a.product_name as product_name"
					 		+",a.product_type_no as product_type_no"
					 		+",b.product_type_name as product_type_name"
					 		+",a.product_price as product_price"
					 		+",a.product_imgsrc1 as product_imgsrc1"
					 		+" from PRODUCT a,PRODUCT_TYPE b"
					 		+" where a.product_type_no = ?"
					 		+" AND a.product_type_no = b.product_type_no");
			 
			 pstmt = con.prepareStatement(sql.toString());
			 pstmt.setInt(1, product_type_no);
			 rs = pstmt.executeQuery();

			 while(rs.next()){
				 ProductDTO data = new ProductDTO();
				 data.setProduct_no(rs.getInt("product_no"));
				 data.setProduct_name(rs.getString("product_name"));
				 data.setProduct_type_name(rs.getString("product_type_name"));
				 data.setProduct_price(rs.getInt("product_price"));
				 data.setProduct_imgsrc1(rs.getString("product_imgsrc1"));
				 
				 list.add(data);
				 
			 }//end while
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 dbMgr.freeContection(rs, pstmt, con);
		 }
		 System.out.println(list+"�ٿ�");
		 return list;
		 
	}//end list
	
	//��ǰ ��� - ������ ���
	public int productInsert (ProductDTO pto){
		dbMgr = DBConnectionMgr.getInstance();
		int insert_result = 0;
		try {
			con = dbMgr.getConnection();
			sql.append("INSERT INTO PRODUCT (product_no, product_name,product_type_no,product_detail,gender_type,product_cost,product_price,product_imgsrc1,product_imgsrc2,product_imgsrc3,product_imgsrc4,product_imgsrc5) VALUES(product_seq.nextval, ?,?,?,?,?,?,?,?,?,?,?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, pto.getProduct_no());
			pstmt.setString(2, pto.getProduct_name());
			pstmt.setInt(3, pto.getProduct_type_no());
			pstmt.setString(4, pto.getProduct_detail());
			pstmt.setString(5, pto.getGender_type());
			pstmt.setInt(6, pto.getProduct_cost());
			pstmt.setInt(7, pto.getProduct_price());
			pstmt.setString(8, pto.getProduct_imgsrc1());
			pstmt.setString(9, pto.getProduct_imgsrc2());
			pstmt.setString(10, pto.getProduct_imgsrc3());
			pstmt.setString(11, pto.getProduct_imgsrc4());
			pstmt.setString(12, pto.getProduct_imgsrc5());
	
			insert_result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeContection(rs, pstmt, con);
		}		
		return insert_result;
	}
	
	public int stockUpdate (ProductDTO pto){
		dbMgr = DBConnectionMgr.getInstance();
		int update_result = 0;
		try {
			con = dbMgr.getConnection();
			sql.append("");
			update_result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeContection(rs, pstmt, con);
		}
		return update_result;
	}
	
}
