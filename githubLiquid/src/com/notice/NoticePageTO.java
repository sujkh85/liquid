package com.notice;

import java.util.ArrayList;

public class NoticePageTO {
	ArrayList<NoticeDTO> list; //��� ����Ʈ ����
	int curPage; 			  //���� ��������ȣ
	int perPage = 10; 		  //������ �� ������ ���ڵ� ��
	int totalCount;			  //��ü ���ڵ� ��
	
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
