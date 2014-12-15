<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!--
/***********************************************************************
 * �۾��� : ��ȫ�� �� �ֽ�ȯ(��Ÿ���۾�) �� �̽¿�(index.jsp���� �ҽ�����)
 * �۾����� : 2014.11.03~05, 11.11
 * � ���Ͽ� ȣ��޴°� :  Index.jsp
 * � ������ ȣ���ϴ°� :  main_Top.jsp,mainProductCatalogue.jsp,
 					 main_UserDesignCatalogue.jsp,main_Footer.jsp
 * ���� Ÿ�� : ��üƲ(�׽�Ʈ��..) 
 ***********************************************************************/
  -->     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">     
<html>
<head>
<!--�Ʒ� meta �±׸� ���� ������ ����� ���� �������� �� ��ҵǾ� ����: ����� ���� ���� ���� ����-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main.jsp</title>
<link rel="stylesheet" href="./css/main.css" type="text/css">
</head> 
<body> 



<%  
	String menu = request.getParameter("menu");
	out.print("������ �޴� : "+menu);// menu���� �߳Ѿ������ Ȯ��	
%>
<div class="main">
<!--============================ main_Top.jsp =================================-->
	<div class="main-header" style="margin-bottom: 100px;">
			<jsp:include page="main/main_Top.jsp" />
			<jsp:include page="main/main_popup.jsp" /> 
	</div>
<!--===========================================================================-->
<!--============================== ��� =========================================-->			
<%		if(menu == null){	
%>	<div class="main-banner">
		<jsp:include page="main/main_Banner.jsp" />	
	</div>		
<!--===========================================================================-->		
		<div class="main-content">
			<jsp:include page="main/main_ProductCatalogue.jsp" />
<!--  ��ǰ�Խ��� �� rolling ��� : �ֽ�ȯ -->
			<jsp:include page="main/main_rolling_banner.jsp"/>
			<jsp:include page="main/main_UserDesignCatalogue.jsp" />
			
<!-- ���� �Խ��� ������ �̵� : ���� ������ -->
<!-- ȸ��Ż�� ������ �̵� : �̽¿� �̱��� -->

<!-- �α��� ������ �̵� : �̽¿�,������ -->	
<%		}else if("loginform".equals(menu)){
%>			<jsp:include page="member/memberLoginForm.jsp" />

<!-- ȸ������ ������ �̵� : �̽¿� -->
<%		}else if("memberagree".equals(menu)){
%>			<jsp:include page="member/memberTerms.jsp" />
<%		}else if("memberform".equals(menu)){
%>			<jsp:include page="member/memberForm.jsp" />
<!-- ȸ���������� ������ �̵� : �̽¿� -->
<%		}else if("memberpage".equals(menu)){
%>			<jsp:include page="member/memberPage.jsp" />
<%		}else if("myinfoform".equals(menu)){
%>			<jsp:include page="member/memberFormEdit.jsp" />
<%		}else if("pwform".equals(menu)){
%>			<jsp:include page="member/memberPWForm.jsp" />
<%		}else if("pwcheck".equals(menu)){
%>			<jsp:include page="member/memberPWCheck.jsp" />
<!-- ȸ������/����/Ż�� �޽��� ��� �̵������� -->
<%		}else if("memmessage".equals(menu)){
%>			<jsp:include page="message/member.jsp" />


<!-- insert / update / delete  -->
<%		}else if("crud".equals(menu)){
%>			<jsp:include page="message/crud.jsp" />

<!-- ������ �Խ��� �������̵�  -->
<%		}else if("designList".equals(menu)){
%>			<jsp:include page="bbs/design/designList.jsp" />
<%		}else if("designWriteForm".equals(menu)){
%>			<jsp:include page="bbs/design/designWriteForm.jsp" /> 
<%		}else if("designDetail".equals(menu)){
%>			<jsp:include page="bbs/design/designDetail.jsp" />
<%		}else if("designUpdate".equals(menu)){
%>			<jsp:include page="bbs/design/designUpdate.jsp" />



<!-- ��ȸ�� ��밡�� : ��ٱ��� Cookie -->
<%		}else if("cart_list".equals(menu)){
%>			<jsp:include page="/cart/cartCookieList.jsp" />


<!-- ȸ������ - ���ø���Ʈ : ��ȫ�� -->
<%		}else if("wishlist".equals(menu)){
%>			<jsp:include page="./bbs/order/WishList.jsp" />
<!-- ȸ������ - ���������� : �̽¿� -->
<%		}else if("mypage".equals(menu)){
%>			<jsp:include page="member/memberPage.jsp" />
<!-- ȸ������ - �ֹ������� : �̹�ȭ -->
<%		}else if("orderInfo".equals(menu)){
%>			<jsp:include page="bbs/order/order_list.jsp" />

<!-- �������� �Խ��� ������ �̵� : �̹�ȭ -->
<%		}else if("notice_listPage".equals(menu)){
%>			<jsp:include page="./bbs/notice/notice_listPage.jsp" />	
<%		}else if("notice_retrieve".equals(menu)){
%>			<jsp:include page="./bbs/notice/notice_retrieve.jsp" />	
<%		}else if("notice_detail".equals(menu)){
%>			<jsp:include page="./bbs/notice/notice_detail.jsp" />	
<%		}else if("notice_write".equals(menu)){
%>			<jsp:include page="./bbs/notice/notice_write.jsp" />	 
 
<!-- Q&A �Խ��� ������ �̵� : ������-->
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

<!-- ��ǰ������ ����Ʈ ������ �̵� : �̹�ȭ -->
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

<!-- ��ǰ�������� �̵� : �̽¿�  -->
<%		}else if("productDetail".equals(menu)){
%>			<jsp:include page="./bbs/product/productDetail.jsp" />	 
 
<!-- �ֹ� ������ �̵� : �̹�ȭ  -->
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