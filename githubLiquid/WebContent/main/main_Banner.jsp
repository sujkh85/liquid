<% /***********************************************************************
 * �۾��� : �̽¿� , �ֽ�ȯ
 * �۾����� : 2014.11.08(update) 11.11(�ֽ�ȯ ����̹��� �۾�) 11.27(�����ʹ�� �̹��� ��ũ�ѹ� �����ӿϼ�)
 * � ���Ͽ� ȣ��޴°� : main.jsp
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� : ��ǰ , �����ȸ �� �п�Ȩ�Ǵ� ��â���� �ҷ����� ����
 ***********************************************************************/%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>banner</title>
</head>
<body>
<!--������ ��� ���� -�ֽ�ȯ-  -->
<table width="50" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><DIV style="POSITION: absolute; TOP: 50px; " id=divMenu2> 
    </DIV></td>
    <td width="100" height="800"> </td>
    <td valign="top"><DIV style="POSITION: absolute; TOP: 50px;" id=divMenu1> 
    			<a href="qna_list.do" ><img src="./img/banner/r_ban_01_1.jpg" width="98" height="88" /></a> 
    			<!-- <a href="qna_list.do" ><img src="./img/banner/r_ban_01_2.jpg" width="98" height="23" /></a>  -->
    			<a href='#' onClick="window.open('ask.jsp', 'CLIENT_WINDOW', 
'resizable=yes scrollbars=yes width=300 height=250')"><img src="./img/banner/r_ban_01_3.jpg" width="98" height="58" /></a> 
    			<a href="main.do" ><img src="./img/banner/r_ban_04.jpg" width="98" height="20" /></a> 
    			<a href="wishlist.do" ><img src="./img/banner/r_ban_05_1.jpg" width="98" height="73" /></a> 
    			<a href="main.do" ><img src="./img/banner/banlo.jpg" /></a>
    			<a href="http://www.hyundai.or.kr/new2010/src/main.asp" target="_blank" ><img src="./img/hy.jpg" /></a></DIV></td>
  </tr>
</table>
<!--�����ʹ�� ��ũ�ѹ� �����̴� ��� ��ġ �̵� -�ֽ�ȯ- -->
 <SCRIPT language=javascript type=text/javascript> 
 <!-- 
// �¿��� ���� ��ʸ� ���� ��ũ��Ʈ  ��ũ�ѹ�
var wing_height = 160; 
 var wing_moveSpeed = 20; 
 var wing_respSpeed = 300;
 function CheckUIElements()  
 { 
 var yMenuFrom, yMenuTo, yButtonFrom, yButtonTo, yOffset, timeoutNextCheck; 
 var divMenu1 = document.getElementById("divMenu1"); 
 var divMenu2 = document.getElementById("divMenu2");
 if (typeof(window.pageYOffset) == "number") { 
 yMenuTo =  window.pageYOffset + wing_height; 
 } else if (typeof(document.documentElement.scrollTop) == "number") { 
 yMenuTo =  Math.max(document.documentElement.scrollTop, document.body.scrollTop) + wing_height; 
 } else { 
 yMenuTo = wing_height; 
 }
 yMenuFrom = parseInt(document.getElementById("divMenu1").style.top, 10); 
 timeoutNextCheck = wing_respSpeed;
 if ( yMenuFrom != yMenuTo ) 
 { 
 yOffset = Math.ceil( Math.abs( yMenuTo - yMenuFrom ) / wing_moveSpeed ); 
 if ( yMenuTo < yMenuFrom ) yOffset = -yOffset;
 
 divMenu1.style.top = (parseInt(divMenu1.style.top, 10) + yOffset)+'px'; 
    divMenu2.style.top = (parseInt(divMenu2.style.top, 10) + yOffset)+'px';
 timeoutNextCheck = 10; 
 } 
 setTimeout ("CheckUIElements()", timeoutNextCheck); 
 } 
 CheckUIElements(); 
 //--> 
 </SCRIPT>
</body>
</html>

<!-- ������ʹ� ���� ���� ���� ���� // ���� ����ǰ�� ǥ���� �ȵ�  
<style type="text/css">

.f_style2 {
     font-size: 11px;	
     font-weight: bold;
     color: #5f5f5f;
}

</style>
 <script language="javascript">


function imgUp()
{
     var nFirstCnt = parseInt(document.LeftGoodsListForm.f_up_no.value);

     if (nFirstCnt == -1)
     {
          alert("���� �� ��ǰ�� �������� �ʽ��ϴ�.");
     }
     else if (nFirstCnt <= 0)
     {
          alert("���� �� ������ ��ǰ�Դϴ�.");
     }
     else
     {
          var strText1 = "<a href=http://www.gmarket.co.kr/challenge/neo_goods/goods.asp?goodscode=" + v_goodscode[nFirstCnt-1] + "&pos_shop_cd=RC&pos_class_cd=111111111&pos_class_kind=T><img src=" + v_goodsimagepath[nFirstCnt-1] + " width=60 height=60 border=0 onError=this.src='http://image.gmarket.co.kr/challenge/neo_image/no_image.gif';></a>";
          var strText2 = "<a href=http://www.gmarket.co.kr/challenge/neo_goods/goods.asp?goodscode=" + v_goodscode[nFirstCnt] + "&pos_shop_cd=RC&pos_class_cd=111111111&pos_class_kind=T><img src=" + v_goodsimagepath[nFirstCnt] + " width=60 height=60 border=0 onError=this.src='http://image.gmarket.co.kr/challenge/neo_image/no_image.gif';></a>";
          var strText3 = "<a href=http://www.gmarket.co.kr/challenge/neo_goods/goods.asp?goodscode=" + v_goodscode[nFirstCnt+1] + "&pos_shop_cd=RC&pos_class_cd=111111111&pos_class_kind=T><img src=" + v_goodsimagepath[nFirstCnt+1] + " width=60 height=60 border=0 onError=this.src='http://image.gmarket.co.kr/challenge/neo_image/no_image.gif';></a>";

          firstFloatingGoodsimg.innerHTML = strText1;
          secondFloatingGoodsimg.innerHTML = strText2;
          thirdFloatingGoodsimg.innerHTML = strText3;

          document.LeftGoodsListForm.f_up_no.value = nFirstCnt-1;
          document.LeftGoodsListForm.f_down_no.value = nFirstCnt+1;
     }
}

