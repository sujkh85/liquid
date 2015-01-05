package com.controller;
/***********************************************************************
 * �۾��� : �̽¿�
 * �۾����� : 14.11.19
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� :  *.do ��û�� ���°�! // ��� FC ����
 * �̰����� ���հ���  Ctrl + F �� ����, �ּ��ʼ�(��Ű����,ȣ���ϴ� jsp���,�۾��ڵ� ���)
 ***********************************************************************/
//�ּ� ����
/******************** ��Ű����,jsp���,�۾��� **********************/	

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.catalogue.CatalogueCMD;
import com.design.DesignDeleteCMD;
import com.design.DesignDetailCMD;
import com.design.DesignFavoriteCMD;
import com.design.DesignListCMD;
import com.design.DesignRetrieveCMD;
import com.design.DesignSearchCMD;
import com.design.DesignUpdateCMD;
import com.design.DesignWriteCMD;
import com.manager.ManagerBestItemCMD;
import com.manager.ManagerMemberListCMD;
import com.manager.ManagerOrderDetailCMD;
import com.manager.ManagerOrderStatusCMD;
import com.manager.ManagerOrderStatusChangeCMD;
import com.manager.ManagerProductListCMD;
import com.manager.ManagerProductSalesCMD;
import com.manager.ManagerSalesCMD;
import com.manager.ManagerTodayOrderCMD;
import com.member.MemberConfirmCMD;
import com.member.MemberInfoInsertCMD;
import com.member.MemberInfoListCMD;
import com.member.MemberInfoUpdateCMD;
import com.member.MemberLoginCMD;
import com.member.MemberPageCMD;
import com.notice.NoticeDeleteCMD;
import com.notice.NoticePageCMD;
import com.notice.NoticeRetrieveCMD;
import com.notice.NoticeRetrieveupdateCMD;
import com.notice.NoticeSearchCMD;
import com.notice.NoticeUpdateCMD;
import com.notice.NoticeWriteCMD;
import com.order.CartListCMD;
import com.order.CookieCreateCMD;
import com.order.OrderDeleteCMD;
import com.order.OrderDetailCMD;
import com.order.OrderDetailInfoCMD;
import com.order.OrderListCMD;
import com.order.OrderPaymentCMD;
import com.order.OrderWriteCMD;
import com.product.ProductDetailListCMD;
import com.product.ProductListCMD;
import com.product.ProductOptionListCMD;
import com.product.ProductWriteCMD;
import com.question.QnABoardDeleteCMD;
import com.question.QnABoardDetailCMD;
import com.question.QnABoardPageCMD;
import com.question.QnABoardReplyCMD;
import com.question.QnABoardReplyUICMD;
import com.question.QnABoardRetrieveCMD;
import com.question.QnABoardSearchCMD;
import com.question.QnABoardUpdateCMD;
import com.question.QnABoardWriteCMD;
import com.review.DetailreviewListCMD;
import com.review.ReviewUpdateCMD;
import com.review.reviewDeleteCMD;
import com.review.reviewWriteCMD;
import com.wishlist.WishListDeleteCMD;
import com.wishlist.WishListInsertCMD;
import com.wishlist.WishListViewCMD;
		
	@WebServlet("*.do")
	public class FrontController extends HttpServlet {
		Logger logger = Logger.getLogger(FrontController.class);
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			doPost(req, res);		
			logger.info("FrontController doGet ȣ�� ����");
		}
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			logger.info("FrontController doPost ȣ�� ����");
			req.setCharacterEncoding("EUC-KR");
			String reqURI = req.getRequestURI();
			String contextPath= req.getContextPath();
			String com = reqURI.substring(contextPath.length());
			Command command = null;
			String nextPage = null;
			System.out.println(com);
/********************** com.catalogue, main���� �Ʒ�, �̽¿� **********************/
			if(com.equals("/main.do")){
				command = new CatalogueCMD();
				command.execute(req, res);
				nextPage = "main.jsp";
			}
