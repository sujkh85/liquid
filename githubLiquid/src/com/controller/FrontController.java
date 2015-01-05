package com.controller;
/***********************************************************************
 * 작업자 : 이승우
 * 작업일자 : 14.11.19
 * 어떤 파일에 호출받는가 : 
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 :  *.do 요청시 오는곳! // 모든 FC 통합
 * 이곳에서 통합관리  Ctrl + F 용 권장, 주석필수(패키지명,호충하는 jsp경로,작업자등 명시)
 ***********************************************************************/
//주석 예시
/******************** 패키지명,jsp경로,작업자 **********************/	

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
			logger.info("FrontController doGet 호출 성공");
		}
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			logger.info("FrontController doPost 호출 성공");
			req.setCharacterEncoding("EUC-KR");
			String reqURI = req.getRequestURI();
			String contextPath= req.getContextPath();
			String com = reqURI.substring(contextPath.length());
			Command command = null;
			String nextPage = null;
			System.out.println(com);
/********************** com.catalogue, main폴더 아래, 이승우 **********************/
			if(com.equals("/main.do")){
				command = new CatalogueCMD();
				command.execute(req, res);
				nextPage = "main.jsp";
			}
/******************** com.member, member폴더 아래 : 이승우 **********************/		
			
			/* 회원정보 수정 이동처리 [?단계]*/
			// 1. 마이페이지로 이동	(SELECT)
			if(com.equals("/memberpage.do")){
				command = new MemberPageCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=memberpage"; 
			}
			// 2-1. 회원정보수정폼으로 이동 (SELECT) 
			if(com.equals("/myinfoform.do")){
				logger.info("회원정보수정");
				command = new MemberInfoListCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=myinfoform";
			}
			if(com.equals("/manager_myinfoform.do")){
				logger.info("매니저 정보수정");
				command = new MemberInfoListCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_myinfoform";
			}
			// 2-2. 패스워드 수정 폼으로 이동
			if(com.equals("/pwform.do")){
				nextPage = "main.jsp?menu=pwform";
			}
				// 2-2-1 이전패스워드 확인 (SELECT)  
				if(com.equals("/pwcheck.do")){
					nextPage = "main.jsp?menu=pwcheck";
				}
				// 2-2-2 패스워드 변경 액션 (UPDATE) - 수정성공메시지
				if(com.equals("/pwupdate.do")){
					nextPage = "main.jsp?menu=memmessage";
				}
			// 3 회원정보수정 액션 (UPDATE) - 수정성공메시지 
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
			
			
			/* 로그인 페이지 이동처리 [3단계]*/
			
			// 1. 로그인폼으로 이동
			if(com.equals("/loginform.do")){
				nextPage = "main.jsp?menu=loginform";
			}
			// 2. 로그인 액션 - 세션값 담는 페이지로 이동 (SELECT)
			if(com.equals("/logingo.do")){
				command = new MemberLoginCMD();
				command.execute(req, res);
				nextPage = "member/memberLoginSession.jsp";
			}
			// 3. 로그아웃 액션 - 세션값 끊는 페이지로 이동
			if(com.equals("/logout.do")){
				nextPage = "member/memberLoginSessionOut.jsp";
			}
			
			
			
			/* 회원가입 페이지 이동 처리 [4 단계]*/
			
			// 1. 회원가입 약관으로 이동
			if(com.equals("/memberagree.do")){
				nextPage = "main.jsp?menu=memberagree";
			}
			// 2. 약관동의시 회원가입 폼으로 이동
			if(com.equals("/memberform.do")){
				nextPage = "main.jsp?menu=memberform";
			}
			// 3. 회원가입 중 아이디 및 닉네임 중복검사 액션 (SELECT)
			if(com.equals("/membercheck.do")){
				logger.info("아이디 중복검사 .do 요청 성공");
				command = new MemberConfirmCMD();
				command.execute(req, res);
				nextPage = "member/memberCheck.jsp";
			}
			// 4. 가입성공 액션 (INSERT) - 가입축하메시지로 이동
			if(com.equals("/membermessage.do")){
				command = new MemberInfoInsertCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=memmessage";
			}
			
			/* 회원탈퇴 페이지 이동 처리 [? 단계]*/
			// 1. 회원탈퇴 액션 (UPDATE) 
			// 구현 계획 : 회원탈퇴시 해당회원의 회원등급번호를 탈퇴회원으로 분류하여 
			// 해당 등급번호를 가지고 있는 회원의 정보는 숨길수 있게한다.
			
			
