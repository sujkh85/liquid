<!--
/***********************************************************************
 * �۾��� :  �ֽ�ȯ
 * �۾����� : 2014.11.17
 * � ���Ͽ� ȣ��޴°� :  
 * � ������ ȣ���ϴ°� : ����
 * ���� Ÿ�� : ȸ�������Ҷ� ����� ���� �� ���ϴ� �ҽ�
 ***********************************************************************/
  -->        
<%@ page language="java" contentType="text/html; charset=EUC-KR"
 pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function chk(){
		var req = document.form.req.checked;
		var num = 0;
		if(req == true){
			num = 1;
	 	} 
	 	if(num==1){
	  		document.form.submit();
	 	}else{
	  		alert("�������� ����� �����ϼž� �մϴ�.");
	  		return false;
	 	}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������ ���</title>
</head>
<body>
<form action="memberform.do" name="form" method="post">
 <div>
   <span style="padding-left: 60px"><img src="./img/banner/banlo.jpg" width="98" height="100" border="0"></span>
   <span style="padding-left: 40px"><b>ȸ������</b></span>
   <hr>
 </div>
 <div style="padding-top: 50px">
   <span style="margin: 0px auto"><strong><h3>Liquid �������</h3></strong></span>
  <div style="padding-top: 10px"> 
   <textarea rows="20" cols="150">
��. �����ϴ� ���������� �׸�ù°, ȸ��� ȸ���� ��, ��Ȱ�� �������, ���� ������ ������ ���� ���� ȸ������ ��� �Ʒ��� ���� �ּ����� ���������� �ʼ��׸����� �����ϰ� �ֽ��ϴ�.
ȸ������
- �̸�, �������, ����, ���̵�, ��й�ȣ, ����, ����ó(�����ּ�, �޴��� ��ȣ �� ����), ������������
��14�� �̸� �Ƶ� ȸ������ 
- �̸�, �������, ����, �����븮�� ����, ���̵�, ��й�ȣ, ����ó (�����ּ�, �޴��� ��ȣ �� ����), ������������
��ü���̵� ȸ������ 
- ��ü���̵�, ȸ���, ��ǥ�ڸ�, ��ǥ ��ȭ��ȣ, ��ǥ �̸��� �ּ�, ��ü�ּ�, ������ ���̵�, ������ ����ó, ������ �μ�/����
- �����׸� : ��ǥ Ȩ������, ��ǥ �ѽ���ȣ
��°, ���� �̿�����̳� ���ó�� �������� �Ʒ��� ���� �������� �ڵ����� �����Ǿ� ������ �� �ֽ��ϴ�.
- IP Address, ��Ű, �湮 �Ͻ�, ���� �̿� ���, �ҷ� �̿� ���
��°, ���̹� ���̵� �̿��� �ΰ� ���� �� ����� ���� �̿� �Ǵ� �̺�Ʈ ���� �������� �ش� ������ �̿��ڿ� ���ؼ��� �������� �߰� ������ �߻��� �� ������, �̷��� ��� ������ ���Ǹ� �޽��ϴ�. 
��°, ����������, ����/���� �� �Ϻ� ���� �̿�� ���� ���� �ؼ��� ���� ���������� �ʿ��� ���, �Ʒ��� ���� �������� ������ �� �ֽ��ϴ�. 
- �̸�, �������, ����, �ߺ�����Ȯ������(DI), ��ȣȭ�� ������ �ĺ�����(CI), �޴��� ��ȣ(����), ������ ��ȣ(������ �̿��), ��/�ܱ��� ����
�ټ�°, ���� ���� �̿� �������� �Ʒ��� ���� ���� �������� ������ �� �ֽ��ϴ�. 
- �ſ�ī�� ������ : ī����, ī���ȣ ��
- �޴���ȭ ������ : �̵���ȭ��ȣ, ��Ż�, �������ι�ȣ ��
- ������ü�� : �����, ���¹�ȣ ��
- ��ǰ�� �̿�� : ��ǰ�� ��ȣ
��. �������� �������ȸ��� ������ ���� ������� ���������� �����մϴ�. 
- Ȩ������, ������, �ѽ�, ��ȭ, ��� �Խ���, �̸���, �̺�Ʈ ����, ��ۿ�û
- ����ȸ��κ����� ���� 
- �������� ���� ���� ���� ����
   </textarea>
  </div> 
 </div>
<div>
   <input type="checkbox" name="req"> �������� ���� �� �̿뿡 �����մϴ�. 
   <br><div align="center">
    <input class="btn btn-info" type="button" value="����" onclick="chk()"/>&nbsp;&nbsp;&nbsp;
    <input class="btn btn-info" type="button" value="�������� �ʽ��ϴ�" onclick="alert('����� �������� ������ ���� �Ͻ� �� �����ϴ�.')"/>
    </div>
</div>
</form>
</body>
</html>