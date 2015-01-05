package com.catalogue;
/***********************************************************************
 * �۾��� : �̽¿� 
 * �۾����� : 2014.11.03 - 14.11.08
 * � ���Ͽ� ȣ��޴°� : UserDesignCatalogueCMD.java / ProductCatalogueCMD.java
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� : 
 ***********************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;








import com.util.DBConnectionMgr;

public class CatalogueDAO {
	Connection con = null;//�������
	PreparedStatement pstmt = null;//������ ����|��û
	ResultSet rs = null;//open-cursor-fetch
	DBConnectionMgr dbMgr = null;
	
	//���� ��ǰ īŻ�α� �Ǹŷ� ����
	public ArrayList<ProductCatalogueDTO> productCatalogueList(){
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ProductCatalogueDTO> list = new ArrayList<ProductCatalogueDTO>();
		try { 
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT rownum, no, name, img, price, sales "
						+    "FROM (SELECT b.product_no NO "
						+               ",c.product_name NAME "
						+ 				",MAX(c.product_imgsrc1) IMG "
						+ 				",MAX(c.product_price) PRICE "
						+ 				",SUM(a.order_detail_quantity) SALES "
						+ 			 "FROM PRODUCT_ORDER_DETAIL a, STOCK b, PRODUCT c "
						+ 			"WHERE a.stock_no = b.stock_no "
						+ 			  "AND b.product_no = c.product_no "
						+ 			"GROUP BY b.product_no,c.product_name "
						+ 			"ORDER BY SUM(a.order_detail_quantity) desc) "
						+   "WHERE rownum < 9  ");
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				while (rs.next()){
					ProductCatalogueDTO data = new ProductCatalogueDTO();
					data.setRownum(rs.getInt("rownum"));
					data.setNo(rs.getInt("no"));
					data.setName(rs.getString("name"));
					data.setImg(rs.getString("img"));
					data.setPrice(rs.getInt("price"));
					data.setSales(rs.getInt("sales"));
					list.add(data);
					//System.out.println("�ξƴ�"+list);
				}
		} catch (Exception e) {
				e.printStackTrace();
	
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return list; // �� ����
	}
	
	
	//���� ���� ������ īŻ�α� ��õ ����	
	public ArrayList<UserDesignCatalogueDTO> UserDesignCatalogueList(){
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<UserDesignCatalogueDTO> list = new ArrayList<UserDesignCatalogueDTO>();
		try {
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT rownum,no,nickname,title,favorite,img FROM (SELECT a.board_userdesign_no as no, b.member_info_nickname as nickname, a.board_userdesign_title as title, a.board_userdesign_favorite as favorite, a.board_userdesign_imgsrc1 as img FROM BOARD_USERDESIGN a, MEMBER_INFO b WHERE a.member_info_no = b.member_info_no ORDER BY a.board_userdesign_favorite) WHERE ROWNUM < 9");
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				while (rs.next()){
					UserDesignCatalogueDTO data = new UserDesignCatalogueDTO();
					data.setRownum(rs.getInt("rownum"));
					data.setNo(rs.getInt("no"));
					data.setNickname(rs.getString("nickname"));
					data.setTitle(rs.getString("title"));
					data.setFavorite(rs.getInt("favorite"));
					data.setImg(rs.getString("img"));
					list.add(data);
				}
		} catch (Exception e) {
				e.printStackTrace();
	
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return list; // �� ����
	}
}
