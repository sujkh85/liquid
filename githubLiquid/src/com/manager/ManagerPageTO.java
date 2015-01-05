package com.manager;

import java.util.ArrayList;

public class ManagerPageTO {
	ArrayList<ManagerMemberListDTO> list; //목록 리스트 저장
	ArrayList<ManagerBestItemDTO> list_bestitem; //목록 리스트 저장
	ArrayList<ManagerProductListDTO> list_productlist;
	ArrayList<ManagerTodayOrderDTO> list_todayorder;
	ArrayList<ManagerOrderStatusDTO> list_orderstatus;
	ArrayList<ManagerSalesDTO> list_sales;
	ArrayList<ManagerProductSalesDTO> list_productsales;
	public ArrayList<ManagerProductSalesDTO> getList_productsales() {
		return list_productsales;
	}
	public void setList_productsales(
			ArrayList<ManagerProductSalesDTO> list_productsales) {
		this.list_productsales = list_productsales;
	}
	public ArrayList<ManagerSalesDTO> getList_sales() {
		return list_sales;
	}
	public void setList_sales(ArrayList<ManagerSalesDTO> list_sales) {
		this.list_sales = list_sales;
	}
	public ArrayList<ManagerOrderStatusDTO> getList_orderstatus() {
		return list_orderstatus;
	}
	public void setList_orderstatus(
			ArrayList<ManagerOrderStatusDTO> list_orderstatus) {
		this.list_orderstatus = list_orderstatus;
	}
	public ArrayList<ManagerTodayOrderDTO> getList_todayorder() {
		return list_todayorder;
	}
	public void setList_todayorder(ArrayList<ManagerTodayOrderDTO> list_todayorder) {
		this.list_todayorder = list_todayorder;
	}
	public ArrayList<ManagerProductListDTO> getList_productlist() {
		return list_productlist;
	}
	public void setList_productlist(ArrayList<ManagerProductListDTO> list_productlist) {
		this.list_productlist = list_productlist;
	}
	int curPage; //현재 페이지 번호
	int perPage = 10; //페이지당 보여줄 레코드 수
	int perPage_productlist = 9; //페이지당 보여줄 레코드 수
	public int getPerPage_productlist() {
		return perPage_productlist;
	}
	public void setPerPage_productlist(int perPage_productlist) {
		this.perPage_productlist = perPage_productlist;
	}
	int totalCount;  //전체 레코드 수 
	
	public ArrayList<ManagerMemberListDTO> getList() {
		return list;
	}
	public void setList(ArrayList<ManagerMemberListDTO> list) {
		this.list = list;
	}
	public ArrayList<ManagerBestItemDTO> getList_bestitem() {
		return list_bestitem;
	}
	public void setList_bestitem(ArrayList<ManagerBestItemDTO> list_bestitem) {
		this.list_bestitem = list_bestitem;
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
