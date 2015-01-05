package com.notice;

import java.util.ArrayList;

public class NoticePageTO {
	ArrayList<NoticeDTO> list; //목록 리스트 저장
	int curPage; 			  //현재 페이지번호
	int perPage = 10; 		  //페이지 당 보여줄 레코드 수
	int totalCount;			  //전체 레코드 수
	
	public ArrayList<NoticeDTO> getList() {
		return list;
	}
	public void setList(ArrayList<NoticeDTO> list) {
		this.list = list;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
