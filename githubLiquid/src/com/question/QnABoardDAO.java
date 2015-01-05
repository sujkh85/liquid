package com.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnectionMgr;

public class QnABoardDAO {
	Connection con = null;//�������
	PreparedStatement pstmt = null;//������ ����|��û
	ResultSet rs = null;//open-cursor-fetch
	DBConnectionMgr dbMgr = null;
	

		//�ڵ��߰�1(25,26p�۾���)----------------------------------------------
			//�۹�ȣ�޾ƿ���(�ۼ� �� ���� ��� ���ΰ�.) (�̹��� ÷�� �� ���ϸ��� �ޱ� ���ؼ�)
			public int curBoardNumber(){
					dbMgr = DBConnectionMgr.getInstance();
					int num = 0;
					
						try {
							con = dbMgr.getConnection();
							StringBuffer query=new StringBuffer();
							query.append("SELECT max(board_question_no) FROM board_question");
							pstmt = con.prepareStatement(query.toString());
							rs = pstmt.executeQuery();
							if(rs.next()){
								num = rs.getInt(1);
							}
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						} finally{
							dbMgr.freeContection(rs, pstmt, con);
						}
						return num;
				}//end curBoardNumber
				//�۾���
				public void write(String _title, String _content, String _member_info_no ,String _imgsrc1, String _imgsrc2, String _imgsrc3, String _imgsrc4, String _imgsrc5){
					dbMgr = DBConnectionMgr.getInstance();
					try {
						con=dbMgr.getConnection();
						StringBuffer query=new StringBuffer();
							query.append("	INSERT INTO board_question                                 		      ");
							query.append("	    (board_question_no,                                               ");
							query.append("	    board_question_title,                                             ");
							query.append("	    board_question_content,                                           ");
							query.append("	    board_question_date,                                              ");
							query.append("	    board_question_viewcount,                                         ");
							query.append("	    member_info_no,                                                   ");
							query.append("	    board_question_reproot,                                           ");
							query.append("	    board_question_repstep,                                           ");
							query.append("	    board_question_repindent,                                         ");                          
							query.append("	    board_question_imgsrc1,                                           ");
							query.append("	    board_question_imgsrc2,                                           ");
							query.append("	    board_question_imgsrc3,                                           ");
							query.append("	    board_question_imgsrc4,                                           ");
							query.append("	    board_question_imgsrc5)                                           ");
							query.append("	VALUES(                                                               ");
							query.append("	    BOARD_QUESTION_SEQ.nextval,                                       ");
							query.append("	    ?,                                                                ");
							query.append("	    ?,                                                                ");
							query.append("	    sysdate,                                                          ");
							query.append("	    0,                                                                ");     
							query.append("	    (SELECT member_info_no FROM member_info WHERE member_info_no = ?),");                                                
							query.append("	    board_question_seq.currval,                                       ");
							query.append("	    0,                                                                ");
							query.append("	    0,                                                                ");
							query.append("	    ?,                                                                ");
							query.append("	    ?,                                                                ");
							query.append("	    ?,                                                                ");
							query.append("	    ?,                                                                ");
							query.append("	    ?)                                                            	  ");
						pstmt = con.prepareStatement(query.toString());
						pstmt.setString(1, _title);
						pstmt.setString(2, _content);
						pstmt.setString(3, _member_info_no);
						if(_imgsrc1 !=null  )
							pstmt.setString(4, "./bbs/question/img/" +_imgsrc1);
						else
							pstmt.setString(4, null);
						if(_imgsrc2 !=null  )
							pstmt.setString(5, "./bbs/question/img/" +_imgsrc2);
						else
							pstmt.setString(5, null);
						if(_imgsrc3 !=null  )
							pstmt.setString(6, "./bbs/question/img/" +_imgsrc3);
						else
							pstmt.setString(6, null);
						if(_imgsrc4 !=null  )
							pstmt.setString(7, "./bbs/question/img/" + _imgsrc4);
							//pstmt.setString(7, "./bbs/question/img/" +maxrownum+1+"_4_" +_imgsrc4);
						else
							pstmt.setString(7, null);
						if(_imgsrc5 !=null  )
							pstmt.setString(8, "./bbs/question/img/" + _imgsrc5);
							//pstmt.setString(8, "./bbs/question/img/" +maxrownum+1+"_5_" +_imgsrc5);
						else
							pstmt.setString(8, null);
							
						int n=pstmt.executeUpdate();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally{
						dbMgr.freeContection(rs, pstmt, con);
					}//end finally
				}//end write
				//�ڵ��߰�1-----------------------------------------------------------------------------
			//�ڵ��߰�28,29(�� ���� �ڼ������� �� �ۼ���)-----------------------------------------------------------------------------
				//��ȸ�� 1����
				public void readCount(String _no){
					dbMgr = DBConnectionMgr.getInstance();
						try {
							con = dbMgr.getConnection();
							StringBuffer query=new StringBuffer();
							query.append("UPDATE board_question "
									+ "      SET board_question_viewcount = board_question_viewcount + 1 "
									+ "    WHERE board_question_no = ? ");
							pstmt = con.prepareStatement(query.toString());
							pstmt.setInt(1, Integer.parseInt(_no));
							int n = pstmt.executeUpdate();
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						} finally{
							dbMgr.freeContection(rs, pstmt, con);
						}//end finally
				}//end readCount
				//�� �ڼ��� ����
				public QnABoardDTO detail(String _no){
					//��ȸ�� ����
					readCount(_no);
					dbMgr = DBConnectionMgr.getInstance();
				
					QnABoardDTO data = new QnABoardDTO();
					try {
						con = dbMgr.getConnection();
						StringBuffer query=new StringBuffer();
						query.append("SELECT board_question_no, "
								+ "			 board_question.member_info_no, "
								+ "			 member_info.member_info_nickname,"
								+ "			 board_question_title, "
								+ "			 board_question_content, "
								+ "			 board_question_date, "
								+ "			 board_question_viewcount, "
								+ "			 board_question_reproot, "
								+ "			 board_question_repstep, "
								+ "			 board_question_repindent, "
								+ "			 board_question_imgsrc1, "
								+ "			 board_question_imgsrc2, "
								+ "			 board_question_imgsrc3, "
								+ "			 board_question_imgsrc4, "
								+ "			 board_question_imgsrc5 "
								+ "     FROM board_question, "
								+ "		  	 member_info "
								+ "    WHERE board_question.member_info_no = member_info.member_info_no "
								+ "		 and board_question.board_question_no = ? ");
						pstmt = con.prepareStatement(query.toString());
						pstmt.setInt(1, Integer.parseInt(_no));
						rs = pstmt.executeQuery();
						if(rs.next()){
							data.setBoard_question_no(rs.getInt("board_question_no"));
							data.setBoard_question_title(rs.getString("board_question_title"));
							data.setMember_info_no_nickname(rs.getString("member_info_nickname"));
							data.setBoard_question_content(rs.getString("board_question_content"));
							data.setBoard_question_date(rs.getString("board_question_date"));
							data.setBoard_question_viewcount(rs.getInt("board_question_viewcount"));
							data.setBoard_question_imgsrc1(rs.getString("board_question_imgsrc1"));
							data.setBoard_question_imgsrc2(rs.getString("board_question_imgsrc2"));
							data.setBoard_question_imgsrc3(rs.getString("board_question_imgsrc3"));
							data.setBoard_question_imgsrc4(rs.getString("board_question_imgsrc4"));
							data.setBoard_question_imgsrc5(rs.getString("board_question_imgsrc5"));
							data.setMember_info_no(rs.getInt("member_info_no"));
						}//end if
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally{
						dbMgr.freeContection(rs, pstmt, con);
					}
					return data;
				}//end detail
		//�ڵ��߰�(�� ���� ����)-----------------------------------------------------------------------------
				public QnABoardDTO retrieve(String _no){
					dbMgr = DBConnectionMgr.getInstance();
					QnABoardDTO data = new QnABoardDTO();
					try {
						con = dbMgr.getConnection();
						StringBuffer query=new StringBuffer();
						query.append("SELECT board_question_no, "
								+ "			 member_info.member_info_nickname , "
								+ "			 board_question_title, "
								+ "			 board_question_content, "
								+ "			 board_question_date, "
								+ "			 board_question_viewcount,"
								+ "			 board_question_reproot, "
								+ "			 board_question_repstep, "
								+ "			 board_question_repindent,"
								+ "			 board_question_imgsrc1, "
								+ "			 board_question_imgsrc2, "
								+ "			 board_question_imgsrc3, "
								+ "			 board_question_imgsrc4, "
								+ "			 board_question_imgsrc5 "
								+ "     FROM board_question, member_info "
								+ "    WHERE board_question.member_info_no = member_info.member_info_no"
								+ "		 AND board_question.board_question_no = ? "
								+ " ORDER BY board_question_reproot desc, board_question_repstep asc ");
						pstmt = con.prepareStatement(query.toString());
						pstmt.setInt(1, Integer.parseInt(_no));
						rs = pstmt.executeQuery();
						if(rs.next()){
							data.setBoard_question_no(rs.getInt("board_question_no"));
							data.setBoard_question_title(rs.getString("board_question_title"));
							data.setMember_info_no_nickname(rs.getString("member_info_nickname"));
							String board_question_content =rs.getString("board_question_content"); 
							board_question_content = board_question_content.replaceAll( "<br>", "\r\n"); // db�� <br>�� �ٽ� \r\n����
							data.setBoard_question_content(board_question_content);
							data.setBoard_question_date(rs.getString("board_question_date"));
							data.setBoard_question_viewcount(rs.getInt("board_question_viewcount"));
							data.setBoard_question_imgsrc1(rs.getString("board_question_imgsrc1"));
							data.setBoard_question_imgsrc2(rs.getString("board_question_imgsrc2"));
							data.setBoard_question_imgsrc3(rs.getString("board_question_imgsrc3"));
							data.setBoard_question_imgsrc4(rs.getString("board_question_imgsrc4"));
							data.setBoard_question_imgsrc5(rs.getString("board_question_imgsrc5"));
							
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
						query.append("UPDATE board_question "
								+ "		 SET board_question_title = ? , "
								+ "			 member_info_no = ?, "
								+ "			 board_question_content = ?"
								+ "    WHERE board_question_no = ? ");
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
		//�ڵ��߰�31,32(�� ���� ����)-----------------------------------------------------------------------------
		//�ڵ��߰�33(�� ���� ����)-----------------------------------------------------------------------------
				//�� �����ϱ�
				public void delete(String _no){
					dbMgr = DBConnectionMgr.getInstance();
					try {
						con = dbMgr.getConnection();
						StringBuffer query=new StringBuffer();
						query.append("DELETE FROM board_question "
								+ "		    WHERE board_question_no = ? ");
						pstmt = con.prepareStatement(query.toString());
						pstmt.setInt (1,Integer.parseInt(_no));
						int n = pstmt.executeUpdate();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally{
						dbMgr.freeContection(rs, pstmt, con);
					}
				}//end delete
			//�ڵ��߰�33(�� ���� ����)-----------------------------------------------------------------------------
				//�ڵ��߰�35(�˻� ����)-----------------------------------------------------------------------------
						//����¡ ó�� : �˻� �� ��ü ���ڵ� ���� ���ϱ�
				public int totalCount_search(String _searchName, String _searchValue){
					dbMgr = DBConnectionMgr.getInstance();
					int count = 0;
						try {
							con = dbMgr.getConnection();
							StringBuffer query=new StringBuffer();
							query.append("SELECT count(*) " 
		                               + "  FROM board_question, "
		                               + " 		 member_info "
		                               + " WHERE board_question.member_info_no = member_info.member_info_no "
		                               + "	 AND ");
								if( _searchName.equals("board_question_title")){
									query.append(" board_question_title LIKE ? ");
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
				//�˻��ϱ�
				public QnABoardPageTO search(int curPage, String _searchName, String _searchValue){
					QnABoardPageTO to = new QnABoardPageTO();
					int totalCount = totalCount_search(_searchName, _searchValue);
					ArrayList<QnABoardDTO> list = new ArrayList<QnABoardDTO>();
					dbMgr = DBConnectionMgr.getInstance();
					try{
						con = dbMgr.getConnection();
						StringBuffer query=new StringBuffer();
						query.append("SELECT board_question_no, "
								+ "			 member_info.member_info_nickname as member_info_nickname, "
								+ "			 board_question_title, "
                               +	"		 board_question_content, "
                               + "			 board_question_date, "
                               + "			 board_question_viewcount, " 
                               + "			 board_question_repindent " 
                                + "		FROM board_question, "
                                + "			 member_info "
                                + "    WHERE board_question.member_info_no = member_info.member_info_no "
                                + "		 AND ");
						if( _searchName.equals("board_question_title")){
							query.append(" 		 board_question_title LIKE ? "
									+ " ORDER BY board_question_no DESC");
						}else{
							query.append(" 		 member_info_nickname LIKE ? "
									+ " ORDER BY board_question_no DESC");
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

						int board_question_no = rs.getInt("board_question_no");
						String member_info_no_nickname = rs.getString("member_info_nickname");
						String board_question_title = rs.getString("board_question_title");
						String board_question_content = rs.getString("board_question_content");
						String board_question_date = rs.getString("board_question_date");
						int board_question_viewcount = rs.getInt("board_question_viewcount");
						int board_question_repindent = rs.getInt("board_question_repindent");
						
						QnABoardDTO data = new QnABoardDTO();
						data.setBoard_question_no(board_question_no);
						data.setMember_info_no_nickname(member_info_no_nickname);
						data.setBoard_question_title(board_question_title);
						data.setBoard_question_content(board_question_content);
						data.setBoard_question_date(board_question_date);
						data.setBoard_question_viewcount(board_question_viewcount);
						data.setBoard_question_repindent(board_question_repindent);
						list.add(data);
					}//end for
						
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
			//�ڵ��߰�35(�˻� ����)-----------------------------------------------------------------------------
			//�ڵ��߰�38(�亯�� �Է� �� ����)-----------------------------------------------------------------------------
			//�亯�� �Է� �� ����
			public QnABoardDTO replyui(String _no){
				dbMgr = DBConnectionMgr.getInstance();
				QnABoardDTO data = new QnABoardDTO();
				try {
					con = dbMgr.getConnection();
					StringBuffer query=new StringBuffer();
					query.append("SELECT board_question_no, "
								+ "	     member_info.member_info_nickname , "
								+ "      board_question_title, "
								+ "	     board_question_content, "
								+ "	     board_question_date, "
								+ "	     board_question_viewcount, "
								+ "	     board_question_reproot, "
								+ "	     board_question_repstep, "
								+ "  	 board_question_repindent, "
								+ "	     board_question_imgsrc1, "
								+ "	     board_question_imgsrc2, "
								+ "	     board_question_imgsrc3, "
								+ "	     board_question_imgsrc4, "
								+ "	     board_question_imgsrc5 "
								+ " FROM board_question, "
								+ "	     member_info "
								+ "WHERE board_question.member_info_no = member_info.member_info_no "
								+ "  AND board_question.board_question_no = ? "
							+ " ORDER BY board_question_reproot desc, board_question_repstep ASC ");
					pstmt = con.prepareStatement(query.toString());
					pstmt.setInt(1, Integer.parseInt(_no));
					rs = pstmt.executeQuery();
					if(rs.next()){
						data.setBoard_question_no(rs.getInt("board_question_no"));
						data.setBoard_question_title(rs.getString("board_question_title"));
						data.setMember_info_no_nickname(rs.getString("member_info_nickname"));
						String board_question_content = rs.getString("board_question_content");
						board_question_content = board_question_content.replaceAll("<br>", "\r\n"); // db�� <br>�� �ٽ� ���ͷ�
						data.setBoard_question_content(board_question_content);
						data.setBoard_question_date(rs.getString("board_question_date"));
						data.setBoard_question_viewcount(rs.getInt("board_question_viewcount"));
						data.setBoard_question_reproot(rs.getInt("board_question_reproot"));
						data.setBoard_question_repstep(rs.getInt("board_question_repstep"));
						data.setBoard_question_repindent(rs.getInt("board_question_repindent"));
												
					}//end if
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally{
					dbMgr.freeContection(rs, pstmt, con);
				}
				return data;
			}//end replyui
			//�ڵ��߰�38(�亯�� �Է� �� ����)-----------------------------------------------------------------------------
			//�ڵ��߰�47(�亯�� ���� ����)-----------------------------------------------------------------------------
			//�亯���� ���� repStep 1����
			public void makeReply(String _root, String _step){
				dbMgr = DBConnectionMgr.getInstance();
				try {
					con = dbMgr.getConnection();
					StringBuffer query=new StringBuffer();
					query.append("UPDATE board_question "
							+ "		 SET board_question_repstep = board_question_repstep + 1 "
								+ "WHERE board_question_reproot = ? "
								+ "  AND board_question_repstep > ? ");
					pstmt = con.prepareStatement(query.toString());
					pstmt.setInt(1,  Integer.parseInt(_root));
					pstmt.setInt(2, Integer.parseInt(_step));
					int n = pstmt.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					dbMgr.freeContection(rs, pstmt, con);
				}
				
			}
			//�亯 �ޱ�
			public void reply(String _no, String _title, String _member_info_no , String _content,
							  String _repRoot, String _repStep, String _repIndent, String _date, String _viewcount){
				makeReply(_repRoot, _repStep);
				dbMgr = DBConnectionMgr.getInstance();
				try {
					con = dbMgr.getConnection();
					StringBuffer query=new StringBuffer();
					query.append(  "INSERT INTO board_question "
							+ "				   (board_question_no, "
							+ "				    board_question_title, "
							+ " 				member_info_no, "
							+ "					board_question_content, "
							+ "					board_question_reproot, "
							+ " 				board_question_repstep, "
							+ "					board_question_repindent, "
							+ "					board_question_date, "
							+ "					board_question_viewcount) "
							+ "		     VALUES(board_question_seq.nextVal, "
							+ "					?,"
							+ "					?,"
							+ "					?,"
							+ "					?,"
							+ "					?,"
							+ "					?,"
							+ "					?,"
							+ "					0)");
					pstmt = con.prepareStatement(query.toString());
					pstmt.setString(1, _title);
					pstmt.setString(2, _member_info_no);
					pstmt.setString(3, _content);
					pstmt.setInt(4, Integer.parseInt(_repRoot));
					pstmt.setInt(5, Integer.parseInt(_repStep)+1);
					pstmt.setInt(6, Integer.parseInt(_repIndent)+1);
					pstmt.setString(7, _date);
					int n = pstmt.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					dbMgr.freeContection(rs, pstmt, con);
				}
			}//end reply
			//�ڵ��߰�47(�亯�� ���� ����)-----------------------------------------------------------------------------
			//�ڵ��߰�51(����¡ ó�� ����)-----------------------------------------------------------------------------
				//����¡ ó�� : ��ü ���ڵ� ���� ���ϱ�
			public int totalCount(){
				dbMgr = DBConnectionMgr.getInstance();
				int count = 0;
				
					try {
						con = dbMgr.getConnection();
						StringBuffer query=new StringBuffer();
						query.append("SELECT count(*) FROM board_question");
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
			public QnABoardPageTO page(int curPage){
					QnABoardPageTO to = new QnABoardPageTO();
					int totalCount = totalCount();
					ArrayList<QnABoardDTO> list = new ArrayList<QnABoardDTO>();
					dbMgr = DBConnectionMgr.getInstance();
					try {
						con = dbMgr.getConnection();
						StringBuffer query=new StringBuffer();
						query.append("SELECT board_question_no, "
								+ "			 member_info.member_info_nickname as member_info_nickname , "
								+ "			 board_question_title, "
								+ "			 board_question_content, "
								+ "			 board_question_date, "
								+ "			 board_question_viewcount,"
								+ "			 board_question_reproot, "
								+ "          board_question_repstep, "
								+ "          board_question_repindent,"
								+ "          board_question_imgsrc1, "
								+ "          board_question_imgsrc2, "
								+ "          board_question_imgsrc3, "
								+ "          board_question_imgsrc4, "
								+ "          board_question_imgsrc5 "
								+ "		FROM board_question, "
								+ "			 member_info "
								+ "    WHERE board_question.member_info_no = member_info.member_info_no "
								+ " ORDER BY board_question_reproot desc, board_question_repstep asc ");
						pstmt = con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						rs = pstmt.executeQuery();
						int perPage = to.getPerPage(); //5
						int skip = (curPage -1)*perPage;
						if(skip>0){
							rs.absolute(skip);
						}
						for(int i=0; i<perPage && rs.next(); i++){
							int board_question_no = rs.getInt("board_question_no");
							String member_info_no_nickname = rs.getString("member_info_nickname");
							String board_question_title = rs.getString("board_question_title");
							String board_question_content =rs.getString("board_question_content");
							String board_question_date = rs.getString("board_question_date");
							int board_question_viewcount = rs.getInt("board_question_viewcount");
							int board_question_reproot = rs.getInt("board_question_reproot");
							int board_question_repstep = rs.getInt("board_question_repstep");
							int board_question_repindent = rs.getInt("board_question_repindent");
							String board_question_imgsrc1 = rs.getString("board_question_imgsrc1");
							String board_question_imgsrc2 = rs.getString("board_question_imgsrc2");
							String board_question_imgsrc3 = rs.getString("board_question_imgsrc3");
							String board_question_imgsrc4 = rs.getString("board_question_imgsrc4");
							String board_question_imgsrc5 = rs.getString("board_question_imgsrc5");
						
							QnABoardDTO data = new QnABoardDTO();
							
							data.setBoard_question_no(board_question_no);
							data.setMember_info_no_nickname(member_info_no_nickname);
							data.setBoard_question_title(board_question_title);
							data.setBoard_question_content(board_question_content);
							data.setBoard_question_date(board_question_date);
							data.setBoard_question_viewcount(board_question_viewcount);
							data.setBoard_question_reproot(board_question_reproot);
							data.setBoard_question_repstep(board_question_repstep);
							data.setBoard_question_repindent(board_question_repindent);
							data.setBoard_question_imgsrc1(board_question_imgsrc1);
							data.setBoard_question_imgsrc2(board_question_imgsrc2);
							data.setBoard_question_imgsrc3(board_question_imgsrc3);
							data.setBoard_question_imgsrc4(board_question_imgsrc4);
							data.setBoard_question_imgsrc5(board_question_imgsrc5);
							
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
			//�ڵ��߰�51(����¡ ó�� ����)-----------------------------------------------------------------------------
				
}//end class
