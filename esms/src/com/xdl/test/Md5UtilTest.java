package com.xdl.test;

import com.xdl.util.Md5Util;

public class Md5UtilTest {

	public static void main(String[] args) {
		//System.out.println(Md5Util.md5Str("Abc123.Liweijie123"));
        System.out.println(Md5Util.md5StrSalt("abc", "123"));
	}

}
