<!--
/***********************************************************************
 * �۾��� :  �ֽ�ȯ(�̿ϼ�)
 * �۾����� : 2014.11.17
 * � ���Ͽ� ȣ��޴°� :  
 * � ������ ȣ���ϴ°� : ����
 * ���� Ÿ�� : ������ ��� �����ȸ ��ư Ŭ���� �����ȸ�� ������ �ϴ� �ҽ� ���� �̿ϼ�
 ***********************************************************************/
  -->     
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="js/artn.execute.js"></script>
<title>�ù���ȸ</title>
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
				color='#006676'><b> &nbsp;&nbsp;�ù���ȸ</b></font></td>
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
								alt="�ù��" width="37" height="11"></td>
							<td width="175"><select name="dtd_select" id="dtd_select"
								onChange="SetDeleveryContents(this.selectedIndex);">
									<option value="��ü���ù�" selected>��ü���ù�</option>
									<option value="�������">�������</option>
									<option value="�����ù�">�����ù�</option>
									<option value="�����ù�">�����ù�</option>
									<option value="�����ù�">�����ù�</option>
									<option value="KG���ο�ĸ�ù�">KG���ο�ĸ�ù�</option>
									<option value="KGB�ù�">KGB�ù�</option>
									<option value="EMS">EMS</option>
									<option value="DHL">DHL</option>
									<option value="�ѵ���">�ѵ���</option>
									<option value="FedEx">FedEx</option>
									<option value="�����ͽ�������">�����ͽ�������</option>
									<option value="CJ GLS">CJ GLS</option>
									<option value="SC ������">SC ������</option>
									<option value="UPS">UPS</option>
									<option value="�ϳ����ù�">�ϳ����ù�</option>
									<option value="����ù�">����ù�</option>
							</select></td>
						</tr>
						<tr>
							<td width="75"><img
								src="http://sstatic.naver.com/keypage/outside/info/txt_delivery_2.gif"
								alt="������ȣ" width="60" height="11"></td>
							<td width="175"><input type="text" style="width: 100%;"
								class="input_off" name="dtd_number_query" id="dtd_number_query"
								value="'-'�� �����ϰ� �Է��ϼ���." onClick="this.value=''"></td>
						</tr>
						<tr>
							<td width="250" colspan="2" align="center"
								style="font-size: 11px; color: #999;"><span
								class="descript"> &nbsp;��)&nbsp; <span id="Dcs01">
										1234567890123 (13�ڸ�) </span>
							</span></td>
						</tr>
						<tr>
							<td width="250" height="30" align="center" colspan="2"><input
								type="image"
								src="http://sstatic.naver.com/keypage/outside/info/btn_delivery_search.gif"
								alt="��ȸ" align="top"></td>
						</tr>
						<tr height="20">
							<td valign="bottom" align="center" colspan="2"
								style="font-size: 11px;"><a
								href="http://parcel.epost.go.kr" id="Dcs04" target="_blank">
									<span id="Dcs02">��ü���ù�</span> &nbsp;�ٷΰ���
							</a><br> (&nbsp; <span>������ȭ</span> &nbsp;:&nbsp; <span
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