/******************** com.member, member���� �Ʒ� : �̽¿� **********************/		
			
			/* ȸ������ ���� �̵�ó�� [?�ܰ�]*/
			// 1. ������������ �̵�	(SELECT)
			if(com.equals("/memberpage.do")){
				command = new MemberPageCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=memberpage"; 
			}
			// 2-1. ȸ���������������� �̵� (SELECT) 
			if(com.equals("/myinfoform.do")){
				logger.info("ȸ����������");
				command = new MemberInfoListCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=myinfoform";
			}
			if(com.equals("/manager_myinfoform.do")){
				logger.info("�Ŵ��� ��������");
				command = new MemberInfoListCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_myinfoform";
			}
			// 2-2. �н����� ���� ������ �̵�
			if(com.equals("/pwform.do")){
				nextPage = "main.jsp?menu=pwform";
			}
				// 2-2-1 �����н����� Ȯ�� (SELECT)  
				if(com.equals("/pwcheck.do")){
					nextPage = "main.jsp?menu=pwcheck";
				}
				// 2-2-2 �н����� ���� �׼� (UPDATE) - ���������޽���
				if(com.equals("/pwupdate.do")){
					nextPage = "main.jsp?menu=memmessage";
				}
			// 3 ȸ���������� �׼� (UPDATE) - ���������޽��� 
			if(com.equals("/myinfogo.do")){
				command = new MemberInfoUpdateCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=memmessage";
			}
			if(com.equals("/manager_myinfogo.do")){
				command = new MemberInfoUpdateCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=managermemmessage";
			}
			
			
			/* �α��� ������ �̵�ó�� [3�ܰ�]*/
			
			// 1. �α��������� �̵�
			if(com.equals("/loginform.do")){
				nextPage = "main.jsp?menu=loginform";
			}
			// 2. �α��� �׼� - ���ǰ� ��� �������� �̵� (SELECT)
			if(com.equals("/logingo.do")){
				command = new MemberLoginCMD();
				command.execute(req, res);
				nextPage = "member/memberLoginSession.jsp";
			}
			// 3. �α׾ƿ� �׼� - ���ǰ� ���� �������� �̵�
			if(com.equals("/logout.do")){
				nextPage = "member/memberLoginSessionOut.jsp";
			}
			
			
			
			/* ȸ������ ������ �̵� ó�� [4 �ܰ�]*/
			
			// 1. ȸ������ ������� �̵�
			if(com.equals("/memberagree.do")){
				nextPage = "main.jsp?menu=memberagree";
			}
			// 2. ������ǽ� ȸ������ ������ �̵�
			if(com.equals("/memberform.do")){
				nextPage = "main.jsp?menu=memberform";
			}
			// 3. ȸ������ �� ���̵� �� �г��� �ߺ��˻� �׼� (SELECT)
			if(com.equals("/membercheck.do")){
				logger.info("���̵� �ߺ��˻� .do ��û ����");
				command = new MemberConfirmCMD();
				command.execute(req, res);
				nextPage = "member/memberCheck.jsp";
			}
			// 4. ���Լ��� �׼� (INSERT) - �������ϸ޽����� �̵�
			if(com.equals("/membermessage.do")){
				command = new MemberInfoInsertCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=memmessage";
			}
			
			/* ȸ��Ż�� ������ �̵� ó�� [? �ܰ�]*/
			// 1. ȸ��Ż�� �׼� (UPDATE) 
			// ���� ��ȹ : ȸ��Ż��� �ش�ȸ���� ȸ����޹�ȣ�� Ż��ȸ������ �з��Ͽ� 
			// �ش� ��޹�ȣ�� ������ �ִ� ȸ���� ������ ����� �ְ��Ѵ�.
			
			