/******************** com.notice, bbs/notice/notice_*.jsp: 이묘화 **********************/			
			
			//페이징 처리
			if(com.equals("/notice_list.do")){
				command = new NoticePageCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=notice_listPage";
			}
			//관리자모드에서 페이징 처리
			if(com.equals("/manager_notice_list.do")){
				command = new NoticePageCMD();
				command.execute(req,res);
				nextPage = "manager_main.jsp?menu=manager_notice_listPage";
			}
			//글 수정하기
			if(com.equals("/notice_update.do")){
				command = new NoticeUpdateCMD();
				command.execute(req,res);
				nextPage = "notice_list.do";
			}
			//관리자모드에서 글 수정하기
			if(com.equals("/manager_notice_update.do")){
				command = new NoticeUpdateCMD();
				command.execute(req,res);
				nextPage = "manager_notice_list.do";
			}

			//글쓰기 폼
			if(com.equals("/notice_writeui.do")){
				nextPage = "main.jsp?menu=notice_write";
			}
			//관리자모드에서 글쓰기 폼
			if(com.equals("/manager_notice_writeui.do")){
				nextPage = "manager_main.jsp?menu=manager_notice_write";
			}
			
			//글쓰기
			if(com.equals("/notice_write.do")){
				command = new NoticeWriteCMD();
				command.execute(req, res);
				nextPage = "notice_list.do";
			}
			//관리자모드에서 글쓰기
			if(com.equals("/manager_notice_write.do")){
				command = new NoticeWriteCMD();
				command.execute(req, res);
				nextPage = "manager_notice_list.do";
			}
			//수정화면 창
			if(com.equals("/notice_retrieve.do")){
				command = new NoticeRetrieveupdateCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=notice_retrieve";
			}
			//관리자모드에서 수정화면 창
			if(com.equals("/manager_notice_retrieve.do")){
				command = new NoticeRetrieveupdateCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_notice_retrieve";
			}
			//상세보기
			if(com.equals("/notice_detail.do")){
				command = new NoticeRetrieveCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=notice_detail";
			}//관리자모드에서 상세보기
			if(com.equals("/manager_notice_detail.do")){
				command = new NoticeRetrieveCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_notice_detail";
			}
			
			//글 삭제하기
			if(com.equals("/notice_delete.do")){
				command = new NoticeDeleteCMD();
				command.execute(req,res);
				nextPage = "notice_list.do";
			}
			//관리자모드에서 글 삭제하기
			if(com.equals("/manager_notice_delete.do")){
				command = new NoticeDeleteCMD();
				command.execute(req,res);
				nextPage = "manager_notice_list.do";
			}
			
			//글 검색하기
			if(com.equals("/notice_search.do")){
				command = new NoticeSearchCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=notice_listPage";
			}
			//관리자모드에서 글 검색하기
			if(com.equals("/manager_notice_search.do")){
				command = new NoticeSearchCMD();
				command.execute(req,res);
				nextPage = "manager_main.jsp?menu=manager_notice_listPage";
			}
			
/******************** com.order, bbs/order/order_*.jsp : 이묘화/이승우 **********************/	
			
			//주문내역 리스트
			if(com.equals("/order_list.do")){
				command = new OrderListCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=order_list";
			}
			//주문상세 리스트
			if(com.equals("/orderDetailInfo.do")){
				command = new OrderDetailInfoCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=orderDetailInfo";
			}
			//주문서 작성
			if(com.equals("/order_writeForm.do")){
				command = new OrderDetailCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=order_writeForm";
			}
			//주문상세입력
			if(com.equals("/order_insert.do")){
				command = new OrderWriteCMD();
				command.execute(req,res);
				nextPage = "order_list.do";
			}
			
			//주문취소
			if(com.equals("/order_delete.do")){
				command = new OrderDeleteCMD();
				command.execute(req,res);
				nextPage = "order_list.do";
			}
			//결제 넘어가기
			if(com.equals("/order_payment.do")){
				command = new OrderPaymentCMD();
				command.execute(req,res);
				nextPage = "order_list.do";
			}
