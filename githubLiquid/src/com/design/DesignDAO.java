package com.design;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.util.DBConnectionMgr;

public class DesignDAO {
	Connection con = null;//�������
	PreparedStatement pstmt = null;//������ ����|��û
	ResultSet rs = null;//open-cursor-fetch
	DBConnectionMgr dbMgr = null;
	
	//������ �Խ��� �� ����
	public int insertDesign (DesignDTO pto, HashMap<String,String> pMap){
	dbMgr = DBConnectionMgr.getInstance();
	StringBuffer sql = new StringBuffer();
	int insert_result = 0;
	try { 
		con = dbMgr.getConnection();
		sql.append("INSERT INTO board_userdesign(board_userdesign_no,member_info_no,board_userdesign_title,board_userdesign_content,board_userdesign_imgsrc1,board_userdesign_imgsrc2,board_userdesign_imgsrc3,board_userdesign_imgsrc4,board_userdesign_imgsrc5,board_userdesign_reproot) VALUES(board_userdesign_seq.NEXTVAL,?,?,?,?,?,?,?,?,board_userdesign_seq.CURRVAL)");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setInt(1, pto.getMember_info_no());
		pstmt.setString(2, pto.getBoard_userdesign_title());
		pstmt.setString(3, pto.getBoard_userdesign_content());
		
		for(int i=1;i<pMap.size()+1;i++){
			pstmt.setString(3+i,pMap.get("board_userdesign_imgsrc"+i));
		}
		insert_result = pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally { 
		dbMgr.freeContection(rs, pstmt, con);
	}		
	return insert_result;
	}
	
	
	//����¡ ó�� : ��ü ���ڵ� ���� ���ϱ�
	public int totalCount(){
		dbMgr = DBConnectionMgr.getInstance();
		int count = 0;
		
			try {
				con = dbMgr.getConnection();
				StringBuffer query=new StringBuffer();
				query.append("SELECT count(*) FROM board_userdesign");
				pstmt = con.prepareStatement(query.toString());
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally{
				dbMgr.freeContection(rs, pstmt, con);
			}
			return count;
	}//end totalCount
	//������ ����
	public DesignPageTO page(int curPage){
			DesignPageTO to = new DesignPageTO();
			int totalCount = totalCount();
			ArrayList<DesignDTO> list = new ArrayList<DesignDTO>();
			dbMgr = DBConnectionMgr.getInstance();
			try {
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();                          
					 sql.append("SELECT board_userdesign_no					 ");
					 sql.append("      ,board_userdesign_title               ");
					 sql.append("      ,board_userdesign_imgsrc1             ");
					 sql.append("      ,board_userdesign_viewcount             ");
					 sql.append("      ,board_userdesign_favorite            ");
					 sql.append("      ,member_info_nickname                 ");
					 sql.append("  FROM BOARD_USERDESIGN A                   ");
					 sql.append("      ,MEMBER_INFO B                        ");
					 sql.append(" WHERE A.member_info_no = B.member_info_no  ");
					 sql.append(" ORDER BY board_userdesign_reproot desc, board_userdesign_repstep asc  ");
				pstmt = con.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = pstmt.executeQuery();
				int perPage = to.getPerPage(); //5
				int skip = (curPage -1)*perPage;
				if(skip>0){
					rs.absolute(skip);
				}
				for(int i=0; i<perPage && rs.next(); i++){
					DesignDTO data = new DesignDTO();                                          
					data.setBoard_userdesign_no(rs.getInt("board_userdesign_no"));             
					data.setBoard_userdesign_title(rs.getString("board_userdesign_title"));    
					data.setBoard_userdesign_imgsrc1(rs.getString("board_userdesign_imgsrc1"));
					data.setBoard_userdesign_favorite(rs.getInt("board_userdesign_favorite")); 
					data.setBoard_userdesign_viewcount(rs.getInt("board_userdesign_viewcount")); 
					data.setMember_info_nickname(rs.getString("member_info_nickname"));        
					list.add(data);                                                            
					
				}//end for
				to.setList(list);  //ArrayList ����
				to.setTotalCount(totalCount); //��ü ���ڵ� ����
				to.setCurPage(curPage); //���� ������
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				dbMgr.freeContection(rs, pstmt, con);
			}
			return to;
	}//end page
	
	
	
	
	/*//�����ΰԽ��� ����Ʈ ����	
	public ArrayList<DesignDTO> listDesign(){
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<DesignDTO> list = new ArrayList<DesignDTO>();
		try {
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();
					 sql.append("SELECT board_userdesign_no					 ");
					 sql.append("      ,board_userdesign_title               ");
					 sql.append("      ,board_userdesign_imgsrc1             ");
					 sql.append("      ,board_userdesign_favorite            ");
					 sql.append("      ,member_info_nickname                 ");
					 sql.append("  FROM BOARD_USERDESIGN A                   ");
					 sql.append("      ,MEMBER_INFO B                        ");
					 sql.append(" WHERE A.member_info_no = B.member_info_no  ");
					 sql.append(" ORDER BY board_userdesign_no desc  ");
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				while (rs.next()){
					DesignDTO data = new DesignDTO();
					data.setBoard_userdesign_no(rs.getInt("board_userdesign_no"));
					data.setBoard_userdesign_title(rs.getString("board_userdesign_title"));
					data.setBoard_userdesign_imgsrc1(rs.getString("board_userdesign_imgsrc1"));
					data.setBoard_userdesign_favorite(rs.getInt("board_userdesign_favorite"));
					data.setMember_info_nickname(rs.getString("member_info_nickname"));
					list.add(data);
 				}
		} catch (Exception e) {
				e.printStackTrace();
	
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return list; // �� ����
	}*/

	// ���������� �� ȭ�� ������
	///////////////////////////�󼼺���/////////////////////////
	//��ȸ��1����
	public void readCount(String board_userdesign_no){
		dbMgr = DBConnectionMgr.getInstance();
			try {
				con = dbMgr.getConnection();
				StringBuffer query=new StringBuffer();
				query.append("UPDATE board_userdesign "
						+ "      SET board_userdesign_viewcount = board_userdesign_viewcount + 1 "
						+ "    WHERE board_userdesign_no = ? ");
				pstmt = con.prepareStatement(query.toString());
				pstmt.setInt(1, Integer.parseInt(board_userdesign_no));
				int n = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally{
				dbMgr.freeContection(rs, pstmt, con);
			}//end finally
	}//end readCount
	
	//�� �ڼ��� ����
	public DesignDTO detailDesign(String board_userdesign_no) {
		//��ȸ�� ����
		readCount(board_userdesign_no);
		dbMgr = DBConnectionMgr.getInstance();
		DesignDTO data = new DesignDTO();
		try {
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT board_userdesign_no, "
						+ "			 board_userdesign.member_info_no, "
						+ "			 member_info.member_info_nickname,"
						+ "			 board_userdesign_title, "
						+ "			 board_userdesign_content, "
						+ "			 board_userdesign_date, "
						+ "			 board_userdesign_viewcount, "
						+ "			 board_userdesign_reproot, "
						+ "			 board_userdesign_repstep, "
						+ "			 board_userdesign_repindent, "
						+ "			 board_userdesign_favorite, "
						+ "			 board_userdesign_imgsrc1, "
						+ "			 board_userdesign_imgsrc2, "
						+ "			 board_userdesign_imgsrc3, "
						+ "			 board_userdesign_imgsrc4, "
						+ "			 board_userdesign_imgsrc5 "
						+ "     FROM board_userdesign, "
						+ "		  	 member_info "
						+ "    WHERE board_userdesign.member_info_no = member_info.member_info_no "
						+ "		 and board_userdesign.board_userdesign_no = ? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, Integer.parseInt(board_userdesign_no));
				rs = pstmt.executeQuery();
				while (rs.next()){
					data.setBoard_userdesign_no(rs.getInt("board_userdesign_no"));
					data.setBoard_userdesign_title(rs.getString("board_userdesign_title"));
					data.setBoard_userdesign_content(rs.getString("board_userdesign_content"));
					data.setBoard_userdesign_date(rs.getString("board_userdesign_date"));
					data.setBoard_userdesign_viewcount(rs.getInt("board_userdesign_viewcount"));
					data.setBoard_userdesign_reproot(rs.getInt("board_userdesign_reproot"));
					data.setBoard_userdesign_repstep(rs.getInt("board_userdesign_repstep"));
					data.setBoard_userdesign_repindent(rs.getInt("board_userdesign_repindent"));
					data.setBoard_userdesign_imgsrc1(rs.getString("board_userdesign_imgsrc1"));
					data.setBoard_userdesign_imgsrc2(rs.getString("board_userdesign_imgsrc2"));
					data.setBoard_userdesign_imgsrc3(rs.getString("board_userdesign_imgsrc3"));
					data.setBoard_userdesign_imgsrc4(rs.getString("board_userdesign_imgsrc4"));
					data.setBoard_userdesign_imgsrc5(rs.getString("board_userdesign_imgsrc5"));
					data.setBoard_userdesign_favorite(rs.getInt("board_userdesign_favorite"));
					data.setMember_info_nickname(rs.getString("member_info_nickname"));
 				}
		} catch (Exception e) {
				e.printStackTrace();
	
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return data; // �� ����
	}
	//�� �����ϱ�
	/////////////////////////�����ϱ�/////////////////////
	public void delete(String board_userdesign_no){
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con = dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			query.append("DELETE FROM board_userdesign "
					+ "		    WHERE board_userdesign_no = ? ");
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt (1,Integer.parseInt(board_userdesign_no));
			int n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
	}//end delete
	//�����ϱ�
	//////////////////////////�� ���� ȭ�� â�� �ʿ��� ������///////////////
	public DesignDTO retrieve(String board_userdesign_no){
		dbMgr = DBConnectionMgr.getInstance();
		DesignDTO data = new DesignDTO();
		try {
			con = dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			query.append("SELECT board_userdesign_no, "
					+ "			 member_info.member_info_nickname , "
					+ "			 board_userdesign_title, "
					+ "			 board_userdesign_content, "
					+ "			 board_userdesign_date, "
					+ "			 board_userdesign_viewcount,"
					+ "			 board_userdesign_reproot, "
					+ "			 board_userdesign_repstep, "
					+ "			 board_userdesign_repindent,"
					+ "			 board_userdesign_imgsrc1, "
					+ "			 board_userdesign_imgsrc2, "
					+ "			 board_userdesign_imgsrc3, "
					+ "			 board_userdesign_imgsrc4, "
					+ "			 board_userdesign_imgsrc5 "
					+ "     FROM board_userdesign, member_info "
					+ "    WHERE board_userdesign.member_info_no = member_info.member_info_no"
					+ "		 AND board_userdesign.board_userdesign_no = ? ");
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1, Integer.parseInt(board_userdesign_no));
			rs = pstmt.executeQuery();
			if(rs.next()){
				data.setBoard_userdesign_no(rs.getInt("board_userdesign_no"));
				data.setBoard_userdesign_title(rs.getString("board_userdesign_title"));
				data.setMember_info_nickname(rs.getString("member_info_nickname"));
				String board_userdesign_content =rs.getString("board_userdesign_content"); 
				board_userdesign_content = board_userdesign_content.replaceAll( "<br>", "\r\n"); // db�� <br>�� �ٽ� \r\n����
				data.setBoard_userdesign_content(board_userdesign_content);
				data.setBoard_userdesign_date(rs.getString("board_userdesign_date"));
				data.setBoard_userdesign_viewcount(rs.getInt("board_userdesign_viewcount"));
				data.setBoard_userdesign_imgsrc1(rs.getString("board_userdesign_imgsrc1"));
				data.setBoard_userdesign_imgsrc2(rs.getString("board_userdesign_imgsrc2"));
				data.setBoard_userdesign_imgsrc3(rs.getString("board_userdesign_imgsrc3"));
				data.setBoard_userdesign_imgsrc4(rs.getString("board_userdesign_imgsrc4"));
				data.setBoard_userdesign_imgsrc5(rs.getString("board_userdesign_imgsrc5"));
			
			}//end if
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return data;
	}//end retrieve
	//�ڵ��߰�28,29(�� ���� ���� ����)-----------------------------------------------------------------------------
//�ڵ��߰�31,32(�� ���� ����)-----------------------------------------------------------------------------
	//�� �����ϱ�
	public void update(String _no, String _title, String _member_info_no, String _content){
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con = dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			query.append("UPDATE board_userdesign "
					+ "		 SET board_userdesign_title = ? , "
					+ "			 member_info_no = ?, "
					+ "			 board_userdesign_content = ?"
					+ "    WHERE board_userdesign_no = ? ");
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, _title);
			pstmt.setString(2, _member_info_no);
			pstmt.setString(3, _content);
			pstmt.setInt(4, Integer.parseInt(_no));
			int n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
	}//end update
	
	
	////////////////////////�˻��ϱ�
	//����¡ ó�� : �˻� �� ��ü ���ڵ� ���� ���ϱ�
	public int totalCount_search(String _searchName, String _searchValue){
		dbMgr = DBConnectionMgr.getInstance();
		int count = 0;
			try {
				con = dbMgr.getConnection();
				StringBuffer query=new StringBuffer();
				query.append("SELECT count(*) " 
                           + "  FROM board_userdesign, "
                           + " 		 member_info "
                           + " WHERE board_userdesign.member_info_no = member_info.member_info_no "
                           + "	 AND ");
					if( _searchName.equals("board_userdesign_title")){
						query.append(" board_userdesign_title LIKE ? ");
					}else{
						query.append(" member_info_nickname LIKE ? ");
					}
				pstmt = con.prepareStatement(query.toString());
				pstmt.setString(1,"%"+_searchValue+"%");
				rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally{
				dbMgr.freeContection(rs, pstmt, con);
			}
			return count;
	}//end totalCount
	public DesignPageTO search(int curPage, String _searchName, String _searchValue){
		DesignPageTO to = new DesignPageTO();
		int totalCount = totalCount_search(_searchName, _searchValue);
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<DesignDTO> list = new ArrayList<DesignDTO>();
		try{
			con = dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			query.append("SELECT board_userdesign_no, "
					+ "			 member_info.member_info_nickname as member_info_nickname, "
					+ "			 board_userdesign_title, "
                   +	"		 board_userdesign_content, "
                   + "			 board_userdesign_date, "
                   + "			 board_userdesign_viewcount, " 
                   + "			 board_userdesign_imgsrc1 " 
                    + "		FROM board_userdesign, "
                    + "			 member_info "
                    + "    WHERE board_userdesign.member_info_no = member_info.member_info_no "
                    + "		 AND " );
			if( _searchName.equals("board_userdesign_title")){
				query.append(" 		 board_userdesign_title LIKE ? "
						+ " ORDER BY board_userdesign_no DESC");
			}else{
				query.append(" 		 member_info_nickname LIKE ? "
						+ " ORDER BY board_userdesign_no DESC");
			}
			pstmt = con.prepareStatement(query.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pstmt.setString(1,"%"+_searchValue+"%");
			rs = pstmt.executeQuery();
			
			int perPage = to.getPerPage(); //5   
			int skip = (curPage -1)*perPage;	
			if(skip>0){							
				rs.absolute(skip);				
			}
			
			for(int i=0; i<perPage && rs.next(); i++){
			int board_userdesign_no = rs.getInt("board_userdesign_no");
			String member_info_nickname = rs.getString("member_info_nickname");
			String board_userdesign_title = rs.getString("board_userdesign_title");
			String board_userdesign_content = rs.getString("board_userdesign_content");
			String board_userdesign_date = rs.getString("board_userdesign_date");
			String board_userdesign_imgsrc1 = rs.getString("board_userdesign_imgsrc1");
			int board_userdesign_viewcount = rs.getInt("board_userdesign_viewcount");
			DesignDTO data = new DesignDTO();
			data.setBoard_userdesign_no(board_userdesign_no);
			data.setMember_info_nickname(member_info_nickname);
			data.setBoard_userdesign_title(board_userdesign_title);
			data.setBoard_userdesign_content(board_userdesign_content);
			data.setBoard_userdesign_date(board_userdesign_date);
			data.setBoard_userdesign_imgsrc1(board_userdesign_imgsrc1);
			data.setBoard_userdesign_viewcount(board_userdesign_viewcount);
			list.add(data);
		}//end while
			
			to.setList(list);  //ArrayList ����
			to.setTotalCount_search(totalCount); //��ü ���ڵ� ����
			to.setCurPage(curPage); //���� ������
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		dbMgr.freeContection(rs, pstmt, con);
	}
		
	return to;
}//end select
	
	
	//////////////////////////��õ�� �ø���
		public int favorite(String board_userdesign_no, String member_info_no){
			dbMgr = DBConnectionMgr.getInstance();
			PreparedStatement pstmt_va = null;
			try {
				con = dbMgr.getConnection();
				StringBuffer query=new StringBuffer();
				query.append("SELECT 1 "
						+ "		FROM board_userdesign_favorite_list "
						+ "	   WHERE board_userdesign_no = ? "
						+ "	     AND member_info_no = ?");
				pstmt = con.prepareStatement(query.toString());
				pstmt.setInt(1, Integer.parseInt(board_userdesign_no));
				pstmt.setInt(2, Integer.parseInt(member_info_no));
				rs = pstmt.executeQuery();
				//���� ������ 1�� ����
				if(!rs.next()){
					System.out.print("rs next�� 1����");
				pstmt.clearParameters();
				
				query.setLength(0);//query�� �ʱ�ȭ
				query.append("INSERT INTO board_userdesign_favorite_list(board_userdesign_no, "
						+ "												 member_info_no) "
						+ "	       VALUES (?, ?)");
				
				//�μ�Ʈ�� �ߵǸ�
				StringBuffer query2 = new StringBuffer();
				query2.append("UPDATE board_userdesign     "
						  +"    SET board_userdesign_favorite = board_userdesign_favorite + 1  "
						  +"  WHERE board_userdesign_no = ?");
				
				pstmt = con.prepareStatement(query.toString());
				pstmt.setInt(1, Integer.parseInt(board_userdesign_no));
				pstmt.setInt(2, Integer.parseInt(member_info_no));
				int n = pstmt.executeUpdate();
				
				if(n == 1){
					pstmt_va = con.prepareStatement(query2.toString());
					pstmt_va.setInt(1, Integer.parseInt(board_userdesign_no));
					pstmt_va.executeUpdate();
				}
				}else{
					System.out.println("rs next ���� ������ ����");
					return 1;  // 1�̸� ���̵� �ߺ�
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally{
				dbMgr.freeContection(rs, pstmt_va, con);
				try{
					if(pstmt !=null) pstmt.close();
				}catch(SQLException se){
					se.printStackTrace();
				}//end catch
			}//and finally
			return 2; //2�� �� ���
		}//end favorite
	
	
}


