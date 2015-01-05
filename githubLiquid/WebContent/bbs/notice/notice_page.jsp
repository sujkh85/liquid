<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.notice.NoticePageTO" %>
<%
	NoticePageTO to = (NoticePageTO)request.getAttribute("page");
	int curPage = to.getCurPage();
	int perPage = to.getPerPage();
	int totalCount = to.getTotalCount();
	
	int totalPage = totalCount/perPage; //보여줄 페이지 번호 개수
	
	if(totalCount % perPage != 0)totalPage++;
	
	for(int i=1;i<=totalPage; i++){
		if(curPage==i){
			out.print("<font size=5 color='black'>"+i+"</font>");
		}else{
			out.print("<a href='notice_list.do?curPage="+i+"'>"+i +"</a>&nbsp;");
		}//end if
	}
%>