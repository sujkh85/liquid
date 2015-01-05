<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!--
/***********************************************************************
 * 작업자 : 김용민
 * 작업일자 : 2014.11.20
 * 어떤 파일에 호출받는가 :  productDetail.jsp
 * 어떤 파일을 호출하는가 :   
 ***********************************************************************/
  --> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 <title>상품상세 텝</title>
 <style type="text/css">
.star_rating{width:100px;height:20px;background:url(bbs/review/img/bg_starpoint_off.gif) 0 0 no-repeat; background-size: 100px; 20px;}
.star_rating span{display:block;height:15px;background:url(bbs/review/img/bg_starpoint_on.gif) 0 0 no-repeat; background-size: 100px; 20px;}
.star_rating .point{display:none}
@media print {
.star_rating span{display:none}
.star_rating .point{display:block}
}
</style>
<!-- 스타일 시트와 jqueryeasyUI 경로 -->
<link rel="stylesheet" type="text/css" href="./css/easyui.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function starpoint(){
		var spoint = ${product_List.getProduct_sangpum()}
		var bpoint = ${product_List.getProduct_besong()}
		// 상품점수 처리
		if(spoint >= 5){
			document.getElementById("star").style.width="100%";
		}else if(spoint >= 4){
			document.getElementById("star").style.width="80%";
		}else if(spoint >= 3){
			document.getElementById("star").style.width="60%";
		}else if(spoint >= 2){
			document.getElementById("star").style.width="40%";
		}else if(spoint >= 1){
			document.getElementById("star").style.width="20%";
		}else{
			document.getElementById("star").style.width="0%"
		}
		// 배송점수 처리
		if(bpoint >= 5){
			document.getElementById("star2").style.width="100%";
		}else if(bpoint >= 4){
			document.getElementById("star2").style.width="80%";
		}else if(bpoint >= 3){
			document.getElementById("star2").style.width="60%";
		}else if(bpoint >= 2){
			document.getElementById("star2").style.width="40%";
		}else if(bpoint >= 1){
			document.getElementById("star2").style.width="20%";
		}else{
			document.getElementById("star2").style.width="0%"
		}
	};
	
	function delete_b(num){
		
		location.href = "reviewdelete.do?board_no=" +num;
	}
	
	function update_b(b_num){
		document.getElementById("update_div").style.display = "block";
	}

