<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--
/***********************************************************************
 * �۾��� : ��ȫ��  ,�ֽ�ȯ(�̹����۾�),�̽¿�, ����ȯ
 * �۾����� : 2014.11.03, 11.11
 * � ���Ͽ� ȣ��޴°� : 
 * � ������ ȣ���ϴ°� :Login.jsp, Order.jsp, Cart.jsp, Mypage.jsp, Main.jsp
                Notice.jsp, qna_listPage.jsp, Review.jsp, Design.jsp, Search.jsp
                OUTER.jsp, TOP.jsp, PANTS.jsp, ONEPIECE.jsp, SALE.jsp 
 * ���� Ÿ�� : Main.jsp��ǰ
 * ������ : 11.11 Q&A �Խ��� �׽�Ʈ(list.jjw)
 * �ֽ�ȯ : 11.11 ���ηΰ� �̹���,��Ÿ�� ����
 * �̽¿� : 11.13 �α��ο��ο� ���� �ֻ�� �޴��� ���� �߰�
 * �̽¿� : 11.17 �ּ�, heder/top menu Ŭ���� ���� �߰�  
 * ��ȫ�� : 11.17 �α��� �������� Cart�޴� Ŭ���� 500���� �ȶ߰� ������ �˾�â �߰�
 * �ֽ�ȯ : 11.21 ���� ��� /��Ÿ�ϼ��� ... ž �߿��ο��� -> ���ڻ��� ,���ηΰ�� ���� gif���� ���� ��ü...�� ������ js ����
 * ��ȫ�� : 11.25 ������ �α��� ���ο� ���� Manager�޴� �߰�
 * ����ȯ : 12.07 ��Ʈ��Ʈ������
 ***********************************************************************/
  --> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<title>�ֻ�� �޴�</title>
<!-- ��Ʈ��Ʈ����뼱�� ����-->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="js/jquery-1.11.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- ��Ʈ��Ʈ����뼱�� ��-->
<script type="text/javascript"> 
	var pimage = new Array;
	var urls = new Array;
	var buttons = new Array;
 
 //pimage * �����̹������� ������680px * 733px
 //urls * ��ǰ��ũ�ּ�
 //[]���� ���ڴ� �̹������� �ǵ��� ���׸��ϼ�

      pimage[0] = './img/imggg_1.jpg';
      urls[0] = 'productDetail.do?product_no=1';
      buttons[0] = 'http://www.pighip.co.kr/design/pighip/images/off.png';
 	
      pimage[1] = './img/imggg_2.jpg' ;
      urls[1] = 'productDetail.do?product_no=3';
      buttons[1] = 'http://www.pighip.co.kr/design/pighip/images/off.png';
  
      pimage[2] = './img/imggg_3.jpg' ;
      urls[2] = 'productDetail.do?product_no=11';
      buttons[2] = 'http://www.pighip.co.kr/design/pighip/images/off.png';	
	
	var cliImg = '';
	var cliImgSrc = '';
	var n = Math.round(3);
	var interval = 3000;
	var setTimeId = '';
 
	function showStop() {
		clearTimeout(setTimeId);
	}
	 
	function showStart() {
		blurs();
	}
	 
	function chki(ci, no) {
	 var pImg = document.getElementById("RollImg");
	 var pUrl = document.getElementById("RollUrl");
	 
		if(cliImg == '') {
			cliImg = ci;
			cliImgSrc = ci.src;
			ci.src = buttons[no];
			n=no;
			pImg.src = pimage[no];
			pUrl.href = urls[no];		
		} else if(cliImg != ci) {
			cliImg.src = cliImgSrc;
			cliImg = ci;
			cliImgSrc = ci.src;
			ci.src = buttons[no];
			n=no;
			pImg.src = pimage[no];
			pUrl.href = urls[no];		
		}
	}
	 
	function blurs() {
		n = (n >= 2) ? 0 : n+1;
		setimgurl();
		setTimeId=setTimeout("blurs()",interval);
	}
	 
	function setimgurl() {
	 var ci = document.getElementById("num_img" + n);
	 
	 if(document.getElementById("RollImg").filters){
	 
	 document.getElementById("RollImg").filters.blendTrans.apply();
	 document.getElementById("RollImg").src=pimage[n];
	 document.getElementById("RollImg").filters.blendTrans.play();
	}else{
	document.getElementById("RollImg").src=pimage[n];
	}
	document.getElementById("RollUrl").href=urls[n];
		
		if(cliImg == '') {
			cliImg = ci;
			cliImgSrc = ci.src;
			ci.src = buttons[n];
		} else if(cliImg != ci) {
			cliImg.src = cliImgSrc;
			cliImg = ci;
			cliImgSrc = ci.src;
			ci.src = buttons[n];
		}
	}
</script>
</head>
<body>
<div class="main-header-minilogo">    
          		<!--  ���� �׸� ���� -->
          <img src="./img/top3.gif" />&nbsp;&nbsp;
          <a href="main.do"><img src="./img/main_top3.jpg" /></a>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <img src="./img/maintop.gif" />
