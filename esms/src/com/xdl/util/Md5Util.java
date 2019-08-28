package com.xdl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
  /** �㴫��һ��û�о���md5������ַ���   ��ȡ��Ӧ��md5��  */
    public  static  String   md5Str(String source){
    	try {
			MessageDigest  md5 =  MessageDigest.getInstance("MD5");
			md5.update(source.getBytes());
			// 1byte = 8bit
			byte[] md5Bytes = md5.digest();
			// �õ���md5Bytes ��  16 byte
			//System.out.println("length="+md5Bytes.length);
			// ��ΰ� 16 ���ȵ� byte���� ��� 32 λ��16����   ��1byte ���2λ16������
			// 4bit ��Ӧһ�� 16������   1byte���� 8bit
			StringBuffer strBuf = new StringBuffer();
			for(int i=0;i<md5Bytes.length;i++){
				byte  b = md5Bytes[i];
				// ��һ��byte ת����16���� 
				String temp = Integer.toHexString(b&0xff);
				if(temp.length() < 2){
					temp = "0" + temp;
				}
				strBuf.append(temp);
			}
            return  strBuf.toString(); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	return  source;
    }	
    
    /** �㴫��һ��û�о���md5������ַ���   ��ȡ��Ӧ��md5��  */
    public  static  String   md5StrSalt(String source,String salt){
    	source = source + salt;
    	try {
			MessageDigest  md5 =  MessageDigest.getInstance("MD5");
			md5.update(source.getBytes());
			// 1byte = 8bit
			byte[] md5Bytes = md5.digest();
			// �õ���md5Bytes ��  16 byte
			//System.out.println("length="+md5Bytes.length);
			// ��ΰ� 16 ���ȵ� byte���� ��� 32 λ��16����   ��1byte ���2λ16������
			// 4bit ��Ӧһ�� 16������   1byte���� 8bit
			StringBuffer strBuf = new StringBuffer();
			for(int i=0;i<md5Bytes.length;i++){
				byte  b = md5Bytes[i];
				// ��һ��byte ת����16���� 
				String temp = Integer.toHexString(b&0xff);
				if(temp.length() < 2){
					temp = "0" + temp;
				}
				strBuf.append(temp);
			}
            return  strBuf.toString(); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	return  source;
    }	
}