</script>
</head>
<body onload="javascript:starpoint()">
	<div style="float: left; margin: 10px; width: 160px;" >
	<div class="star_rating"><span id="star" style="width:75%"></span><span class="point">5</span></div>	
    <div style="margin:20px 0 10px 0; width: 1000; background-color: #fff;"></div><font color="red" style="font: sans-serif "> 상품평가 ${product_List.getProduct_sangpum()} 점</font></div>
    <div style="float: left; margin: 10px;">
    <div class="star_rating"><span id="star2" style="width:75%"></span><span class="point">5</span></div>	
    <div style="margin:20px 0 10px 0; width: 1000; background-color: #fff;"></div><font color="red" style="font: sans-serif "> 배송평가 ${product_List.getProduct_besong()} 점</font></div>
    <div class="easyui-tabs" style="width:auto; height:auto; clear: both; " >
    	<!-- 상품 상세설명에 대한 테그 -->
        <div title="상품설명" style="padding:10px; height: 100%; background-color: #fff; " >
			<img src="${product_List.getProduct_imgsrc2()}"><br>	
			<img src="${product_List.getProduct_imgsrc3()}"><br>
			<img src="${product_List.getProduct_imgsrc4()}"><br>
			<img src="${product_List.getProduct_imgsrc5()}"><br>
		</div>
		
		<!-- 제품Q&A에 대한 테그 -->
        <!-- <div title="Q&A" style="padding:10px">
        	hgfdhgfdhfd
        </div> -->
              
        <!-- 구매후기에 대한 테그 -->
        <div title="구매후기" style="padding:10px; background-color:#ffffff;">
        <div title="상품평">
        	
        </div>
        <c:if test="${not empty s_member_info_no}">
        <div title="starpoint">
        	
        </div>
        	<form action="reviewWrite.do?product_no=${dto.product_no}" >
        	<div id="assesmentmain" style="height: 50px; margin: 7px; ">
        	<div id="sangpumass" style="float: left;  height: 20PX ">
        		<h3>상품평가</h3>
        		<input type="radio" name="sangpum" value="5">매우 맘에 듬<br>
        		<input type="radio" name="sangpum" value="4">맘에 듬<br>
        		<input type="radio" name="sangpum" value="3" checked="checked">보통<br>
        		<input type="radio" name="sangpum" value="2">맘에 안듬<br>
        		<input type="radio" name="sangpum" value="1">매우 맘에 안듬<br>
        	</div>
        	<div id="besongass" style="float: left; margin: auto;">
        		<h3>배송평가</h3>
        		<input type="radio" name="besong" value="5">매우 맘에 듬<br>
        		<input type="radio" name="besong" value="4">맘에 듬<br>
        		<input type="radio" name="besong" value="3" checked="checked">보통<br>
        		<input type="radio" name="besong" value="2">맘에 안듬<br>
        		<input type="radio" name="besong" value="1">매우 맘에 안듬<br>
        	</div>
        	<div id="writereview" align="center">
        		<textarea name="review" rows="7" cols="94" ></textarea>
        		<input type="hidden" name="member_no" value="${s_member_info_no }">
        		<input type="hidden" name="nick_name" value="${s_member_info_nickname}">
        		
      			<input type="hidden" name="product_no" value="${product_List.getProduct_no()}">
        		<input type="submit" value="확인"> <!-- sangpum,besong,review를 보내줌 -->
        	</div>
        	</div>
        	</form>
        </c:if>
        <c:set var="nick" value="${s_member_info_nickname }"/>
        <table width="100%" height="100%" border="1" cellspacing="0" cellpadding="10" >
				<tr bgcolor="#AEAEC0">
					<td colspan="3" height="15px"></td>
				</tr>
        	<c:forEach items="${reviewList}" var="review">
					<tr bgcolor="#EEF4F4" >
						<%-- <c:set var="b_num" value="${review.getBoard_review_no()}" /> 필요 없나?  --%> 
						<td width="13%" ><div>상품평 &nbsp; ${review.getSangpum()}</div><div>배송평 &nbsp; ${review.getBesong()}</div></td>
						<td width="70%">${review.getBoard_review_content()} 
						<c:if test="${review.getMember_info_nickname() == nick }" >
							<input type="button" onclick="update_b()" value="수정"/>
							<input type="button" onclick="delete_b(${review.getBoard_review_no()})" value="삭제"/> 
						</c:if> 
							</td>
						<td align="center">${review.getBoard_review_date()}<br>${review.getMember_info_nickname()} </td>
					</tr>
			</c:forEach>
				<tr bgcolor="#AEAEC0">
					<td colspan="3" height="15px"></td>
				</tr>
		</table>
        </div>
    </div>
    
   <!-- 글수정 div -->
    <div style="display: none;" id="update_div">
    	<form action="reviewUpdate.do" id="act" >
        	<div id="assesmentmain" style="height: 50px; margin: 7px; ">
        	<div id="sangpumass" style="float: left;  height: 20PX ">
        		<h3>상품평가</h3>
        		<input type="radio" name="sangpum" value="5">매우 맘에 듬<br>
        		<input type="radio" name="sangpum" value="4">맘에 듬<br>
        		<input type="radio" name="sangpum" value="3" checked="checked">보통<br>
        		<input type="radio" name="sangpum" value="2">맘에 안듬<br>
        		<input type="radio" name="sangpum" value="1">매우 맘에 안듬<br>
        	</div>
        	<div id="besongass" style="float: left; margin: auto;">
        		<h3>배송평가</h3>
        		<input type="radio" name="besong" value="5">매우 맘에 듬<br>
        		<input type="radio" name="besong" value="4">맘에 듬<br>
        		<input type="radio" name="besong" value="3" checked="checked">보통<br>
        		<input type="radio" name="besong" value="2">맘에 안듬<br>
        		<input type="radio" name="besong" value="1">매우 맘에 안듬<br>
        	</div>
        	<div id="writereview" align="center">
        		<textarea name="review" rows="7" cols="94" ></textarea>
        		<input type="hidden" name="member_no" value="${s_member_info_no }">
        		<input type="hidden" name="nick_name" value="${s_member_info_nickname}">
      			<input type="hidden" name="board_no" value="board_no">
        		<input type="submit" value="확인" onclick="" > <!-- sangpum,besong,review를 보내줌 -->
        	</div>
        	</div>
 </form>
    </div>
</body>
</html>