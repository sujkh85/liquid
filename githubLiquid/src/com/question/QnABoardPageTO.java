package com.question;

import java.util.ArrayList;

public class QnABoardPageTO {
	ArrayList<QnABoardDTO> list; //��� ����Ʈ ����
	int curPage; //���� ������ ��ȣ
	int perPage = 5; //�������� ������ ���ڵ� ��
	int totalCount;  //��ü ���ڵ� �� 
	int totalCount_search;
	
	public int getTotalCount_search(String searchName, String searchValue) {
		return totalCount_search;
	}
	public void setTotalCount_search(int totalCount_search) {
		this.totalCount_search = totalCount_search;
	}
	public ArrayList<QnABoardDTO> getList() {
		return list;
	}
	public void setList(ArrayList<QnABoardDTO> list) {
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