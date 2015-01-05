package com.design;

import java.util.ArrayList;

public class DesignPageTO {
	ArrayList<DesignDTO> list; //목록 리스트 저장
	int curPage; //현재 페이지 번호
	int perPage = 9; //페이지당 보여줄 레코드 수
	int totalCount;  //전체 레코드 수 
	int totalCount_search;
	public int getTotalCount_search(String searchName, String searchValue) {
		return totalCount_search;
	}
	public void setTotalCount_search(int totalCount_search) {
		this.totalCount_search = totalCount_search;
	}
	public ArrayList<DesignDTO> getList() {
		return list;
	}
	public void setList(ArrayList<DesignDTO> list) {
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
