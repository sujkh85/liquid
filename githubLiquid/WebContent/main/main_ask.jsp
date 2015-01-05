<!--
/***********************************************************************
 * 작업자 :  최승환(미완성)
 * 작업일자 : 2014.11.17
 * 어떤 파일에 호출받는가 :  
 * 어떤 파일을 호출하는가 : 없음
 * 파일 타입 : 오른쪽 배너 배송조회 버튼 클릭시 배송조회가 나오게 하는 소스 아직 미완성
 ***********************************************************************/
  -->     
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="js/artn.execute.js"></script>
<title>택배조회</title>
<link rel="stylesheet" href="http://sstatic.naver.com/search/css/search09112514.css" type="text/css">
</head>
<body>
	<table width="250" height="50" border="0" cellpadding="0"
		cellspacing="5" align="center">
		<tr>
			<td height="2" colspan="2" bgcolor="#CDCDCD"></td>
		</tr>
		<tr>
			<td height="30" colspan="2" bgcolor="#efefef"><font
				color='#006676'><b> &nbsp;&nbsp;택배조회</b></font></td>
		</tr>
		<tr>
			<td height="1" colspan="2" bgcolor="#CDCDCD"></td>
		</tr>
		<tr>
			<td height="30">
				<form name="door_to_door_frm"
					onSubmit="doorToDoorSearch();return false;">
					<Table width="100%" height="30" border="0" cellpadding="3"
						cellspacing="0" align="center">
						<tr>
							<td width="75"><img
								src="http://sstatic.naver.com/keypage/outside/info/txt_delivery_1.gif"
								alt="택배사" width="37" height="11"></td>
							<td width="175"><select name="dtd_select" id="dtd_select"
								onChange="SetDeleveryContents(this.selectedIndex);">
									<option value="우체국택배" selected>우체국택배</option>
									<option value="대한통운">대한통운</option>
									<option value="한진택배">한진택배</option>
									<option value="로젠택배">로젠택배</option>
									<option value="현대택배">현대택배</option>
									<option value="KG옐로우캡택배">KG옐로우캡택배</option>
									<option value="KGB택배">KGB택배</option>
									<option value="EMS">EMS</option>
									<option value="DHL">DHL</option>
									<option value="한덱스">한덱스</option>
									<option value="FedEx">FedEx</option>
									<option value="동부익스프레스">동부익스프레스</option>
									<option value="CJ GLS">CJ GLS</option>
									<option value="SC 로지스">SC 로지스</option>
									<option value="UPS">UPS</option>
									<option value="하나로택배">하나로택배</option>
									<option value="대신택배">대신택배</option>
							</select></td>
						</tr>
						<tr>
							<td width="75"><img
								src="http://sstatic.naver.com/keypage/outside/info/txt_delivery_2.gif"
								alt="운송장번호" width="60" height="11"></td>
							<td width="175"><input type="text" style="width: 100%;"
								class="input_off" name="dtd_number_query" id="dtd_number_query"
								value="'-'를 제외하고 입력하세요." onClick="this.value=''"></td>
						</tr>
						<tr>
							<td width="250" colspan="2" align="center"
								style="font-size: 11px; color: #999;"><span
								class="descript"> &nbsp;예)&nbsp; <span id="Dcs01">
										1234567890123 (13자리) </span>
							</span></td>
						</tr>
						<tr>
							<td width="250" height="30" align="center" colspan="2"><input
								type="image"
								src="http://sstatic.naver.com/keypage/outside/info/btn_delivery_search.gif"
								alt="조회" align="top"></td>
						</tr>
						<tr height="20">
							<td valign="bottom" align="center" colspan="2"
								style="font-size: 11px;"><a
								href="http://parcel.epost.go.kr" id="Dcs04" target="_blank">
									<span id="Dcs02">우체국택배</span> &nbsp;바로가기
							</a><br> (&nbsp; <span>문의전화</span> &nbsp;:&nbsp; <span
								id="Dcs03">1588-1300</span> &nbsp;)</td>
						</tr>
					</Table>
				</form>
			</td>
		</tr>
		<tr>
			<td height="1" colspan="2" bgcolor='#E1E1E1'></td>
		</tr>
	</table>
	<!--  <table align="center">
	<tr align="center">
	<td width="250" height="250" align="center">
	<a href="#"><img src="./img/ask.gif"/></a>
	</td>
	</tr>
	</table>  -->
</body>
</html>
