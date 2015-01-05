package com.util;
/***********************************************************************
 * 작업자 : 이승우
 * 작업일자 : 2014.10.31
 * 어떤 파일에 호출받는가 : 각 패키지별 DAO
 * 어떤 파일을 호출하는가 : 
 * 파일 타입 : DB정보 
 ***********************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnectionMgr {
	static DBConnectionMgr instance = null;
	static DataSource dataFactory = null;
	public DBConnectionMgr(){
	}
	public static DBConnectionMgr getInstance(){
		try {
			Context ctx = new InitialContext();
			//127.0.0.1 개인 test
//			dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/liquid_test"); 
			//172.16.9.31 실제 서버테스트
			dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/liquid");
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(instance == null)
				instance=new DBConnectionMgr();
		return instance;
	}
	public Connection getConnection(){
		Connection con = null;
		try {
			con = dataFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return con;
	}
	//사용한 자원 반납하기
	public void freeContection( ResultSet rs,PreparedStatement pstmt, Connection con){
		try {
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
}