/******************** com.order, cart/cart_*.jsp : 이묘화/이승우 **********************/				
			/*//디테일에서 장바구니 담을 경우 해당 상품 재고관리번호 쿠키 생성
			if(com.equals("/cartCookie.do")){
				command = new CookieCreateCMD();
				command.execute(req,res);
				nextPage = "cartList.do";  
			}*/
		
			// 실제 장바구니에 보여줄 데이터 처리 : 쿠키나누기와상품조회
			if(com.equals("/cartList.do")){
				command = new CartListCMD();
				command.execute(req,res);
				nextPage = "main.jsp?menu=cart_list";
			}
			
			
			
/******************** com.product, bbs/product/product*.jsp : 이승우,이묘화 **********************/	
			
			/********** 상품 등록:이승우 **************/
			//OUTER 상품 리스트 1
			if(com.equals("/productWrite.do")){
				command = new ProductWriteCMD();  
				command.execute(req,res);
				nextPage = "productDetail.do";
			}
			
			/********** 상품상세 커맨드:이승우 **************/
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
			
			/********** OUTER 상품 커맨드:이묘화 **************/
			//OUTER 상품 리스트 1
			if(com.equals("/outer_list.do")){
				command = new ProductListCMD(1);  
				command.execute(req,res);
				nextPage = "main.jsp?menu=outer_list";
			}
		
			/********** TOP 상품 커맨드:이묘화 **************/
			//TOP 상품 리스트 2
			if(com.equals("/top_list.do")){
				command = new ProductListCMD(2);
				command.execute(req,res);
				nextPage = "main.jsp?menu=top_list";
			}
			
			/********** BOTTOMS 상품 커맨드:이묘화 **************/
			//BOTTOMS 상품 리스트 3
			if(com.equals("/bottoms_list.do")){
				command = new ProductListCMD(3);
				command.execute(req,res);
				nextPage = "main.jsp?menu=bottoms_list";
			}
			
			/********** ONEPIECE 상품 커맨드:이묘화 **************/
			//ONEPIECE 상품 리스트 4
			if(com.equals("/onepiece_list.do")){
				command = new ProductListCMD(4);
				command.execute(req,res);
				nextPage = "main.jsp?menu=onepiece_list";
			}
			
			/********** SALE 상품 커맨드:이묘화 **************/
			//SALE 상품 목록보기 6
			if(com.equals("/sale_list.do")){
				command = new ProductListCMD(6); 
				command.execute(req,res);
				nextPage = "main.jsp?menu=sale_list";
			}

			/********** ETC 상품 커맨드:이묘화 **************/
			//ETC 상품 목록보기 5
			if(com.equals("/etc_list.do")){
				command = new ProductListCMD(5);
				command.execute(req,res);
				nextPage = "main.jsp?menu=etc_list";
			}
			
			
			
/******************** com.question, bbs/question/qna_*.jsp : 전종우 **********************/
	//목록보기//p54수정 추가
		  		
			//페이징 처리 한 글 목록
			if(com.equals("/qna_list.do")){
				command = new QnABoardPageCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=qna_listPage";
			}//관리자페이지에서 목록
			if(com.equals("/manager_qna_list.do")){
				command = new QnABoardPageCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_qna_listPage";
			}
			//목록보기//p54수정 추가
			//코드추가27p(글쓰기)-----------------------------------------------------------
			//글쓰기 폼
			if(com.equals("/qna_writeui.do")){
				nextPage = "main.jsp?menu=qna_write";
			}
			//관리자에서 글쓰기폼
			if(com.equals("/manager_qna_writeui.do")){
				nextPage = "manager_main.jsp?menu=manager_qna_write";
			}
			// 글쓰기
			if(com.equals("/qna_write.do")){
				command = new QnABoardWriteCMD();
				command.execute(req, res);
				nextPage = "qna_list.do";
			}//관리자에서 글쓰기
			if(com.equals("/manager_qna_write.do")){
				command = new QnABoardWriteCMD();
				command.execute(req, res);
				nextPage = "manager_qna_list.do?mode=manager";
			}
			//코드추가27p-----------------------------------------------------------
			//코드추가30p(글 수정 보기)-----------------------------------------------------------
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
			//상세보기추가	
			if(com.equals("/qna_detail.do")){
				command = new QnABoardDetailCMD();
				command.execute(req,  res);
				nextPage = "main.jsp?menu=qna_detail";
			}//관리자화면에서 상세보기
			if(com.equals("/manager_qna_detail.do")){
				command = new QnABoardDetailCMD();
				command.execute(req,  res);
				nextPage = "manager_main.jsp?menu=manager_qna_detail";
			}
			//코드추가30p(글 자세히 보기)-----------------------------------------------------------
			//코드추가33p(글 수정하기)-----------------------------------------------------------
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
			//코드추가33p(글 수정하기)-----------------------------------------------------------
			//코드추가34p(글 삭제하기)-----------------------------------------------------------
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
			//코드추가34p(글 삭제하기)-----------------------------------------------------------
			//코드추가37p(글 검색하기)-----------------------------------------------------------
			if(com.equals("/qna_search.do")){
				command = new QnABoardSearchCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=qna_listPage";
			}//관리자에서 검색
			if(com.equals("/manager_qna_search.do")){
				command = new QnABoardSearchCMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_qna_listPage&mode=manager";
			}
			//코드추가37p(글 검색하기)-----------------------------------------------------------
			//코드추가39p(답변하기)-----------------------------------------------------------
			if(com.equals("/qna_replyui.do")){
				command = new QnABoardReplyUICMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=qna_reply";
			}//관리자에서 답변폼
			if(com.equals("/manager_qna_replyui.do")){
				command = new QnABoardReplyUICMD();
				command.execute(req, res);
				nextPage = "manager_main.jsp?menu=manager_qna_reply";
			}
			//코드추가39p(답변하기)-----------------------------------------------------------
			//코드추가49p(답변글쓰기)-----------------------------------------------------------
			if(com.equals("/qna_reply.do")){
				command = new QnABoardReplyCMD();
				command.execute(req, res);
				nextPage = "qna_list.do";
			}//관리자에서 답변하기
			if(com.equals("/manager_qna_reply.do")){
				command = new QnABoardReplyCMD();
				command.execute(req, res);
				nextPage = "manager_qna_list.do";
			}
			//코드추가49p(답변글쓰기)-----------------------------------------------------------
								
			
			
