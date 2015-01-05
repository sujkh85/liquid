<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
    
<!--
/***********************************************************************
 * 작업자 : 이홍수 → 최승환(스타일작업) → 이승우(index.jsp에서 소스이전)
 * 작업일자 : 2014.11.03~05, 11.11
 * 어떤 파일에 호출받는가 :  Index.jsp
 * 어떤 파일을 호출하는가 :  manager폴더의 jsp파일들..
 					 
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
<link rel="stylesheet" href="./css/manager_main_top.css" type="text/css">
</head>
<body> 
</body>
<%  
	String menu = request.getParameter("menu");
	out.print("선택한 메뉴 : "+menu);// menu값이 잘넘어오는지 확인	
%>
<c:set var="mode1" scope="session" value="manager1"></c:set><!-- 세션 -->
<div class="main">
<!--============================ manager_main_Top.jsp =================================-->
	<div class="main-header">
			<jsp:include page="manager/manager_main_top.jsp" /> 
	</div>
<!--===========================================================================-->
<!--============================== 배너 =========================================-->			
<%		if(menu==null){	
%>	<div class="main-banner">
		<jsp:include page="main/main_Banner.jsp" />	
	</div>		
<!--===========================================================================-->		
		<div class="main-content" align="center">
			
			<h2>관리자페이지임</h2>
 
<%		}else if("manager_todayorder".equals(menu)){
%>			<jsp:include page="manager/TodayOrder.jsp"/>
<%		}else if("manager_list".equals(menu)){
%>			<jsp:include page="manager/MemberList.jsp"/>
<%		}else if("manager_detail_list".equals(menu)){
%>			<jsp:include page="manager/MemberDetailList.jsp"/>
<%		}else if("manager_bestitem".equals(menu)){
%>			<jsp:include page="manager/BestItem.jsp"/>
<%		}else if("manager_productDetail".equals(menu)){
%>			<jsp:include page="bbs/product/productDetail.jsp"/>
<%		}else if("manager_orderstatus".equals(menu)){
%>			<jsp:include page="manager/OrderStatus.jsp"/>
<%		}else if("manager_sales".equals(menu)){
%>			<jsp:include page="manager/Sales.jsp"/>
<%		}else if("manager_productsales".equals(menu)){
%>			<jsp:include page="manager/ProductSales.jsp" />
<%		}else if("manager_productlist".equals(menu)){
%>			<jsp:include page="manager/ProductList.jsp"/>
<%		}else if("manager_orderdetail".equals(menu)){
%> 			<jsp:include page="manager/OrderDetail.jsp"/>
 
 
 
<%		}else if("manager_qna_listPage".equals(menu)){
%>			<jsp:include page="bbs/question/qna_listPage.jsp" />
<%		}else if("manager_qna_detail".equals(menu)){
%>			<jsp:include page="bbs/question/qna_detail.jsp" />
<%		}else if("manager_qna_reply".equals(menu)){
%>			<jsp:include page="bbs/question/qna_reply.jsp" />
<%		}else if("manager_qna_retrieve".equals(menu)){
%>			<jsp:include page="bbs/question/qna_retrieve.jsp" />
<%		}else if("manager_qna_write".equals(menu)){
%>			<jsp:include page="bbs/question/qna_write.jsp" />


<%		}else if("manager_myinfoform".equals(menu)){
%>			<jsp:include page="manager/memberEdit.jsp"/>
<%		}else if("managermemmessage".equals(menu)){
%>			<jsp:include page="message/manager.jsp"/>



<%	    }else if("manager_notice_listPage".equals(menu)){
%>			<jsp:include page="bbs/notice/notice_listPage.jsp"/>
<%	    }else if("manager_notice_detail".equals(menu)){
%>			<jsp:include page="bbs/notice/notice_detail.jsp"/>
<%	    }else if("manager_notice_retrieve".equals(menu)){
%>			<jsp:include page="bbs/notice/notice_retrieve.jsp"/>
<%	    }else if("manager_notice_write".equals(menu)){
%>			<jsp:include page="bbs/notice/notice_write.jsp"/>
<%		}
%>		


	</div>	

<!--========================== footer ==========================================-->
	<div class="main-footer">
		<jsp:include page="main/main_Footer.jsp"/> 
	</div>
<!--===========================================================================-->			
</div>  
</body>
</html>