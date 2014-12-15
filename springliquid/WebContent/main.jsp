<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!--
/***********************************************************************
 * 작업자 : 이홍수 → 최승환(스타일작업) → 이승우(index.jsp에서 소스이전)
 * 작업일자 : 2014.11.03~05, 11.11
 * 어떤 파일에 호출받는가 :  Index.jsp
 * 어떤 파일을 호출하는가 :  main_Top.jsp,mainProductCatalogue.jsp,
 					 main_UserDesignCatalogue.jsp,main_Footer.jsp
 * 파일 타입 : 전체틀(테스트용..) 
 ***********************************************************************/
  -->     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">     
<html>
<head>
<!--아래 meta 태그를 넣지 않으면 모바일 기기로 접속했을 때 축소되어 나옴: 모바일 버전 현재 적용 안함-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main.jsp</title>
<link rel="stylesheet" href="./css/main.css" type="text/css">
</head> 
<body> 



<%  
	String menu = request.getParameter("menu");
	out.print("선택한 메뉴 : "+menu);// menu값이 잘넘어오는지 확인	
%>
<div class="main">
<!--============================ main_Top.jsp =================================-->
	<div class="main-header" style="margin-bottom: 100px;">
			<jsp:include page="main/main_Top.jsp" />
			<jsp:include page="main/main_popup.jsp" /> 
	</div>
