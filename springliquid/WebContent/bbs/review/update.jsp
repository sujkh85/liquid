<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
 <script type="text/javascript">
<!-- function getHttpParam(name) {
    var regexS = "[\\?&]" + name + "=([^&#]*)";
    var regex = new RegExp(regexS);
    var results = regex.exec(window.location.href);
    if (results == null) {
        return 2;
    } else {
        return results[1];
    }
}
var str = getHttpParam("board_no")

function gogo(){
	document.getElementById("act").action="main.do?board_no="+str;
	act.submit();
}-->

function close(){
	window.close();
}
</script> 
</head>
<body>
<form action="reviewUpdate.do" id="act" >
        	<div id="assesmentmain" style="height: 50px; margin: 7px; ">
        	<div id="sangpumass" style="float: left;  height: 20PX ">
        		<h3>��ǰ��</h3>
        		<input type="radio" name="sangpum" value="5">�ſ� ���� ��<br>
        		<input type="radio" name="sangpum" value="4">���� ��<br>
        		<input type="radio" name="sangpum" value="3" checked="checked">����<br>
        		<input type="radio" name="sangpum" value="2">���� �ȵ�<br>
        		<input type="radio" name="sangpum" value="1">�ſ� ���� �ȵ�<br>
        	</div>
        	<div id="besongass" style="float: left; margin: auto;">
        		<h3>�����</h3>
        		<input type="radio" name="besong" value="5">�ſ� ���� ��<br>
        		<input type="radio" name="besong" value="4">���� ��<br>
        		<input type="radio" name="besong" value="3" checked="checked">����<br>
        		<input type="radio" name="besong" value="2">���� �ȵ�<br>
        		<input type="radio" name="besong" value="1">�ſ� ���� �ȵ�<br>
        	</div>
        	<div id="writereview" align="center">
        		<textarea name="review" rows="7" cols="94" ></textarea>
        		<input type="hidden" name="member_no" value="${s_member_info_no }">
        		<input type="hidden" name="nick_name" value="${s_member_info_nickname}">
      			<input type="hidden" name="board_no" value="board_no">
        		<input type="submit" value="Ȯ��" onclick="" > <!-- sangpum,besong,review�� ������ -->
        	</div>
        	</div>
 </form>
</body>
</html>