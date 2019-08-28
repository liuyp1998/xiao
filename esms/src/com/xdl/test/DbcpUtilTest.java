package com.xdl.test;

import java.sql.Connection;
import java.util.UUID;

import com.xdl.util.DbcpUtil;

public class DbcpUtilTest {

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
		//Connection conn = DbcpUtil.getConnection();
		//System.out.println(conn);
	    for(int i=0;i<10;i++){
	    	Connection conn = DbcpUtil.getConnection();
	    	System.out.println(conn.hashCode());
	    	if(i==5 || i==7){
	    		DbcpUtil.realeaseResource(conn, null, null);
	    	}
	    }			

	}

}
