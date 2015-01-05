package com.review;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.util.DBConnectionMgr;

public class DetailreviewListDAO {

	Logger logger = Logger.getLogger(DetailreviewListDAO.class);
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = null;
	
	//상품번호에 따른 상품 상세페이지 SELECT
	public ArrayList<DetailReviewDTO> reviewList(String product_no){
		dbMgr = DBConnectionMgr.getInstance();
		DetailReviewDTO data = null;
		ArrayList<DetailReviewDTO> list = new ArrayList<DetailReviewDTO>();
		try {
			con = dbMgr.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_review_no, board_review_content, Board_review_date, "
					+ "member_info_nickname, Board_review_besong, board_review_sangpum "
					+ "from BOARD_REVIEW a, member_info b "
					+ "where product_no = ? "
					+ "and b.member_info_no in a.member_info_no ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, product_no);
			rs = pstmt.executeQuery();
			while (rs.next()){
				data = new DetailReviewDTO();
				data.setBoard_review_content(rs.getString("Board_review_content"));
				data.setBoard_review_date(rs.getString("Board_review_date"));
				data.setBoard_review_no(rs.getInt("Board_review_NO"));
				data.setMember_info_nickname(rs.getString("member_info_nickname"));
				data.setBesong(rs.getInt("Board_review_besong"));
				data.setSangpum(rs.getInt("Board_review_sangpum"));
				list.add(data);
			}// end while			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
	return list;	
	}// end reviewList
	
	//상풍평 등록
	public int reviewWrite(DetailReviewDTO dto){
		
		System.out.println(dto.getBoard_review_content());
		System.out.println(dto.getMember_info_no());
		System.out.println(dto.getProduct_no());
		System.out.println(dto.getBesong());
		System.out.println(dto.getSangpum());
		
		System.out.println("라이터 메소드");
		dbMgr = DBConnectionMgr.getInstance();
		PreparedStatement pstmt_va = null;
		StringBuffer sql = new StringBuffer();
		
		
		try{	//상품평 게시판에 작성하는 쿼리
			
			con = dbMgr.getConnection();
			System.out.print("write");
			sql.append("select 1 from board_review where product_no = ? and member_info_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getProduct_no());
			pstmt.setInt(2, dto.getMember_info_no());
			rs = pstmt.executeQuery();
			
			if(!rs.next()){
				System.out.print("rs next 참 데이터 없음");
			pstmt.clearParameters();
			
			sql.setLength(0);
			sql.append("insert into Board_review "
					+ "(BOARD_REVIEW_NO, BOARD_REVIEW_CONTENT, "
					+ "BOARD_REVIEW_DATE, MEMBER_INFO_NO, PRODUCT_NO, BOARD_REVIEW_BESONG, BOARD_REVIEW_SANGPUM) "
					+ "values (Board_review_seq.nextval, ?, sysdate,?,?,?,?)");
				//상품 게시판에 점수를 저장하는 쿼리
			StringBuffer sql_se = new StringBuffer();
			sql_se.append("update product set product_sangpum = product_sangpum + ? "
					+ ", product_besong = product_besong + ? "
					+ ", product_review_count = product_review_count + 1 "
					+ "where product_no = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			System.out.println(dto.getSangpum());
			pstmt.setString(1, dto.getBoard_review_content());
			pstmt.setInt(2, dto.getMember_info_no());
			pstmt.setInt(3, dto.getProduct_no());
			pstmt.setInt(4, dto.getBesong());
			pstmt.setInt(5, dto.getSangpum());
			int n = pstmt.executeUpdate();
			
			if(n == 1){
				pstmt_va = con.prepareStatement(sql_se.toString());
				pstmt_va.setInt(1, dto.getSangpum());
				pstmt_va.setInt(2, dto.getBesong());
				pstmt_va.setInt(3, dto.getProduct_no());
				pstmt_va.executeUpdate();
			}
			}else{
				System.out.println("rs next 거짓 데이터 있음");
				return 1;  // 1이면 아이디 중복
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt_va, con);
			try{
				if(pstmt !=null) pstmt.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end catch
		}//and finally
		return 2;		//2이면 평가 등록
	}// end write method
	
	public int reviewDelete(DetailReviewDTO dto){
		dbMgr = DBConnectionMgr.getInstance();
		con = dbMgr.getConnection();
		System.out.print("delete");
		StringBuffer sql = new StringBuffer();
		int fin = 0;
		try{
			sql.append("select product_no, board_review_besong, board_review_sangpum "
					+ "from board_review "
					+ "where board_review_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			System.out.println(dto.getBoard_review_no());
			pstmt.setInt(1, dto.getBoard_review_no());
			rs = pstmt.executeQuery();
			System.out.println("1");
			if(rs.next()){
				dto.setProduct_no(rs.getInt("product_no"));
				dto.setBesong(rs.getInt("board_review_besong"));
				dto.setSangpum(rs.getInt("board_review_sangpum"));
			}// end if
			sql.setLength(0);
			
			// 테스트
			System.out.println(dto.getProduct_no());
			System.out.println(dto.getBoard_review_no());
			
			sql.append("delete from board_review where board_review_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getBoard_review_no());
			int n = pstmt.executeUpdate();
			System.out.println(n);
			if(n != 0){
				System.out.println("2.5");
				sql.setLength(0);
				sql.append("update product set product_sangpum =  product_sangpum - ? , "
						+ "product_besong = product_besong - ? , "
						+ "product_review_count = product_review_count - 1 where product_no = ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, dto.getSangpum());
				pstmt.setInt(2, dto.getBesong());
				pstmt.setInt(3, dto.getProduct_no());
				fin = pstmt.executeUpdate();
				if(fin != 0){
					fin = dto.getProduct_no();
				}
				System.out.println("3");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return fin;
	}
	
	public int reviewUpdate(DetailReviewDTO dto){
		dbMgr = DBConnectionMgr.getInstance();
		con = dbMgr.getConnection();
		System.out.print("delete");
		StringBuffer sql = new StringBuffer();
		int fin = 0;
		try{
			sql.append("select product_no, board_review_besong, board_review_sangpum "
					+ "from board_review "
					+ "where board_review_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			System.out.println(dto.getBoard_review_no());
			pstmt.setInt(1, dto.getBoard_review_no());
			rs = pstmt.executeQuery();
			System.out.println("1");
			if(rs.next()){
				dto.setProduct_no(rs.getInt("product_no"));
				dto.setBesong(rs.getInt("board_review_besong"));
				dto.setSangpum(rs.getInt("board_review_sangpum"));
			}// end if
			sql.setLength(0);
			
			// 테스트
			System.out.println(dto.getProduct_no());
			System.out.println(dto.getBoard_review_no());
			
			sql.append("delete from board_review where board_review_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getBoard_review_no());
			int n = pstmt.executeUpdate();
			System.out.println(n);
			if(n != 0){
				System.out.println("2.5");
				sql.setLength(0);
				sql.append("update product set product_sangpum =  product_sangpum - ? , "
						+ "product_besong = product_besong - ? , "
						+ "product_review_count = product_review_count - 1 where product_no = ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, dto.getSangpum());
				pstmt.setInt(2, dto.getBesong());
				pstmt.setInt(3, dto.getProduct_no());
				fin = pstmt.executeUpdate();
				if(fin != 0){
					fin = dto.getProduct_no();
				}
				System.out.println("3");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return fin;
	}
	
}//end class


















