package com.xdl.test;

import com.xdl.bean.XdlUser;
import com.xdl.service.XdlUserService;

public class XdlUserServiceTest {

	public static void main(String[] args) {
		XdlUserService  userService  = new XdlUserService();
		XdlUser  xdlUser = new XdlUser("zhangsan", "123",
			"gg@163.com", "weijie");
		//System.out.println(userService.register(xdlUser));
        XdlUser  user = userService.login("zhangsan", "1234");
        System.out.println(user);
	}

}
