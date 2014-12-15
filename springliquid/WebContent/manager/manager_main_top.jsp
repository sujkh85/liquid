<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
/***********************************************************************
 * 작업자 : 이홍수
 * 작업일자 : 14.11.25
 * 페이지 용도 : manager_main top 메뉴
 * 호출하는 페이지 : manager_main 
 ***********************************************************************/
 -->       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<SCRIPT> 
var pimage = new Array;
var urls = new Array;
var buttons = new Array;
 
 
 //pimage * 메인이미지삽입 사이즈680px * 733px
 //urls * 상품링크주소
 //[]안의 숫자는 이미지순서 건들라면 나테말하셈

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
 
</SCRIPT>
<!-- 부트스트랩사용선언 -->
<script src="js/jquery-1.11.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/respond.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="main-header-minilogo">    
          		<!--  메인 그림 설정 -->
          <img src="./img/top3.gif" />
          <a href="main.do"><img src="./img/main_top3.jpg" /></a>
          <img src="./img/maintop.gif" />
</div>    
<div class="menubar" >
<ul>
 <li><a href="#">회원관리</a>
 	<ul>
 		<li><a href="manager_list.do">회원목록</a></li>		
 	</ul>
 </li>
 	
 <li><a href="#" id="current">상품관리</a>
	<ul>
     <li><a href="manager_bestitem.do">인기상품</a></li>
     <li><a href="manager_productlist.do">전체상품</a></li>
    </ul>
 </li>
 <li><a href="#">주문관리</a>
 	<ul>
 		<li><a href="manager_todayorder.do?order_date=0">기간별 주문 정보 </a></li>
 		<li><a href="manager_orderstatus.do?status=전체주문조회">전체주문 조회</a></li>
 	</ul>
 </li>
 <li><a href="#">매출관리</a>
 	<ul>
 		<li><a href="manager_sales.do?date=day">일 매출량 </a></li>
 		<li><a href="manager_sales.do?date=month">월 매출량</a></li>
 		<li><a href="manager_productsales.do">상품별 매출</a></li>
 	</ul>
 </li>
 <li><a href="#">게시판관리</a>
 	<ul>
 		<li><a href="manager_notice_list.do?mode=manager">Notice</a></li>
 		<li><a href="manager_qna_list.do?mode=manager">Q&A </a></li>
 		<li><a href="#">Product</a></li>
 	</ul>
 </li>
 
 <li>
 	<a href="index.jsp">쇼핑몰 메인으로</a>
 </li>
</ul>


</div>
	
       <table cellpadding="0" cellspacing="0">
          <tr cellpadding="0" cellspacing="0">
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
</body>
</html>