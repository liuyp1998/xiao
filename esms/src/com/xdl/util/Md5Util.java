package com.xdl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
  /** 你传入一份没有经过md5处理的字符串   获取对应的md5串  */
    public  static  String   md5Str(String source){
    	try {
			MessageDigest  md5 =  MessageDigest.getInstance("MD5");
			md5.update(source.getBytes());
			// 1byte = 8bit
			byte[] md5Bytes = md5.digest();
			// 得到的md5Bytes 是  16 byte
			//System.out.println("length="+md5Bytes.length);
			// 如何把 16 长度的 byte数组 变成 32 位的16进制   把1byte 变成2位16进制数
			// 4bit 对应一个 16进制数   1byte正好 8bit
			StringBuffer strBuf = new StringBuffer();
			for(int i=0;i<md5Bytes.length;i++){
				byte  b = md5Bytes[i];
				// 把一个byte 转换成16进制 
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
    
    /** 你传入一份没有经过md5处理的字符串   获取对应的md5串  */
    public  static  String   md5StrSalt(String source,String salt){
    	source = source + salt;
    	try {
			MessageDigest  md5 =  MessageDigest.getInstance("MD5");
			md5.update(source.getBytes());
			// 1byte = 8bit
			byte[] md5Bytes = md5.digest();
			// 得到的md5Bytes 是  16 byte
			//System.out.println("length="+md5Bytes.length);
			// 如何把 16 长度的 byte数组 变成 32 位的16进制   把1byte 变成2位16进制数
			// 4bit 对应一个 16进制数   1byte正好 8bit
			StringBuffer strBuf = new StringBuffer();
			for(int i=0;i<md5Bytes.length;i++){
				byte  b = md5Bytes[i];
				// 把一个byte 转换成16进制 
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
