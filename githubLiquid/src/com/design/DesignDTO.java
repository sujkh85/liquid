package com.design;

public class DesignDTO {                   
		  private int    board_userdesign_no         =0;//
		  private String board_userdesign_title      ="";//
		  private String board_userdesign_content    ="";//
		  private String board_userdesign_date       ="";//
		  private String board_userdesign_imgsrc1    ="";//
		  private String board_userdesign_imgsrc2    ="";//
		  private String board_userdesign_imgsrc3    ="";//
		  private String board_userdesign_imgsrc4    ="";//
		  private String board_userdesign_imgsrc5    ="";//
		  private int    board_userdesign_viewcount  =0;//
		  private int    member_info_no              =0;//
		  private int    board_userdesign_favorite   =0;//
		  private int    board_userdesign_reproot    =0;//
		  private int    board_userdesign_repstep    =0;//
		  private int    board_userdesign_repindent  =0;//
		  private String member_info_nickname		 ="";
		  
		 
		public DesignDTO() {}   
		   
		public DesignDTO(int board_userdesign_no,
				String board_userdesign_title, String board_userdesign_content,
				String board_userdesign_date, String board_userdesign_imgsrc1,
				String board_userdesign_imgsrc2, String board_userdesign_imgsrc3,
				String board_userdesign_imgsrc4, String board_userdesign_imgsrc5,
				int board_userdesign_viewcount, int member_info_no,
				int board_userdesign_favorite, int board_userdesign_reproot,
				int board_userdesign_repstep, int board_userdesign_repindent) {
			
			this.board_userdesign_no = board_userdesign_no;
			this.board_userdesign_title = board_userdesign_title;
			this.board_userdesign_content = board_userdesign_content;
			this.board_userdesign_date = board_userdesign_date;
			this.board_userdesign_imgsrc1 = board_userdesign_imgsrc1;
			this.board_userdesign_imgsrc2 = board_userdesign_imgsrc2;
			this.board_userdesign_imgsrc3 = board_userdesign_imgsrc3;
			this.board_userdesign_imgsrc4 = board_userdesign_imgsrc4;
			this.board_userdesign_imgsrc5 = board_userdesign_imgsrc5;
			this.board_userdesign_viewcount = board_userdesign_viewcount;
			this.member_info_no = member_info_no;
			this.board_userdesign_favorite = board_userdesign_favorite;
			this.board_userdesign_reproot = board_userdesign_reproot;
			this.board_userdesign_repstep = board_userdesign_repstep;
			this.board_userdesign_repindent = board_userdesign_repindent;
		}

		public int getBoard_userdesign_no() {
			return board_userdesign_no;
		}
		public void setBoard_userdesign_no(int board_userdesign_no) {
			this.board_userdesign_no = board_userdesign_no;
		}
		public String getBoard_userdesign_title() {
			return board_userdesign_title;
		}
		public void setBoard_userdesign_title(String board_userdesign_title) {
			this.board_userdesign_title = board_userdesign_title;
		}
		public String getBoard_userdesign_content() {
			return board_userdesign_content;
		}
		public void setBoard_userdesign_content(String board_userdesign_content) {
			this.board_userdesign_content = board_userdesign_content;
		}
		public String getBoard_userdesign_date() {
			return board_userdesign_date;
		}
		public void setBoard_userdesign_date(String board_userdesign_date) {
			this.board_userdesign_date = board_userdesign_date;
		}
		public String getBoard_userdesign_imgsrc1() {
			return board_userdesign_imgsrc1;
		}
		public void setBoard_userdesign_imgsrc1(String board_userdesign_imgsrc1) {
			this.board_userdesign_imgsrc1 = board_userdesign_imgsrc1;
		}
		public String getBoard_userdesign_imgsrc2() {
			return board_userdesign_imgsrc2;
		}
		public void setBoard_userdesign_imgsrc2(String board_userdesign_imgsrc2) {
			this.board_userdesign_imgsrc2 = board_userdesign_imgsrc2;
		}
		public String getBoard_userdesign_imgsrc3() {
			return board_userdesign_imgsrc3;
		}
		public void setBoard_userdesign_imgsrc3(String board_userdesign_imgsrc3) {
			this.board_userdesign_imgsrc3 = board_userdesign_imgsrc3;
		}
		public String getBoard_userdesign_imgsrc4() {
			return board_userdesign_imgsrc4;
		}
		public void setBoard_userdesign_imgsrc4(String board_userdesign_imgsrc4) {
			this.board_userdesign_imgsrc4 = board_userdesign_imgsrc4;
		}
		public String getBoard_userdesign_imgsrc5() {
			return board_userdesign_imgsrc5;
		}
		public void setBoard_userdesign_imgsrc5(String board_userdesign_imgsrc5) {
			this.board_userdesign_imgsrc5 = board_userdesign_imgsrc5;
		}
		public int getBoard_userdesign_viewcount() {
			return board_userdesign_viewcount;
		}
		public void setBoard_userdesign_viewcount(int board_userdesign_viewcount) {
			this.board_userdesign_viewcount = board_userdesign_viewcount;
		}
		public int getMember_info_no() {
			return member_info_no;
		}
		public void setMember_info_no(int member_info_no) {
			this.member_info_no = member_info_no;
		}
		public int getBoard_userdesign_favorite() {
			return board_userdesign_favorite;
		}
		public void setBoard_userdesign_favorite(int board_userdesign_favorite) {
			this.board_userdesign_favorite = board_userdesign_favorite;
		}
		public int getBoard_userdesign_reproot() {
			return board_userdesign_reproot;
		}
		public void setBoard_userdesign_reproot(int board_userdesign_reproot) {
			this.board_userdesign_reproot = board_userdesign_reproot;
		}
		public int getBoard_userdesign_repstep() {
			return board_userdesign_repstep;
		}
		public void setBoard_userdesign_repstep(int board_userdesign_repstep) {
			this.board_userdesign_repstep = board_userdesign_repstep;
		}
		public int getBoard_userdesign_repindent() {
			return board_userdesign_repindent;
		}
		public void setBoard_userdesign_repindent(int board_userdesign_repindent) {
			this.board_userdesign_repindent = board_userdesign_repindent;
		}

		public String getMember_info_nickname() {
			return member_info_nickname;
		}

		public void setMember_info_nickname(String member_info_nickname) {
			this.member_info_nickname = member_info_nickname;
		}
	}
