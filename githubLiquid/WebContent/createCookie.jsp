<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- ��Ű ���� ���δ� ũ�ҿ��� �����ڵ���-Resources-Cookies/localhost ���� Ȯ���� �� �ִ�. 

����1.createCookie.do(CookieCreateCMD) ���� ��Ű����� cartList.do(CartListCMD)���� ��Ű������ ������ ��ٱ��� ȭ�鿡
	��ǰ������ ���ü����� �ѷ�����ϴµ� url�� createCookie.do���� �����ְ� cartList.do��� ��û�� �Ͼ�� �ʴ´�. �׷��� ����ٱ��� ȭ�鸸��
	�����ش�. ������ �޴����� ���� ��ٱ��� ����� �����ؼ� cartList.do�� �ٷ� ��û�ϸ� ��Ű����� ������ �� �� �ִ�. ��Ű �������� ������ ������, 
	.do��û�� .do�� ��û�϶�� �κп��� �� ���� �ʴ´�.
	�ذ�.�׷��� ��Ű�� �����ϴ� �������� java�� ��Ʈ�Ѵ��� �ƴ϶� ������ jsp���������� �̷������, �� �ѹ��� CartList.do�� ��û�ϴ°����� �ش繮���� �ذ��Ͽ���.
	
����2. ��Ű�� �����ϴ� �� �������� cart �����ȿ� �� ��� path�� /liquid/cart/ �����θ� ��Ű�� �����ȴ�.
	�ذ�. /liquid ���� ��Ű�� �����ǵ��� �� �������� WebContent ���� �ؿ� ������ �ذ��Ͽ���.  -->

<%
		//��������ȣ
		String stock_no = request.getParameter("stock_no");
		//���ü��� 
		int quantity = Integer.parseInt(request.getParameter("order_detail_quantity"));
		/***********************************************
		 *  
		 *  ���⼭�� ��������ȣ���� ���ο� ��Ű ��ü�� ����.
		 *  �ߺ��Ǵ� ��������ȣ�� ������� ���ü������� ������Ʈ.
		 *  
		 **********************************************/
		//��� ��Ű������ ������.
		Cookie[] isCart = request.getCookies();
		
		//��������ȣ�� ���ü����� ������ ���ڿ��� ���� ����
		String[] str_cookie = new String[isCart.length];
		
		//��������ȣ�� ���ü����� �и��Ͽ� �ߺ�üũ�� ��ģ�� Ű���� ���Ѵ� 
		String cart = "cart1";	
		if (isCart.length != 0){
			for (int i=0; i<isCart.length; i++){
				if((cart).equals(isCart[i].getName())){
					//��� cart ��Ű�� �̸��� ������ ���� �����ͼ� �ߺ����� Ȯ���Ѵ�.
					str_cookie[i] = isCart[i].getValue();
					String str[] = str_cookie[i].split(":");
					//String str[] = (isCart[i].getValue()).split(":");
					if(str[0].equals(stock_no)){
						quantity += Integer.parseInt(str[1]);
						cart = isCart[i].getName();
					}else {
						cart = "cart";
						cart +=i+1;
					}
				}
			}
		}
		String cookie = stock_no + ":"+Integer.toString(quantity);
		Cookie c_cart = new Cookie(cart,cookie);
		c_cart.setMaxAge(60*30);
		response.addCookie(c_cart); 
		response.sendRedirect("./cartList.do");
		
%>
<!-- <script type="text/javascript">
	location.href="../cartList.do"
</script> -->

</body>
</html>