/******************** com.notice, bbs/notice/notice_*.jsp: �̹�ȭ **********************/			
			
			//����¡ ó��
			if(com.equals("/notice_list.do")){
				command = new NoticePageCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=notice_listPage";
			}
			//�����ڸ�忡�� ����¡ ó��
			if(com.equals("/manager_notice_list.do")){
				command = new NoticePageCMD();
				command.execute(req,res);
				nextPage = "manager_main.jsp?menu=manager_notice_listPage";
			}
			//�� �����ϱ�
			if(com.equals("/notice_update.do")){
				command = new NoticeUpdateCMD();
				command.execute(req,res);
				nextPage = "notice_list.do";
			}
			//�����ڸ�忡�� �� �����ϱ�
			if(com.equals("/manager_notice_update.do")){
				command = new NoticeUpdateCMD();
				command.execute(req,res);
				nextPage = "manager_notice_list.do";
			}

			//�۾��� ��
			if(com.equals("/notice_writeui.do")){
				nextPage = "main.jsp?menu=notice_write";
			}
			//�����ڸ�忡�� �۾��� ��
			if(com.equals("/manager_notice_writeui.do")){
				nextPage = "manager_main.jsp?menu=manager_notice_write";
			}
			
			//�۾���
			if(com.equals("/notice_write.do")){
				command = new NoticeWriteCMD();
				command.execute(req, res);
				nextPage = "notice_list.do";
			}
			//�����ڸ�忡�� �۾���
			if(com.equals("/manager_notice_write.do")){
				command = new NoticeWriteCMD();
				command.execute(req, res);
				nextPage = "manager_notice_list.do";
			}
			//����ȭ�� â
			if(com.equals("/notice_retrieve.do")){
				command = new NoticeRetrieveupdateCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=notice_retrieve";
			}
			//�����ڸ�忡�� ����ȭ�� â
			if(com.equals("/manager_notice_retrieve.do")){
				command = new NoticeRetrieveupdateCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_notice_retrieve";
			}
			//�󼼺���
			if(com.equals("/notice_detail.do")){
				command = new NoticeRetrieveCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=notice_detail";
			}//�����ڸ�忡�� �󼼺���
			if(com.equals("/manager_notice_detail.do")){
				command = new NoticeRetrieveCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_notice_detail";
			}
			
			//�� �����ϱ�
			if(com.equals("/notice_delete.do")){
				command = new NoticeDeleteCMD();
				command.execute(req,res);
				nextPage = "notice_list.do";
			}
			//�����ڸ�忡�� �� �����ϱ�
			if(com.equals("/manager_notice_delete.do")){
				command = new NoticeDeleteCMD();
				command.execute(req,res);
				nextPage = "manager_notice_list.do";
			}
			
			//�� �˻��ϱ�
			if(com.equals("/notice_search.do")){
				command = new NoticeSearchCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=notice_listPage";
			}
			//�����ڸ�忡�� �� �˻��ϱ�
			if(com.equals("/manager_notice_search.do")){
				command = new NoticeSearchCMD();
				command.execute(req,res);
				nextPage = "manager_main.jsp?menu=manager_notice_listPage";
			}
			
/******************** com.order, bbs/order/order_*.jsp : �̹�ȭ/�̽¿� **********************/	
			
			//�ֹ����� ����Ʈ
			if(com.equals("/order_list.do")){
				command = new OrderListCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=order_list";
			}
			//�ֹ��� ����Ʈ
			if(com.equals("/orderDetailInfo.do")){
				command = new OrderDetailInfoCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=orderDetailInfo";
			}
			//�ֹ��� �ۼ�
			if(com.equals("/order_writeForm.do")){
				command = new OrderDetailCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=order_writeForm";
			}
			//�ֹ����Է�
			if(com.equals("/order_insert.do")){
				command = new OrderWriteCMD();
				command.execute(req,res);
				nextPage = "order_list.do";
			}
			
			//�ֹ����
			if(com.equals("/order_delete.do")){
				command = new OrderDeleteCMD();
				command.execute(req,res);
				nextPage = "order_list.do";
			}
			//���� �Ѿ��
			if(com.equals("/order_payment.do")){
				command = new OrderPaymentCMD();
				command.execute(req,res);
				nextPage = "order_list.do";
			}