/******************** com.wishlist wishList.jsp : 이홍수 **********************/	
			
			if(com.equals("/wishlist.do")){//wishlist목록 보여주기
				logger.info("여기오나?");	
				command = new WishListViewCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=wishlist";
			}
			if(com.equals("/wishlist_delete.do")){ //wishlist 삭제
				command = new WishListDeleteCMD();
				command.execute(req, res);
				nextPage = "wishlist.do";
			}if(com.equals("/wishlist_insert.do")){//wishlist 담기
				command = new WishListInsertCMD();
				command.execute(req, res);
				nextPage="wishlist.do";
			}
/******************************com.manager : 이홍수***********************************/		
			if(com.equals("/manager_main.do")){
			//	logger.info("관리자메인");
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
			    //logger.info("정보");
				command = new ManagerMemberListCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_list";
			}
		
			if(com.equals("/manager_detail_list.do")){
			    //logger.info("상세정보");
				command = new ManagerMemberListCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_detail_list";
			}
			if(com.equals("/manager_todayorder.do")){
			//	logger.info("오늘주문건수");
				command = new ManagerTodayOrderCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_todayorder";
			}
			if(com.equals("/manager_bestitem.do")){
				//	logger.info("인기상품");
				command = new ManagerBestItemCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_bestitem";
			}
			if(com.equals("/manager_orderstatus.do")){
			//	logger.info("주문상태별 목록");
				command = new ManagerOrderStatusCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_orderstatus";
			}
			if(com.equals("/manager_orderdetail.do")){
				//	logger.info("주문상세정보");
				command = new ManagerOrderDetailCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_orderdetail";
			}
			if(com.equals("/manager_sales.do")){
			//	logger.info("일/월 매출량");
				command = new ManagerSalesCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_sales";
			}
			if(com.equals("/manager_productsales.do")){
			//	logger.info("상품별 매출량");
				command = new ManagerProductSalesCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_productsales";
			}
			if(com.equals("/manager_productlist.do")){
			//	logger.info("상품 전체 목록");
				command = new ManagerProductListCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=manager_productlist";
			}if(com.equals("/manager_orderstatuschange.do")){
				logger.info("주문상태바꾸기");
				command = new ManagerOrderStatusChangeCMD();
				command.execute(req, res);
				String next=(String)req.getAttribute("next");
				logger.info("next가져오나?"+next);
				nextPage="manager_orderstatus.do?status="+next;
			}
			//QNA가져다가 붙이기
			if(com.equals("/manager_notice_list.do")){
				command = new NoticePageCMD();
				command.execute(req,res);
				nextPage = "manager_main.jsp?menu=manager_notice_listPage";
			}
			
			
			/*
			///////////////게시판전부(공사중)//////
			if(com.equals("/manager_boardall.do")){
				command = new QnABoardPageCMD();
				command.execute(req, res);
				nextPage="manager_main.jsp?menu=qna_listPage";
			}
			*/
			
		
		
			
			

