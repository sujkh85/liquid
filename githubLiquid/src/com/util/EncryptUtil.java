package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



//암호화 모듈 사용방법 
/**********************************************************************
 * String strTest ="비밀번호";
 * String strSHA ="암호화된비밀번호받을변수"
 * 
 * String strSHA = EncryptUtil.getSHA256(strTest);
 **********************************************************************/

public class EncryptUtil {
	
	//SHA-256	
	public static String getSHA256(String str) {
		String rtnSHA = "";
		
		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
			sh.update(str.getBytes()); 
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer(); 
			
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			rtnSHA = sb.toString();
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			rtnSHA = null; 
		}
		return rtnSHA;
	}

}//class



