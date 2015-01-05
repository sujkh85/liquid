package com.controller;
/***********************************************************************
 * 작업자 : 이승우 
 * 작업일자 : 2014.11.08
 * 어떤 파일에 호출받는가 : *CMD.java
 * 어떤 파일을 호출하는가 :  
 * 파일 타입 : 모든 CMD 클래스에서 구현해야할 인터페이스를 목적으로 함.  
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public void execute(HttpServletRequest req, HttpServletResponse res);
}