<!--===========================================================================-->
<!--============================== 배너 =========================================-->			
<%		if(menu == null){	
%>	<div class="main-banner">
		<jsp:include page="main/main_Banner.jsp" />	
	</div>		
<!--===========================================================================-->		
		<div class="main-content">
			<jsp:include page="main/main_ProductCatalogue.jsp" />
<!--  상품게시판 밑 rolling 배너 : 최승환 -->
			<jsp:include page="main/main_rolling_banner.jsp"/>
			<jsp:include page="main/main_UserDesignCatalogue.jsp" />
			
<!-- 리뷰 게시판 페이지 이동 : 김용민 구현중 -->
<!-- 회원탈퇴 페이지 이동 : 이승우 미구현 -->

<!-- 로그인 페이지 이동 : 이승우,전종우 -->	
<%		}else if("loginform".equals(menu)){
%>			<jsp:include page="member/memberLoginForm.jsp" />

<!-- 회원가입 페이지 이동 : 이승우 -->
<%		}else if("memberagree".equals(menu)){
%>			<jsp:include page="member/memberTerms.jsp" />
<%		}else if("memberform".equals(menu)){
%>			<jsp:include page="member/memberForm.jsp" />
<!-- 회원정보수정 페이지 이동 : 이승우 -->
<%		}else if("memberpage".equals(menu)){
%>			<jsp:include page="member/memberPage.jsp" />
<%		}else if("myinfoform".equals(menu)){
%>			<jsp:include page="member/memberFormEdit.jsp" />
<%		}else if("pwform".equals(menu)){
%>			<jsp:include page="member/memberPWForm.jsp" />
<%		}else if("pwcheck".equals(menu)){
%>			<jsp:include page="member/memberPWCheck.jsp" />
<!-- 회원가입/수정/탈퇴 메시지 결과 이동페이지 -->
<%		}else if("memmessage".equals(menu)){
%>			<jsp:include page="message/member.jsp" />


<!-- insert / update / delete  -->
<%		}else if("crud".equals(menu)){
%>			<jsp:include page="message/crud.jsp" />

<!-- 디자인 게시판 페이지이동  -->
<%		}else if("designList".equals(menu)){
%>			<jsp:include page="bbs/design/designList.jsp" />
<%		}else if("designWriteForm".equals(menu)){
%>			<jsp:include page="bbs/design/designWriteForm.jsp" /> 
<%		}else if("designDetail".equals(menu)){
%>			<jsp:include page="bbs/design/designDetail.jsp" />
<%		}else if("designUpdate".equals(menu)){
%>			<jsp:include page="bbs/design/designUpdate.jsp" />



<!-- 비회원 사용가능 : 장바구니 Cookie -->
<%		}else if("cart_list".equals(menu)){
%>			<jsp:include page="/cart/cartCookieList.jsp" />


<!-- 회원전용 - 위시리스트 : 이홍수 -->
<%		}else if("wishlist".equals(menu)){
%>			<jsp:include page="./bbs/order/WishList.jsp" />
<!-- 회원전용 - 마이페이지 : 이승우 -->
<%		}else if("mypage".equals(menu)){
%>			<jsp:include page="member/memberPage.jsp" />
<!-- 회원전용 - 주문상세정보 : 이묘화 -->
<%		}else if("orderInfo".equals(menu)){
%>			<jsp:include page="bbs/order/order_list.jsp" />

<!-- 공지사항 게시판 페이지 이동 : 이묘화 -->
<%		}else if("notice_listPage".equals(menu)){
%>			<jsp:include page="./bbs/notice/notice_listPage.jsp" />	
<%		}else if("notice_retrieve".equals(menu)){
%>			<jsp:include page="./bbs/notice/notice_retrieve.jsp" />	
<%		}else if("notice_detail".equals(menu)){
%>			<jsp:include page="./bbs/notice/notice_detail.jsp" />	
<%		}else if("notice_write".equals(menu)){
%>			<jsp:include page="./bbs/notice/notice_write.jsp" />	 
 
<!-- Q&A 게시판 페이지 이동 : 전종우-->
<%		}else if("qna_listPage".equals(menu)){
%>			<jsp:include page="./bbs/question/qna_listPage.jsp" />	 
<%		}else if("qna_detail".equals(menu)){
%>			<jsp:include page="./bbs/question/qna_detail.jsp" /> 	
<%		}else if("qna_reply".equals(menu)){
%>			<jsp:include page="./bbs/question/qna_reply.jsp" />	
<%		}else if("qna_retrieve".equals(menu)){
%>			<jsp:include page="./bbs/question/qna_retrieve.jsp" />	
<%		}else if("qna_write".equals(menu)){
%>			<jsp:include page="./bbs/question/qna_write.jsp" />	 

<!-- 상품종류별 리스트 페이지 이동 : 이묘화 -->
<%		}else if("outer_list".equals(menu)){
%>			<jsp:include page="./bbs/product/productList.jsp" />	  
<%		}else if("top_list".equals(menu)){
%>			<jsp:include page="./bbs/product/productList.jsp" />
<%		}else if("bottoms_list".equals(menu)){
%>			<jsp:include page="./bbs/product/productList.jsp" />
<%		}else if("onepiece_list".equals(menu)){
%>			<jsp:include page="./bbs/product/productList.jsp" />			
<%		}else if("etc_list".equals(menu)){
%>			<jsp:include page="./bbs/product/productList.jsp" />	 	 
<%		}else if("sale_list".equals(menu)){
%>			<jsp:include page="./bbs/product/productList.jsp" />	 

<!-- 상품상세페이지 이동 : 이승우  -->
<%		}else if("productDetail".equals(menu)){
%>			<jsp:include page="./bbs/product/productDetail.jsp" />	 
 
<!-- 주문 페이지 이동 : 이묘화  -->
<%		}else if("order_list".equals(menu)){
%>			<jsp:include page="./bbs/order/order_list.jsp" />
<%		}else if("order_writeForm".equals(menu)){
%>			<jsp:include page="./bbs/order/order_write.jsp" /> 
<%		}else if("order_payment".equals(menu)){
%>			<jsp:include page="./bbs/order/order_payment.jsp" /> 
<%		}else if("order_payList".equals(menu)){
%>			<jsp:include page="./bbs/order/order_list.jsp" /> 
<%		}else if("orderDetailInfo".equals(menu)){
%>			<jsp:include page="./bbs/order/orderDetailInfo.jsp" /> 
<%		}
%>


	</div>	

<!--========================== footer ==========================================-->
	<div class="main-footer" >
		<jsp:include page="main/main_Footer.jsp"/> 
	</div>
<!--===========================================================================-->			
</div>  
</body>
</html>