/*************************** 작업자 : 김용민 공사중 ***********************************/
		if(com.equals("/reviewWrite.do")){
			logger.info("revieWrite.do");
			command = new reviewWriteCMD();
			command.execute(req, res);
			int productno = (int)req.getAttribute("review");
			if(productno == 1){
			     res.setCharacterEncoding("EUC-KR");
			     PrintWriter writer = res.getWriter();
			     writer.println("<script type='text/javascript'>");
			     writer.println("alert('상품평은 한번만 가능합니다.');");
			     writer.println("history.back();");
			     writer.println("</script>");
			     writer.flush();
				return;
			     
			}else{
				System.out.println(productno);
				 res.setCharacterEncoding("EUC-KR");
			     PrintWriter writer = res.getWriter();
			     writer.println("<script type='text/javascript'>");
			     writer.println("alert('등록되었습니다.');");
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
			     writer.println("alert('지움~');");
			     writer.println("location.href = 'productDetail.do?product_no="+ productno+"';" );
			     writer.println("</script>");
			     writer.flush();
			     return;
			}else{
				 res.setCharacterEncoding("EUC-KR");
			     PrintWriter writer = res.getWriter();
			     writer.println("<script type='text/javascript'>");
			     writer.println("alert('삭제 못함 경한이형한테 물어봐라~!');");
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

			
			
/******************** com.design , bbs/design/*.jsp 이승우, 전종우 **********************/	
			
			//리스트;디자인 작품 전체 리스트 보여주기(design 메뉴)
			if(com.equals("/designList.do")){
				logger.info("디자인 게시판 목록보여주기");
				command = new DesignListCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=designList";
			}

			//작품상세;
			if(com.equals("/designDetail.do")){
				command = new DesignDetailCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=designDetail";
			}
			
			//유저 디자인 작품 등록화면
			if(com.equals("/designWriteForm.do")){
				logger.info("디자인 게시판 글쓰기");	
				nextPage = "main.jsp?menu=designWriteForm";
			}
			//유저 디자인 작품 등록;insert 후 전체 리스트로 
			if(com.equals("/designWrite.do")){
				logger.info("디자인 게시판 글쓰기");	
				command = new DesignWriteCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=crud";
			}
			//작품수정화면
			if(com.equals("/designRetrieve.do")){
				command = new DesignRetrieveCMD();
				command.execute(req,  res);
				nextPage = "main.jsp?menu=designUpdate";
			}
			//작품수정
			if(com.equals("/designUpdate.do")){
				command = new DesignUpdateCMD();
				command.execute(req, res);
				nextPage = "designList.do";
			}
			//작품삭제;
			if(com.equals("/designDelete.do")){
				command = new DesignDeleteCMD();
				command.execute(req, res);
				nextPage = "designList.do";
			}
			//작품검색
			if(com.equals("/designSearch.do")){
				command = new DesignSearchCMD();
				command.execute(req, res);
				nextPage = "main.jsp?menu=designList";
			}
			//추천수 올리기
			if(com.equals("/designfavorite.do")){
				command = new DesignFavoriteCMD();
				command.execute(req, res);
				if((int)req.getAttribute("review")==1){
				     res.setCharacterEncoding("EUC-KR");
				     PrintWriter writer = res.getWriter();
				     writer.println("<script type='text/javascript'>");
				     writer.println("alert('추천은 한번만 가능합니다.');");
				     writer.println("history.back();");
				     writer.println("</script>");
				     writer.flush();
			     return;
				}else{
					res.setCharacterEncoding("EUC-KR");
				     PrintWriter writer = res.getWriter();
				     writer.println("<script type='text/javascript'>");
				     writer.println("alert('추천되었습니다.');");
				     writer.println("history.back();");
				     writer.println("</script>");
				     writer.flush();
				     return;
				}
//				nextPage = "main.jsp?menu=designList";
				//nextPage = "designList.do";
			}
			
			
/******************** 디스펙쳐 서블릿 **********************/	
			
		RequestDispatcher dis = req.getRequestDispatcher(nextPage);
		dis.forward(req, res);
	}		
}
	