<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type=text/javascript>
	function closeDiv(){
		self.close(); 
	}
	window.setTimeout("mainAd.style.visibility = 'hidden'", 7000);
</script>
</head>
<body>
<DIV id="mainAd"style="Z-INDEX: 150; RIGHT: 200px; POSITION: absolute; TOP: 150px; border:solid; border-color:black; border-width:1px" >
<FORM name=mainAdfrm>
 <TABLE cellSpacing=0 cellPadding=0 border=0 style="border:solid; border-color:#cccccc; border-width:1px" >
  <TR>
   <TD style="PADDING: 0px 0px 0px 0px">
   <TABLE cellSpacing=0 cellPadding=0 width="710" border=0>
     <TR>
      <TD align=left></TD>
      <TD width=16></TD>
     </TR>
    </TABLE>
	</TD>
  </TR>
  <TR>
  	<td>
   <!-- <TD style="padding:3 5px 0 5px" background="popup/images/drag_bg_mid.gif"> -->
 <!-- �˾� ���� -->
        <iframe id="mainAdFrame" src="./img/event1.jpg" width="690" height="740" frameborder="0" marginwidth="0" marginheight="0" vspace="0" hspace="0" scrolling="no" allowtransparency="true"></iframe>
 <!-- // �˾����� �� -->
   
   </TD>
   </TR>
  <TR>
 	<td>
   <TABLE cellSpacing=0 cellPadding=0 width="700" border=0 bgcolor="#ffffff">
     <TR>
      <TD style="PADDING-RIGHT: 0px" align=center><INPUT onfocus='this.blur();' id=checkbox type=checkbox value=checkbox name=checkbox>
       <LABEL for=checkbox><font size="5" color="#ff0000" face="����">������ ���̻� �����ʱ�</font></LABEL></TD>
      <TD width=21 style="PADDING: 0 8 0 0;"><IMG style="CURSOR: pointer" onclick="closeDiv()" src="./img/x.jpg" border=1></TD>
     </TR>
    </TABLE>
	</td>
  </TR>
 </TABLE>
</FORM>
</DIV>
</body>
</html>