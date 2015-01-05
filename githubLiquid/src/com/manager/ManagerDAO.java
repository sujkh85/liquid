package com.manager;
/***********************************************************************
 * �۾��� : ��ȫ��
 * �۾����� : 14.11.25
 * � ���Ͽ� ȣ��޴°� :  com.manager��Ű���� ��� CMD
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� :  
 ***********************************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.member.MemberDTO;
import com.util.DBConnectionMgr;

public class ManagerDAO {//������
	Logger logger = Logger.getLogger(ManagerDAO.class);
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = null;
	
	
	//�Ա�Ȯ��
public void managerorderPayment(int order_no,int order_money){
		
		dbMgr = DBConnectionMgr.getInstance();
		 
		 try{
			 con = dbMgr.getConnection();
			 
			 String query =  "UPDATE product_order_master"
			 		+ " SET order_paydate=to_char(sysdate,'YYYY/MM/DD')"
			 		+ ",order_waybillno=order_waybillno_seq.NEXTVAL"
			 		+ ",order_final_money=?"
			 		+ ",order_paystatus='��۴��'"
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
	
	
	//�ֹ� �� ����
	public ArrayList<ManagerOrderDetailDTO> orderdetail(int order_no){
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerOrderDetailDTO> list= new ArrayList<ManagerOrderDetailDTO>();
		try {
			con = dbMgr.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select * from product_order_master a,member_info b where order_no = ? and a.member_info_no = b.member_info_no ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, order_no);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ManagerOrderDetailDTO dto = new ManagerOrderDetailDTO();
				dto.setOrder_no(rs.getInt("order_no"));
				dto.setMember_info_name(rs.getString("member_info_name"));
				dto.setMember_info_no(rs.getInt("member_info_no"));
				dto.setOrder_date(rs.getString("order_date"));
				dto.setOrder_paystatus(rs.getString("order_paystatus"));
				dto.setOrder_payment(rs.getString("order_payment"));
				dto.setOrder_address1(rs.getString("order_address1"));
				dto.setOrder_address2(rs.getString("order_address2"));
				dto.setOrder_post1(rs.getString("order_post1"));
				dto.setOrder_post2(rs.getString("order_post2"));
				dto.setOrder_message(rs.getString("order_message"));
				dto.setOrder_money(rs.getInt("order_money"));
				dto.setOrder_final_money(rs.getInt("order_final_money"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return list;
	}
	
	
	
	
	
	//���������������� ȸ������ ����
	public int managermemberInfoUpdate(MemberDTO data){
		logger.info("managermemberInfoUpdateȣ��");
		dbMgr = DBConnectionMgr.getInstance();
		int update_result = 1;
		
		try {
				con = dbMgr.getConnection();
				StringBuffer sql = new StringBuffer();
				//���ǿ� ��� ȸ����ȣ�� ������ ȸ�������� ȭ�鿡�� �н����带 �����ϰ� ��������
				sql.append("UPDATE member_info SET member_info_nickname = ?, member_info_address1 = ?, member_info_address2 = ?, member_info_post1 = ?, member_info_post2 = ?, member_info_birthday = ?, member_info_gender = ?, member_info_phone = ?,member_info_email = ? , member_grade_no=?  WHERE member_info_no = ?");
				
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
				pstmt.setString(10, data.getMember_grade_no());
				pstmt.setString(11, data.getMember_info_no());
				update_result = pstmt.executeUpdate(); 
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				dbMgr.freeContection(rs, pstmt, con);
			}
			return update_result; // 0 �Ǵ� 1�̹Ƿ� �� ����
		}
		
	
	//ȸ�������� ����¡ó��
		//����¡ ó�� : ��ü ���ڵ� ���� ���ϱ�
			public int totalCount(){
				dbMgr = DBConnectionMgr.getInstance();
				int count = 0;
					try {
						con = dbMgr.getConnection();
						String query = "SELECT count(*) FROM member_info";
						pstmt = con.prepareStatement(query);
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
		
		//ȸ������(������..)
//		public ArrayList<ManagerMemberListDTO> memberList(){
		public ManagerPageTO memberList(int curPage,String align){	
			
			ManagerPageTO to = new ManagerPageTO();//�߰�
			int totalCount = totalCount();			//�߰�
			ArrayList<ManagerMemberListDTO> list= new ArrayList<ManagerMemberListDTO>();
			dbMgr = DBConnectionMgr.getInstance();
			try {
				con=dbMgr.getConnection();
				StringBuffer query=new StringBuffer();
				
					query.append("	SELECT ROWNUM,                             ");
					query.append("       a.member_info_id,                     ");
					query.append("       a.member_info_no,                     ");
					query.append("       a.member_grade_no,                    ");
					query.append("       b.member_grade_name,                  ");
					query.append("       a.member_info_name,                   ");
					query.append("       a.member_info_date,                   ");
					query.append("       a.member_info_phone                   ");
					query.append("  FROM member_info a,member_grade b          ");
					query.append("  where a.member_grade_no=b.member_grade_no  ");
					if("asc".equals(align)){
					query.append("  order by a.member_info_date asc    ");
					}else if("desc".equals(align)){
					query.append("  order by a.member_info_date desc    ");
					}
					pstmt=con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					rs=pstmt.executeQuery();
					
					int perPage = to.getPerPage(); //5   //
					int skip = (curPage -1)*perPage;	//�߰�
					if(skip>0){							//
						rs.absolute(skip);				//
					}
					
					
					//while(rs.next()){
					for(int i=0; i<perPage && rs.next(); i++){
						ManagerMemberListDTO dto=new ManagerMemberListDTO();
						dto.setRownum(rs.getInt("rownum"));
						dto.setMember_info_id(rs.getString("member_info_id"));
						dto.setMember_info_no(rs.getInt("member_info_no"));
						dto.setMember_grade_no(rs.getInt("member_grade_no"));
						dto.setMember_grade_name(rs.getString("member_grade_name"));
						dto.setMember_info_name(rs.getString("member_info_name"));
						dto.setMember_info_date(rs.getDate("member_info_date"));
						dto.setMember_info_phone(rs.getString("member_info_phone"));
						
						list.add(dto);
					}//���� ��
					
					to.setList(list);  //ArrayList ����
					to.setTotalCount(totalCount); //��ü ���ڵ� ����
					to.setCurPage(curPage); //���� ������	
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				dbMgr.freeContection(rs, pstmt, con);
			}
//			return list;
			return to;
		}
	
	
	//ȸ������(�󼼸��..)
	public ArrayList<ManagerMemberListDTO> memberDetailList(int member_info_no){
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerMemberListDTO> list= new ArrayList<ManagerMemberListDTO>();
		
		try {
			con=dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			
			query.append("	SELECT a.member_info_no,                      ");
			query.append("       a.member_grade_no,                       ");
			query.append("       b.member_grade_name,                     ");
			query.append("        a.member_info_id,                       ");
			query.append("       a.member_info_name,                      ");
			query.append("       a.member_info_address1,                  ");
			query.append("       a.member_info_address2,                  ");
			query.append("       a.member_info_post1,                     ");
			query.append("       a.member_info_post2,                     ");
			query.append("       a.member_info_phone,                     ");
			query.append("       a.member_info_gender,                    ");
			query.append("       a.member_info_birthday,                  ");
			query.append("       to_char(a.member_info_date,'YYYY-MM-DD') as member_info_date, ");
			query.append("       a.member_info_pw,                         ");
			query.append("       a.member_info_nickname,                   ");
			query.append("       a.member_info_email                       ");
			query.append("  FROM member_info a, member_grade b             ");
			query.append("  where a.member_grade_no = b.member_grade_no    ");
			query.append("	and  a.member_info_no = ?					   ");
			
			pstmt=con.prepareStatement(query.toString());
			pstmt.setInt(1, member_info_no);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ManagerMemberListDTO dto=new ManagerMemberListDTO();
				dto.setMember_info_no(rs.getInt("member_info_no"));
				dto.setMember_info_name(rs.getString("member_info_name"));
				dto.setMember_info_address1(rs.getString("member_info_address1"));
				dto.setMember_info_address2(rs.getString("member_info_address2"));
				dto.setMember_info_post1(rs.getString("member_info_post1"));
				dto.setMember_info_post2(rs.getString("member_info_post2"));
				dto.setMember_info_gender(rs.getString("member_info_gender"));
				dto.setMember_info_birthday(rs.getString("member_info_birthday"));
				dto.setMember_info_date(rs.getDate("member_info_date"));
				dto.setMember_info_id(rs.getString("member_info_id"));
				dto.setMember_info_pw(rs.getString("member_info_pw"));
				dto.setMember_info_nickname(rs.getString("member_info_nickname"));
				dto.setMember_info_email(rs.getString("member_info_email"));
				dto.setMember_grade_no(rs.getInt("member_grade_no"));
				dto.setMember_grade_name(rs.getString("member_grade_name"));
				dto.setMember_info_phone(rs.getString("member_info_phone"));
				
				list.add(dto);
				
			}
//			to.setList(list);  //ArrayList ����
//			to.setTotalCount(totalCount); //��ü ���ڵ� ����
//			to.setCurPage(curPage); //���� ������	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		
		return list;
		
	}
	
	//ȸ������(��������)�߰�����..
	
	
	
	
	
	
	
	//�ֹ�����(�����ֹ��Ǽ� ī��Ʈ)
	//�����ֹ��Ǽ�����¡ó��
	public int totalCount_todayOrder(String order_date){
		dbMgr = DBConnectionMgr.getInstance();
		int count = 0;
		
			try {
				con = dbMgr.getConnection();
				StringBuffer query = new StringBuffer();
				
				query.append(" SELECT COUNT (*)                                           ");
				query.append("   FROM member_info a, product_order_master b               ");
				query.append("  WHERE     a.member_info_no = b.member_info_no             ");
				query.append("   and b.order_date between  to_char(sysdate-?,'YYYY/MM/DD')  and  to_char(sysdate,'YYYY/MM/DD')  ");
				                                                                          
				pstmt = con.prepareStatement(query.toString());
				pstmt.setString(1, order_date);
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
	public ManagerPageTO todayOrder(int curPage,String order_date){
		logger.info(order_date);
		ManagerPageTO to = new ManagerPageTO();//�߰�
		int totalCount = totalCount_todayOrder(order_date);			//�߰�
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerTodayOrderDTO> list= new ArrayList<ManagerTodayOrderDTO>();
		try {
			con=dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
		query.append("	 select rownum                                     ");
        query.append("     ,b.order_no                                     ");
        query.append("     ,a.member_info_name                             ");
        query.append("     ,b.order_date				                   ");
        query.append("     ,b.order_paystatus                              ");
        query.append("     ,b.order_payment                                ");
        query.append("     ,a.member_info_phone                            ");
        query.append("     ,b.order_final_money                            ");
        query.append("   from member_info a,product_order_master b         ");
        query.append("   where a.member_info_no=b.member_info_no           ");
        query.append("   and b.order_date between  to_char(sysdate-?,'YYYY/MM/DD')  and  to_char(sysdate,'YYYY/MM/DD')  ");
        query.append("   order by b.order_no desc  ");
        
        
        pstmt=con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstmt.setString(1, order_date);
		rs=pstmt.executeQuery();
		int perPage = to.getPerPage(); //�� �������� ������ row ��
		int skip = (curPage -1)*perPage;
		if(skip>0){
			rs.absolute(skip);
		}
	// while(rs.next()){
		 for(int i=0; i<perPage && rs.next(); i++){
        	ManagerTodayOrderDTO dto=new ManagerTodayOrderDTO();
        	dto.setRownum(rs.getInt("rownum"));
        	dto.setOrder_no(rs.getInt("order_no"));
        	dto.setMember_info_name(rs.getString("member_info_name"));
        	dto.setOrder_date(rs.getString("order_date"));
        	dto.setOrder_paystatus(rs.getString("order_paystatus"));
        	dto.setOrder_payment(rs.getString("order_payment"));
        	dto.setMember_info_phone(rs.getString("member_info_phone"));
        	dto.setOrder_final_money(rs.getInt("order_final_money"));
        	
        	list.add(dto);
        	}
		 to.setList_todayorder(list);  //ArrayList ����
			to.setTotalCount(totalCount); //��ü ���ڵ� ����
			to.setCurPage(curPage); //���� ������
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return to;
	}
	
	
		
	//�ֹ�����( �ֹ�����  ���� (�����Ϸ�,����߹��̷���...))
	//�ֹ���������¡ó��
		public int totalCount_orderStatus(String order_paystatus){
			dbMgr = DBConnectionMgr.getInstance();
			int count = 0;
			
				try {
					con = dbMgr.getConnection();
					String query =   "	 select count(*)                              	    "         
					                +"   from member_info a,product_order_master b 			"			                     
					                +"   where a.member_info_no=b.member_info_no  	 		"
					                +"   and order_paystatus=?                    	 		";
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, order_paystatus);
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
		
	public ManagerPageTO orderStatus(String order_paystatus, int curPage){
		ManagerPageTO to = new ManagerPageTO();//�߰�
		int totalCount = totalCount_orderStatus(order_paystatus);			//�߰�
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerOrderStatusDTO> list= new ArrayList<ManagerOrderStatusDTO>();
		try {
			con=dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			
			query.append("	 select                              ");
	        query.append("      b.order_no                             ");
	        query.append("     ,a.member_info_name                     ");
	        query.append("     ,b.order_date,b.order_paystatus         ");
	        query.append("     ,b.order_payment                        ");
	        query.append("     ,a.member_info_phone                    ");
	        query.append("     ,b.order_final_money                    ");
	        query.append("     ,b.order_money                    ");
	        query.append("  from member_info a,product_order_master b  ");
	        query.append("  where a.member_info_no=b.member_info_no    ");
	        query.append("  and order_paystatus=?                      ");
	        query.append("  order by b.order_no desc                      ");
	        
	        pstmt=con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        pstmt.setString(1, order_paystatus);
	        rs=pstmt.executeQuery();
	        int perPage = to.getPerPage(); //�� �������� ������ row ��
			int skip = (curPage -1)*perPage;
			if(skip>0){
				rs.absolute(skip);
			}
			 for(int i=0; i<perPage && rs.next(); i++){
			
	        	ManagerOrderStatusDTO dto = new ManagerOrderStatusDTO();
	        	/*dto.setRownum(rs.getInt("rownum"));*/
	        	dto.setOrder_no(rs.getInt("order_no"));
	        	dto.setMember_info_name(rs.getString("member_info_name"));
	        	dto.setOrder_date(rs.getString("order_date"));
	        	dto.setOrder_paystatus(rs.getString("order_paystatus"));
	        	dto.setOrder_payment(rs.getString("order_payment"));
	        	dto.setMember_info_phone(rs.getString("member_info_phone"));
	        	dto.setOrder_final_money(rs.getInt("order_final_money"));
	        	dto.setOrder_money(rs.getInt("order_money"));
	        	
	        	list.add(dto);
	        }
			 	to.setList_orderstatus(list);  //ArrayList ����
				to.setTotalCount(totalCount); //��ü ���ڵ� ����
				to.setCurPage(curPage); //���� ������
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return to;
	}
	
	
	//�ֹ����� (�ֹ� ���� ����)
	public String orderStatusChange(String order_no,String order_paystatus){
		dbMgr = DBConnectionMgr.getInstance();
		//logger.info(order_paystatus+"�Ķ���ͷ� �޾ƿ°�");
		try {
			con=dbMgr.getConnection();
			StringBuffer query = new StringBuffer();
			
				query.append(" UPDATE product_order_master ");
				query.append("    SET order_paystatus = ?  ");
				query.append("  WHERE order_no = ?         ");
				
			pstmt=con.prepareStatement(query.toString());
			if("��۴��".equals(order_paystatus)){
				order_paystatus="��ǰ�غ���";
				//logger.info(order_paystatus+"if���� ��۴�� �ɸ���?");
			}else if("��ǰ�غ���".equals(order_paystatus)){
				order_paystatus="��ǰ�����";
			}else if("��ǰ�����".equals(order_paystatus)){
				order_paystatus="��ۿϷ�";
			}else if("�Աݴ��".equals(order_paystatus)){
				order_paystatus="��۴��";
			}
			pstmt.setString(1, order_paystatus);
			pstmt.setString(2, order_no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(null, pstmt, con);
		}
		return order_paystatus;
	}
	
	
	//�ֹ� ��ü��� ��ȸ
	//�ֹ� ��ü��� ����¡ó��. �� ���������ΰ� ������.
			public int totalCount_ordersearchlist(){
				dbMgr = DBConnectionMgr.getInstance();
				int count = 0;
				
					try {
						con = dbMgr.getConnection();
						String query =   "	 select count(*)              	    "         
						                +"   from member_info a,product_order_master b		"			                     
						                +"   where a.member_info_no=b.member_info_no		";
						pstmt = con.prepareStatement(query);
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
	
	
	
	
	public ManagerPageTO ordersearchlist(int curPage){
		ManagerPageTO to = new ManagerPageTO();//�߰�
		int totalCount = totalCount_ordersearchlist();			//�߰�
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerOrderStatusDTO> list= new ArrayList<ManagerOrderStatusDTO>();
		try {
			con=dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			
					query.append("   select rownum                             ");
		            query.append("   ,b.order_no                               ");
		            query.append("  ,a.member_info_name                        ");
		            query.append("   ,b.order_date,b.order_paystatus           ");
		            query.append("  ,b.order_payment                           ");
		            query.append("  ,a.member_info_phone                       ");
		            query.append("  ,b.order_final_money                       ");
		            query.append("  from member_info a,product_order_master b  ");
		            query.append("  where a.member_info_no=b.member_info_no    ");
		            query.append("  order by b.order_no desc    ");
		            
		            pstmt=con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		            rs=pstmt.executeQuery();
		            int perPage = to.getPerPage(); //�� �������� ������ row ��
					int skip = (curPage -1)*perPage;
					if(skip>0){
						rs.absolute(skip);
					}
					 for(int i=0; i<perPage && rs.next(); i++){
		            	ManagerOrderStatusDTO dto = new ManagerOrderStatusDTO();
			        	dto.setRownum(rs.getInt("rownum"));
			        	dto.setOrder_no(rs.getInt("order_no"));
			        	dto.setMember_info_name(rs.getString("member_info_name"));
			        	dto.setOrder_date(rs.getString("order_date"));
			        	dto.setOrder_paystatus(rs.getString("order_paystatus"));
			        	dto.setOrder_payment(rs.getString("order_payment"));
			        	dto.setMember_info_phone(rs.getString("member_info_phone"));
			        	dto.setOrder_final_money(rs.getInt("order_final_money"));
			        	
			        	list.add(dto);
		            	
		            }
						to.setList_orderstatus(list);  //ArrayList ����
						to.setTotalCount(totalCount); //��ü ���ڵ� ����
						to.setCurPage(curPage); //���� ������
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return to;
	}
	
	
	
	
	
	//������(�α��ǰ)
	//�α������ ����¡ó��
		public int totalCount_bestitem(){
			dbMgr = DBConnectionMgr.getInstance();
			int count = 0;
			
				try {
					con = dbMgr.getConnection();
					String query =   "	SELECT count(*)                                                    "         
									+"	FROM (  SELECT b.product_no NO,                                    "
									+"	          c.product_name NAME,                                     "
									+"	          MAX (c.product_price) PRICE,                             "
									+"	          SUM (a.order_detail_quantity) SALES                      "
									+"	     FROM PRODUCT_ORDER_DETAIL a, STOCK b, PRODUCT c               "
									+"	    WHERE a.stock_no = b.stock_no AND b.product_no = c.product_no  "
									+"	 GROUP BY b.product_no, c.product_name )                           ";
					pstmt = con.prepareStatement(query);
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
	
	
	public ManagerPageTO bestItem(int curPage){
		ManagerPageTO to = new ManagerPageTO();//�߰�
		int totalCount = totalCount_bestitem();			//�߰�
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerBestItemDTO> list_bestitem= new ArrayList<ManagerBestItemDTO>();
		try {
			con=dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			
			query.append(" SELECT ROWNUM,                                                     ");
            query.append(" no,                                                                ");
            query.append(" name,                                                              ");
            query.append(" price,                                                             ");
            query.append(" sales                                                              ");
            query.append(" FROM (  SELECT b.product_no NO,                                    ");
            query.append("           c.product_name NAME,                                     ");
            query.append("           MAX (c.product_price) PRICE,                             ");
            query.append("           SUM (a.order_detail_quantity) SALES                      ");
            query.append("      FROM PRODUCT_ORDER_DETAIL a, STOCK b, PRODUCT c               ");
            query.append("     WHERE a.stock_no = b.stock_no AND b.product_no = c.product_no  "); 
            query.append("  GROUP BY b.product_no, c.product_name                             ");
            query.append("  ORDER BY SUM (a.order_detail_quantity) DESC)                      ");
			
            pstmt=con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    		rs=pstmt.executeQuery();
    		
    		int perPage = to.getPerPage(); //4   //
			int skip = (curPage -1)*perPage;	//�߰�
			if(skip>0){							//
				rs.absolute(skip);				//
			}
    		
    		
    		//while(rs.next()){
    		for(int i=0; i<perPage && rs.next(); i++){	
    			ManagerBestItemDTO dto = new ManagerBestItemDTO();
    			dto.setRownum(rs.getInt("rownum"));
    			dto.setNo(rs.getInt("no"));
    			dto.setName(rs.getString("name"));
    			dto.setPrice(rs.getInt("price"));
    			dto.setSales(rs.getInt("sales"));
    			
    			list_bestitem.add(dto);
    			}//end for
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		
		to.setList_bestitem(list_bestitem);  //ArrayList ����
		to.setTotalCount(totalCount); //��ü ���ڵ� ����
		to.setCurPage(curPage); //���� ������	
		
		return to;
	}
	
	
	
	
	//������(��ǰ�� ����)
	//��ǰ������ ���÷���
	public int totalCount_productSales(){
		dbMgr = DBConnectionMgr.getInstance();
		int count = 0;
		
			try {
				con = dbMgr.getConnection();
				StringBuffer query=new StringBuffer();
				
				query.append("	select count(*) 															 ");
				query.append("	    from (  																 ");  
				query.append("	    select a.product_name,c.stock_size                           	         ");
				query.append("	          ,max(a.product_price) as price                                     ");
				query.append("	          ,sum(b.order_detail_quantity) as quantity                          ");
				query.append("	          ,max(a.product_price)*sum(b.order_detail_quantity) as finalmoney   ");
				query.append("	from product a,product_order_detail b,stock c,product_order_master d         ");
				query.append("	where a.product_no=c.product_no                                              ");
				query.append("	and     c.stock_no=b.stock_no                                                ");
				query.append("	and     d.order_no=b.order_no                                                ");
				query.append("	group by a.product_name , c.stock_size                                       ");
				query.append("	order by product_name     )          										 ");
				
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
	
	public ManagerPageTO productSales(int curPage){
		ManagerPageTO to = new ManagerPageTO();//�߰�
		int totalCount = totalCount_productSales();			//�߰�
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerProductSalesDTO> list_productsales = new ArrayList<ManagerProductSalesDTO>();
		try {
			con=dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			
			query.append("			select a.product_name,c.stock_size,a.product_no                                  ");
			query.append("	          ,max(a.product_price) as price                                    ");
			query.append("	          ,sum(b.order_detail_quantity) as quantity                         ");
			query.append("	          ,max(a.product_price)*sum(b.order_detail_quantity) as finalmoney  ");
			query.append("	from product a,product_order_detail b,stock c,product_order_master d        ");
			query.append("	where a.product_no=c.product_no                                             ");
			query.append("	and     c.stock_no=b.stock_no                                               ");
			query.append("	and     d.order_no=b.order_no                                               ");
			query.append("	group by a.product_name , c.stock_size ,a.product_no                                      ");
			query.append("	order by product_name                                                       ");
			
		    pstmt=con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    		rs=pstmt.executeQuery();
    		int perPage = to.getPerPage(); //4   //
			int skip = (curPage -1)*perPage;	//�߰�
			if(skip>0){							//
				rs.absolute(skip);				//
			}
    		for(int i=0; i<perPage && rs.next(); i++){	
    			ManagerProductSalesDTO dto = new ManagerProductSalesDTO();
    			dto.setProduct_name(rs.getString("product_name"));
    			dto.setStock_size(rs.getString("stock_size"));
    			dto.setPrice(rs.getInt("price"));
    			dto.setQuantity(rs.getInt("quantity"));
    			dto.setFinalmoney(rs.getInt("finalmoney"));
    			dto.setProduct_no(rs.getInt("product_no"));
    			
    			list_productsales.add(dto);
    		}
		    
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		to.setList_productsales(list_productsales);  //ArrayList ����
		to.setTotalCount(totalCount); //��ü ���ڵ� ����
		to.setCurPage(curPage); //���� ������	
		return to;
	}
	
	
	//�������(�Ϻ���..)
	//�������(�Ϻ���) ����¡ó��
	public int totalCount_daySales(){
		logger.info("�ϸ��� ȣ��");
		dbMgr = DBConnectionMgr.getInstance();
		int count = 0;
		
			try {
				con = dbMgr.getConnection();
				StringBuffer query=new StringBuffer();
				////////////////////////////////////////////////////
				 query.append("	SELECT COUNT(*)                                                                 ");
				 query.append("	  FROM(SELECT orderdate,                                                        ");
				 query.append("    		SUM (finalmoney) AS finalmoney,                                         ");
				 query.append("    		SUM (quantity) AS quantity,                                             ");
				 query.append("   		COUNT (ordercount) AS ordercount                                        ");
				 query.append("  		FROM (  SELECT a.order_paydate AS orderdate,                            ");
				 query.append("         SUM (b.order_detail_quantity) AS quantity,                              ");
				 query.append("         a.order_final_money AS finalmoney,                                      ");
				 query.append("         a.order_no AS ordercount                                                ");
				 query.append("         FROM product_order_master a, product_order_detail b                     ");
				 query.append("         WHERE     order_paydate BETWEEN TO_CHAR (SYSDATE - 31,('YYYY/MM/DD'))   ");     
				 query.append("                                    AND TO_CHAR (SYSDATE, ('YYYY/MM/DD'))        ");
				 query.append("                                    AND a.order_no = b.order_no                  ");             
				 query.append("                                     and a.order_paystatus != '�ֹ����'            ");             
				 query.append("     GROUP BY a.order_final_money, a.order_paydate, a.order_no)                  ");
				 query.append("     GROUP BY orderdate                                                          ");
				 query.append("     order BY orderdate )                                                        ");
				                                                                                                
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
	}//end totalCount_daysales()
	public ManagerPageTO daySales(int curPage){
		ManagerPageTO to = new ManagerPageTO();
		int totalCount = totalCount_daySales();
		
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerSalesDTO> list= new ArrayList<ManagerSalesDTO>();
		try {
			con=dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			
			query.append("	SELECT orderdate,                                                       ");
	        query.append("    SUM (finalmoney) AS finalmoney,                                       ");
	        query.append("    SUM (quantity) AS quantity,                                           ");
	        query.append("    COUNT (ordercount) AS ordercount                                      ");
	        query.append("    FROM (  SELECT a.order_date AS orderdate,                          ");
	        query.append("              SUM (b.order_detail_quantity) AS quantity,                  ");
	        query.append("              a.order_final_money AS finalmoney,                          ");
	        query.append("              a.order_no AS ordercount                                    ");
	        query.append("         FROM product_order_master a, product_order_detail b              ");
	        query.append("        WHERE     order_date BETWEEN TO_CHAR (SYSDATE - 31,            ");
	        query.append("                                                 ('YYYY/MM/DD'))          ");
	        query.append("                                    AND TO_CHAR (SYSDATE, ('YYYY/MM/DD')) "); 
	        query.append("              AND a.order_no = b.order_no                                 ");
	        query.append("             and a.order_paystatus != '�ֹ����'                                 ");
	        query.append("     GROUP BY a.order_final_money, a.order_date, a.order_no)           ");
	        query.append("     GROUP BY orderdate                                                   ");
	        query.append("     order BY orderdate                                                   ");
	        
	        pstmt=con.prepareStatement(query.toString());
    		rs=pstmt.executeQuery();
    		int perPage = to.getPerPage_productlist(); //�� �������� ������ row ��
 			int skip = (curPage -1)*perPage;
 			if(skip>0){
 				rs.absolute(skip);
 			}
 			 for(int i=0; i<perPage && rs.next(); i++){
    			ManagerSalesDTO dto = new ManagerSalesDTO();
    			dto.setOrderdate(rs.getString("orderdate"));
    			dto.setFinalmoney(rs.getInt("finalmoney"));
    			dto.setQuantity(rs.getInt("quantity"));
    			dto.setOrdercount(rs.getInt("ordercount"));
    			
    			list.add(dto);
    		}
 			to.setList_sales(list);  //ArrayList ����
			to.setTotalCount(totalCount); //��ü ���ڵ� ����
			to.setCurPage(curPage); //���� ������
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return to;
	}
	
	
	
	//�������(������..)
	//������� ������ ��Ż�ο��
	public int totalCount_monthSales(){
		dbMgr = DBConnectionMgr.getInstance();
		int count = 0;
		
			try {
				con = dbMgr.getConnection();
				StringBuffer query=new StringBuffer();
				 query.append("	SELECT COUNT(*) 															");
				 query.append("   FROM (SELECT orderdate,                                                   ");
				 query.append("     SUM (finalmoney) AS finalmoney,                                         ");
				 query.append("     SUM (quantity) AS quantity,                                             ");
				 query.append("     COUNT (ordercount) AS ordercount                                        ");
				 query.append("     FROM (  SELECT MAX (SUBSTR (a.order_date, '1', '7')) AS orderdate,      ");
				 query.append("               SUM (b.order_detail_quantity) AS quantity,                    ");
				 query.append("               a.order_final_money AS finalmoney,                            ");
				 query.append("               a.order_no AS ordercount                                      ");
				 query.append("          FROM product_order_master a, product_order_detail b                ");
				 query.append("         WHERE     order_paydate BETWEEN TO_CHAR (SYSDATE - 31,              ");
				 query.append("                                                  ('YYYY/MM/DD'))            ");
				 query.append("                                     AND TO_CHAR (SYSDATE, ('YYYY/MM/DD'))   ");
				 query.append("               AND a.order_no = b.order_no                                   ");
				 query.append("                and a.order_paystatus != '�ֹ����'                            ");
				 query.append("      GROUP BY a.order_final_money, a.order_paydate, a.order_no)             ");
				 query.append("      GROUP BY orderdate		)											   ");
				 
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
	public ManagerPageTO monthSales(int curPage){
		logger.info("������ ȣ��");
		ManagerPageTO to = new ManagerPageTO();
		int totalCount = totalCount_monthSales();
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerSalesDTO> list= new ArrayList<ManagerSalesDTO>();
		try {
			con=dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			
		query.append("	SELECT orderdate,                                                          ");
	    query.append("     SUM (finalmoney) AS finalmoney,                                         ");
	    query.append("     SUM (quantity) AS quantity,                                             ");
	    query.append("     COUNT (ordercount) AS ordercount                                        ");
	    query.append("     FROM (  SELECT MAX (SUBSTR (a.order_date, '1', '7')) AS orderdate,      ");
	    query.append("               SUM (b.order_detail_quantity) AS quantity,                    ");
	    query.append("               a.order_final_money AS finalmoney,                            ");
	    query.append("               a.order_no AS ordercount                                      ");
	    query.append("          FROM product_order_master a, product_order_detail b                ");
	    query.append("         WHERE     order_date BETWEEN TO_CHAR (SYSDATE - 100,              ");
	    query.append("                                                  ('YYYY/MM/DD'))            ");
	    query.append("                                     AND TO_CHAR (SYSDATE, ('YYYY/MM/DD'))   ");
	    query.append("               AND a.order_no = b.order_no                                   ");
	    query.append("               and a.order_paystatus != '�ֹ����'                                   ");
	    query.append("      GROUP BY a.order_final_money, a.order_date, a.order_no)             ");
	    query.append("      GROUP BY orderdate													   ");
	    
	    
        pstmt=con.prepareStatement(query.toString());
		rs=pstmt.executeQuery();
		int perPage = to.getPerPage_productlist(); //�� �������� ������ row ��
		int skip = (curPage -1)*perPage;
		if(skip>0){
			rs.absolute(skip);
		}
		for(int i=0; i<perPage && rs.next(); i++){

			ManagerSalesDTO dto = new ManagerSalesDTO();
			dto.setOrderdate(rs.getString("orderdate"));
			dto.setFinalmoney(rs.getInt("finalmoney"));
			dto.setQuantity(rs.getInt("quantity"));
			dto.setOrdercount(rs.getInt("ordercount"));
			
			list.add(dto);
		}
		to.setList_sales(list);  //ArrayList ����
		to.setTotalCount(totalCount); //��ü ���ڵ� ����
		to.setCurPage(curPage); //���� ������	
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return to;
	}
	//��ϵ� ��ǰ��� �Ѵ��� ���� �ְ�..
	//����¡ ó�� : ��ü ���ڵ� ���� ���ϱ�
	public int totalCount_product(){
		dbMgr = DBConnectionMgr.getInstance();
		int count = 0;
		
			try {
				con = dbMgr.getConnection();
				StringBuffer query=new StringBuffer();
				
				 query.append("        SELECT count(*)                    ");
				 query.append("      FROM product a, product_type b, stock c   ");
				 query.append("  WHERE b.product_type_no = a.product_type_no   ");
				 query.append("        AND a.product_no = c.product_no         ");
				 query.append("        order by a.product_no				   ");
				
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
	
	
	
	public ManagerPageTO productList(int curPage){
//		public ArrayList<ManagerProductListDTO> productList(int curPage){
		ManagerPageTO to = new ManagerPageTO();
		int totalCount = totalCount_product();

		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerProductListDTO> list= new ArrayList<ManagerProductListDTO>();
		try {
			con=dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			
		 query.append("        SELECT a.product_no,                    ");
		 query.append("        a.product_name,                         ");
		 query.append("        b.product_type_name,                    ");
		 query.append("        c.stock_size,                           ");
		 query.append("        c.stock_quantity,                       ");
		 query.append("        a.product_cost,                         ");
		 query.append("        a.product_price,                        ");
		 query.append("        a.product_date                          ");
		 query.append("      FROM product a, product_type b, stock c   ");
		 query.append("  WHERE b.product_type_no = a.product_type_no   ");
		 query.append("        AND a.product_no = c.product_no         ");
		 query.append("        order by a.product_no				   ");
			
		 pstmt=con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		 rs=pstmt.executeQuery();
		 //int perPage = to.getPerPage(); //5
//		 int perPage = 6; //�� �������� ������ row ��
		 int perPage = to.getPerPage_productlist(); //�� �������� ������ row ��
			int skip = (curPage -1)*perPage;
			if(skip>0){
				rs.absolute(skip);
			}
		// while(rs.next()){
			 for(int i=0; i<perPage && rs.next(); i++){

			 ManagerProductListDTO dto = new ManagerProductListDTO();
			 dto.setProduct_no(rs.getInt("product_no"));
			 dto.setProduct_name(rs.getString("product_name"));
			 dto.setProduct_type_name(rs.getString("product_type_name"));
			 dto.setStock_size(rs.getString("stock_size"));
			 dto.setStock_quantity(rs.getInt("stock_quantity"));
			 dto.setProduct_cost(rs.getInt("product_cost"));
			 dto.setProduct_price(rs.getInt("product_price"));
			 dto.setProduct_date(rs.getString("product_date"));
			 
			 list.add(dto);
		 }
			to.setList_productlist(list);  //ArrayList ����
			to.setTotalCount(totalCount); //��ü ���ڵ� ����
			to.setCurPage(curPage); //���� ������
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return to;
	}
	
	//��ǰ�˻�
	//����¡ ó�� : ��ü ���ڵ� ���� ���ϱ�
		public int totalCount_searchproduct(String product_name){
			dbMgr = DBConnectionMgr.getInstance();
			int count = 0;
			
				try {
					con = dbMgr.getConnection();
					StringBuffer query=new StringBuffer();
					
					 query.append("        SELECT count(*)                    ");
					 query.append("      FROM product a, product_type b, stock c   ");
					 query.append("  WHERE b.product_type_no = a.product_type_no   ");
					 query.append("        AND a.product_no = c.product_no         ");
					 query.append("        and a.product_name like ? 				   ");
					
					
					pstmt = con.prepareStatement(query.toString());
					pstmt.setString(1, "%"+product_name+"%");
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
	
	
	
	
	
	
	
	
	
	
	public ManagerPageTO searchProduct(int curPage, String product_name){
		//logger.info("��ǰ�˻� �޼ҵ� ȣ��");
		ManagerPageTO to = new ManagerPageTO();
		int totalCount = totalCount_searchproduct(product_name);
		
		dbMgr = DBConnectionMgr.getInstance();
		ArrayList<ManagerProductListDTO> list= new ArrayList<ManagerProductListDTO>();
		
		try {
			con=dbMgr.getConnection();
			StringBuffer query=new StringBuffer();
			
		    query.append("       SELECT a.product_no,                      ");
		    query.append("       a.product_name,                           ");
		    query.append("       b.product_type_name,                      ");
		    query.append("       c.stock_size,                             ");
		    query.append("       c.stock_quantity,                         ");
		    query.append("       a.product_cost,                           ");
		    query.append("       a.product_price,                          ");
		    query.append("       a.product_date                            ");
		    query.append("     FROM product a, product_type b, stock c     ");
		    query.append(" WHERE b.product_type_no = a.product_type_no     ");
		    query.append("       AND a.product_no = c.product_no           ");
		    query.append("       and a.product_name like ?                 ");
		    query.append("       order by a.product_no                     ");
		    pstmt=con.prepareStatement(query.toString());
    		pstmt.setString(1, "%"+product_name+"%");
		    rs=pstmt.executeQuery();
		    int perPage = to.getPerPage_productlist(); //9
			int skip = (curPage -1)*perPage;
			if(skip>0){
				rs.absolute(skip);
			}
		    
			 for(int i=0; i<perPage && rs.next(); i++){
		   	 ManagerProductListDTO dto = new ManagerProductListDTO();
			 dto.setProduct_no(rs.getInt("product_no"));
			 dto.setProduct_name(rs.getString("product_name"));
			 dto.setProduct_type_name(rs.getString("product_type_name"));
			 dto.setStock_size(rs.getString("stock_size"));
			 dto.setStock_quantity(rs.getInt("stock_quantity"));
			 dto.setProduct_cost(rs.getInt("product_cost"));
			 dto.setProduct_price(rs.getInt("product_price"));
			 dto.setProduct_date(rs.getString("product_date"));
			 
			 list.add(dto);
		    }
			to.setList_productlist(list);  //ArrayList ����
			to.setTotalCount(totalCount); //��ü ���ڵ� ����
			to.setCurPage(curPage); //���� ������
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dbMgr.freeContection(rs, pstmt, con);
		}
		return to;
	}
	
	//�Խ��ǰ���(�Խ��� ��ϵ� �Ѵ��� �����ְ�)�߰�����...
	
	
	//
	
	
}