/******************** com.order, cart/cart_*.jsp : �̹�ȭ/�̽¿� **********************/				
			/*//�����Ͽ��� ��ٱ��� ���� ��� �ش� ��ǰ ��������ȣ ��Ű ����
			if(com.equals("/cartCookie.do")){
				command = new CookieCreateCMD();
				command.execute(req,res);
				nextPage = "cartList.do";  
			}*/
		
			// ���� ��ٱ��Ͽ� ������ ������ ó�� : ��Ű������ͻ�ǰ��ȸ
			if(com.equals("/cartList.do")){
				command = new CartListCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=cart_list";
			}
			
			
			
/******************** com.product, bbs/product/product*.jsp : �̽¿�,�̹�ȭ **********************/	
			
			/********** ��ǰ ���:�̽¿� **************/
			//OUTER ��ǰ ����Ʈ 1
			if(com.equals("/productWrite.do")){
				command = new ProductWriteCMD();  
				command.execute(req,res);
				nextPage = "productDetail.do";
			}
			
			/********** ��ǰ�� Ŀ�ǵ�:�̽¿� **************/
			//PRODUCT DETAIL SELECT
			if(com.equals("/productDetail.do")){
				command = new ProductDetailListCMD();
				command.execute(req, res);
				command = new ProductOptionListCMD();
				command.execute(req, res);
				command = new DetailreviewListCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=productDetail";
			}
			
			/********** OUTER ��ǰ Ŀ�ǵ�:�̹�ȭ **************/
			//OUTER ��ǰ ����Ʈ 1
			if(com.equals("/outer_list.do")){
				command = new ProductListCMD(1);  
				command.execute(req,res);
				nextPage = "main.jsp?menu=outer_list";
			}
		
			/********** TOP ��ǰ Ŀ�ǵ�:�̹�ȭ **************/
			//TOP ��ǰ ����Ʈ 2
			if(com.equals("/top_list.do")){
				command = new ProductListCMD(2);
				command.execute(req,res);
				nextPage = "main.jsp?menu=top_list";
			}
			
			/********** BOTTOMS ��ǰ Ŀ�ǵ�:�̹�ȭ **************/
			//BOTTOMS ��ǰ ����Ʈ 3
			if(com.equals("/bottoms_list.do")){
				command = new ProductListCMD(3);
				command.execute(req,res);
				nextPage = "main.jsp?menu=bottoms_list";
			}
			
			/********** ONEPIECE ��ǰ Ŀ�ǵ�:�̹�ȭ **************/
			//ONEPIECE ��ǰ ����Ʈ 4
			if(com.equals("/onepiece_list.do")){
				command = new ProductListCMD(4);
				command.execute(req,res);
				nextPage = "main.jsp?menu=onepiece_list";
			}
			
			/********** SALE ��ǰ Ŀ�ǵ�:�̹�ȭ **************/
			//SALE ��ǰ ��Ϻ��� 6
			if(com.equals("/sale_list.do")){
				command = new ProductListCMD(6); 
				command.execute(req,res);
				nextPage = "main.jsp?menu=sale_list";
			}

			/********** ETC ��ǰ Ŀ�ǵ�:�̹�ȭ **************/
			//ETC ��ǰ ��Ϻ��� 5
			if(com.equals("/etc_list.do")){
				command = new ProductListCMD(5);
				command.execute(req,res);
				nextPage = "main.jsp?menu=etc_list";
			}
			
			
			