</div>
<form name="i_home">
  <div class="main-header-top">
   <!-- �ֻ�ܸ޴� ���� tr�±׾ȿ� class�� ���� : header_menu -->
     <ul class="main-header-top-menu">
      <!-- �α��� ���ο� ���� ���ǰ�(ȸ������)�� ������ �ֻ�ܿ� �������� �޴��� ����  -->
      <c:choose>
         <c:when test="${s_member_info_no == null}">
           <span><a href="loginform.do" class="btn btn-default glyphicon glyphicon-off">Login</a></span>
           <span><a href="order_list.do" class="btn btn-default glyphicon glyphicon-hand-right">Order</a></span>
           <span><a href="cartList.do" class="btn btn-default glyphicon glyphicon-shopping-cart" >Cart</a></span>
           <span><a href="memberagree.do" class="btn btn-default glyphicon glyphicon-plus">Sign up</a></span>
         </c:when> 
         <c:when test="${s_member_info_no != null && s_member_grade_no != 10}">
            <span><a href="logout.do" class="btn btn-default glyphicon glyphicon-off">Logout</a></span>
           <span><a href="order_list.do" class="btn btn-default glyphicon glyphicon-hand-right">Order</a></span>
           <span><a href="cartList.do" class="btn btn-default glyphicon glyphicon-shopping-cart">Cart</a></span>
           <span><a href="wishlist.do" class="btn btn-default glyphicon glyphicon-heart-empty">WishList</a></span>
           <span><a href="memberpage.do" class="btn btn-default glyphicon glyphicon-star">Mypage</a></span>
         </c:when>
         <c:when test="${s_member_info_no !=null && s_member_grade_no == 10}">
           <span><a href="index.jsp?mode=manager" class="btn btn-default glyphicon glyphicon-tower">Manager</a></span>
           <span><a href="logout.do" class="btn btn-default glyphicon glyphicon-off">Logout</a></span>
           <span><a href="order_list.do" class="btn btn-default glyphicon glyphicon-hand-right">Order</a></span>
           <span><a href="cartList.do" class="btn btn-default glyphicon glyphicon-shopping-cart">Cart</a></span>
           <span><a href="wishlist.do" class="btn btn-default glyphicon glyphicon-heart-empty">WishList</a></span>
           <span><a href="memberpage.do" class="btn btn-default glyphicon glyphicon-star">Mypage</a></span>
         </c:when>
      </c:choose>
     </ul>
      </div>
      
	
       <table cellpadding="0" cellspacing="0">
          <tr>
            <td valign=top >
			   <DIV align=left>
			     <A onfocus=this.blur()  id=RollUrl>
				 <img src="http://pighip.img2.kr/yoonna/main_img/img0.jpg" name="RollImg"  border=0  id=RollImg ></A>	
			   </DIV>
			</td>
          </tr>
          <tr>
            <td valign=top align="left"> 
               <DIV style="POSITION: relative">
               <DIV style="POSITION: absolute;">
                 <TABLE border=0 cellSpacing=0 cellPadding=0 align=left>
                 <TBODY>
                   <TR>
                     <TD><IMG src="http://www.pighip.co.kr/design/pighip/images/on.png" name="num_img0" border=0  id=num_img0 style="FILTER: " onMouseOver="chki(this, 0);"></TD>
                     <TD width=5></TD>
                     <TD><IMG src="http://www.pighip.co.kr/design/pighip/images/on.png" name="num_img1" border=0  id=num_img1 style="FILTER: " onMouseOver="chki(this, 1);"></TD>
                     <TD width=5></TD>
                     <TD><IMG src="http://www.pighip.co.kr/design/pighip/images/on.png" name="num_img2" border=0  id=num_img2 style="FILTER: " onMouseOver="chki(this, 2);"></TD>
                   </TR>
                 </TBODY>
                 </TABLE>
               </DIV></DIV>
               <SCRIPT> showStart(); </SCRIPT>
            </td>
          </tr>
       </table>    
	<br>
	<br>
	<div class="main-header-under-menu" >
	    <div class="row" align="center">
  			<!-- <div class="col-md-3 btn-lg btn btn-default" align="center"><a href="main.do">Home</a></div> -->
  			<div align="center"><a href="main.do" class="btn btn-default btn-lg col-md-3 glyphicon glyphicon-home">Home</a></div>
  			<div align="center"><a href="notice_list.do" class="btn btn-default btn-lg col-md-3 glyphicon glyphicon-th-list">Notice</a></div>
  			<div align="center"><a href="qna_list.do" class="btn btn-default btn-lg col-md-3 glyphicon glyphicon-th-list">Q&A</a></div>
  			<!-- <div align="center"><a href="review.do" class="btn btn-default btn-lg col-md-2 glyphicon glyphicon-th-list">Review</a></div> -->
  			<div align="center"><a href="designList.do" class="btn btn-default btn-lg col-md-3 glyphicon glyphicon-user">Design</a></div>
  			<!-- <div align="center"><a href="search.do" class="btn btn-default btn-lg col-md-2 glyphicon glyphicon-search">Search</a></div> -->
		 </div>

	     <div class="row" align="center" >
  			<div align="center"><a href="outer_list.do" class="btn btn-default btn-lg col-md-2 glyphicon glyphicon-tree-conifer">OUTER</a></div>
  			<div align="center"><a href="top_list.do" class="btn btn-default btn-lg col-md-2 glyphicon glyphicon-tree-deciduous">TOP</a></div>
  			<div align="center"><a href="bottoms_list.do" class="btn btn-default btn-lg col-md-2 glyphicon glyphicon-tag">BOTTOMS</a></div>
  		    <div align="center"><a href="onepiece_list.do" class="btn btn-default btn-lg col-md-2 glyphicon glyphicon-send">ONEPIECE</a></div>
  		    <div align="center"><a href="sale_list.do" class="btn btn-default btn-lg col-md-2 glyphicon glyphicon-heart">SALE</a></div> 
  			<div align="center"><a href="etc_list.do" class="btn btn-default btn-lg col-md-2 glyphicon glyphicon-music">ETC</a></div>
		 </div>
	</div>
</form>
</body>
<!-- </div>  -->
</html>