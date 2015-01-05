<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 쿠키 생성 여부는 크롬에서 관리자도구-Resources-Cookies/localhost 에서 확인할 수 있다. 

문제1.createCookie.do(CookieCreateCMD) 에서 쿠키만들고 cartList.do(CartListCMD)에서 쿠키정보를 가지고 장바구니 화면에
	상품정보와 선택수량을 뿌려줘야하는데 url이 createCookie.do에서 멈춰있고 cartList.do라는 요청이 일어나지 않는다. 그래서 빈장바구니 화면만을
	보여준다. 하지만 메뉴에서 직접 장바구니 목록을 선택해서 cartList.do를 바로 요청하면 쿠키에담긴 정보를 볼 수 있다. 쿠키 생성에는 문제가 없으나, 
	.do요청시 .do를 요청하라는 부분에서 잘 되지 않는다.
	해결.그래서 쿠키를 생성하는 페이지는 java의 컨트롤단이 아니라 현재의 jsp페이지에서 이루어지고, 단 한번의 CartList.do를 요청하는것으로 해당문제를 해결하였다.
	
문제2. 쿠키를 생성하는 이 페이지가 cart 폴더안에 들어갈 경우 path가 /liquid/cart/ 밑으로만 쿠키가 생성된다.
	해결. /liquid 에서 쿠키가 생성되도록 이 페이지만 WebContent 폴더 밑에 둠으로 해결하였다.  -->

<%
		//재고관리번호
		String stock_no = request.getParameter("stock_no");
		//선택수량 
		int quantity = Integer.parseInt(request.getParameter("order_detail_quantity"));
		/***********************************************
		 *  
		 *  여기서는 재고관리번호별로 새로운 쿠키 객체를 생성.
		 *  중복되는 재고관리번호가 있을경우 선택수량만을 업데이트.
		 *  
		 **********************************************/
		//모든 쿠키정보를 가져옴.
		Cookie[] isCart = request.getCookies();
		
		//재고관리번호와 선택수량이 합쳐진 문자열을 담을 변수
		String[] str_cookie = new String[isCart.length];
		
		//재고관리번호와 선택수량을 분리하여 중복체크를 거친뒤 키값을 정한다 
		String cart = "cart1";	
		if (isCart.length != 0){
			for (int i=0; i<isCart.length; i++){
				if((cart).equals(isCart[i].getName())){
					//모든 cart 쿠키의 이름이 있으면 값을 가져와서 중복인지 확인한다.
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