function imgDown()
{
     var nLastCnt = parseInt(document.LeftGoodsListForm.f_down_no.value);
     var nMaxCnt = 5;

     if (nLastCnt == -1)
     {
          alert("���� �� ��ǰ�� �������� �ʽ��ϴ�.");
     }
     else if (nLastCnt >= nMaxCnt)
     {
          alert("���� �� ó�� ��ǰ�Դϴ�.");
     }
     else
     {
          var strText1 = "<a href=http://www.gmarket.co.kr/challenge/neo_goods/goods.asp?goodscode=" + v_goodscode[nLastCnt-1] + "&pos_shop_cd=RC&pos_class_cd=111111111&pos_class_kind=T><img src=" + v_goodsimagepath[nLastCnt-1] + " width=60 height=60 border=0 onError=this.src='http://image.gmarket.co.kr/challenge/neo_image/no_image.gif';></a>";
          var strText2 = "<a href=http://www.gmarket.co.kr/challenge/neo_goods/goods.asp?goodscode=" + v_goodscode[nLastCnt] + "&pos_shop_cd=RC&pos_class_cd=111111111&pos_class_kind=T><img src=" + v_goodsimagepath[nLastCnt] + " width=60 height=60 border=0 onError=this.src='http://image.gmarket.co.kr/challenge/neo_image/no_image.gif';></a>";
          var strText3 = "<a href=http://www.gmarket.co.kr/challenge/neo_goods/goods.asp?goodscode=" + v_goodscode[nLastCnt+1] + "&pos_shop_cd=RC&pos_class_cd=111111111&pos_class_kind=T><img src=" + v_goodsimagepath[nLastCnt+1] + " width=60 height=60 border=0 onError=this.src='http://image.gmarket.co.kr/challenge/neo_image/no_image.gif';></a>";

          firstFloatingGoodsimg.innerHTML = strText1;
          secondFloatingGoodsimg.innerHTML = strText2;
          thirdFloatingGoodsimg.innerHTML = strText3;

          document.LeftGoodsListForm.f_up_no.value = nLastCnt-1;
          document.LeftGoodsListForm.f_down_no.value = nLastCnt+1;
     }
}

//
</script>

<table width="85" border="0" cellspacing="0" cellpadding="0">
<form name="LeftGoodsListForm">
<input type="hidden" name="f_up_no" value="0">
<input type="hidden" name="f_down_no" value="2">

  <tr>
    <td height="27" valign="bottom" background="http://image.gmarket.co.kr/challenge/neo_image/banner/floating/tit2.gif">
     <table width="82" height="24" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="62">&nbsp;</td>
        <td align="center"><a href=''><font style="font-size:11px; color:#777777 ; text-decoration:underline; alt="";"></font></a></td>
      </tr>
    </table></td>
  </tr>
    <tr>
    <td><a href=''><img src="http://image.gmarket.co.kr/challenge/neo_image/banner/floating/all_view.gif" width="85" height="18" border="0"></a></td>
  </tr>
  <tr>
    <td><a href='javascript:imgUp();'><img src="http://image.gmarket.co.kr/challenge/neo_image/banner/floating/a1.gif" width="85" height="18" border="0"></a></td>
  </tr>
  <tr>
    <td align="center" background="http://image.gmarket.co.kr/challenge/neo_image/banner/floating/line_bg.gif">
     <table width="79"  border="0" cellspacing="0" cellpadding="0">

      <tr>
        <td align="center"><table width="73" height="73" border="0" cellpadding="0" cellspacing="1" bgcolor="D3D3D3">
            <tr>
              <td bgcolor="#FFFFFF" align="center"><span id="firstFloatingGoodsimg"><a href=""><img src="" width="60" height="60" border="0" onError="this.src='http://image.gmarket.co.kr/challenge/neo_image/banner/floating/img2.gif';"></a></span></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="5" align="center"></td>
      </tr>
      <tr>
        <td align="center"><table width="73" height="73" border="0" cellpadding="0" cellspacing="1" bgcolor="D3D3D3">
            <tr>
              <td bgcolor="#FFFFFF" align="center"><span id="secondFloatingGoodsimg"><a href=""><img src="" width="60" height="60" border="0" onError="this.src='http://image.gmarket.co.kr/challenge/neo_image/banner/floating/img2.gif';"></a></span></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="5" align="center"></td>
      </tr>
      <tr>
        <td align="center"><table width="73" height="73" border="0" cellpadding="0" cellspacing="1" bgcolor="D3D3D3">
            <tr>
              <td bgcolor="#FFFFFF" align="center"><span id="thirdFloatingGoodsimg"><a href=""><img src="" width="60" height="60" border="0" onError="this.src='http://image.gmarket.co.kr/challenge/neo_image/banner/floating/img2.gif';"></a></span></td>
            </tr>
        </table></td>
      </tr>

    </table></td>
  </tr>
  <tr>
    <td><a href='javascript:imgDown();'><img src="http://image.gmarket.co.kr/challenge/neo_image/banner/floating/aa1.gif" width="85" height="18" border="0"></a></td>
  </tr>
</form>
</table>

���� �� ��ǰ���  �� -->

