package com.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.util.DBConnectionMgr;

public class NoticeDAO {
	Connection con = null;//연결통로
	PreparedStatement pstmt = null;//쿼리문 전달|요청
	ResultSet rs = null;//open-cursor-fetch
	DBConnectionMgr dbMgr = null;

	//목록보기
	public ArrayList<NoticeDTO> list(){
		 dbMgr = DBConnectionMgr.getInstance();
		 ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
		 try{
			 con = dbMgr.getConnection();
			 String query = "SELECT a.board_notice_no as board_notice_no,a.board_notice_title as board_notice_title"
					 +",a.board_notice_content as board_notice_content"
					 +",to_char(a.board_notice_date,'YYYY/MM/DD') as board_notice_date"
					 +",a.board_notice_imgsrc1 as board_notice_imgsrc1,a.board_notice_imgsrc2 as board_notice_imgsrc2"
					 +",a.member_info_no as member_info_no,b.member_info_nickname as member_info_nickname,"
					 + "a.board_notice_views as board_notice_views"
					 +" FROM board_notice a,member_info b"
					 +" WHERE a.member_info_no = b.member_info_no"
					 +" ORDER BY board_notice_no desc";

			 pstmt = con.prepareStatement(query);
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()){
				 int board_notice_no = rs.getInt("board_notice_no");
				 String board_notice_title = rs.getString("board_notice_title");
				 String board_notice_content =rs.getString("board_notice_content");
				 String board_notice_date = rs.getString("board_notice_date");
				 int board_notice_views = rs.getInt("board_notice_views");
				 String board_notice_imgsrc1 = rs.getString("board_notice_imgsrc1");
				 String board_notice_imgsrc2 = rs.getString("board_notice_imgsrc2");
				 String member_info_nickname = rs.getString("member_info_nickname");
				 int member_info_no = rs.getInt("member_info_no");

				 NoticeDTO data = new NoticeDTO();
				 
				 data.setBoard_notice_no(board_notice_no);
				 data.setBoard_notice_title(board_notice_title);
				 data.setBoard_notice_content(board_notice_content);
				 data.setBoard_notice_date(board_notice_date);
				 data.setBoard_notice_views(board_notice_views);
				 data.setBoard_notice_imgsrc1(board_notice_imgsrc1);
				 data.setBoard_notice_imgsrc2(board_notice_imgsrc2);
				 data.setMember_info_nickname(member_info_nickname);
				 data.setMember_info_no(member_info_no);
				 
				 list.add(data);
				 
			 }//end while
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 dbMgr.freeContection(rs, pstmt,con );
		 }
		 return list;
	}//end select
	
	//글쓰기
	public void write(String _board_notice_title,String _board_notice_content
			,String _board_notice_imgsrc1,String _board_notice_imgsrc2,String _member_info_no){
		dbMgr = DBConnectionMgr.getInstance();
		try{
			con = dbMgr.getConnection();
			String query = " INSERT INTO board_notice(board_notice_no,board_notice_title,board_notice_content,"
				    +"board_notice_imgsrc1,board_notice_imgsrc2,board_notice_views,member_info_no)"
			+" values(notice_seq.NEXTVAL,?,?,?,?,0,?)";
				    
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,_board_notice_title);
			pstmt.setString(2,_board_notice_content);
			pstmt.setString(3,_board_notice_imgsrc1);
			pstmt.setString(4,_board_notice_imgsrc2);
			pstmt.setString(5,_member_info_no);
			
			int n = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt,con );
		}//end finally
	}//end write
	
	public void readCount(String _board_notice_no){
		dbMgr = DBConnectionMgr.getInstance();
		try{
			con = dbMgr.getConnection();
		String query= "UPDATE board_notice SET board_notice_views = board_notice_views + 1 WHERE board_notice_no="+ _board_notice_no;
					pstmt = con.prepareStatement(query);
					int n = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt,con );
		}//end finally
	}//end readCount
	
	//글 자세히 보기
	
	public NoticeDTO retrieve(String _board_notice_no){
		dbMgr = DBConnectionMgr.getInstance();
		//조회수 증가
		readCount(_board_notice_no);
		NoticeDTO data = new NoticeDTO();
		try{
			con = dbMgr.getConnection();
			String query = "SELECT a.board_notice_no as board_notice_no,a.board_notice_title as board_notice_title"
					 +",a.board_notice_content as board_notice_content"
					 +",to_char(a.board_notice_date,'YYYY/MM/DD') as board_notice_date"
					 +",a.board_notice_imgsrc1 as board_notice_imgsrc1,a.board_notice_imgsrc2 as board_notice_imgsrc2"
					 +",a.member_info_no as member_info_no,b.member_info_nickname as member_info_nickname,"
					 + "a.board_notice_views as board_notice_views"
					 +" FROM board_notice a,member_info b"
					 +" WHERE a.member_info_no = b.member_info_no"
					 +" AND a.board_notice_no = ?"
					 +" ORDER BY board_notice_no desc";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_board_notice_no));
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				 int board_notice_no = rs.getInt("board_notice_no");
				 String board_notice_title = rs.getString("board_notice_title");
				 String board_notice_content =rs.getString("board_notice_content");
				 String board_notice_date = rs.getString("board_notice_date");
				 int board_notice_views = rs.getInt("board_notice_views");
				 String board_notice_imgsrc1 = rs.getString("board_notice_imgsrc1");
				 String board_notice_imgsrc2 = rs.getString("board_notice_imgsrc2");
				 String member_info_nickname = rs.getString("member_info_nickname");
				 int member_info_no = rs.getInt("member_info_no");
				 
				 data.setBoard_notice_no(board_notice_no);
				 data.setBoard_notice_title(board_notice_title);
				 data.setBoard_notice_content(board_notice_content);
				 data.setBoard_notice_date(board_notice_date);
				 data.setBoard_notice_views(board_notice_views);
				 data.setBoard_notice_imgsrc1(board_notice_imgsrc1);
				 data.setBoard_notice_imgsrc2(board_notice_imgsrc2);
				 data.setMember_info_nickname(member_info_nickname);
				 data.setMember_info_no(member_info_no);
			}//end if
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt,con );
		}
	return data;
	}//end retrieve
	
	public NoticeDTO retrievetest(String _board_notice_no){
		dbMgr = DBConnectionMgr.getInstance();
		//조회수 증가
		readCount(_board_notice_no);
		NoticeDTO data = new NoticeDTO();
		try{
			con = dbMgr.getConnection();
			String query = "SELECT a.board_notice_no as board_notice_no,a.board_notice_title as board_notice_title"
					 +",a.board_notice_content as board_notice_content"
					 +",to_char(a.board_notice_date,'YYYY/MM/DD') as board_notice_date"
					 +",a.board_notice_imgsrc1 as board_notice_imgsrc1,a.board_notice_imgsrc2 as board_notice_imgsrc2"
					 +",a.member_info_no as member_info_no,b.member_info_nickname as member_info_nickname,"
					 + "a.board_notice_views as board_notice_views"
					 +" FROM board_notice a,member_info b"
					 +" WHERE a.member_info_no = b.member_info_no"
					 +" AND a.board_notice_no = ?"
					 +" ORDER BY board_notice_no desc";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_board_notice_no));
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				 int board_notice_no = rs.getInt("board_notice_no");
				 String board_notice_title = rs.getString("board_notice_title");
				 String board_notice_content =rs.getString("board_notice_content");
				 String board_notice_date = rs.getString("board_notice_date");
				 int board_notice_views = rs.getInt("board_notice_views");
				 String board_notice_imgsrc1 = rs.getString("board_notice_imgsrc1");
				 String board_notice_imgsrc2 = rs.getString("board_notice_imgsrc2");
				 String member_info_nickname = rs.getString("member_info_nickname");
				 int member_info_no = rs.getInt("member_info_no");
				 
				 data.setBoard_notice_no(board_notice_no);
				 data.setBoard_notice_title(board_notice_title);
				 data.setBoard_notice_content(board_notice_content);
				 data.setBoard_notice_date(board_notice_date);
				 data.setBoard_notice_views(board_notice_views);
				 data.setBoard_notice_imgsrc1(board_notice_imgsrc1);
				 data.setBoard_notice_imgsrc2(board_notice_imgsrc2);
				 data.setMember_info_nickname(member_info_nickname);
				 data.setMember_info_no(member_info_no);
				 
			}//end if
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
	return data;
	}//end retrievetest
	
	
	public void delete(String _board_notice_no){
		dbMgr = DBConnectionMgr.getInstance();
		try{
			con = dbMgr.getConnection();
			String query = "DELETE FROM board_notice WHERE board_notice_no = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(_board_notice_no));
			int n = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
	}//end delete
	
	public ArrayList<NoticeDTO> search(String _searchName, String _searchValue){
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
		try{
			con = dbMgr.getConnection();
			String query = "SELECT a.board_notice_no as board_notice_no,a.board_notice_title as board_notice_title"
					 +",a.board_notice_content as board_notice_content"
					 +",to_char(a.board_notice_date,'YYYY/MM/DD') as board_notice_date"
					 +",a.board_notice_imgsrc1 as board_notice_imgsrc1,a.board_notice_imgsrc2 as board_notice_imgsrc2"
					 +",a.member_info_no as member_info_no,b.member_info_nickname as member_info_nickname,"
					 + "a.board_notice_views as board_notice_views"
					 +" FROM board_notice a,member_info b"
					 +" WHERE a.member_info_no = b.member_info_no";
			
			if( _searchName.equals("board_notice_title")){
				query += " AND a.board_notice_title LIKE ?"
						+ " ORDER BY board_notice_no desc";
			}else{
				query += " AND b.member_info_nickname LIKE ?"
						+ " ORDER BY board_notice_no desc"; 
			}
			pstmt = con.prepareStatement(query);
			//pstmt.setString(1,_searchValue);
			pstmt.setString(1,"%"+_searchValue+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				 int board_notice_no = rs.getInt("board_notice_no");
				 String board_notice_title = rs.getString("board_notice_title");
				 String board_notice_content =rs.getString("board_notice_content");
				 String board_notice_date = rs.getString("board_notice_date");
				 int board_notice_views = rs.getInt("board_notice_views");
				 String board_notice_imgsrc1 = rs.getString("board_notice_imgsrc1");
				 String board_notice_imgsrc2 = rs.getString("board_notice_imgsrc2");
				 String member_info_nickname = rs.getString("member_info_nickname");
				 int member_info_no = rs.getInt("member_info_no");

				 NoticeDTO data = new NoticeDTO();
				 
				 data.setBoard_notice_no(board_notice_no);
				 data.setBoard_notice_title(board_notice_title);
				 data.setBoard_notice_content(board_notice_content);
				 data.setBoard_notice_date(board_notice_date);
				 data.setBoard_notice_views(board_notice_views);
				 data.setBoard_notice_imgsrc1(board_notice_imgsrc1);
				 data.setBoard_notice_imgsrc2(board_notice_imgsrc2);
				 data.setMember_info_nickname(member_info_nickname);
				 data.setMember_info_no(member_info_no);
				 
				 list.add(data);
				 
			}//end while
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return list;
	}//end search
	
	public int totalCount(){
		dbMgr = DBConnectionMgr.getInstance();
		int count=0;
			try{
				con = dbMgr.getConnection();
				String query = "SELECT count(*) FROM board_notice";
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				if(rs.next()){
					count=rs.getInt(1);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				dbMgr.freeContection(rs, pstmt, con);
			}
			return count;
	}//end totalCount
	
	//페이지 구현
	
	public NoticePageTO page(int curPage){
		dbMgr = DBConnectionMgr.getInstance();
		NoticePageTO to = new NoticePageTO();
		int totalCount = totalCount();
		ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
		try{
			con = dbMgr.getConnection();
			String query = "SELECT a.board_notice_no as board_notice_no,a.board_notice_title as board_notice_title"
					 +",a.board_notice_content as board_notice_content"
					 +",to_char(a.board_notice_date,'YYYY/MM/DD') as board_notice_date"
					 +",a.board_notice_imgsrc1 as board_notice_imgsrc1,a.board_notice_imgsrc2 as board_notice_imgsrc2"
					 +",a.member_info_no as member_info_no,b.member_info_nickname as member_info_nickname,"
					 + "a.board_notice_views as board_notice_views"
					 +" FROM board_notice a,member_info b"
					 +" WHERE a.member_info_no = b.member_info_no"
					 +" ORDER BY board_notice_no desc";
			pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs = pstmt.executeQuery();
			int perPage = to.getPerPage(); //5
			int skip = (curPage -1) * perPage;
			if(skip > 0){
				rs.absolute(skip);
			}
			for(int i=0;i<perPage && rs.next();i++){
				 
				 int board_notice_no = rs.getInt("board_notice_no");
				 String board_notice_title =rs.getString("board_notice_title");
				 String board_notice_content = rs.getString("board_notice_content");
				 String board_notice_date = rs.getString("board_notice_date");
				 String board_notice_imgsrc1 = rs.getString("board_notice_imgsrc1");
				 String board_notice_imgsrc2 = rs.getString("board_notice_imgsrc2");
				 String member_info_nickname = rs.getString("member_info_nickname");
				 int board_notice_views = rs.getInt("board_notice_views");
				 int member_info_no = rs.getInt("member_info_no");
				 
				 NoticeDTO data = new NoticeDTO();
				 
				 data.setBoard_notice_no(board_notice_no);
				 data.setBoard_notice_title(board_notice_title);
				 data.setBoard_notice_content(board_notice_content);
				 data.setBoard_notice_date(board_notice_date);
				 data.setBoard_notice_imgsrc1(board_notice_imgsrc1);
				 data.setBoard_notice_imgsrc2(board_notice_imgsrc2);
				 data.setMember_info_nickname(member_info_nickname);
				 data.setBoard_notice_views(board_notice_views);
				 data.setMember_info_no(member_info_no);
				 
				 list.add(data);
			}//end for
			
			to.setList(list); //ArrayList 저장
			to.setTotalCount(totalCount); //전체 레코드 갯수
			to.setCurPage(curPage);
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return to;
	}//end page

	public void update(String _board_notice_no,String _board_notice_title,String _board_notice_content){
		dbMgr = DBConnectionMgr.getInstance();
		try{
			con = dbMgr.getConnection();
			String query = "UPDATE board_notice SET board_notice_title = ? ,board_notice_content = ? WHERE board_notice_no =?";
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,_board_notice_title);
			pstmt.setString(2,_board_notice_content);
			pstmt.setInt(3,Integer.parseInt(_board_notice_no));
			
			int n = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
	}//end update
}//end class
