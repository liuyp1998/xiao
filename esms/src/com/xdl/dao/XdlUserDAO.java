package com.xdl.dao;

import com.xdl.bean.XdlUser;

public interface XdlUserDAO {
    /** 把用户信息 传入数据库   返回 int  等于0 代表存储失败 等于1 代表成功 */
	int  insertXdlUser(XdlUser  user);
	/** 根据登录名  和 密码 查询一个用户 不成功返回 null 成功返回XdlUser对象 */
	XdlUser  getXdlUserByLoginNameAndPassword(String  login_name,
		String password);
}
