package com.controller;
/***********************************************************************
 * �۾��� : �̽¿� 
 * �۾����� : 2014.11.08
 * � ���Ͽ� ȣ��޴°� : *CMD.java
 * � ������ ȣ���ϴ°� :  
 * ���� Ÿ�� : ��� CMD Ŭ�������� �����ؾ��� �������̽��� �������� ��.  
 ***********************************************************************/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public void execute(HttpServletRequest req, HttpServletResponse res);
}