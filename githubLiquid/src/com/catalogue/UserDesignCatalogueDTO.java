package com.catalogue;
/***********************************************************************
 * �۾��� : �̽¿� 
 * �۾����� : 2014.11.08
 * � ���Ͽ� ȣ��޴°� : UserDesignCatalogueDAO.java
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� : ����ȭ�� ���������� īŻ�α׿� �������� ������ ���� �����̳� DTO
 ***********************************************************************/
public class UserDesignCatalogueDTO {
	private int rownum 		=0;   // ���������λ�ǰ ��õ����
	private int no			=0;    // �Խ��ǹ�ȣ
	private String nickname ="";   // �г���
	private String title    ="";  // ����
	private int favorite 	=0;   // ��õ��
	private String img      ="";   // �̹������1
	
	public UserDesignCatalogueDTO(){}
	
	public UserDesignCatalogueDTO(int rownum, int no, String nickname, String title, int favorite, String img){
		this.rownum = rownum;
		this.no = no;
		this.nickname = nickname;
		this.title = title;
		this.favorite = favorite;
		this.img = img;
	}
	
	public int getRownum() {
		return rownum;
	}


	public void setRownum(int rownum) {
		this.rownum = rownum;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getFavorite() {
		return favorite;
	}


	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}
}