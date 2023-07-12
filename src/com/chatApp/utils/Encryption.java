package com.chatApp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
          public static String passwordEncrypt(String plainpassword) throws NoSuchAlgorithmException
          {
        	  String encryptedpassword=null;
        	  MessageDigest messageDigest1=MessageDigest.getInstance("MD5");
        	  messageDigest1.update(plainpassword.getBytes());
        	  byte[] encrypt=messageDigest1.digest();
        	  System.out.println(encrypt);
        	  StringBuffer sb=new StringBuffer();
        	  for(byte b:encrypt)
        	  {
        		  sb.append(b);
        	  }
        	  encryptedpassword=sb.toString();
        	  return encryptedpassword;
        	  
          }
}
