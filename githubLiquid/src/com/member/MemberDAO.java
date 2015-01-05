package com.member;
/***********************************************************************
 * �۾��� : �̽¿�,������
 * �۾����� : 14.11.10 - 14.11.13 
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� :   
 * �̽¿� : �α��� �����۾�, ����������/ȸ������ �߰� �۾� 
 ***********************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.util.DBConnectionMgr;

public class MemberDAO {
	Connection con = null;//�������
	PreparedStatement pstmt = null;//������ ����|��û
	ResultSet rs = null;//open-cursor-fetch
	DBConnectionMgr dbMgr = null;
	
	
	//�α������� ��ġ�� ���ǿ� ���� ȸ����ȣ,ȸ���г���,ȸ����޹�ȣ ��ȸ SELECT  
	public MemberDTO loginCheck(String member_info_id, String password_SHA) { 
		dbMgr = DBConnectionMgr.getInstance();
		MemberDTO login_dto = null;
		try {
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT member_info_no, member_info_nickname,member_grade_no FROM MEMBER_INFO WHERE member_info_id = ? AND member_info_pw = ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,member_info_id);
				pstmt.setString(2,password_SHA);
				rs = pstmt.executeQuery();
				while(rs.next()){
					login_dto = new MemberDTO();
					login_dto.setMember_info_no(rs.getString("member_info_no"));
					login_dto.setMember_info_nickname(rs.getString("member_info_nickname"));
					login_dto.setMember_grade_no(rs.getString("member_grade_no"));
				}  
			} catch (Exception e) {
				e.printStackTrace(); 
			} finally{
				dbMgr.freeContection(rs, pstmt, con);
			}
			return login_dto; // ��ġ�ϴ� �α�������(id/pw)�� ������� �� : MemberLOginCMD.java���� ����
	}
	
	
	
	//mypage.jsp���� ����� ���� ��ȸ SELECT 
	public MemberDTO memberPageList(String member_info_no){
		dbMgr = DBConnectionMgr.getInstance();
		MemberDTO mypage_dto = null;
		try {
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT a.name as member_info_name,a.grade as grade_name,b.ordercount as order_count FROM (SELECT a.member_info_name as name, b.member_grade_name as grade FROM MEMBER_INFO a, MEMBER_GRADE b WHERE a.member_info_no = ? AND a.member_grade_no = b.member_grade_no ) A,(SELECT count(a.order_no) as orderCount FROM product_order_master a, member_info b WHERE a.member_info_no = b.member_info_no AND a.order_paystatus != '��ۿϷ�' AND b.member_info_no = ?) B");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, member_info_no);
				pstmt.setString(2, member_info_no);
				rs = pstmt.executeQuery();
				while(rs.next()){
					mypage_dto = new MemberDTO();
					mypage_dto.setMember_info_name(rs.getString("member_info_name")); 
					mypage_dto.setMember_grade_name(rs.getString("grade_name"));
					mypage_dto.setOrderCount(rs.getInt("order_count"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return mypage_dto; // ������ ȸ����ȣ�� ������ �˻��ϱ� ������ �� ����.
	}
	
	//ȸ������ ����Ʈ SELECT
	public MemberDTO memberInfoList(String mem_info_no){
		dbMgr = DBConnectionMgr.getInstance();
		MemberDTO data = null;
		try {
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT b.member_grade_no,b.member_grade_name,a.member_info_name, a.member_info_address1,a.member_info_address2,a.member_info_post1,a.member_info_post2, a.member_info_phone, a.member_info_birthday,a.member_info_id,a.member_info_pw,a.member_info_nickname,a.member_info_email,a.member_info_gender FROM MEMBER_INFO a,member_grade b WHERE a.MEMBER_INFO_NO = ? and a.member_grade_no = b.member_grade_no ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, mem_info_no);
				rs = pstmt.executeQuery();
				while(rs.next()){
					data = new MemberDTO();
					data.setMember_grade_no(rs.getString("member_grade_no"));
					data.setMember_grade_name(rs.getString("member_grade_name"));
					data.setMember_info_name(rs.getString("member_info_name"));
					data.setMember_info_address1(rs.getString("member_info_address1"));
					data.setMember_info_address2(rs.getString("member_info_address2"));
					data.setMember_info_post1(rs.getString("member_info_post1"));
					data.setMember_info_post2(rs.getString("member_info_post2"));
					data.setMember_info_phone(rs.getString("member_info_phone"));
					data.setMember_info_birthday(rs.getString("member_info_birthday"));
					data.setMember_info_id(rs.getString("member_info_id"));
					data.setMember_info_pw(rs.getString("member_info_pw"));
					data.setMember_info_nickname(rs.getString("member_info_nickname"));
					data.setMember_info_email(rs.getString("member_info_email"));
					data.setMember_info_gender(rs.getString("member_info_gender"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return data; // ������ ȸ����ȣ�� ������ �˻��ϱ� ������ �� ����.
	}
	
	
	//ȸ������ ���� UPDATE (�н����� ����)
	public int memberInfoUpdate(MemberDTO data){
		dbMgr = DBConnectionMgr.getInstance();
		int update_result = 0;
		try {
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();
				//���ǿ� ��� ȸ����ȣ�� ������ ȸ�������� ȭ�鿡�� �н����带 �����ϰ� ��������
				sql.append("UPDATE member_info SET member_info_nickname = ?, member_info_address1 = ?, member_info_address2 = ?, member_info_post1 = ?, member_info_post2 = ?, member_info_birthday = ?, member_info_gender = ?, member_info_phone = ?,member_info_email = ?   WHERE member_info_no = ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,data.getMember_info_nickname());
				pstmt.setString(2,data.getMember_info_address1());
				pstmt.setString(3,data.getMember_info_address2());
				pstmt.setString(4,data.getMember_info_post1());
				pstmt.setString(5,data.getMember_info_post2());
				pstmt.setString(6,data.getMember_info_birthday());
				pstmt.setString(7,data.getMember_info_gender());
				pstmt.setString(8,data.getMember_info_phone());
				pstmt.setString(9,data.getMember_info_email());
				pstmt.setString(10, data.getMember_info_no());
				update_result = pstmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return update_result; // 0 �Ǵ� 1�̹Ƿ� �� ����
	}

	//ȸ������ INSERT  
	public int memberInfoInsert(MemberDTO data){
		dbMgr = DBConnectionMgr.getInstance();
		int insert_result = 0;
		try {
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO member_info(member_info_no,member_info_id,member_info_nickname,member_info_pw,member_info_name,member_info_birthday,member_info_gender,member_info_address1,member_info_address2,member_info_post1,member_info_post2,member_info_phone,member_info_email) values(member_info_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, data.getMember_info_id());
				pstmt.setString(2, data.getMember_info_nickname());
				pstmt.setString(3, data.getMember_info_pw());
				pstmt.setString(4, data.getMember_info_name());
				pstmt.setString(5, data.getMember_info_birthday());
				pstmt.setString(6, data.getMember_info_gender());
				pstmt.setString(7, data.getMember_info_address1());
				pstmt.setString(8, data.getMember_info_address2());
				pstmt.setString(9, data.getMember_info_post1());
				pstmt.setString(10, data.getMember_info_post2());
				pstmt.setString(11, data.getMember_info_phone());
				pstmt.setString(12, data.getMember_info_email());
				insert_result = pstmt.executeUpdate(); 
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return insert_result; // 0 �Ǵ� 1�̹Ƿ� �� ����
	}
	
	//ȸ������ PASSWORD�� ���� // �̱���
	public int memberPWUpdate(String PASSWORD){
		int update_result = 0;
		// �� �� �� ��
		return update_result; // 0�Ǵ� 1�̹Ƿ� �� ����
	}
	//ȸ�����Խ� ���̵� �г��� �ߺ�üũ
	public int confirm(String member_info_id, String member_info_nickname ) {
		dbMgr = DBConnectionMgr.getInstance();
		int insert_result = 0;
		try {
			 con = dbMgr.getConnection();
			 StringBuffer sql = new StringBuffer();
			 
		     if (member_info_id != null){
		    	 sql.append("SELECT member_info_id FROM member_info WHERE member_info_id = ?");
		    	 pstmt = con.prepareStatement(sql.toString());
				 pstmt.setString(1, member_info_id);
			 
		     } else if (member_info_nickname != null){
		    	 sql.append("SELECT member_info_nickname FROM member_info  WHERE member_info_nickname = ?");
		    	 pstmt = con.prepareStatement(sql.toString());
				 pstmt.setString(1, member_info_nickname);
			 }
			 rs = pstmt.executeQuery();
				if(rs.next()){
					insert_result = 1; //�ش� ���̵� ����
				}
	        } catch(Exception e) {
	             e.printStackTrace(); 
	        } finally {
	        	dbMgr.freeContection(rs, pstmt, con);
	        }
			return insert_result;
		}
}
