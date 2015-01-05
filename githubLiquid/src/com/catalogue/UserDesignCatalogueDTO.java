package com.catalogue;
/***********************************************************************
 * 작업자 : 이승우 
 * 작업일자 : 2014.11.08
 * 어떤 파일에 호출받는가 : UserDesignCatalogueDAO.java
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 : 메인화면 유저디자인 카탈로그에 보여지는 정보를 담을 컨테이너 DTO
 ***********************************************************************/
public class UserDesignCatalogueDTO {
	private int rownum 		=0;   // 유저디자인상품 추천순위
	private int no			=0;    // 게시판번호
	private String nickname ="";   // 닉네임
	private String title    ="";  // 제목
	private int favorite 	=0;   // 추천수
	private String img      ="";   // 이미지경로1
	
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