/******************** com.question, bbs/question/qna_*.jsp : ������ **********************/
	//��Ϻ���//p54���� �߰�
		  		
			//����¡ ó�� �� �� ���
			if(com.equals("/qna_list.do")){
				command = new QnABoardPageCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=qna_listPage";
			}//���������������� ���
			if(com.equals("/manager_qna_list.do")){
				command = new QnABoardPageCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_qna_listPage";
			}
			//��Ϻ���//p54���� �߰�
			//�ڵ��߰�27p(�۾���)-----------------------------------------------------------
			//�۾��� ��
			if(com.equals("/qna_writeui.do")){
				nextPage = "main.jsp?menu=qna_write";
			}
			//�����ڿ��� �۾�����
			if(com.equals("/manager_qna_writeui.do")){
				nextPage = "manager_main.jsp?menu=manager_qna_write";
			}
			// �۾���
			if(com.equals("/qna_write.do")){
				command = new QnABoardWriteCMD();
				command.execute(req, res);
				nextPage = "qna_list.do";
			}//�����ڿ��� �۾���
			if(com.equals("/manager_qna_write.do")){
				command = new QnABoardWriteCMD();
				command.execute(req, res);
				nextPage = "manager_qna_list.do?mode=manager";
			}
			//�ڵ��߰�27p-----------------------------------------------------------
			//�ڵ��߰�30p(�� ���� ����)-----------------------------------------------------------
			if(com.equals("/qna_retrieve.do")){
				command = new QnABoardRetrieveCMD();
				command.execute(req,  res);
				nextPage = "main.jsp?menu=qna_retrieve";
			}
			if(com.equals("/manager_qna_retrieve.do")){
				command = new QnABoardRetrieveCMD();
				command.execute(req,  res);
				nextPage = "manager_main.jsp?menu=manager_qna_retrieve&mode=manager";
			}
			//�󼼺����߰�	
			if(com.equals("/qna_detail.do")){
				command = new QnABoardDetailCMD();
				command.execute(req,  res);
				nextPage = "main.jsp?menu=qna_detail";
			}//������ȭ�鿡�� �󼼺���
			if(com.equals("/manager_qna_detail.do")){
				command = new QnABoardDetailCMD();
				command.execute(req,  res);
				nextPage = "manager_main.jsp?menu=manager_qna_detail";
			}
			//�ڵ��߰�30p(�� �ڼ��� ����)-----------------------------------------------------------
			//�ڵ��߰�33p(�� �����ϱ�)-----------------------------------------------------------
			if(com.equals("/qna_update.do")){
				command = new QnABoardUpdateCMD();
				command.execute(req, res);
				nextPage = "qna_list.do";
			}
			if(com.equals("/manager_qna_update.do")){
				command = new QnABoardUpdateCMD();
				command.execute(req, res);
				nextPage = "manager_qna_list.do?mode=manager";
			}
			//�ڵ��߰�33p(�� �����ϱ�)-----------------------------------------------------------
			//�ڵ��߰�34p(�� �����ϱ�)-----------------------------------------------------------
			if(com.equals("/qna_delete.do")){
				command = new QnABoardDeleteCMD();
				command.execute(req, res);
				nextPage = "qna_list.do";
			}
			if(com.equals("/manager_qna_delete.do")){
				command = new QnABoardDeleteCMD();
				command.execute(req, res);
				nextPage = "manager_qna_list.do?mode=manager";
			}
			//�ڵ��߰�34p(�� �����ϱ�)-----------------------------------------------------------
			//�ڵ��߰�37p(�� �˻��ϱ�)-----------------------------------------------------------
			if(com.equals("/qna_search.do")){
				command = new QnABoardSearchCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=qna_listPage";
			}//�����ڿ��� �˻�
			if(com.equals("/manager_qna_search.do")){
				command = new QnABoardSearchCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_qna_listPage&mode=manager";
			}
			//�ڵ��߰�37p(�� �˻��ϱ�)-----------------------------------------------------------
			//�ڵ��߰�39p(�亯�ϱ�)-----------------------------------------------------------
			if(com.equals("/qna_replyui.do")){
				command = new QnABoardReplyUICMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=qna_reply";
			}//�����ڿ��� �亯��
			if(com.equals("/manager_qna_replyui.do")){
				command = new QnABoardReplyUICMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_qna_reply";
			}
			//�ڵ��߰�39p(�亯�ϱ�)-----------------------------------------------------------
			//�ڵ��߰�49p(�亯�۾���)-----------------------------------------------------------
			if(com.equals("/qna_reply.do")){
				command = new QnABoardReplyCMD();
				command.execute(req, res);
				nextPage = "qna_list.do";
			}//�����ڿ��� �亯�ϱ�
			if(com.equals("/manager_qna_reply.do")){
				command = new QnABoardReplyCMD();
				command.execute(req, res);
				nextPage = "manager_qna_list.do";
			}
			//�ڵ��߰�49p(�亯�۾���)-----------------------------------------------------------
								
			
			
/******************** com.wishlist wishList.jsp : ��ȫ�� **********************/	
			
			if(com.equals("/wishlist.do")){//wishlist��� �����ֱ�
				logger.info("�������?");	
				command = new WishListViewCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=wishlist";
			}
			if(com.equals("/wishlist_delete.do")){ //wishlist ����
				command = new WishListDeleteCMD();
				command.execute(req, res);
				nextPage = "wishlist.do";
			}if(com.equals("/wishlist_insert.do")){//wishlist ���
				command = new WishListInsertCMD();
				command.execute(req, res);
				nextPage="wishlist.do";
			}
/******************************com.manager : ��ȫ��***********************************/		
			if(com.equals("/manager_main.do")){
			//	logger.info("�����ڸ���");
				command = new ManagerMemberListCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_list";
			}
			if(com.equals("/manager_productDetail.do")){
				command = new ProductDetailListCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_productDetail";
			}
			if(com.equals("/manager_list.do")){
			    //logger.info("����");
				command = new ManagerMemberListCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_list";
			}
		
			if(com.equals("/manager_detail_list.do")){
			    //logger.info("������");
				command = new ManagerMemberListCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_detail_list";
			}
			if(com.equals("/manager_todayorder.do")){
			//	logger.info("�����ֹ��Ǽ�");
				command = new ManagerTodayOrderCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_todayorder";
			}
			if(com.equals("/manager_bestitem.do")){
				//	logger.info("�α��ǰ");
				command = new ManagerBestItemCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_bestitem";
			}
			if(com.equals("/manager_orderstatus.do")){
			//	logger.info("�ֹ����º� ���");
				command = new ManagerOrderStatusCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_orderstatus";
			}
			if(com.equals("/manager_orderdetail.do")){
				//	logger.info("�ֹ�������");
				command = new ManagerOrderDetailCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_orderdetail";
			}
			if(com.equals("/manager_sales.do")){
			//	logger.info("��/�� ���ⷮ");
				command = new ManagerSalesCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_sales";
			}
			if(com.equals("/manager_productsales.do")){
			//	logger.info("��ǰ�� ���ⷮ");
				command = new ManagerProductSalesCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_productsales";
			}
			if(com.equals("/manager_productlist.do")){
			//	logger.info("��ǰ ��ü ���");
				command = new ManagerProductListCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_productlist";
			}if(com.equals("/manager_orderstatuschange.do")){
				logger.info("�ֹ����¹ٲٱ�");
				command = new ManagerOrderStatusChangeCMD();
				command.execute(req, res);
				String next=(String)req.getAttribute("next");
				logger.info("next��������?"+next);
				nextPage="manager_orderstatus.do?status="+next;
			}
			//QNA�����ٰ� ���̱�
			if(com.equals("/manager_notice_list.do")){
				command = new NoticePageCMD();
				command.execute(req,res);
				nextPage = "manager_main.jsp?menu=manager_notice_listPage";
			}
			
			
			/*
			///////////////�Խ�������(������)//////
			if(com.equals("/manager_boardall.do")){
				command = new QnABoardPageCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=qna_listPage";
			}
			*/
			
		
		
			
			

/*************************** �۾��� : ���� ������ ***********************************/
		if(com.equals("/reviewWrite.do")){
			logger.info("revieWrite.do");
			command = new reviewWriteCMD();
			command.execute(req, res);
			int productno = (int)req.getAttribute("review");
			if(productno == 1){
			     res.setCharacterEncoding("EUC-KR");
			     PrintWriter writer = res.getWriter();
			     writer.println("<script type='text/javascript'>");
			     writer.println("alert('��ǰ���� �ѹ��� �����մϴ�.');");
			     writer.println("history.back();");
			     writer.println("</script>");
			     writer.flush();
				return;
			     
			}else{
				System.out.println(productno);
				 res.setCharacterEncoding("EUC-KR");
			     PrintWriter writer = res.getWriter();
			     writer.println("<script type='text/javascript'>");
			     writer.println("alert('��ϵǾ����ϴ�.');");
			     writer.println("location.href = 'productDetail.do?product_no="+ productno+"';" );
			     writer.println("</script>");
			     writer.flush();
				/*nextPage = "productDetail.do";*/
			     return;
			}
		}
		 
		if(com.equals("/reviewdelete.do")){
			logger.info("reviewdelete.do");
			command = new reviewDeleteCMD();
			command.execute(req, res);
			int productno = (int)req.getAttribute("comp");
			if(productno!=0){
				res.setCharacterEncoding("EUC-KR");
			     PrintWriter writer = res.getWriter();
			     writer.println("<script type='text/javascript'>");
			     writer.println("alert('����~');");
			     writer.println("location.href = 'productDetail.do?product_no="+ productno+"';" );
			     writer.println("</script>");
			     writer.flush();
			     return;
			}else{
				 res.setCharacterEncoding("EUC-KR");
			     PrintWriter writer = res.getWriter();
			     writer.println("<script type='text/javascript'>");
			     writer.println("alert('���� ���� ������������ �������~!');");
			     writer.println("history.back();");
			     writer.println("</script>");
			     writer.flush();
			     return;
			}
		}
		
		if(com.equals("/reviewUpdate.do")){
			logger.info("reviewUpdate.do");
			command = new ReviewUpdateCMD();
			command.execute(req, res);
		}

			
			
/******************** com.design , bbs/design/*.jsp �̽¿�, ������ **********************/	
			
			//����Ʈ;������ ��ǰ ��ü ����Ʈ �����ֱ�(design �޴�)
			if(com.equals("/designList.do")){
				logger.info("������ �Խ��� ��Ϻ����ֱ�");
				command = new DesignListCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=designList";
			}

			//��ǰ��;
			if(com.equals("/designDetail.do")){
				command = new DesignDetailCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=designDetail";
			}
			
			//���� ������ ��ǰ ���ȭ��
			if(com.equals("/designWriteForm.do")){
				logger.info("������ �Խ��� �۾���");	
				nextPage = "main.jsp?menu=designWriteForm";
			}
			//���� ������ ��ǰ ���;insert �� ��ü ����Ʈ�� 
			if(com.equals("/designWrite.do")){
				logger.info("������ �Խ��� �۾���");	
				command = new DesignWriteCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=crud";
			}
			//��ǰ����ȭ��
			if(com.equals("/designRetrieve.do")){
				command = new DesignRetrieveCMD();
				command.execute(req,  res);
				nextPage = "main.jsp?menu=designUpdate";
			}
			//��ǰ����
			if(com.equals("/designUpdate.do")){
				command = new DesignUpdateCMD();
				command.execute(req, res);
				nextPage = "designList.do";
			}
			//��ǰ����;
			if(com.equals("/designDelete.do")){
				command = new DesignDeleteCMD();
				command.execute(req, res);
				nextPage = "designList.do";
			}
			//��ǰ�˻�
			if(com.equals("/designSearch.do")){
				command = new DesignSearchCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=designList";
			}
			//��õ�� �ø���
			if(com.equals("/designfavorite.do")){
				command = new DesignFavoriteCMD();
				command.execute(req, res);
				if((int)req.getAttribute("review")==1){
				     res.setCharacterEncoding("EUC-KR");
				     PrintWriter writer = res.getWriter();
				     writer.println("<script type='text/javascript'>");
				     writer.println("alert('��õ�� �ѹ��� �����մϴ�.');");
				     writer.println("history.back();");
				     writer.println("</script>");
				     writer.flush();
			     return;
				}else{
					res.setCharacterEncoding("EUC-KR");
				     PrintWriter writer = res.getWriter();
				     writer.println("<script type='text/javascript'>");
				     writer.println("alert('��õ�Ǿ����ϴ�.');");
				     writer.println("history.back();");
				     writer.println("</script>");
				     writer.flush();
				     return;
				}
//				nextPage = "main.jsp?menu=designList";
				//nextPage = "designList.do";
			}
			
			
/******************** ������ ���� **********************/	
			
		RequestDispatcher dis = req.getRequestDispatcher(nextPage);
		dis.forward(req, res);
	}		
}
	